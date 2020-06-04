//Alicia Sheng
//PA03
//Feb 20th, 2020

/**
 * This class plays a variation of the game of Mastermind with a user.
 * Users can make guesses of numbers with the digits they provide.
 * Users will get clues of the number of correct digits in correct place and wrong place.
 */

import java.util.Random;
import java.util.Scanner;

public class Part1 {

	/**
	 * main() scans users' input and print out the game.
	 */

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("How many digits does the number you want to guess have? ");
		int digit = in.nextInt();
		String number = generateNumber(digit);
		System.out.print(
				"Please enter your guess of an integer (if you are guessing a number with fewer digits, please insert '0's before your guess.)\n(eg. enter '0001' for '1' if you are guessing a 4-digit number) : ");
		String guess = in.next();
		boolean correctInput;
		boolean correct = judge(number, guess);
		while (!correct) {
			correctInput = correctInput(guess, digit);
			while (!correctInput) {
				System.out.println("You are not entering an integer with the correct length.");
				System.out.print("Please enter your guess again: ");
				guess = in.next();
				correctInput = correctInput(guess, digit);
			}
			print(number, guess);
			System.out.print("Please enter your guess again: ");
			guess = in.next();
			correct = judge(number, guess);
		}
		System.out.println("Congratulations! The number is " + number + ".");
	}

	/**
	 * input() indicates whether the player is guessing with the right form.
	 * 
	 * @param guess the player's guess.
	 * @param digit the player's input of digit.
	 * @return true if guess is not a number or guess's digit is not the same as the
	 *         digit user inputs, false otherwise.
	 */

	public static boolean correctInput(String guess, int digit) {
		for (int i = 0; i < guess.length(); i++) {
			if (!Character.isDigit(guess.charAt(i))) {
				return false;
			}
		}
		if (guess.length() != digit) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * generateNumber() returns a random number player is going to guess with the
	 * digit player inputs.
	 * 
	 * @param digit the player's input of digit.
	 * @return the string form of the random number.
	 */

	public static String generateNumber(int digit) {
		int number = 1;
		for (int i = 0; i < digit; i++) {
			number *= 10;
		}
		Random rand = new Random();
		int num = rand.nextInt(number);
		String returnNum = Integer.toString(num);
		for (int i = 0; i < digit - returnNum.length(); i++) {
			returnNum = "0" + returnNum;
		}
		return returnNum;
	}

	/**
	 * judge() indicates whether the player is guessing the correct number.
	 * 
	 * @param number the correct number player should guess.
	 * @param guess  the player's guess.
	 * @return true if number and guess are the same, false otherwise.
	 */

	public static boolean judge(String number, String guess) {
		if (!number.equals(guess)) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * digitNum() returns the number of correct digits in correct place and wrong
	 * place. To avoid duplication, the calculation of correct digits in wrong place
	 * happens after the full calculation of correct digits in correct place.
	 * 
	 * @param number the correct number player should guess.
	 * @param guess  the player's guess.
	 * @return an array with two strings of correct number and wrong number.
	 */

	public static int[] digitNum(String number, String guess) {
		int[] num = new int[2];
		int correctNum = 0;
		int wrongNum = 0;
		for (int i = 0; i < number.length(); i++) {
			for (int j = 0; j < guess.length(); j++) {
				if (number.charAt(i) == guess.charAt(j)) {
					if (i == j) {
						correctNum += 1;
					}
				}
			}
		}
		for (int m = 0; m < number.length(); m++) {
			for (int n = 0; n < guess.length(); n++) {
				if (number.charAt(m) == guess.charAt(n)) {
					if (m != n) {
						if (wrongNum < number.length() - correctNum) {
							wrongNum += 1;
						}
					}
				}
			}
		}
		num[0] = correctNum;
		num[1] = wrongNum;
		return num;
	}

	/**
	 * print() prints the clues to the player with change in "is" and "are".
	 * 
	 * @param number the correct number player should guess.
	 * @param guess  the player's guess.
	 */

	public static void print(String number, String guess) {
		int[] digitNumber = digitNum(number, guess);
		int correctPlace = digitNumber[0];
		int wrongPlace = digitNumber[1];
		if (correctPlace > 1) {
			if (wrongPlace > 1) {
				System.out.println("There are " + correctPlace
						+ " digits of the guess are correct and in the correct place, and there are " + wrongPlace
						+ " digits of guess are correct but in the wrong place.");
			} else {
				System.out.println("There are " + correctPlace
						+ " digits of the guess are correct and in the correct place, and there is " + wrongPlace
						+ " digit of guess is correct but in the wrong place.");
			}
		} else {
			if (wrongPlace > 1) {
				System.out.println("There is " + correctPlace
						+ " digit of the guess is correct and in the correct place, and there are " + wrongPlace
						+ " digits of guess are correct but in the wrong place.");
			} else {
				System.out.println("There is " + correctPlace
						+ " digit of the guess is correct and in the correct place, and there is " + wrongPlace
						+ " digit of guess is correct but in the wrong place.");
			}
		}
	}
}