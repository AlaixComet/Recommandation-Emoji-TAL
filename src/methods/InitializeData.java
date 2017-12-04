package methods;

import objects.emojis.Emoji;
import objects.emojis.FeelingEmoji;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Methods creating java objects using the files
 */
public class InitializeData {

    /**
     * Creates Emoji objects from csv file and keep them in an Array
     * the csv file lines are like :
     * Unicode,Emoji and description, regex
     *
     * @param csvFilename
     * @param parser
     * @return ArrayList of initialized objects
     */
    public static ArrayList<Emoji> initializeWordEmojis(String csvFilename, String parser) {
        ArrayList<Emoji> wordEmojiArrayList = new ArrayList<>();
        Emoji emoji;
        String emote;
        String name;
        ArrayList<String[]> lines = LoadData.getDataFromCSV(csvFilename, parser);
        //each line of the file is an object
        for (String[] line : lines) {
        //an emoji generaly takes 2 char, but some exception are 1 char
            if (!line[1].substring(1,2).equals(" ")){
                name = line[1].substring(3, line[1].length());
                emote = line[1].substring(0, 2);
            } else {
                name = line[1].substring(2, line[1].length());
                emote = line[1].substring(0, 1);
            }
            emoji = new Emoji(line[0],  name, emote);
            emoji.setRegex(new ArrayList<>(Arrays.asList(line[2].split(";"))));
            wordEmojiArrayList.add(emoji);
        }
        return wordEmojiArrayList;
    }

    /**
     * Creates FeelingEmoji objects from csv file and keep them in an Array
     * the csv file lines are like :
     * Unicode,Emoji and description, pos, joy, sadness, love, surprise, fear, anger
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
        String feelings[]={"pos", "joy", "sadness", "love", "surprise", "fear", "anger"};
        ArrayList<String[]> lines = LoadData.getDataFromCSV(csvFilename, parser);
        //each line of the file is an object
        for (String[] line : lines) {
            //an emoji generaly takes 2 char, but some exception are 1 char
            if (!line[1].substring(1,2).equals(" ")){
            name = line[1].substring(3, line[1].length());
            emote = line[1].substring(0, 2);
            } else {
                name = line[1].substring(2, line[1].length());
                emote = line[1].substring(0, 1);
            }
            HashMap scores = new HashMap();
            for (int i = 2; i<9; i++){
                scores.put(feelings[i-2],line[i]);
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
