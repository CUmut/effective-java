package Chapter4.item18;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class InstrumentedSet<E> extends ForwardingSet<E> {

	/*
	 * To summarize, inheritance is powerful, but it is problematic because it
	 * violates encapsulation. It is appropriate only when a genuine subtype
	 * relationship exists between the subclass and the superclass. Even then,
	 * inheritance may lead to fragility if the subclass is in a different package
	 * from the superclass and the superclass is not designed for inheritance. To
	 * avoid this fragility, use composition and forwarding instead of inheritance,
	 * especially if an appropriate interface to implement a wrapper class exists.
	 * Not only are wrapper classes more robust than subclasses, they are also more
	 * powerful.
	 */

	private int addCount = 0;

	public InstrumentedSet(Set<E> s) {
		super(s);
	}

	@Override
	public boolean add(E e) {
		addCount++;
		return super.add(e);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		addCount += c.size();
		return super.addAll(c);
	}

	public int getAddCount() {
		return addCount;
	}

	public static void main(String[] args) {
		InstrumentedSet<String> s = new InstrumentedSet<>(new HashSet<>());
		s.addAll(Arrays.asList("Snap", "Crackle", "Pop"));
		System.out.println(s.getAddCount());
	}

}
