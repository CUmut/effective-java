package Chapter9.item61;

import java.util.Comparator;

public class BrokenComparator {

	public static void main(String[] args) {

//       Comparator<Integer> naturalOrder =
//               (i, j) -> (i < j) ? -1 : (i == j ? 0 : 1);

		// Fixed Comparator
		Comparator<Integer> naturalOrder = (iBoxed, jBoxed) -> {
			int i = iBoxed, j = jBoxed; // Auto-unboxing
			return i < j ? -1 : (i == j ? 0 : 1);
		};

		int result = naturalOrder.compare(new Integer(42), new Integer(42));
		System.out.println(result);
	}

}
