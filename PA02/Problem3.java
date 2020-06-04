//Alicia Sheng
//PA02
//Feb 25th, 2020

import java.util.Scanner;

/**
 * This program allows users to check if the integers they pass are unique.
 */
public class Problem3 {

	/**
	 * main() calls the method and prints the result.
	 */
	public static void main(String[] args) {
		System.out.println("This program allows you to check\nif the integers you pass are unique.");
		int[] number = passInt();
		System.out.println("The numbers you input are unique is " + isUnique(number) + ".");
	}

	/**
	 * isUnique() checks if the numbers user inputs are unique.
	 * 
	 * @param array an array of integers of user input.
	 * @return true if the number are unique, and false otherwise.
	 */
	public static boolean isUnique(int[] array) {
		boolean ans = true;
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[i] == array[j]) {
					count += 1;
				}
			}
			if (count > 1) {
				ans = false;
			}
			count = 0;
		}
		return ans;
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
