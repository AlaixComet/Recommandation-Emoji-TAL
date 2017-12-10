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
            System.out.println(feelingE.getEmote() +" / "+feelingE.getName() );
        }
*/

        for (Emoji wordE : wordEmojiArrayList) {
            System.out.println(wordE.getEmote() +" / "+wordE.getRegex().get(0));
        }

    }
}
