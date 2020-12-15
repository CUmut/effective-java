package Chapter8.item54;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheeseFactory {

	/*
	 * In summary, never return null in place of an empty array or collection. It
	 * makes your API more difficult to use and more prone to error, and it has no
	 * performance advantages.
	 */

	/*
	 * Null kullanmak Hataya daha yatkın hale getirir. kod okunurluğunu düşürür dizi
	 * veya koleksiyon kullanmak daha iyidir
	 */

	private static final List<Cheese> stock = new ArrayList<Cheese>();

	public static List<Cheese> getCheese() {

		if (stock.isEmpty()) {
			// return null; // DON'T USE
			return Collections.emptyList();
		}

		return stock;
	}

	public static void main(String[] args) {

		List<Cheese> cheeseList = CheeseFactory.getCheese();
		if (cheeseList != null && cheeseList.contains(Cheese.EZINE)) {

			System.out.println("What a beautiful cheese");
		}

	}

}
