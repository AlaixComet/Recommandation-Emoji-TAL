package methods;

import objects.emojis.Emoji;
import objects.emojis.FeelingEmoji;

import java.util.ArrayList;

/**
 * Methods creating java objects using the files
 */
public class InitializeData {

    /**
     * Creates Emoji objects from csv file and keep them in an Array listed by popularity
     *
     * @param csvFilename
     * @param parser
     * @return ArrayList of initialized objects
     */
    public static ArrayList<Emoji> initializeEmojis(String csvFilename, String parser) {
        //TODO : create emoji objects from csv file and keep them in an Array listed by popularity
        return null;
    }

    /**
     * Creates FeelingEmoji objects from csv file and keep them in an Array listed by popularity
     * the csv file lines are like :
     * Unicode,Emoji and description, pos/neutral/neg, joy, sadness, love, surprise, fear, anger, popularity, word
     * Lines starting with "#" symbol must be ignored
     *
     * @param csvFilename
     * @param parser
     * @return ArrayList of initialized objects
     */
    public static ArrayList<FeelingEmoji> initializeFeelingEmojis(String csvFilename, String parser) {
        ArrayList<FeelingEmoji> feelingEmojiArrayList = new ArrayList<>();
        FeelingEmoji feelingEmoji;
        String emote;
        String name;
        ArrayList<String[]> lines = LoadData.getDataFromCSV(csvFilename, parser);
        //each line of the file is an object
        for (String[] line : lines) {
            float[] scores = {Float.parseFloat(line[2]), Float.parseFloat(line[3]), Float.parseFloat(line[4]),
                    Float.parseFloat(line[5]), Float.parseFloat(line[6]), Float.parseFloat(line[7]), Float.parseFloat(line[8])};
            //an emoji generaly takes 2 char, but some exception are 1 char
            if (!line[1].substring(1,2).equals(" ")){
            name = line[1].substring(3, line[1].length());
            emote = line[1].substring(0, 2);
            } else {
                name = line[1].substring(2, line[1].length());
                emote = line[1].substring(0, 1);
            }
            feelingEmoji = new FeelingEmoji(line[0],  name, emote, scores);
            feelingEmojiArrayList.add(feelingEmoji);
        }
        return feelingEmojiArrayList;
    }

    /**
     * Create dictionaries objects from csv file
     *
     * @param csvFilename
     * @param parser
     * @return ArrayList of initialized objects
     */
    public static ArrayList<Object> initializeDictionaries(String csvFilename, String parser) {
        //TODO : create dictionaries objects from csv file and keep them in Arrays (??)
        return null;
    }
}
