//Alicia Sheng
//PA02
//Feb 25th, 2020

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This program allows users to search the popularity of the names they input.
 */
public class Problem2 {

	/**
	 * main() calls the methods and print lines.
	 */
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println(
				"This program allows you to search through the\ndata from the Social Security Administration\nto see how popular a particular name has been\nsince 1900.\n");
		File file = new File("names.txt");
		Scanner names = new Scanner(file);
		String name = correctName();
		while (!rightForm(name, names)) {
			System.out.println("This is not the right form. Please input again.");
			name = correctName();
		}
		print(name, names);
	}
	
	/**
	 * correctName() forms the user input into the correct form.
	 * @return a string of user input.
	 */
	public static String correctName() {
		Scanner in = new Scanner(System.in);
		System.out.print("Name? ");
		String nameIn = in.next();
		String nameCorrect = nameIn.substring(0, 1).toUpperCase() + nameIn.substring(1).toLowerCase();
		return nameCorrect;
	}
	
	/**
	 * rightForm() checks if the user input is a word.
	 * @param name the user input with the correct form.
	 * @param names the file scanned.
	 * @return true if the input is all letter, false otherwise.
	 */
	public static boolean rightForm(String name, Scanner names) {
		boolean result = true;
		int count = 0;
		for (int i = 0; i < name.length(); i++) {
			if (!Character.isLetter(name.charAt(i))) {
				result = false;
			}
		}
		return result;
	}
	
	/**
	 * print() prints out the statistics of the name user inputs.
	 * @param name the user input with the correct form.
	 * @param names the file scanned.
	 */
	public static void print(String name, Scanner names) {
		boolean inFile = false;
		while (names.hasNext()) {
			if (name.equals(names.next())) {
				System.out.println("Statistics on name \"" + name + "\"");
				int first = 1900;
				for (int i = 0; i < 11; i++) {
					int number = names.nextInt();
					System.out.println((first + 10 * i) + ": " + number);
				}
				inFile = true;
				break;
			}
		}
		if (!inFile) {
			System.out.println("The name is not recorded in our file.");
		}
	}
}
