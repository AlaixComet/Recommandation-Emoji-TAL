package methods;

import constants.Constants;
import objects.emojis.Emoji;
import objects.emojis.FeelingEmoji;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        String feelings[]= Constants.feelings;
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
     * Initialise the popularity attribute value of the emojis from txt
     * @param emojiArrayList
     * @param filename
     * @return
     */
    public static ArrayList<Emoji> setPopularityOfEmojiArray(ArrayList<Emoji> emojiArrayList,String filename){
        String text =LoadData.getDataFromTxtSingleString(filename);
        for (int i = 0; i<emojiArrayList.size();i++) {
            Pattern regex = Pattern.compile("id=\"score-"+emojiArrayList.get(i).getUnicode()+"\">(\\d*)</span>");
            Matcher m = regex.matcher(text);
            if (m.find()) {
                int score = Integer.parseInt(m.group(1));
                emojiArrayList.get(i).setPopularity(score);
            }
        }
        return emojiArrayList;
    }

    /**
     * FeelingEmoji version of the previous setPopularity method
     * @param feelingEmojiArrayList
     * @param filename
     * @return
     */
    public static ArrayList<FeelingEmoji> setPopularityOfFeelingEmojiArray(ArrayList<FeelingEmoji> feelingEmojiArrayList,String filename){
        String text =LoadData.getDataFromTxtSingleString(filename);
        for (int i = 0; i<feelingEmojiArrayList.size();i++) {
            Pattern regex = Pattern.compile("id=\"score-"+feelingEmojiArrayList.get(i).getUnicode()+"\">(\\d*)</span>");
            Matcher m = regex.matcher(text);
            if (m.find()) {
                int score = Integer.parseInt(m.group(1));
                feelingEmojiArrayList.get(i).setPopularity(score);
            }
        }
        return feelingEmojiArrayList;
    }
}
