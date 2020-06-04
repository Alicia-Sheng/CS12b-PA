//Alicia Sheng
//PA#0
//Jan 25th, 2020

import java.util.Scanner;

public class Problem1 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.print("Enter your birth year: ");
		int birthyear = in.nextInt();
		int copy = birthyear;
		int count = 1;
		for (; copy > 0; copy /= 10) {
			count *= 10;
		}

		for (int x = count / 10; x > 0; x /= 10) {
			int number = birthyear / x;
			birthyear = birthyear - number * x;
			System.out.println(number);
		}
		in.close();

	}

}
