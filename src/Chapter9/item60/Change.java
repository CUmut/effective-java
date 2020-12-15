package Chapter9.item60;

public class Change {

	// Broken - uses floating point for monetary calculation!
	public static void main(String[] args) {
		double funds = 1.00;
		int itemsBought = 0;
		for (double price = 0.10; funds >= price; price += 0.10) {
			funds -= price;
			itemsBought++;
		}
		System.out.println(itemsBought + " items bought.");
		System.out.println("Change: $" + funds);
	}

	/*
	 * This is the wrong answer! The right way to solve this problem is to use
	 * BigDecimal, int, or long for monetary calculations.
	 */

}
