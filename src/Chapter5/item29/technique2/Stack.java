package Chapter5.item29.technique2;

import java.util.Arrays;

import Chapter5.item29.EmptyStackException;

public class Stack<E> {

	/*
	 * This class should have been parameterized to begin with, but since it wasn’t,
	 * we can generify it after the fact. In other words, we can parameterize it
	 * without harming clients of the original non-parameterized version. As it
	 * stands, the client has to cast objects that are popped off the stack, and
	 * those casts might fail at runtime. The first step in generifying a class is
	 * to add one or more type parameters to its declaration. In this case there is
	 * one type parameter, representing the element type of the stack, and the
	 * conventional name for this type parameter is E The next step is to replace
	 * all the uses of the type Object with the appropriate type parameter and then
	 * try to compile the resulting program:
	 */

	/*
	 * In summary, generic types are safer and easier to use than types that require
	 * casts in client code. When you design new types, make sure that they can be
	 * used without such casts. This will often mean making the types generic. If
	 * you have any existing types that should be generic but aren’t, generify them.
	 * This will make life easier for new users of these types without breaking
	 * existing clients
	 */

	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;

	public Stack() {
		elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}

	public void push(E e) {
		ensureCapacity();
		elements[size++] = e;
	}

	// Appropriate suppression of unchecked warning
	public E pop() {
		if (size == 0)
			throw new EmptyStackException();

		// push requires elements to be of type E, so cast is correct
		@SuppressWarnings("unchecked")
		E result = (E) elements[--size];

		elements[size] = null; // Eliminate obsolete reference
		return result;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	private void ensureCapacity() {
		if (elements.length == size)
			elements = Arrays.copyOf(elements, 2 * size + 1);
	}

	// Little program to exercise our generic Stack
	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		for (String arg : args)
			stack.push(arg);
		while (!stack.isEmpty())
			System.out.println(stack.pop().toUpperCase());
	}

}
