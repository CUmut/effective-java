package Chapter6.item39;

public class Sample {

	/*
	 * xThe Sample class has seven static methods, four of which are annotated as
	 * tests. Two of these, m3 and m7, throw exceptions, and two, m1 and m5, do not.
	 * But one of the annotated methods that does not throw an exception, m5, is an
	 * instance method, so it is not a valid use of the annotation. In sum, Sample
	 * contains four tests: one will pass, two will fail, and one is invalid. The
	 * four methods that are not annotated with the Test annotation will be ignored
	 * by the testing tool. The Test annotations have no direct effect on the
	 * semantics of the Sample class. They serve only to provide information for use
	 * by interested programs. More generally, annotations don’t change the
	 * semantics of the annotated code but enable it for special treatment by tools
	 * such as this simple test runner:
	 */

	@Test
	public static void m1() {

	}

	public static void m2() {

	}

	@Test
	public static void m3() {
		throw new RuntimeException("Boom");
	}

	public static void m4() {

	}

	@Test
	public void m5() { // Invalid USE : nonstatic method

	}

	public static void m6() {

	}

	@Test
	public static void m7() {
		throw new RuntimeException("Crash");
	}

	public static void m8() {
	}
}
