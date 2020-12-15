package Chapter5.item28;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Chooser<T> {

	/*
	 * In summary, arrays and generics have very different type rules. Arrays are
	 * covariant and reified; generics are invariant and erased. As a consequence,
	 * arrays provide runtime type safety but not compile-time type safety, and vice
	 * versa for generics. As a rule, arrays and generics don’t mix well. If you
	 * find yourself mixing them and getting compile-time errors or warnings, your
	 * first impulse should be to replace the arrays with lists.
	 */

	/*
	 * Diziler yerine generics kullanılarak hataları çalışma anında değil , derleme
	 * anında görebiliriz.
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

		// Why generic array creation is illegal - won't compile!
		List<Integer> intList = List.of(1, 2, 3, 4, 5, 6);

		Chooser<Integer> chooser = new Chooser<>(intList);

		for (int i = 0; i < 10; i++) {
			Number choice = chooser.choose();
			System.out.println(choice);
		}
	}

}
