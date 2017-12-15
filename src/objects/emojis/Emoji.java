package objects.emojis;

import java.util.ArrayList;

/**
 * Emoji object allowing manipulation of the common data of every emoji
 * Attributes are :
 * <ul>
 *  <li>String unicode</li>
 *  <li>String name</li>
 *  <li>String emote</li>
 *  <li>ArrayList of String regex (optional)</li>
 *  <li>int popularity (optional)</li>
 * </ul>
 */
public class Emoji  implements Comparable<Emoji> {

    private String unicode;
    private String name;
    private String emote;
    private ArrayList<String> regex;
    private int popularity;

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

    public int getPopulatity() {
        return this.popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    @Override
    public int compareTo(Emoji o) {
        return o.getPopulatity() - this.getPopulatity();
    }
}