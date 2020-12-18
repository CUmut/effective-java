package Chapter5.item27;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test {

	/*
	 * In summary, unchecked warnings are important. Don’t ignore them. Every
	 * unchecked warning represents the potential for a ClassCastException at
	 * runtime. Do your best to eliminate these warnings. If you can’t eliminate an
	 * unchecked warning and you can prove that the code that provoked it is
	 * typesafe, suppress the warning with a @SuppressWarnings("unchecked")
	 * annotation in the narrowest possible scope. Record the rationale for your
	 * decision to suppress the warning in a comment.
	 */

	public static void main(String[] args) {
		Set<Lark> exaltation = new HashSet();
		// unchecked conversion

		Set<String> goodExaltation = new HashSet<>();

	}

	public <T> T[] toArray(T[] a) {
		if (a.length < size) {
			return (T[]) Arrays.copyOf(elements, size, a.getClass());
		}
		System.arraycopy(elements, 0, a, 0, size);
		if (a.length > size) {
			a[size] = null;
		}
		return a;
	}

	/*
	 * It is illegal to put a SuppressWarnings annotation on the return statement,
	 * because it isn’t a declaration [JLS, 9.7]. You might be tempted to put the
	 * annotation on the entire method, but don’t. Instead, declare a local variable
	 * to hold the return value and annotate its declaration, like so:
	 */

	public <T> T[] toArray(T[] a) {
		if (a.length < size) {
			// Burada tür güvenliği vardır çünkü yarattığımız dizinin türü
			// parametre geçilen tür ile aynıdır: T[]
			@SuppressWarnings("unchecked")
			T[] result = (T[]) Arrays.copyOf(elements, size, a.getClass());
			return result;
		}

		System.arraycopy(elements, 0, a, 0, size);
		if (a.length > size)
			a[size] = null;
	}

}
