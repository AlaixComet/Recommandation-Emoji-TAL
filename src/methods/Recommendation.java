package methods;

import constants.Constants;
import objects.emojis.FeelingEmoji;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class for the recommendation methods
 */
public class Recommendation {

    /**
     * List the emojis that are relevant to the feeling found in the text
     * @param hash
     * @param feelingEmojiArrayList
     * @return relevantFeelingEmojiArrayList
     */
    public static ArrayList<FeelingEmoji> CompareFeelingScores(HashMap<String, Float> hash, ArrayList<FeelingEmoji> feelingEmojiArrayList){
        //List of the relevant emojis
        ArrayList<FeelingEmoji> relevantFeelingEmojiArrayList = new ArrayList<>();
        ArrayList<FeelingEmoji> irrelevantFeelingEmojiArrayList = new ArrayList<>();
        //List of the feelings
        String feelings[]= Constants.feelings;
        //For each emoji
        for (FeelingEmoji e: feelingEmojiArrayList ) {
            //For each feeling
            for (int i = 0; i < feelings.length; i ++){
                String feeling = feelings[i];
                float score = hash.get(feeling);
                //cases : Emoji score > 0 : feeling is searched
                if (e.getScores().get(feeling) > 0){
                    relevantFeelingEmojiArrayList.add(e);
                }
                //case : score = 0 : feeling is not related
                else if (e.getScores().get(feeling) == 0){

                }
                //case : score < 0 : feeling is contradictory
                else if (e.getScores().get(feeling) < 0){
                    irrelevantFeelingEmojiArrayList.add(e);
                }
            }
        }
        for (FeelingEmoji e: irrelevantFeelingEmojiArrayList ) {
            relevantFeelingEmojiArrayList.remove(e);
        }
        return relevantFeelingEmojiArrayList;
    }
}
