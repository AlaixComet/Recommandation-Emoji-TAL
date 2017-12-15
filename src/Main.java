<<<<<<< HEAD
import methods.LoadData;
=======
import methods.Recommendation;
>>>>>>> 7ae3d18d5dd1c85b4a327ba161e2c24a7e4bb4b4
import objects.emojis.Emoji;
import objects.emojis.FeelingEmoji;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //initialisation of emoji corpus
        ArrayList<FeelingEmoji> feelingEmojiArrayList = methods.InitializeData.initializeFeelingEmojis("data/feeling-emoji-list.csv",",");
        ArrayList<Emoji> wordEmojiArrayList = methods.InitializeData.initializeWordEmojis("data/word-emoji-list.csv",",");
        //emoji popularity
        feelingEmojiArrayList = methods.InitializeData.setPopularityOfFeelingEmojiArray(feelingEmojiArrayList,"data/emoji-popularity.txt");
        wordEmojiArrayList = methods.InitializeData.setPopularityOfEmojiArray(wordEmojiArrayList,"data/emoji-popularity.txt");
        //sorting by popularity
        Collections.sort(feelingEmojiArrayList);
        Collections.sort(wordEmojiArrayList);

        //parcours list exemples and tests
/*
        for (FeelingEmoji feelingE : feelingEmojiArrayList) {
            System.out.println(feelingE.getEmote() +" / "+feelingE.getName() +"     "+feelingE.getScores().get("pos") );
        }
*/

/*        for (Emoji wordE : wordEmojiArrayList) {
            System.out.println(wordE.getEmote() +" / "+wordE.getRegex().get(0));
        }
*/

        System.out.println("Entrez texte :");
        Scanner sc = new Scanner (System.in);
        String text = sc.nextLine();
        ArrayList<Emoji> recommendeddEmojiList = new ArrayList<>();
        ArrayList<FeelingEmoji> recommendeddFeelingEmojiList = new ArrayList<>();

        //Recommendation type 1 :
        recommendeddFeelingEmojiList = Recommendation.CompareFeelingScores(methods.LoadData.getTextScoresFromXmi("DetectionSentiment/output/texte.txt.xmu"),feelingEmojiArrayList);
        for (FeelingEmoji e: recommendeddFeelingEmojiList ) {
            System.out.println(e.getEmote());
        }

        //Recommendation type 2 :
        for (Emoji wordE : wordEmojiArrayList) {
            for (String regex : wordE.getRegex()) {
                //If we find the regex
                if (text.matches((".*(^|\\s|\\W)"+regex+"(\\s|$|\\W).*"))){
                    //If the emote wasn't added yet
                    if (!recommendeddEmojiList.contains(wordE)){
                        recommendeddEmojiList.add(wordE);
                    }
                }

            }
        }

        for ( Emoji e: recommendeddEmojiList) {
            System.out.println(e.getEmote());

        }

        LoadData.getDataFromXmi();
    }
}
