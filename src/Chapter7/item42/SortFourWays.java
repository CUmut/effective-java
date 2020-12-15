package Chapter7.item42;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortFourWays {

	/*
	 * Unlike methods and classes, lambdas lack names and documentation; of a
	 * computation is not self-explanatory, or exceeds a few lines, don’t put it in
	 * a lambda
	 * 
	 * One line is ideal for a lambda, and three lines is a reasonable maximum.
	 * 
	 * If you violate this rule, it can cause serious harm to the readability of
	 * your programs
	 * 
	 */

	public static void main(String[] args) {
		List<String> words = Arrays.asList(args);

		// Anonymous class instance as a function object - obsolete!
		/*
		 * Historically, interfaces (or, rarely, abstract classes) with a single
		 * abstract method were used as function types. Their instances, known as
		 * function objects, represent functions or actions. Since JDK 1.1 was released
		 * in 1997, the primary means of creating a function object was the anonymous
		 * class (Item 24). Here’s a code snippet to sort a list of strings in order of
		 * length, using an anonymous class to create the sort’s comparison function
		 * (which imposes the sort order):
		 */
		Collections.sort(words, new Comparator<String>() {
			public int compare(String s1, String s2) {
				return Integer.compare(s1.length(), s2.length());
			}
		});
		System.out.println(words);
		Collections.shuffle(words);

		// Lambda expression as function object (replaces anonymous class) (Page 194)
		Collections.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
		System.out.println(words);
		Collections.shuffle(words);

		// Comparator construction method (with method reference) in place of lambda
		// (Page 194)
		Collections.sort(words, comparingInt(String::length));
		System.out.println(words);
		Collections.shuffle(words);

		// Default method List.sort in conjunction with comparator construction method
		// (Page 194)
		words.sort(comparingInt(String::length));
		System.out.println(words);
	}

	/*
	 * In summary, as of Java 8, lambdas are by far the best way to represent small
	 * function objects. Don’t use anonymous classes for function objects unless you
	 * have to create instances of types that aren’t functional interfaces. Also,
	 * remember that lambdas make it so easy to represent small function objects
	 * that it opens the door to functional programming techniques that were not
	 * previously practical in Java.
	 */

}
