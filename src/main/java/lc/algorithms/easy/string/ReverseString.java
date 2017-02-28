package lc.algorithms.easy.string;

/**
 * Created by LinnykOleh on 2/8/17.
 */
public class ReverseString {

	/**
	 * Faster implementation.
	 *
	 * Write a function that takes a string as input and returns the string reversed.
     *
	 * Example:
	 * Given s = "hello", return "olleh"..
	 *
	 * @param s string to reverse
	 * @return  reversed string
	 */
	public String reverseString(String s) {
		return new StringBuilder(s).reverse().toString();
	}

	/**
	 * Slower implementation.
	 *
	 * Write a function that takes a string as input and returns the string reversed.
	 *
	 * Example:
	 * Given s = "hello", return "olleh"..
	 *
	 * @param s string to reverse
	 * @return  reversed string
	 */
	public String reverseString2(String s) {
		String result = "";
		final String[] lines = s.split("\n");
		for(final String line : lines){
			final char[] strArray = line.toCharArray();
			for(int i = strArray.length - 1; i >= 0; i--){
				result+=strArray[i];
			}
		}
		return result;
	}
}
