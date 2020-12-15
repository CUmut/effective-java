package Chapter5.item26.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Chooser<T> {

	/*
	 * Yanlış türde nesne eklenmesinin önüne geçilebilir ve genericler ile derleme
	 * anında hataları görebiliriz.

	/*
	 * SINCE Java 5, generics have been a part of the language. Before generics, you
	 * had to cast every object you read from a collection. If someone accidentally
	 * inserted an object of the wrong type, casts could fail at runtime. With
	 * generics, you tell the compiler what types of objects are permitted in each
	 * collection. The compiler inserts casts for you automatically and tells you at
	 * compile time if you try to insert an object of the wrong type. This results
	 * in programs that are both safer and clearer, but these benefits, which are
	 * not limited to collections, come at a price. This chapter tells you how to
	 * maximize the benefits and minimize the complications.
	 */

	/*
	 * This version is a tad more verbose, and perhaps a tad slower, but it’s worth
	 * it for the peace of mind that you won’t get a ClassCastException at runtime.
	 * In summary, arrays and generics have very different type rules. Arrays are
	 * covariant and reified; generics are invariant and erased. As a consequence,
	 * arrays provide runtime type safety but not compile-time type safety, and vice
	 * versa for generics. As a rule, arrays and generics don’t mix well. If you
	 * find yourself mixing them and getting compile-time errors or warnings, your
	 * first impulse should be to replace the arrays with lists.
	 */

	private final List<T> choiceList;

	public Chooser(Collection<T> choices) {
		choiceList = new ArrayList<>(choices);
	}

	public T choose() {
		Random rnd = ThreadLocalRandom.current();
		return choiceList.get(rnd.nextInt(choiceList.size()));
	}

	public static void main(String[] args) {
		List<Integer> intList = List.of(1, 2, 3, 4, 5, 6);

		Chooser<Integer> chooser = new Chooser<>(intList);
		/*
		 * // Why generic array creation is illegal - won't compile! List<String>[]
		 * stringLists = new List<String>[1]; // (1) List<Integer> intList =
		 * List.of(42); Object[] objects = stringLists; objects[0] = intList; String s =
		 * stringLists[0].get(0); // (2) // (3) // (4) // (5)
		 */

		/*
		 * List<Object> ol = new ArrayList<Long>(); // Incompatible types
		 * ol.add("I don't fit in");
		 */

		for (int i = 0; i < 10; i++) {
			Number choice = chooser.choose();
			System.out.println(choice);
		}
	}

}
