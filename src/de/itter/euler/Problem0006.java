/**
 * 
 */
package de.itter.euler;

/**
 * @author eriki
 *
 */
public class Problem0006 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(sum(1, 100));
		System.out.println(sum(1, 100) * sum(1, 100) - sumOfSquares(1, 100));
	}

	private static long sum(long iMin, long iMax) {
		return (iMin + iMax) * ((iMax - iMin + 1) / 2);
	}

	private static long sumOfSquares(long iMin, long iMax) {

		long result = 0;

		for (long l = iMin; l <= iMax; l++) {
			result += l * l;
		}

		return result;
	}

}
