package Chapter4.item19;

import java.time.Instant;

//Demonstration of what can go wrong when you override a method  called from constructor
public final class Sub extends Super {

	/*
	 * The only way to test a class designed for inheritance is to write subclasses.
	 * 
	 * The only way to test a class designed for inheritance is to write subclasses.
	 * 
	 * The superclass constructor runs before the subclass constructor, so the
	 * overriding method in the subclass will get invoked before the subclass
	 * constructor has run
	 * 
	 * If the overriding method depends on any initialization performed by the
	 * subclass constructor, the method will not behave as expected. To make this
	 * concrete, here’s a class that violates this rule:
	 */

	/*
	 * This is not just a theoretical problem. It is not uncommon to receive
	 * subclassing-related bug reports after modifying the internals of a nonfinal
	 * concrete class that was not designed and documented for inheritance. The best
	 * solution to this problem is to prohibit subclassing in classes that are not
	 * designed and documented to be safely subclassed.
	 */

	/*
	 * If you fail to do this, subclasses may become dependent on implementation
	 * details of the superclass and may break if the implementation of the
	 * superclass changes. To allow others to write efficient subclasses, you may
	 * also have to export one or more protected methods. Unless you know there is a
	 * real need for subclasses, you are probably better off prohibiting inheritance
	 * by declaring your class final or ensuring that there are no accessible
	 * constructors.
	 */

	// Blank final, set by constructor
	private final Instant instant;

	Sub() {
		instant = Instant.now();
	}

	// Overriding method invoked by superclass constructor
	@Override
	public void overrideMe() {
		System.out.println(instant);
	}

	public static void main(String[] args) {
		Sub sub = new Sub();
		sub.overrideMe();
	}

}
