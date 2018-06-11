/**
 * 
 */
package de.itter.euler;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Vector;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

/**
 * @author eriki
 *
 */
public class Problem0098 {

	private static Vector<String> words = new Vector<String>();
	private static HashMap<String, Collection<String>> wordAnagrams = new HashMap<String, Collection<String>>();
	private static HashMap<String, Collection<Integer>> squareAnagrams = new HashMap<String, Collection<Integer>>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long t = System.currentTimeMillis();
		readWords();
		findAnagrams();
		deleteTrivials();
		System.out.println(wordAnagrams.size());
		findSquareAnagrams();
		deleteTrivialSquares();
		System.out.println(squareAnagrams.size());
		System.out.println(System.currentTimeMillis() - t + "ms");
	}

	/**
	 * 
	 */
	private static void deleteTrivialSquares() {
		LinkedList<String> keys = new LinkedList<String>();
		for (String key : squareAnagrams.keySet()) {
			if (squareAnagrams.get(key).size() < 2) {
				keys.add(key);
			}
		}

		for (String key : keys) {
			squareAnagrams.remove(key);
		}
	}

	/**
	 * 
	 */
	private static void findSquareAnagrams() {
		for (int i = 1; i < 100000; i++) {
			String key = Integer.toString(i);
			key = key(key);
			if (!squareAnagrams.containsKey(key)) {
				squareAnagrams.put(key, new Vector<Integer>());
			}
			squareAnagrams.get(key).add(new Integer(i));
		}
	}

	/**
	 * 
	 */
	private static void deleteTrivials() {
		LinkedList<String> keys = new LinkedList<String>();
		for (String key : wordAnagrams.keySet()) {
			if (wordAnagrams.get(key).size() < 2) {
				keys.add(key);
			}
		}

		for (String key : keys) {
			wordAnagrams.remove(key);
		}
	}

	/**
	 * 
	 */
	private static void findAnagrams() {
		for (String word : words) {
			String key = key(word);
			if (!wordAnagrams.containsKey(key)) {
				wordAnagrams.put(key, new Vector<String>());
			}
			wordAnagrams.get(key).add(word);
		}
	}

	/**
	 * @param word
	 * @return
	 */
	private static String key(String word) {
		byte[] key = word.getBytes();
		Arrays.sort(key);
		return new String(key);
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
