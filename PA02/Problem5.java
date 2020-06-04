//Alicia Sheng
//PA02
//Feb 25th, 2020

import java.util.Scanner;

/**
 * This program allows users to check the closest guess to the correct price
 * which doesn't pass it.
 */
public class Problem5 {

	/**
	 * main() calls the methods and prints out the lines.
	 */
	public static void main(String[] args) {
		System.out.println(
				"This program allows you to check the closest guess\nto the correct price which doesn't pass it.\nAll the guesses should be integers,\nand if all guesses are lareger than the correct price,\nit will return -1.");
		int price = getPrice();
		int[] guess = passInt();
		System.out.println("The closest guess is " + priceIsRight(guess, price) + ".");
	}

	/**
	 * priceIsRight() checks the closest guess to the correct price which doesn't
	 * pass it.
	 * 
	 * @param array an array of integers of user's input of guess.
	 * @param price the correct price user inputs.
	 * @return an integer of the closest guess.
	 */
	public static int priceIsRight(int[] array, int price) {
		int[] store = new int[array.length];
		int test = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] <= price) {
				store[i] = array[i];
			} else if (array[i] > price) {
				test += 1;
			}
		}
		int max = store[0];
		for (int i = 1; i < store.length; i++) {
			if (store[i] > max) {
				max = store[i];
			}
		}
		if (test == array.length) {
			return -1;
		} else {
			return max;
		}
	}

	/**
	 * getPrice() gets the user's input of the correct price.
	 * 
	 * @return an integer of the user's input of price.
	 */
	public static int getPrice() {
		Scanner in = new Scanner(System.in);
		System.out.print("What is the correct price? ");
		int price = in.nextInt();
		return price;
	}

	/**
	 * passInt() passes all values user inputs into an array.
	 * 
	 * @return an array of integers of user input.
	 */
	public static int[] passInt() {
		Scanner in = new Scanner(System.in);
		System.out.print("How many guesses are there? ");
		int guessNum = in.nextInt();
		int[] number = new int[guessNum];
		System.out.print("Please enter your guesses (with spaces between each): ");
		for (int i = 0; i < guessNum; i++) {
			number[i] = in.nextInt();
		}
		return number;
	}

}
