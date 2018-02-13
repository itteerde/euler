package de.itter.euler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem0098 {

	private static List<String> words = new LinkedList<String>();
	private static HashMap<String, LinkedList<String>> anagrams = new HashMap<String, LinkedList<String>>();

	public static void main(String[] args) {
		readWords();
		findAnagrams();
		System.out.println(anagrams.size());
		List<String> keys = new LinkedList<String>(anagrams.keySet());
		Collections.sort(keys, new StringLengthComparator());
		System.out.println(keys);
	}

	private static void findAnagrams() {
		Iterator<String> it = words.iterator();
		while (it.hasNext()) {
			String word = it.next();
			String key = keyString(word);
			if (!anagrams.containsKey(key)) {
				anagrams.put(key, new LinkedList<String>());
			}
			anagrams.get(key).add(word);
		}

		Collection<String> toBeRemoved = new LinkedList<String>();
		it = anagrams.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			if (anagrams.get(key).size() == 1) {
				toBeRemoved.add(key);
			}
		}

		it = toBeRemoved.iterator();
		while (it.hasNext()) {
			anagrams.remove(it.next());
		}
	}

	private static String keyString(String s) {
		byte[] characters = s.getBytes();
		Arrays.sort(characters);
		return new String(characters);
	}

	private static void readWords() {
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File("p098_words.txt")));
			String s = in.readLine();
			StringTokenizer st = new StringTokenizer(s, "\",\"");
			while (st.hasMoreTokens()) {
				words.add(st.nextToken());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
