/**
 * 
 */
package de.itter.euler;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
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
	private static HashMap<String, Collection<Long>> squareAnagrams = new HashMap<String, Collection<Long>>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long t = System.currentTimeMillis();
		readWords();
		findAnagrams();
		deleteTrivials();
		System.out.println(wordAnagrams);
		findSquareAnagrams();
		deleteTrivialSquares();
		System.out.println(squareAnagrams.size());
		
		
		Vector<String> squareAnagramKeys = new Vector<String>(new LinkedList<String>(squareAnagrams.keySet()));
		squareAnagramKeys.sort(new StringLengthComparator());
		
		for(int i=0;i<20;i++){
			System.out.println(squareAnagrams.get(squareAnagramKeys.elementAt(i)));
		}
		
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
		for (long i = 1; i < 100000; i++) {
			String key = Long.toString(i*i);
			key = key(key);
			if (!squareAnagrams.containsKey(key)) {
				squareAnagrams.put(key, new Vector<Long>());
			}
			squareAnagrams.get(key).add(new Long(i*i));
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
	
	private static boolean isValid(String a, String b, long x, long y){
		
		char[] c = new char[10];
		
		return false;
	}

}
