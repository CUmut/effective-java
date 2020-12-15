package Chapter5.item26.generics;

import java.util.ArrayList;
import java.util.List;

public class Raw {

	/*
	 * Generics kullanarak hataları derleme anında yakalayabiliyoruz.
	 * 
	 * You must use raw types in class literals.
	 * 
	 * 
	 * you lose type safety if you use a raw type such as List, but not if you use a
	 * parameterized type such as List<Object>. To make this concrete, consider the
	 * following program:
	 */

	public static void main(String[] args) {
		List<String> strings = new ArrayList<>();
		unsafeAdd(strings, new String("42"));
		String s = strings.get(0); // Has compiler-generated cast
	}

	/*
	 * And indeed, if you run the program, you get a ClassCastException when the
	 * program tries to cast the result of the invocation strings.get(0), which is
	 * an Integer, to a String. This is a compiler-generated cast, so it’s normally
	 * guaranteed to succeed, but in this case we ignored a compiler warning and
	 * paid the price. If you replace the raw type List with the parameterized type
	 * List<Object> in the unsafeAdd declaration and try to recompile the program,
	 * you’ll find that it no longer compiles but emits the error message:
	 */

	private static <T> void unsafeAdd(List<T> list, T o) {
		list.add(o);
	}

	// Uses unbounded wildcard type - typesafe and flexible static int
	
	// soru işareti ile gelen tip belli olmadığı için null dışında nesne atılmasına
	// izin verilmez.
	
	// numElementsInCommon(Set<?> s1, Set<?> s2) { ... }
}
