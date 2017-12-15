package objects.emojis;

import java.util.HashMap;

/**
 * FeelingEmoji object extends Emoji's object, adding the notion of score for every feeling we're associating emojis with
 * New variables are :
 * <ul>
 *  <li> Hashmap Score with the String :
 *      <ul>
 *          <li> Joie</li>
 *          <li> Triste</li>
 *          <li> Degout</li>
 *          <li> Surprise</li>
 *          <li> Peur</li>
 *          <li> Colere</li>
 *      </ul>
 *      Corresponding to a float score
 *  </li>
 * </ul>
 */
public class FeelingEmoji extends Emoji{

    private HashMap<String, Float> scores;

    /**
     * Class constructor
     *
     * @param unicode
     * @param name
     * @param emote
     * @param scores
     */
    public FeelingEmoji(String unicode, String name, String emote, HashMap scores) {
        super(unicode, name, emote);
        this.scores = scores;
    }

    //Setters and Getters
    public HashMap<String, Float> getScores() {
        return this.scores;
    }

    public void setScores(HashMap<String, Float> scores) {
        this.scores = scores;
    }

}