//Alicia Sheng
//PA#0
//Jan 25th, 2020

import java.util.Scanner;

public class Problem6 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.print("Enter x: ");
		Double x = in.nextDouble();
		System.out.print("Enter y: ");
		Double y = in.nextDouble();
		if (x > 0) {
			if (y > 0) {
				System.out.println(1);
			} else if (y < 0) {
				System.out.println(4);
			} else {
				System.out.println(0);
			}
		}
		if (x < 0) {
			if (y > 0) {
				System.out.println(2);
			} else if (y < 0) {
				System.out.println(3);
			} else {
				System.out.println(0);
			}
		}
		in.close();
	}
}
