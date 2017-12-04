import objects.emojis.FeelingEmoji;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<FeelingEmoji> feelingEmojiArrayList = methods.InitializeData.initializeFeelingEmojis("data/feeling-emoji-list.csv",",");
        for (FeelingEmoji feelingE : feelingEmojiArrayList) {
            System.out.println(feelingE.getEmote() +" / "+feelingE.getName() );
        }

    }
}
