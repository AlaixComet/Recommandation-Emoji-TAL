public class FeelingEmoji extends Emoji{

    private float[] scores;
    private float popularity;

    //Constructor
    public FeelingEmoji(float[] scores, float popularity){
        super();
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