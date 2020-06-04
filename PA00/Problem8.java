//Alicia Sheng
//PA#0
//Jan 25th, 2020

public class Problem8 {

	public static void main(String[] args) {

		for (int i = 5; i >= 0; i -= 1) {
			for (int a = 0; a < i; a++) {
				System.out.print("*");
			}
			for (int a = 0; a < 6 - i; a++) {
				System.out.print(" ");
			}
			for (int a = 0; a < 2 * i; a++) {
				System.out.print("/");
			}
			for (int a = 0; a < 10 - 2 * i; a++) {
				System.out.print("\\");
			}
			for (int a = 0; a < 6 - i; a++) {
				System.out.print(" ");
			}
			for (int a = 0; a < i; a++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
	}
}
