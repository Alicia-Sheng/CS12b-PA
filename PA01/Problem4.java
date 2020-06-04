//Alicia Sheng
//PA01
//Feb 22th, 2020

import java.util.Scanner;

/**
 * This program produces a Caesar cipher of a given message string.
 */
public class Problem4 {

	/**
	 * main() gets user's input, changes it into the correct format, and prints it
	 * out.
	 */
	public static void main(String[] args) {
		String message = getMessage();
		int key = getKey();
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String ans = getAns(message, alphabet, key);
		System.out.println("Your message: " + ans);
	}

	/**
	 * getMessage() gets user's input and changes it to upper case.
	 * 
	 * @return a string of user's message with all upper cases.
	 */
	public static String getMessage() {
		String result;
		Scanner in = new Scanner(System.in);
		System.out.print("Your message? ");
		result = in.nextLine().toUpperCase();
		return result;
	}

	/**
	 * getKey() gets user's input of the encoding key.
	 * 
	 * @return an integer of the encoding key user wants to have.
	 */
	public static int getKey() {
		int result;
		Scanner in = new Scanner(System.in);
		System.out.print("Encoding key? ");
		result = in.nextInt();
		return result;
	}

	public static String getAns(String message, String alphabet, int key) {
		String result = "";
		for (int i = 0; i < message.length(); i++) {
			if (message.charAt(i) == ' ') {
				result += " ";
			} else {
				for (int a = 0; a < alphabet.length(); a++) {
					if (message.charAt(i) == alphabet.charAt(a)) {
						if (a < alphabet.length() - key) {
							result += alphabet.charAt(a + key);
						} else {
							result += alphabet.charAt(a - (26 - key));
						}
					}
				}
			}
		}
		return result;
	}

}
