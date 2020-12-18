package Chapter5.item32;

import java.util.ArrayList;
import java.util.List;

public class Test4 {
	/*
	 * The rule for deciding when to use the SafeVarargs annotation is simple:
	 * Use @SafeVarargs on every method with a varargs parameter of a generic or
	 * parameterized type, so its users won’t be burdened by needless and confusing
	 * compiler warnings. This implies that you should neverwrite unsafe varargs
	 * methods like dangerous or toArray. Every time the compiler warns you of
	 * possible heap pollution from a generic varargs parameter in a method you
	 * control, check that the method is safe. As a reminder, a generic varargs
	 * methods is safe if: 1. it doesn’t store anything in the varargs parameter
	 * array, and 2. it doesn’t make the array (or a clone) visible to untrusted
	 * code. If either of these prohibitions is violated, fix it. Note that the
	 * SafeVarargs annotation is legal only on methods that can’t be overridden,
	 * because it is impossible to guarantee that every possible overriding method
	 * will be safe. In Java 8, the annotation was legal only on static methods and
	 * final instance methods; in Java 9, it became legal on private instance
	 * methods as well. An alternative to using the SafeVarargs annotation is to
	 * take the advice of Item 28 and replace the varargs parameter (which is an
	 * array in disguise) with a List parameter. Here’s how this approach looks when
	 * applied to our flatten method. Note that only the parameter declaration has
	 * changed:
	 */

	// List as a typesafe alternative to a generic varargs parameter
	static <T> List<T> flatten(List<List<? extends T>> lists) {
		List<T> result = new ArrayList<>();
		for (List<? extends T> list : lists)
			result.addAll(list);
		return result;
	}

}
