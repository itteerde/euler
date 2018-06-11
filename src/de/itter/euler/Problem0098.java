/**
 * 
 */
package de.itter.euler;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Vector;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

/**
 * @author eriki
 *
 */
public class Problem0098 {

	private static Vector<String> words = new Vector<String>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		readWords();
		System.out.println(words);
	}

	/**
	 * 
	 */
	private static void readWords() {
		try {
			Reader in = new FileReader("p098_words.txt");
			Iterable<CSVRecord> record = CSVFormat.DEFAULT.parse(in);
			for (CSVRecord words : record) {
				for (int i = 0; i < words.size(); i++) {
					Problem0098.words.add(words.get(i));
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
