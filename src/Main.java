import constants.Constants;
import methods.LoadData;
import methods.Recommendation;
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

        //attributing emoji's popularity
        feelingEmojiArrayList = methods.InitializeData.setPopularityOfFeelingEmojiArray(feelingEmojiArrayList,"data/emoji-popularity.txt");
        wordEmojiArrayList = methods.InitializeData.setPopularityOfEmojiArray(wordEmojiArrayList,"data/emoji-popularity.txt");

        //Variables text and recommended emojis
        ArrayList<Emoji> recommendeddEmojiList = new ArrayList<>();
        ArrayList<FeelingEmoji> recommendeddFeelingEmojiList = new ArrayList<>();
        String text;

        //Décommenter et placer la recomandation 1 dans le else pour permetter un choix d'interactions console :
        /*
        boolean intercation = false;
        boolean console = false;
        while (!intercation){
            System.out.println("Voulez vous entrer un texte via la console ? (o/n)");
            Scanner sc = new Scanner (System.in);
            String answer = sc.nextLine();
            if (answer.equals("o")){
                intercation = true;
                console = true;
            }
            else if (answer.equals("n")){
                intercation = true;
            }
            else {
                System.out.println("Veuillez répondre par \"o\" ou \"n\" uniquement");
            }
        }

        //Si on choisit de rentrer son propre texte, on ne fait pas la recommandation 1 et on prend l'entrée de l'user
        if (console){
            //Interface for recommandation 2 only from console
            System.out.println("Entrez texte :");
            Scanner sc = new Scanner (System.in);
            text = sc.nextLine();
        }

        //Sinon on effectue la recommandation 1 et 2 sur le txt
        else {

        }
        */
        text=LoadData.getDataFromTxtSingleString("DetectionSentiment/input/texte.txt");
        System.out.println("D'après le texte du fichier en entrée :\n"+text);
        //Recommendation type 1 :
        recommendeddFeelingEmojiList = Recommendation.CompareFeelingScores(methods.LoadData.getDataFromXmi("DetectionSentiment/output/texte.xmi"),feelingEmojiArrayList);

        //sorting by popularity
        Collections.sort(recommendeddFeelingEmojiList);
        //printing for user
        System.out.println("Recommandation par sentimments détéctés");
        for (FeelingEmoji e: recommendeddFeelingEmojiList ) {
            System.out.println(e.getEmote());
        }
        System.out.println("\n");

        //Recommendation type 2 :
        for (Emoji wordE : wordEmojiArrayList) {
            for (String regex : wordE.getRegex()) {
                //If we find the regex
                for (String txt : text.split("\n"))
                    if (txt.toLowerCase().matches((".*(^|\\s|\\W)"+regex+"(\\s|$|\\W).*"))){
                        //If the emote wasn't added yet
                        if (!recommendeddEmojiList.contains(wordE)){
                            recommendeddEmojiList.add(wordE);
                        }
                    }

            }
        }
        //sorting by popularity
        Collections.sort(recommendeddEmojiList);
        //printing for user
        System.out.println("Recommandation par mots détéctés");
        for ( Emoji e: recommendeddEmojiList) {
            System.out.println(e.getEmote());
        }
    }
}
