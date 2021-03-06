package Chapter6.item39;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunTest3 {

	public static void main(String[] args) throws ClassNotFoundException {

		int tests = 0;
		int passed = 0;
		///
		Class<?> testClass = Class.forName("chapter06.item39.examples.Sample3");

		for (Method m : testClass.getDeclaredMethods()) {
			if (m.isAnnotationPresent(ExceptionTestV2.class)) {
				tests++;
				try {
					m.invoke(null);
					System.out.printf("Test %s failed: no exception%n", m);
				} catch (InvocationTargetException wrappedEx) {
					Throwable exc = wrappedEx.getCause();
					int oldPassed = passed;
					Class<? extends Throwable>[] excTypes = m.getAnnotation(ExceptionTestV2.class).value();
					for (Class<? extends Throwable> excType : excTypes) {
						if (excType.isInstance(exc)) {
							passed++;
							break;
						}
					}

					if (passed == oldPassed) {
						System.out.printf("Test %s failed: %s %n", m, exc);
					}

				} catch (Exception e) {
					System.out.println("Invalid @Test : " + m);
				}
			}
		}

		System.out.println("tests :  " + tests + " , passed : " + passed + " failed : " + (tests - passed));
	}

}
