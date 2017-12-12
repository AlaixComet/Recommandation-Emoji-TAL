package objects.emojis;

import java.util.HashMap;

/**
 * FeelingEmoji object extends Emoji's object, adding the notion of score for every feeling we're associating emojis with
 * New variables are :
 * <ul>
 *  <li> float[] Score
 *      <ul>
 *          <li> pos</li>
 *          <li> joy</li>
 *          <li> sadness</li>
 *          <li> love</li>
 *          <li> surprise</li>
 *          <li> fear</li>
 *          <li> anger</li>
 *      </ul>
 *  </li>
 *  <li>float Popularity</li>
 * </ul>
 */
public class FeelingEmoji extends Emoji{

    private HashMap scores;

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
    public HashMap getScores() {
        return this.scores;
    }

    public void setScores(HashMap scores) {
        this.scores = scores;
    }

}