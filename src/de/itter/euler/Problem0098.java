/**
 * 
 */
package de.itter.euler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 * @author eriki
 *
 */
public class Problem0098 {

	private static HashMap<String, LinkedList<String>> anagrams = new HashMap<String, LinkedList<String>>();
	private static Comparator<String> lengthFirstComparator = new Comparator<String>() {
		public int compare(String l, String r) {
			if (l.length() != r.length()) {
				return r.length() - l.length();
			}
			return l.compareTo(r);
		}
	};

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		readWords();
		deleteNonAnagrams();
		Vector<String> sortedKeys = sortKeys();
		Iterator<String> it = sortedKeys.iterator();
		while (it.hasNext()) {
			String key = it.next();
			System.out.println(key + "=" + anagrams.get(key));
		}

	}

	/**
	 * @return
	 */
	private static Vector<String> sortKeys() {
		Vector<String> sortedKeys = new Vector<String>(anagrams.keySet());
		sortedKeys.sort(lengthFirstComparator);
		return sortedKeys;
	}

	/**
	 * 
	 */
	private static void deleteNonAnagrams() {
		LinkedList<String> keysToBeDeleted = new LinkedList<String>();
		Set<String> keys = anagrams.keySet();
		Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			String key = it.next();
			if (anagrams.get(key).size() < 2) {
				keysToBeDeleted.add(key);
			}
		}
		Iterator<String> keysToBeDeletedIterator = keysToBeDeleted.iterator();
		while (keysToBeDeletedIterator.hasNext()) {
			anagrams.remove(keysToBeDeletedIterator.next());
		}
	}

	/**
	 * 
	 */
	private static void readWords() {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader("p098_words.txt"));
			String s = in.readLine();
			StringTokenizer st = new StringTokenizer(s, ",");
			while (st.hasMoreTokens()) {
				String word = st.nextToken();
				word = word.substring(1, word.length() - 1);
				if (!anagrams.containsKey(key(word))) {

					anagrams.put(key(word), new LinkedList<String>());
				}
				anagrams.get(key(word)).add(word);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * @param word
	 * @return
	 */
	private static String key(String word) {
		byte[] chars = word.getBytes();
		Arrays.sort(chars);
		return new String(chars);
	}

}
