package Chapter6.item39;

import java.lang.reflect.*;

public class RunTests {

	public static void main(String[] args) throws ClassNotFoundException {

		int tests = 0;
		int passed = 0;
		///
		Class<?> testClass = Class.forName("chapter06.item39.examples.Sample");

		for (Method m : testClass.getDeclaredMethods()) {
			if (m.isAnnotationPresent(Test.class)) {
				tests++;
				try {
					m.invoke(null);
					passed++;
				} catch (InvocationTargetException wrappedExc) {
					Throwable exc = wrappedExc.getCause();
					System.out.println(m + " failed : " + exc);
				} catch (Exception e) {
					System.out.println("Invalid @Test : " + m);
				}
			}
		}

		System.out.println("tests :  " + tests + " , passed : " + passed + " failed : " + (tests - passed));
	}

}
