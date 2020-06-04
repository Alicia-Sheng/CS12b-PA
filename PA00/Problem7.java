//Alicia Sheng
//PA#0
//Jan 26th, 2020

import java.util.Scanner;

public class Problem7 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.println("Enter an integer: ");
		int a = in.nextInt();
		Boolean ans = true;
		for (int i = 2; i < a / 2; i++) {
			if (a % i == 0) {
				ans = false;
			}
		}
		System.out.println(ans);
		in.close();
	}
}
