package Chapter5.item32;

import java.util.concurrent.ThreadLocalRandom;

public class Test2 {

	// UNSAFE - Exposes a reference to its generic parameter array!
	static <T> T[] toArray(T... args) {
		return args;
	}

	/*
	 * This method is not, in and of itself, dangerous and would not generate a
	 * warning except that it invokes the toArray method, which has a generic
	 * varargs parameter. When compiling this method, the compiler generates code to
	 * create a varargs parameter array in which to pass two T instances to toArray.
	 * This code allocates an array of type Object[], which is the most specific
	 * type that is guaranteed to hold these instances, no matter what types of
	 * objects are passed to pickTwo at the call site. The toArray method simply
	 * returns this array to pickTwo, which in turn returns it to its caller, so
	 * pickTwo will always return an array of type Object[]. Now consider this main
	 * method, which exercises pickTwo:
	 */

	static <T> T[] pickTwo(T a, T b, T c) {
		switch (ThreadLocalRandom.current().nextInt(3)) {
		case 0:
			// Warning : Type safety: A generic array of T is created for a varargs
			// parameter
			// This code allocates an array of type Object[], which is the most specific
			// type that is guaranteed to hold these instances, no matter what types of
			// objects are passed to pickTwo at the call site
			return toArray(a, b);
		case 1:
			return toArray(a, c);
		case 2:
			return toArray(b, c);
		}
		throw new AssertionError(); // Can't get here
	}

	public static void main(String[] args) {
		String[] attributes = pickTwo("Good", "Fast", "Cheap"); // ClassCastException
		// The cast fails, because Object[] is not a subtype of String[]
	}

	// it is unsafe to give another method access to a generic varargs parameter
	// array

}
