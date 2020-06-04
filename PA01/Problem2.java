//Alicia Sheng
//PA01
//Feb 22th, 2020

import java.util.Scanner;

/**
 * This program accepts user's first name and last name, and returns the pig
 * latin form of the name.
 *
 */
public class Problem2 {

	/**
	 * main() gets the pig latin form of the first and last name and prints it out.
	 */
	public static void main(String[] args) {
		String first = getFirst();
		String last = getLast();
		System.out.println(first + " " + last);
	}

	/**
	 * getFirst() turns the first name of the user to the correct form.
	 * 
	 * @return a string of the pig latin form of the user's first name.
	 */
	public static String getFirst() {
		String result;
		Scanner in = new Scanner(System.in);
		System.out.println("your first name: ");
		String first = in.next().toLowerCase();
		char charF = Character.toUpperCase(first.charAt(1));
		result = charF + first.substring(2, first.length()) + first.charAt(0) + "ay";
		return result;
	}

	/**
	 * getLast() turns the last name of the user to the correct form.
	 * 
	 * @return a string of the pig latin form of the user's last name.
	 */
	public static String getLast() {
		String result;
		Scanner in = new Scanner(System.in);
		System.out.println("your last name: ");
		String last = in.next().toLowerCase();
		char charF = Character.toUpperCase(last.charAt(1));
		result = charF + last.substring(2, last.length()) + last.charAt(0) + "ay";
		return result;
	}

}
