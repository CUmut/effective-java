package Chapter5.item30;

import java.util.HashSet;
import java.util.Set;

public class Union {

	/*
	 * Just as classes can be generic, so can methods. Static utility methods that
	 * operate on parameterized types are usually generic. All of the “algorithm”
	 * methods in Collections (such as binarySearchand sort) are generic. Writing
	 * generic methods is similar to writing generic types. Consider this deficient
	 * method, which returns the union of two sets:
	 */

	/*
	 * To fix these warnings and make the method typesafe, modify its declaration to
	 * declare a type parameter representing the element type for the three sets
	 * (the two arguments and the return value) and use this type parameter
	 * throughout the method. The type parameter list, which declares the type
	 * parameters, goes between a method’s modifiers and its return type.
	 */

	/*
	 * In summary, generic methods, like generic types, are safer and easier to use
	 * than methods requiring their clients to put explicit casts on input
	 * parameters and return values. Like types, you should make sure that your
	 * methods can be used without casts, which often means making them generic. And
	 * like types, you should generify existing methods whose use requires casts.
	 * This makes life easier for new users without breaking existing clients
	 */

	// Generic method
	/*
	 * s1 ve s2'ye gelen 2 veri tipide aynı olmalı.
	 */
	public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
		Set<E> result = new HashSet<>(s1);
		result.addAll(s2);
		return result;
	}

	// Simple program to exercise generic method
	public static void main(String[] args) {
		Set<String> guys = Set.of("Tom", "Dick", "Harry");
		Set<String> stooges = Set.of("Larry", "Moe", "Curly");
		Set<String> aflCio = union(guys, stooges);
		System.out.println(aflCio);
	}

}
