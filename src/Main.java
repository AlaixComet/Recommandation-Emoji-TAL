import objects.emojis.Emoji;
import objects.emojis.FeelingEmoji;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<FeelingEmoji> feelingEmojiArrayList = methods.InitializeData.initializeFeelingEmojis("data/feeling-emoji-list.csv",",");
        ArrayList<Emoji> wordEmojiArrayList = methods.InitializeData.initializeWordEmojis("data/word-emoji-list.csv",",");

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

        //Recommendation type 1 :

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



     //   System.out.println("j'aime les chevaux".matches(".*(^|\\s)cheva(ux|l)(\\s|$).*"));
    }
    }
}
