package Chapter4.item18;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class InstrumentedHashSet<E> extends HashSet<E> {

	/*
	 * The problems discussed in this item do not apply to interface
	 * inheritance(when a class implements an interface or when one interface
	 * extends another). Unlike method invocation, inheritance violates
	 * encapsulation In other words, a subclass depends on the implementation
	 * details of its superclass for its proper function. The superclass’s
	 * implementation may change from release to release, and if it does, the
	 * subclass may break, even though its code has not been touched. As a
	 * consequence, a subclass must evolve in tandem with its superclass, unless the
	 * superclass’s authors have designed and documented it specifically for the
	 * purpose of being extended.
	 * 
	 * To make this concrete, let’s suppose we have a program that uses a HashSet.
	 * To tune the performance of our program, we need to query the HashSet as to
	 * how many elements have been added since it was created (not to be confused
	 * with its current size, which goes down when an element is removed). To
	 * provide this functionality, we write a HashSet variant that keeps count of
	 * the number of attempted element insertions and exports an accessor for this
	 * count. The HashSet class contains two methods capable of adding elements, add
	 * and addAll, so we override both of these methods:
	 */

	/*
	 * inheritance is appropriate only in circumstances where the subclass really is
	 * a subtype of the superclass. In other words, a class B should extend a class
	 * A only if an “is-a” relationship exists between the two classes. If you are
	 * tempted to have a class B extend a class A, ask yourself the question: Is
	 * every Breally an A?
	 */

	// The number of attempted element insertions
	private int addCount = 0;

	public InstrumentedHashSet() {
	}

	public InstrumentedHashSet(int initCap, float loadFactor) {
		super(initCap, loadFactor);
	}

	@Override
	public boolean add(E e) {
	//	addCount++; // HashSet içerisinde add ile tekrar arttırdığı için sonuç 6 çıkacaktır.Sonuç
					// her kalıtım yaptığın sınıfı dost sanma tanı !.
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
		InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
		s.addAll(Arrays.asList("Snap", "Crackle", "Pop"));
		System.out.println(s.getAddCount());
	}

}
