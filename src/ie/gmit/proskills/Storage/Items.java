package ie.gmit.proskills.Storage;

public class Items {

	// Variables
	private String itemName;
	
	// Getters and Setters
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	private double itemPrice;
	
	// Constructor
	public Items(String name, double price) {
		super();
		this.itemName = itemName;
		this.itemPrice = itemPrice;
	}

	// ToString override
	@Override
	public String toString() {
		return "\nName:  " + itemName + "\nPrice: €" + itemPrice + "\n";
	}
}
