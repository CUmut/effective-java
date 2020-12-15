package Chapter8.item53;

public class Varargs {

	/*
	 * Varargs metodları belirtilen türden 0 veya daha fazla argümanı kabul eder
	 * Metod parametlerinde karmaşıklığı engeller. Hatayı derleme anında
	 * yakalayabiliriz.
	 */

	// Simple use of varargs (Page 245)
	static int sum(int... args) {
		int sum = 0;
		for (int arg : args)
			sum += arg;
		return sum;
	}

	/*
	 * The varargs facility works by first creating an array whose size is the
	 * number of arguments passed at the call site, then putting the argument values
	 * into the array, and finally passing the array to the method.
	 */

	/*
	 * Sometimes it’s appropriate to write a method that requires one or more
	 * arguments of some type, rather than zero or more. For example, suppose you
	 * want to write a function that computes the minimum of its arguments. This
	 * function is not well defined if the client passes no arguments. You could
	 * check the array length at runtime:
	 */

//    // The WRONG way to use varargs to pass one or more arguments! (Page 245)
//    static int min(int... args) {
//        if (args.length == 0)
//            throw new IllegalArgumentException("Too few arguments");
//        int min = args[0];
//        for (int i = 1; i < args.length; i++)
//            if (args[i] < min)
//                min = args[i];
//        return min;
//    }

	// The right way to use varargs to pass one or more arguments (Page 246)
	static int min(int firstArg, int... remainingArgs) {
		int min = firstArg;
		for (int arg : remainingArgs)
			if (arg < min)
				min = arg;
		return min;
	}

	public static void main(String[] args) {
		System.out.println(sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		System.out.println(min(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
	}

	/*
	 * In summary, varargs are invaluable when you need to define methods with a
	 * variable number of arguments. Precede the varargs parameter with any required
	 * parameters, and be aware of the performance consequences of using varargs.
	 */

}
