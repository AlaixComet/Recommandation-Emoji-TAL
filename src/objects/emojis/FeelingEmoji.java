package objects.emojis;

/**
 * FeelingEmoji object extends Emoji's object, adding the notion of score for every feeling we're associating emojis with
 * New variables are :
 * <li>
 * <ul>
 *     <li>
 *     float[] Score
 *     <ul> pos/neutral/neg</ul>
 *     <ul> joy</ul>
 *     <ul> sadness</ul>
 *     <ul> love</ul>
 *     <ul> surprise</ul>
 *     <ul> fear</ul>
 *     <ul> anger</ul>
 *     </li>
 * </ul>
 * <ul>float Popularity</ul>
 * </li>
 */
public class FeelingEmoji extends Emoji {

    private float[] scores;
    private float popularity;

    /**
     * Class constructor
     * @param unicode
     * @param name
     * @param emote
     * @param scores
     * @param popularity
     */
    public FeelingEmoji(String unicode, String name, String emote, float[] scores, float popularity){
        super(unicode, name, emote);
        this.scores = scores;
        this.popularity = popularity;
    }

    //Setters and Getters
    public float[] getScores(){
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