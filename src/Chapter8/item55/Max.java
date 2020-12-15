package Chapter8.item55;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Max {

	/*
	 * If a client neglects to check for a null return and stores a null return
	 * value away in some data structure, a NullPointerException may result at some
	 * arbitrary time in the future, at some place in the code that has nothing to
	 * do with the problem.
	 * 
	 * A method that conceptually returns a T but may be unable to do so under
	 * certain circumstances can instead be declared to return an Optional<T>. This
	 * allows the method to return an empty result to indicate that it couldn’t
	 * return a valid result. An Optional-returning method is more flexible and
	 * easier to use than one that throws an exception, and it is less error-prone
	 * than one that returns null. In Item 30, we showed this method to calculate
	 * the maximum value in a collection, according to its elements’ natural order.
	 * 
	 */

//  // Returns maximum value in collection - throws exception if empty (Page 249)
//  public static <E extends Comparable<E>> E max(Collection<E> c) {
//      if (c.isEmpty())
//          throw new IllegalArgumentException("Empty collection");
//
//      E result = null;
//      for (E e : c)
//          if (result == null || e.compareTo(result) > 0)
//              result = Objects.requireNonNull(e);
//
//      return result;
//  }

//  // Returns maximum value in collection as an Optional<E> (Page 250)
//  public static <E extends Comparable<E>>
//  Optional<E> max(Collection<E> c) {
//      if (c.isEmpty())
//          return Optional.empty();
//
//      E result = null;
//      for (E e : c)
//          if (result == null || e.compareTo(result) > 0)
//              result = Objects.requireNonNull(e);
//
//      return Optional.of(result);
//  }

	// Returns max val in collection as Optional<E> - uses stream
	public static <E extends Comparable<E>> Optional<E> max(Collection<E> c) {
		return c.stream().max(Comparator.naturalOrder());
	}

	public static void main(String[] args) {
		List<String> words = Arrays.asList(args);

		System.out.println(max(words));

		// Using an optional to provide a chosen default value
		String lastWordInLexicon = max(words).orElse("No words...");
		System.out.println(lastWordInLexicon);
	}

}
