package Chapter4.item20;

import java.util.AbstractList;
import java.util.List;
import java.util.Objects;

public interface Test {

	/*
	 * To summarize, an interface is generally the best way to define a type that
	 * permits multiple implementations. If you export a nontrivial interface, you
	 * should strongly consider providing a skeletal implementation to go with it.
	 * To the extent possible, you should provide the skeletal implementation via
	 * default methods on the interface so that all implementors of the interface
	 * can make use of it. That said, restrictions on interfaces typically mandate
	 * that a skeletal implementation take the form of an abstract class.
	 */

	static List<Integer> intArrayAsList(int[] a) {
		Objects.requireNonNull(a);
		// The diamond operator is only legal here in Java 9 and later // If you're
		// using an earlier release, specify <Integer>
		return new AbstractList<Integer>() {
			@Override
			public Integer get(int i) {
				return a[i]; // Autoboxing (Item 6)
			}

			@Override
			public Integer set(int i, Integer val) {
				int oldVal = a[i];
				a[i] = val; // Auto-unboxing
				return oldVal; // Autoboxing
			}

			@Override
			public int size() {
				return a.length;
			}
		};
	}

}
