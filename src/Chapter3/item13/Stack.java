package Chapter3.item13;

import java.util.Arrays;

public class Stack implements Cloneable {

	/*
	 * Given all the problems associated with Cloneable, new interfaces should not
	 * extend it, and new extendable classes should not implement it. While it’s
	 * less harmful for final classes to implement Cloneable, this should be viewed
	 * as a performance optimization, reserved for the rare cases where it is
	 * justified (Item 67). As a rule, copy functionality is best provided by
	 * constructors or factories. A notable exception to this rule is arrays, which
	 * are best copied with the clone method.
	 */

	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;

	public Stack() {
		this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}

	public void push(Object e) {
		ensureCapacity();
		elements[size++] = e;
	}

	public Object pop() {
		if (size == 0)
			throw new EmptyStackException();
		Object result = elements[--size];
		elements[size] = null; // Eliminate obsolete reference
		return result;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	/*
	 * In effect, the clone method functions as a constructor; you must ensure that
	 * it does no harm to the original object and that it properly establishes
	 * invariants on the clone. In order for the clone method on Stack to work
	 * properly, it must copy the internals of the stack. The easiest way to do this
	 * is to call clone recursively on the elements array:
	 */

	// Clone method for class with references to mutable state
	@Override
	public Stack clone() {
		try {
			Stack result = (Stack) super.clone();
			result.elements = elements.clone();
			return result;
		} catch (CloneNotSupportedException e) {
			throw new AssertionError();
		}
	}

	// Ensure space for at least one more element.
	private void ensureCapacity() {
		if (elements.length == size)
			elements = Arrays.copyOf(elements, 2 * size + 1);
	}

	// To see that clone works, call with several command line arguments
	public static void main(String[] args) {
		Stack stack = new Stack();
		for (String arg : args)
			stack.push(arg);
		Stack copy = stack.clone();
		while (!stack.isEmpty())
			System.out.print(stack.pop() + "");
		System.out.println();
		while (!copy.isEmpty())
			System.out.print(copy.pop() + " ");
	}
}
