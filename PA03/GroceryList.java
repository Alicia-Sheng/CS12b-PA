//Alicia Sheng
//PA03
//Feb 20th, 2020

/**
 * The GroceryList class stores the grocery items and 
 * its size and total item quantity with an array field.
 */

import java.util.Scanner;

public class GroceryList {

	int size;
	int totalQuantity = 0;
	static GroceryList groceryList = new GroceryList();
	GroceryItemOrder[] list = new GroceryItemOrder[10];
	// <data type>[] <variable name> = new <data type>[<array length>];

	/**
	 * main() takes user's inputs as well as prints the grocery list.
	 */

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("My Grocery List (you can only have 10 items in the list)\n");
		System.out.println("Please enter an item to add to the list (item-name quantity price)");
		System.out.println("Enter \"quit\" to stop adding items to the list\n");
		String itemName;
		int itemQuantity;
		double itemPricePerUnit;
		boolean run = true;
		while (run) {
			itemName = in.next();
			if (itemName.toLowerCase().equals("quit")) {
				run = false;
				break;
			}
			itemQuantity = in.nextInt();
			itemPricePerUnit = in.nextDouble();
			GroceryItemOrder newItem = new GroceryItemOrder(itemName, itemQuantity, itemPricePerUnit);
			groceryList.add(newItem);
			groceryList.getQuantity(itemQuantity);
		}
		System.out.println(groceryList.toStr());
		System.out.println("Total grocery amount: $ " + groceryList.getTotalCost());
		System.out.println("Total number of items: " + groceryList.totalQuantity);
	}

	/**
	 * GroceryList() constructs an empty array.
	 */

	public GroceryList() {
		size = 0;
	}

	/**
	 * add() adds the given item order to the list if the list has fewer than 10
	 * items.
	 * 
	 * @param item each grocery item order.
	 */

	public void add(GroceryItemOrder item) {
		if (this.size < 10) {
			for (int i = 0; i < this.list.length; i++) {
				if (this.list[i] == null) {
					this.list[i] = item;
					break;
				}
			}
			size++;
		}
	}

	/**
	 * getTotalCost() returns the total sum cost of all grocery item orders in the
	 * list.
	 * 
	 * @return a floating number with type double of the sum cost.
	 */

	public double getTotalCost() {
		double totalCost = 0;
		double eachCost;
		for (int i = 0; i < size; i++) {
			eachCost = this.list[i].getCost();
			totalCost += eachCost;
		}
		return totalCost;
	}

	/**
	 * getQuantity() adds quantity of each item in the list together.
	 * 
	 * @param quantity each item quantity.
	 */

	public void getQuantity(int quantity) {
		this.totalQuantity += quantity;
	}

	/**
	 * toStr() transfers the grocery list to a readable format.
	 * 
	 * @return a string of the grocery list with quantity and name of each item.
	 */

	public String toStr() {
		String result = "My list: [";
		for (int i = 0; i < 9; i++) {
			if (groceryList.list[i] != null) {
				result = result + Integer.toString(groceryList.list[i].itemQuantity) + " "
						+ groceryList.list[i].itemName + ", ";
			} else {
				result += "null, ";
			}
		}
		if (groceryList.list[9] != null) {
			result += Integer.toString(groceryList.list[9].itemQuantity) + " " + groceryList.list[9].itemName + "]";
		} else {
			result += "null]";
		}
		return result;
	}

}