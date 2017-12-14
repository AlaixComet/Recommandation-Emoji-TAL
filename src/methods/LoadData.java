package methods;

import constants.Constants;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Methods to retrieve data from files
 * @author Alexis
 */
public class LoadData {

	/**
	 * Extracts Strings from csv file
	 * The returned Array as a String[] for each line of the csv
	 * The String is the csv line parsed by the parser
	 * @param csvFile String
	 * @param parser String
	 * @return ArrayList<String[]> lines
	 */
	public static ArrayList<String[]> getDataFromCSV(String csvFile, String parser) {
		ArrayList<String[]> lines = new ArrayList<>();
		String line;
		
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			
			while ((line = br.readLine()) != null) {
				lines.add(line.split(parser));
	        }

		} catch (IOException e) {
	            e.printStackTrace();
	    }
		return lines;
    }

    public static String getDataFromTxtSingleString(String filename){
		String string="";
		String line;
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

			while ((line = br.readLine()) != null) {
				string = string+line;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return string;
	}

	public static HashMap getTextScoresFromXmi(String filename){
    	HashMap hashmap = null;
		String feelings[]= Constants.feelings;
		//TODO read xmi, find feeling values, associate it to the sames Hashmap as Emoji's (key = feelings)
		return hashmap;
	}
}
