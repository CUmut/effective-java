package Chapter5.item32;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Test5 {
	static <T> List<T> pickTwo(T a, T b, T c) {
		switch (ThreadLocalRandom.current().nextInt(3)) {
		case 0:
			return List.of(a, b);
		case 1:
			return List.of(a, c);
		case 2:
			return List.of(b, c);
		}
		throw new AssertionError();
	}

	// The resulting code is typesafe because it uses only generics, and not arrays.
	public static void main(String[] args) {
		List<String> attributes = pickTwo("Good", "Fast", "Cheap");
		System.out.println(attributes);
	}

	/*
	 * The resulting code is typesafe because it uses only generics, and not arrays.
	 * In summary, varargs and generics do not interact well because the varargs
	 * facility is a leaky abstraction built atop arrays, and arrays have different
	 * type rules from generics. Though generic varargs parameters are not typesafe,
	 * they are legal. If you choose to write a method with a generic (or
	 * parameterized) varargs parameter, first ensure that the method is typesafe,
	 * and then annotate it with @SafeVarargs so it is not unpleasant to use.
	 */
}
