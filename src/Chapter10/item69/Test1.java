package Chapter10.item69;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Test1 {

	public static void main(String[] args) {

		List<Foo> collection = List.of();
		// Do not use this hideous code for iteration over a collection!
		try {
			Iterator<Foo> i = collection.iterator();
			while (true) {
				Foo foo = i.next();
			}
		} catch (NoSuchElementException e) {
		}

	}
}

class Foo {

}
