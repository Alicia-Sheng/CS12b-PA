//Alicia Sheng
//PA#0
//Jan 25th, 2020

public class Problem5 {

	public static void main(String[] args) {

		int F0 = 0;
		int F1 = 1;
		System.out.print(F0 + " " + F1);
		for (int i = 0; i < 8; i++) {
			int Fnext = F0 + F1;
			F0 = F1;
			F1 = Fnext;
			System.out.print(" " + Fnext);
		}
	}
}
