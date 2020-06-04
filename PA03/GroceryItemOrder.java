//Alicia Sheng
//PA03
//Feb 20th, 2020

/**
 * GroceryItemOrder is a class used internally by the GroceryList class. Each
 * GroceryItemOrder has three references: one to a string (its name), one to an
 * integer (its quantity), and one to a double (its price per unit).
 */
public class GroceryItemOrder {

	String itemName;
	int itemQuantity;
	double itemPricePerUnit;

	/**
	 * GroceryItemOrder() constructs an item order referencing to its name,
	 * quantity, and price per unit.
	 * 
	 * @param name         the item name.
	 * @param quantity     the item quantity.
	 * @param pricePerUnit price per unit of the item.
	 */
	public GroceryItemOrder(String name, int quantity, double pricePerUnit) {
		itemName = name;
		itemQuantity = quantity;
		itemPricePerUnit = pricePerUnit;
	}

	/**
	 * getCost() returns the total amount of price each item costs.
	 * 
	 * @return a double which is the multiplication of item quantity and price per
	 *         unit.
	 */
	public double getCost() {
		double cost = this.itemQuantity * this.itemPricePerUnit;
		return cost;
	}

	/**
	 * Actually it wasn't called in my program, since I think the function of this
	 * method is a part of the constructor. I still wrote it because the instruction
	 * asks me to do it.
	 * 
	 * setQuantity() sets the grocery item's quantity to be given value.
	 * 
	 * @param quantity an integer of the quantity of the item.
	 */
	public void setQuantity(int quantity) {
		itemQuantity = quantity;
	}

}