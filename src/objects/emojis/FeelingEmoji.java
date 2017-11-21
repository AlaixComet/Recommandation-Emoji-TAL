package objects.emojis;

/**
 * FeelingEmoji object extends Emoji's object, adding the notion of score for every feeling we're associating emojis with
 * New variables are :
 * <ul>
 *  <li> float[] Score
 *      <ul>
 *          <li> pos/neutral/neg</li>
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
public class FeelingEmoji extends Emoji {

    private float[] scores;
    private float popularity;

    /**
     * Class constructor
     *
     * @param unicode
     * @param name
     * @param emote
     * @param scores
     * @param popularity
     */
    public FeelingEmoji(String unicode, String name, String emote, float[] scores, float popularity) {
        super(unicode, name, emote);
        this.scores = scores;
        this.popularity = popularity;
    }

    //Setters and Getters
    public float[] getScores() {
        return this.scores;
    }

    public void setScores(float[] scores) {
        this.scores = scores;
    }

    public float getPopulatity() {
        return this.popularity;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }


}