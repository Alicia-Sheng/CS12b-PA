//Alicia Sheng
//PA02
//Feb 25th, 2020

import java.util.Random;
import java.util.Scanner;

/**
 * This program works as a reverse hang-man game. The computer would guess the
 * word user input until it gets the correct word.
 */
public class Problem1 {

	/**
	 * main() calls the methods, gets the value of variables, and prints out the
	 * reverse hang-man game.
	 */
	public static void main(String[] args) {
		String word = getWord();
		int wordLength = word.length();
		String show;
		String guess = "";
		char[] charGuessed = new char[26];
		for (int i = 0; i < word.length(); i++) {
			guess += "-";
		}
		while (!guess.equals(word)) {
			char guessChar = charInduce(charGuessed);
			charGuessed = append(charGuessed, guessChar);
			System.out.print("My guess: " + guessChar + "  ");
			show = loop(guess, word, guessChar);
			System.out.println("current status: " + show);
			guess = show;
			show = "";
		}
	}

	/**
	 * getWord() gets user's input of the word.
	 * 
	 * @return a string of user's input as the word computer is going to guess.
	 */
	public static String getWord() {
		String result;
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter a word for me to guess(letters only): ");
		result = in.next().toLowerCase();
		return result;
	}

	/**
	 * randomChar() induces a random character from a to z.
	 * 
	 * @param num the range of character.
	 * @return a random character from a to z.
	 */
	public static char randomChar(int num) {
		Random random = new Random();
		char rndChar = (char) (random.nextInt(num) + 'a');
		return rndChar;
	}

	/**
	 * charInduce() makes sure the induced character is not repeated before.
	 * 
	 * @param charGuessed the array of characters of ones have been induced before.
	 * @return a character computer guesses.
	 */
	public static char charInduce(char[] charGuessed) {
		boolean notRepeat = false;
		char guessChar = '\u0000';
		while (!notRepeat) {
			guessChar = randomChar(26);
			int count = 0;
			for (int i = 0; i < charGuessed.length; i++) {
				if (guessChar == charGuessed[i]) {
					count += 1;
				}
			}
			if (count == 0) {
				notRepeat = true;
			}
		}
		return guessChar;
	}

	/**
	 * append() adds the character computer guesses into the array of character
	 * guessed.
	 * 
	 * @param charGuessed the array of guessed character.
	 * @param guessChar   the character computer guesses.
	 * @return the array of guessed character after appending the computer's new
	 *         guess to it.s
	 */
	public static char[] append(char[] charGuessed, char guessChar) {
		for (int i = 0; i < charGuessed.length; i++) {
			if (charGuessed[i] == '\u0000') {
				charGuessed[i] = guessChar;
				break;
			}
		}
		for (int i = 0; i < charGuessed.length; i++) {
		}
		return charGuessed;
	}

	/**
	 * loop() gets the string which has to be shown.
	 * 
	 * @param guess     the string of current guess.
	 * @param word      the string of what computer has to guess.
	 * @param guessChar the character computer guesses.
	 * @return the string which is going to be shown on the screen.
	 */
	public static String loop(String guess, String word, char guessChar) {
		String result = "";
		for (int i = 0; i < word.length(); i++) {
			if (guessChar == word.charAt(i)) {
				result += guessChar;
			} else {
				result += guess.charAt(i);
			}
		}
		return result;
	}

}