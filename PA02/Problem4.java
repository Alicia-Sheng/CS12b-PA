//Alicia Sheng
//PA02
//Feb 25th, 2020

import java.util.Scanner;

/**
 * This program allows users to check the length of the longest sorted sequence
 * of integers in the array they input.
 */
public class Problem4 {

	/**
	 * main() calls the methods and prints the results.
	 */
	public static void main(String[] args) {
		System.out.println(
				"This program allows you to check the length of\nthe longest sorted (nondecreasing) sequence of\nintegers in the array you input.");
		int[] input = passInt();
		System.out.println("There are " + longestSortedSequence(input)
				+ " numbers in the longest sorted sequence of integers in your array.");
	}

	/**
	 * longestSortedSequence() checks the length of the longest sorted integers of
	 * the array input.
	 * 
	 * @param array an array of integers of user input.
	 * @return an integer of the length of the longest sorted integers in the array.
	 */
	public static int longestSortedSequence(int[] array) {
		if (array.length == 0) {
			return 0;
		}
		int[] total = new int[array.length];
		int count = 1;
		for (int i = 1; i < array.length; i++) {
			if (array[i] >= array[i - 1]) {
				count += 1;
				total[i - 1] = count;
			} else {
				total[i - 1] = count;
				count = 1;
			}
		}
		int max = total[0];
		for (int i = 1; i < total.length; i++) {
			if (total[i] > max) {
				max = total[i];
			}
		}
		return max;
	}

	/**
	 * passInt() passes all values user inputs into an array.
	 * 
	 * @return an array of integers of user input.
	 */
	public static int[] passInt() {
		Scanner in = new Scanner(System.in);
		System.out.print("How many integers do you want to have? ");
		int length = in.nextInt();
		int[] number = new int[length];
		System.out.print("Please enter the numbers you want to check (with spaces between each): ");
		for (int i = 0; i < length; i++) {
			number[i] = in.nextInt();
		}
		return number;
	}

}
