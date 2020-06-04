//Alicia Sheng
//PA01
//Feb 21th, 2020

import java.util.Scanner;

/**
 * This program accepts item name, quantity, and price. It outputs a bill with a
 * tax rate of 6.25%.
 */
public class Problem1 {

	/**
	 * main() gets input and prints the bill.
	 */
	public static void main(String[] args) {
		int number = getNumber();
		String[] itemName = new String[number];
		int[] itemQuantity = new int[number];
		double[] itemPrice = new double[number];
		double[] itemTotal = new double[number];
		double subtotal = 0.0;
		for (int i = 0; i < number; i++) {
			itemName[i] = getName(i);
			itemQuantity[i] = getQuantity(i);
			itemPrice[i] = getPrice(i);
			itemTotal[i] = itemQuantity[i] * itemPrice[i];
			subtotal += itemTotal[i];
		}
		double tax = getTax(subtotal);
		double total = getTotal(tax, subtotal);
		print(itemName, itemQuantity, itemPrice, itemTotal, subtotal, tax, total, number);
	}

	/**
	 * getNumber() gets the number of items user has.
	 * 
	 * @return the integer of user's input of item number.
	 */
	public static int getNumber() {
		Scanner in = new Scanner(System.in);
		System.out.print("How many items are there? ");
		int num = in.nextInt();
		return num;
	}

	/**
	 * getName() gets each name of item user has in the bill.
	 * 
	 * @param i the individual item number.
	 * @return a string of each item name user inputs.
	 */
	public static String getName(int i) {
		Scanner in = new Scanner(System.in);
		System.out.println("Input name of item " + (i + 1) + ": ");
		String result = in.next();
		return result;
	}

	/**
	 * getQuantity() gets each quantity of item user has in the bill.
	 * 
	 * @param i the individual item quantity.
	 * @return an integer of each item quantity user inputs.
	 */
	public static int getQuantity(int i) {
		Scanner in = new Scanner(System.in);
		System.out.println("Input quantity of item " + (i + 1) + ": ");
		int result = in.nextInt();
		return result;
	}

	/**
	 * getPrice() gets each price of item user has in the bill.
	 * 
	 * @param i the individual item price.
	 * @return a double of each item price user inputs.
	 */
	public static double getPrice(int i) {
		Scanner in = new Scanner(System.in);
		System.out.println("Input price of item " + (i + 1) + ": ");
		double result = in.nextDouble();
		return result;
	}

	/**
	 * getTax() gets total tax of the user's bill.
	 * 
	 * @param subtotal the total price of items without tax of the user's bill.
	 * @return a double of total tax of the user's bill.
	 */
	public static double getTax(double subtotal) {
		double result;
		result = subtotal * 0.0625;
		return result;
	}

	/**
	 * getTotal() gets total price of all items in the bill.
	 * 
	 * @param tax      the total tax of the user's bill.
	 * @param subtotal the total price of items without tax of the user's bill.
	 * @return a double of total price of items after tax of the user's bill.
	 */
	public static double getTotal(double tax, double subtotal) {
		double result;
		result = subtotal + tax;
		return result;
	}

	/**
	 * print() prints out the bill with a specific format.
	 * 
	 * @param name      a set of item names.
	 * @param quantity  a set of item quantities.
	 * @param price     a set of item prices.
	 * @param itemTotal a set of item total prices.
	 * @param subtotal  total tax of the user's bill.
	 * @param tax       the total tax of the user's bill.
	 * @param total     total price of items after tax of the user's bill.
	 */
	public static void print(String[] name, int[] quantity, double[] price, double[] itemTotal, double subtotal,
			double tax, double total, int number) {
		System.out.println("Your bill:");
		System.out.printf("%-30s%-10s%-10s%-10s%n", "Item", "Quantity", "Price", "Total");
		for (int i = 0; i < number; i++) {
			System.out.printf("%-30s%-10d%-10.2f%-10.2f%n", name[i], quantity[i], price[i], itemTotal[i]);
		}
		System.out.printf("%n%-50s%-10.2f%n", "Subtotal", subtotal);
		System.out.printf("%-50s%-10.2f%n", "6.25% sales tax", tax);
		System.out.printf("%-50s%-10.2f%n", "Total", total);
	}
}
