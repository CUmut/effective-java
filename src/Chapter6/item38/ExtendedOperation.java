package Chapter6.item38;

import java.util.Arrays;
import java.util.Collection;

public enum ExtendedOperation {

	EXP("^") {
		public double apply(double x, double y) {
			return Math.pow(x, y);
		}
	},
	REMAINDER("%") {
		public double apply(double x, double y) {
			return x % y;
		}
	};

	private final String symbol;

	ExtendedOperation(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return symbol;
	}

	/*
	 * You can now use your new operations anywhere you could use the basic
	 * operations, provided that APIs are written to take the interface type
	 * (Operation), not the implementation (BasicOperation). Note that you don’t
	 * have to declare the abstract apply method in the enum as you do in a
	 * nonextensible enum with instance-specific method implementations (page 162).
	 * This is because the abstract method (apply) is a member of the interface
	 * (Operation). Not only is it possible to pass a single instance of an
	 * “extension enum” anywhere a “base enum” is expected, but it is possible to
	 * pass in an entire extension enum type and use its elements in addition to or
	 * instead of those of the base type. For example, here is a version of the test
	 * program on page 163 that exercises all of the extended operations defined
	 * previously:
	 */

	/*
	 * public static void main(String[] args) { double x =
	 * Double.parseDouble(args[0]); double y = Double.parseDouble(args[1]);
	 * test(ExtendedOperation.class, x, y); }
	 * 
	 * private static <T extends Enum<T> &amp; Operation> void test( Class<T>
	 * opEnumType, double x, double y) {
	 * 
	 * for (Operation op : opEnumType.getEnumConstants()) {
	 * System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y)); } }
	 */

	// Using a collection instance to represent a collection of extended enums (page
	// 178)
	public static void main(String[] args) {
		double x = Double.parseDouble(args[0]);
		double y = Double.parseDouble(args[1]);
		test(Arrays.asList(ExtendedOperation.values()), x, y);
	}

	private static void test(Collection<? extends Operation> opSet, double x, double y) {
		for (Operation op : opSet)
			System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
	}

}
