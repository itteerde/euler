/**
 * 
 */
package de.itter.euler;

/**
 * @author eriki
 *
 */
public class Problem0220 {

	static StringBuffer curve = new StringBuffer("Fa");
	static char direction = 'n';
	static long x = 0;
	static long y = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			step();
		}

		draw(500);

		System.out.println("(" + x + "," + y + ")");
		System.out.println(curve.length());
		// System.out.println(curve);
	}

	private static void step() {
		for (int i = 0; i < curve.length(); i++) {
			if (curve.charAt(i) == 'a') {
				curve.deleteCharAt(i);
				curve.insert(i, "aRbFR");
				i += 4;
				continue;
			}
			if (curve.charAt(i) == 'b') {
				curve.deleteCharAt(i);
				curve.insert(i, "LFaLb");
				i += 4;
				continue;
			}
		}

	}

	private static void draw(int steps) {
		int stepcounter = 0;
		for (int i = 0; stepcounter < steps; i++) {
			char c = curve.charAt(i);
			if (c == 'F') {
				stepcounter++;
				switch (direction) {
				case 'n':
					y++;
					continue;
				case 'e':
					x++;
					continue;
				case 's':
					y--;
					continue;
				case 'w':
					x--;
				}
			}

			if (c == 'L') {
				switch (direction) {
				case 'n':
					direction = 'w';
					continue;
				case 'e':
					direction = 'n';
					continue;
				case 's':
					direction = 'e';
					continue;
				case 'w':
					direction = 's';
				}
			}

			if (c == 'R') {
				switch (direction) {
				case 'n':
					direction = 'e';
					continue;
				case 'e':
					direction = 's';
					continue;
				case 's':
					direction = 'w';
					continue;
				case 'w':
					direction = 'n';
				}
			}
		}
	}
}
