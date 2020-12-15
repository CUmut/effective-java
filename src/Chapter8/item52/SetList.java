package Chapter8.item52;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetList {

	/*
	 * This is the case when at least one corresponding formal parameter in each
	 * pair of overloadings has a “radically different” type in the two
	 * overloadings. Two types are radically different if it is clearly impossible
	 * to cast any non-null expression to both types. Under these circumstances,
	 * which overloading applies to a given set of actual parameters is fully
	 * determined by the runtime types of the parameters and cannot be affected by
	 * their compile-time types, so a major source of confusion goes away. For
	 * example, ArrayList has one constructor that takes an int and a second
	 * constructor that takes a Collection. It is hard to imagine any confusion over
	 * which of these two constructors will be invoked under any circumstances.
	 * Prior to Java 5, all primitive types were radically different from all
	 * reference types, but this is not true in the presence of autoboxing, and it
	 * has caused real trouble. Consider the following program:
	 */

	/*
	 * The call to set.remove(i) selects the overloading remove(E), where E is the
	 * element type of the set (Integer), and autoboxes i from int to Integer. This
	 * is the behavior you’d expect, so the program ends up removing the positive
	 * values from the set. The call to list.remove(i), on the other hand, selects
	 * the overloading remove(int i), which removes the element at the specified
	 * position in the list. If you start with the list [-3, -2, -1, 0, 1, 2] and
	 * remove the zeroth element, then the first, and then the second, you’re left
	 * with [-2, 0, 2], and the mystery is solved.
	 */

	public static void main(String[] args) {
		Set<Integer> set = new TreeSet<>();
		List<Integer> list = new ArrayList<>();

		for (int i = -3; i < 3; i++) {
			set.add(i);
			list.add(i);
		}
		for (int i = 0; i < 3; i++) {
			set.remove(i);
			list.remove((Integer) i);
		}
		System.out.println(set + " " + list);
	}

}
