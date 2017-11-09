public class Emoji{

    private String unicode;
    private String name;
    private String emote;
    private String word;

//Constructor
    public Emoji (String unicode, String name, String emote, String word){
        this.unicode = unicode;
        this.name = name;
        this.emote = emote;
        this.word = word
    }

//Setters and Getters
    public String getUnicode(){
        return this.unicode;
    }

    public void setUnicode(String unicode){
        this.unicode = unicode;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmote(){
        return this.emote;
    }

    public void setEmote(String emote){
        this.emote = emote;
    }
    

    public String getWord(){
        return this.word;
    }

    public void setWord(String word){
        this.emote = word;
    }
}