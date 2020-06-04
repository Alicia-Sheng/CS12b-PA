//Alicia Sheng
//PA03
//Feb 22th, 2020

import java.util.Scanner;

/**
 * This program finds a baseball player's batting average with the number of
 * times the player was at bat and the number of hits earned user inputs.
 *
 */
public class Problem3 {

	/**
	 * main() gets the average and prints it out with the correct format.
	 */
	public static void main(String[] args) {
		double average = getAverage();
		System.out.printf("%.4f", average);
	}

	/**
	 * getAverage() gets user's input and calculate the batting average.
	 * 
	 * @return a double of user's batting average.
	 */
	public static double getAverage() {
		double result;
		Scanner in = new Scanner(System.in);
		System.out.println("number of times you were at bat: ");
		double bat = in.nextDouble();
		System.out.println("number of hits earned: ");
		double hit = in.nextDouble();
		result = hit / bat;
		return result;
	}

}
