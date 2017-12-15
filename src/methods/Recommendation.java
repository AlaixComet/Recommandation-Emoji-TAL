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
                float textScore = hash.get(feeling);
                float eScore = e.getScores().get(feeling);
                //case 1 : Emoji score and text score are same sign : emoji is recommended
                //case 2 : Emoji score and text score are opposite : emoji is removed from the recommendation
                //case 3 : One of the two scores is 0 : we don't act
                if (textScore > 0){
                    if (eScore > 0){
                        relevantFeelingEmojiArrayList.add(e);
                    }
                    else if (eScore < 0){
                        irrelevantFeelingEmojiArrayList.add(e);
                    }
                } else if (textScore < 0){
                    if (eScore < 0){
                        relevantFeelingEmojiArrayList.add(e);
                    }
                    else if (eScore > 0){
                        irrelevantFeelingEmojiArrayList.add(e);
                    }
                }
            }
        }
        for (FeelingEmoji e: irrelevantFeelingEmojiArrayList ) {
            relevantFeelingEmojiArrayList.remove(e);
        }
        return relevantFeelingEmojiArrayList;
    }
}
