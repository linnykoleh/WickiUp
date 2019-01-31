package com.linnik.wickiup.leet_code.algorithms.easy.binary_search;

/**
 * @author LinnykOleh
 */
public class GuessNumberHigherOrLower {

	/**
	 * We are playing the Guess Game. The game is as follows:
     *
	 * I pick a number from 1 to n. You have to guess which number I picked.
     *
	 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
	 *
	 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
	 *
	 * 		-1 : My number is lower
	 * 		 1 : My number is higher
	 * 		 0 : Congrats! You got it!
	 * 	Example:
	 *       n = 10, I pick 6.
     *
	 * Return 6.
	 *
	 * @param n random number from 1 to n
	 * @return    guessed number
	 */
	public int guessNumber(int n) {
		int top = n;
		int bottom = 1;
		int answer;

		while(bottom < top){
			answer = (top + bottom) / 2;
			int apiResult = guess(answer);
			if(apiResult == 0){
				return answer;
			}else if(apiResult == -1){
				top  = answer;
			}else{
				bottom = answer + 1;
			}
		}
		return bottom;
	}

	/**
	 * This method provide by site API, this is why the body is empty
	 *
	 * @param answer my answer
	 * @return       guessed result
	 */
	private int guess(int answer){
		return answer;
	}
}
