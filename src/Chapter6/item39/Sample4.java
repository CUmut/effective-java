package Chapter6.item39;

import java.util.ArrayList;
import java.util.List;

public class Sample4 {

	@ExceptionTest4(ArithmeticException.class)
	public static void m1() { // Test should pass
		int i = 0;
		i = i / i;
	}

	@ExceptionTest(ArithmeticException.class)
	public static void m2() { // Should fail (wrong exception)
		int[] a = new int[0];
		int i = a[1];
	}

	@ExceptionTest(ArithmeticException.class)
	public static void m3() {
	} // Should fail (no exception)

	// Code containing a repeated annotation (Page 186)
	@ExceptionTest4(IndexOutOfsBoundsException.class)
	@ExceptionTest4(NullPointerException.class)
	public static void doublyBad() {
		List<String> list = new ArrayList<>();

		// The spec permits this staticfactory to throw either
		// IndexOutOfBoundsException or NullPointerException
		list.addAll(5, null);
	}

}
