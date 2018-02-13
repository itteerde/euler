package de.itter.euler;

import java.util.Comparator;

public class StringLengthComparator implements Comparator<String> {

	@Override
	public int compare(String l, String r) {
		if (l.length() != r.length()) {
			return r.length() - l.length();
		}
		return l.compareTo(r);
	}

}
