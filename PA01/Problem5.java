//Alicia Sheng
//PA01
//Feb 22th, 2020

import java.util.Scanner;

/**
 * This program helps students to check their course score or the score they
 * have to get for a specific target score.
 *
 */
public class Problem5 {

	/**
	 * main() prints homework, midterm, and final score calculation.
	 */
	public static void main(String[] args) {
		double homeworkWeightedScore = printHomework();
		double midtermWeightedScore = printMidterm();
		printFinal(homeworkWeightedScore, midtermWeightedScore);
	}

	/**
	 * printHomework() prints the questions of homework score, and also gets the
	 * homework weighted score.
	 * 
	 * @return a double of homework weighted score for further calculation.
	 */
	public static double printHomework() {
		Scanner in = new Scanner(System.in);
		System.out.println("Homework:");
		System.out.print("    What is its weight (0-100)? ");
		double homeworkWeight = in.nextDouble();
		System.out.print("    How many homework assignments were there? ");
		double homework = in.nextDouble();
		int homeworkInt = (int) homework;
		double[] homeworkScore = new double[2 * homeworkInt];
		double[] homeworkMaxScore = new double[2 * homeworkInt];
		double homeworkScoreSum = 0.0;
		double homeworkMaxScoreSum = 0.0;
		for (int i = 0; i < homeworkInt; i++) {
			System.out.print("    Homework " + i + " score and max score: ");
			homeworkScore[i] = in.nextDouble();
			homeworkMaxScore[i] = in.nextDouble();
			homeworkScoreSum += homeworkScore[i];
			homeworkMaxScoreSum += homeworkMaxScore[i];
		}
		double homeworkWeightedScore = homeworkScoreSum / homeworkMaxScoreSum * homeworkWeight;
		System.out.printf("    Weighted homework score: %.2f", homeworkWeightedScore);
		System.out.println("\n");
		return homeworkWeightedScore;
	}

	/**
	 * printMidterm() prints the questions of mid-term score, and also gets the
	 * mid-term weighted score.
	 * 
	 * @return a double of mid-term weighted score for further calculation.
	 */
	public static double printMidterm() {
		Scanner in = new Scanner(System.in);
		System.out.println("Midterm exam:");
		System.out.print("    What is its weight (0-100)? ");
		double midtermWeight = in.nextDouble();
		System.out.print("    Exam score: ");
		double midtermScore = in.nextDouble();
		System.out.print("    Was ther a curve? (1 for yes, 2 for no) ");
		int yn1 = in.nextInt();
		double midtermCurve = 0.0;
		if (yn1 == 1) {
			System.out.print("    How much was the curve? ");
			midtermCurve = in.nextDouble();
		}
		double midtermWeightedScore = (midtermScore + midtermCurve) / 100.0 * midtermWeight;
		if (midtermWeightedScore > midtermWeight) {
			midtermWeightedScore = midtermWeight;
		}
		System.out.printf("    Weighted exam score: %.2f", midtermWeightedScore);
		System.out.println("\n");
		return midtermWeightedScore;
	}

	/**
	 * printFinal() prints the questions for final exam.
	 * 
	 * @param homeworkWeightedScore the user's homework weighted score.
	 * @param midtermWeightedScore  the user's mid-term weighted score.
	 */
	public static void printFinal(double homeworkWeightedScore, double midtermWeightedScore) {
		Scanner in = new Scanner(System.in);
		System.out.println("Final exam:");
		System.out.print("    Have you taken the final exam yet? ");
		int yn2 = in.nextInt();
		if (yn2 == 1) {
			System.out.print("    What is its weight (0-100)? ");
			double finalWeight = in.nextDouble();
			System.out.print("    Exam score: ");
			double finalScore = in.nextDouble();
			System.out.print("    Was there a curve? (1 for yes, 2 for no) ");
			int yn3 = in.nextInt();
			double finalCurve = 0.0;
			if (yn3 == 1) {
				System.out.print("    How much was the curve? ");
				finalCurve = in.nextDouble();
			}
			double finalWeightedScore = (finalScore + finalCurve) / 100.0 * finalWeight;
			if (finalWeightedScore > finalWeight) {
				finalWeightedScore = finalScore;
			}
			System.out.printf("    Weighted exam score: %.2f", finalWeightedScore);
			System.out.println("");
			double grade = homeworkWeightedScore + midtermWeightedScore + finalWeightedScore;
			System.out.printf("\n    Your course grade is %.2f", grade);
			System.out.println("");
		} else if (yn2 == 2) {
			System.out.print("    What is its weight (0-100)? ");
			double finalWeight = in.nextDouble();
			System.out.print("    What percentage would you like to earn in the course? ");
			double percentage = in.nextDouble();
			double needScore = (percentage - homeworkWeightedScore - midtermWeightedScore) / finalWeight * 100.0;
			double possibleScore = homeworkWeightedScore + midtermWeightedScore + finalWeight;
			if (possibleScore >= percentage) {
				System.out.printf("\n    You need a score of %.2f", needScore, " on the final exam.\n");
			} else if (possibleScore < percentage) {
				System.out.printf("\n    You need a score of %.2f", needScore, " on the final exam.");
				System.out.println("\n    Sorry, it is impossible to achieve this percentage.");
				System.out.printf("    The highest percentage you can get is %.2f", possibleScore);
				System.out.println("");
			}
		}
	}
}