package methods;

import constants.Constants;
import objects.emojis.FeelingEmoji;

import java.util.ArrayList;
import java.util.HashMap;

public class Recommendation {

    /**
     * List the emojis that are relevant to the feeling found in the text
     * @param hash
     * @param feelingEmojiArrayList
     * @return relevantFeelingEmojiArrayList
     */
    public static ArrayList<FeelingEmoji> CompareFeelingScores(HashMap hash, ArrayList<FeelingEmoji> feelingEmojiArrayList){
        //List of the relevant emojis
        ArrayList<FeelingEmoji> relevantFeelingEmojiArrayList = new ArrayList<>();
        //List of the feelings
        String feelings[]= Constants.feelings;
        //For each emoji
        for (FeelingEmoji e: feelingEmojiArrayList ) {
            //For each feeling
            for
            //cases : score > 0

            //case : score = 0

            //case : score < 0
        }
        return relevantFeelingEmojiArrayList;
    }
}
