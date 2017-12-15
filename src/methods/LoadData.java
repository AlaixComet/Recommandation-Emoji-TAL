package methods;


import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import java.io.IOException;

import org.w3c.dom.traversal.DocumentTraversal;
import org.w3c.dom.traversal.NodeIterator;
import org.w3c.dom.traversal.NodeFilter;

import org.xml.sax.SAXException;
import constants.Constants;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import java.util.regex.Pattern;


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

	public static HashMap<String,Float> getDataFromXmi() {
        HashMap<String, Float> scoreSentiment = new HashMap<String, Float>();

        try {
			final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			final DocumentBuilder parser = factory.newDocumentBuilder();
			final Document doc = parser.parse("F:\\cours\\M1 SCA\\TAL\\Recommandation-Emoji-TAL\\DetectionSentiment\\output\\texte.xmi");
			final Element racine = doc.getDocumentElement();
			final NodeList enfantRacine = racine.getChildNodes();
			int nbChild = enfantRacine.getLength();
			for (int i = 0; i < nbChild; i++) {
				if (enfantRacine.item(i).getNodeName().contains("annotator:Ph")) {
					String sentiment = enfantRacine.item(i).getNodeName().replace("annotator:Ph", "");
					String[] score = sentiment.split("Z"); //utilisation d'une regex pour sortir le sentiment ET le score qui va avec
                    scoreSentiment.put(score[0],Float.parseFloat(score[1]));
                }
			}
		} catch (final ParserConfigurationException e) {
			e.printStackTrace();
		} catch (final SAXException e) {
			e.printStackTrace();
		} catch (final IOException e) {
			e.printStackTrace();
		}
        return scoreSentiment;
    }
	public static HashMap getTextScoresFromXmi(String filename){
    	HashMap hashmap = null;
		String feelings[]= Constants.feelings;
		//TODO read xmi, find feeling values, associate it to the sames Hashmap as Emoji's (key = feelings)
		return hashmap;
	}
}
