public class Emoji{

    private String unicode;
    private String name;
    private String emote;

//Constructor
    public Emoji (String unicode){
        this.unicode = unicode;
        this.name = name;
        this.emote = emote;
        
    }

//Setters and Getters
    public String getUnicode(){
        return this.unicode;
    }

    public void setUnicode(){
        this.unicode = unicode;
    }

    public String getName(){
        return this.name;
    }

    public void setName(){
        this.name = name;
    }

    public String getEmote(){
        return this.emote;
    }

    public void setEmote(){
        this.emote = emote;
    }
}