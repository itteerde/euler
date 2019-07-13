/**
 * 
 */
package de.itter.euler;

import java.util.Arrays;

/**
 * @author Erik Itter
 *
 */
public class Problem000122 {

	public static void main(String[] args) {

		int[] m = new int[201]; // in order to use index as in maths
		m[1] = 0;
		m[2] = 1;

		for (int k = 3; k <= 200; k++) {

			int min = Integer.MAX_VALUE;

			for (int i = 1; i <= k / 2; i++) {

				if (i == k - i) {
					if (m[i] + 1 < min) {
						min = m[i] + 1;
					}
					continue;
				}
				if (m[i] + m[k - i] + 1 < min) {
					min = m[i] + m[k - i] + 1;
				}
			}

			m[k] = min;
		}

		System.out.println(Arrays.toString(m));
		System.out.println(m[15]);
	}
}
