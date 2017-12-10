package objects.emojis;

/**
 * Emoji object allowing manipulation of the common data of every emoji
 * All variables are Strings :
 * <ul>
 *  <li>unicode</li>
 *  <li>name</li>
 *  <li>emote</li>
 *  <li>word (optional)</li>
 * </ul>
 */
public class Emoji {

    private String unicode;
    private String name;
    private String emote;
    private String word;
    private float popularity;

    /**
     *
     * Class constructor
     * @param unicode
     * @param name
     * @param emote
     */
    public Emoji(String unicode, String name, String emote) {
        this.unicode = unicode;
        this.name = name;
        this.emote = emote;
    }

    //Setters and Getters
    public String getUnicode() {
        return unicode;
    }

    public void setUnicode(String unicode) {
        this.unicode = unicode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmote() {
        return emote;
    }

    public void setEmote(String emote) {
        this.emote = emote;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public float getPopulatity() {
        return this.popularity;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }
}