package Chapter6.item39;

import java.util.ArrayList;
import java.util.List;

public class Sample3 {

	// Code containing an annotation with an array parameter
	@ExceptionTest2({ IndexOutOfBoundsException.class, NullPointerException.class })
	public static void doublyBad() {
		List<String> list = new ArrayList<>();
		// The spec permits this method to throw either
		// IndexOutOfBoundsException or NullPointerException
		list.addAll(5, null);
	}

}
