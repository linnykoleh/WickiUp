package leet_code.algorithms.easy.bit_manipulation;

/**
 * @author LinnykOleh
 */
public class HammingDistance {

	/**
	 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
     *
	 * Given two integers x and y, calculate the Hamming distance.
	 *
	 * Example:
     *
	 * Input: x = 1, y = 4
     *
	 * Output: 2
     *
	 * Explanation:
	 *    1   (0 0 0 1)
	 *    4   (0 1 0 0)
     *           ↑   ↑
     *
	 * The above arrows point to positions where the corresponding bits are different.
	 * @param x number 1
	 * @param y number 1
	 * @return  hammingDistance
	 */
	public int hammingDistance(int x, int y) {
		int result = 0;

		String xBinary = Integer.toBinaryString(x);
		String yBinary = Integer.toBinaryString(y);

		final int dif = xBinary.length() - yBinary.length();
		for (int i = 0; i < Math.abs(dif); i++) {
			if (dif < 0) {
				xBinary  = "0" + xBinary;
			} else if (dif > 0) {
				yBinary = "0" + yBinary;
			}
		}

		char[] xBinaryArray = xBinary.toCharArray();
		char[] yBinaryArray = yBinary.toCharArray();

		for (int i = 0; i < xBinaryArray.length; i++) {
			if(xBinaryArray[i] != yBinaryArray[i]){
				result++;
			}

		}
		return result;
	}
}
