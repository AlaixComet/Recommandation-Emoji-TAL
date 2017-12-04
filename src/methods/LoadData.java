package methods;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
}