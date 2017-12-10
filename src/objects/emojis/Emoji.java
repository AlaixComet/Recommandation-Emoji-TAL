package objects.emojis;

import java.util.ArrayList;

/**
 * Emoji object allowing manipulation of the common data of every emoji
 * All variables are Strings :
 * <ul>
 *  <li>unicode</li>
 *  <li>name</li>
 *  <li>emote</li>
 *  <li>regex (optional)</li>
 *  <li>popularity (optional)</li>
 * </ul>
 */
public class Emoji {

    private String unicode;
    private String name;
    private String emote;
    private ArrayList<String> regex;
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

    public ArrayList<String> getRegex() { return regex;    }

    public void setRegex(ArrayList<String> regex) { this.regex = regex;    }

    public float getPopulatity() {
        return this.popularity;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }
}