package Chapter5.item31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;

public class Stack<E> {

	private E[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;

	// The elements array will contain only E instances from push(E).
	// This is sufficient to ensure type safety, but the runtime
	// type of the array won't be E[]; it will always be Object[]!
	@SuppressWarnings("unchecked")
	public Stack() {
		elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
	}

	public void push(E e) {
		ensureCapacity();
		elements[size++] = e;
	}

	public E pop() {
		if (size == 0)
			throw new EmptyStackException();
		E result = elements[--size];
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

//    // pushAll staticfactory without wildcard type - deficient!
//    public void pushAll(Iterable<E> src) {
//        for (E e : src)
//            push(e);
//    }

	/*
	 * Luckily, there’s a way out. The language provides a special kind of
	 * parameterized type call a bounded wildcard type to deal with situations like
	 * this. The type of the input parameter to pushAll should not be “Iterable of
	 * E” but “Iterable of some subtype of E,” and there is a wildcard type that
	 * means precisely that: Iterable<? extends E>. (The use of the keyword extends
	 * is slightly misleading: recall from Item 29 that subtype is defined so that
	 * every type is a subtype of itself, even though it does not extend itself.)
	 * Let’s modify pushAll to use this type:
	 */
	// Wildcard type for parameter that serves as an E producer
	public void pushAll(Iterable<? extends E> src) {
		for (E e : src)
			push(e);
	}

	/*
	 * The popAll method pops each element off the stack and adds the elements to
	 * the given collection. Here’s how a first attempt at writing the popAll method
	 * might look:
	 */

//    // popAll staticfactory without wildcard type - deficient!
//    public void popAll(Collection<E> dst) {
//        while (!isEmpty())
//            dst.add(pop());
//    }

	// Wildcard type for parameter that serves as an E consumer
	public void popAll(Collection<? super E> dst) {
		while (!isEmpty())
			dst.add(pop());
	}

	// Little program to exercise our generic Stack
	public static void main(String[] args) {
		Stack<Number> numberStack = new Stack<>();
		Iterable<Integer> integers = Arrays.asList(3, 1, 4, 1, 5, 9);
		numberStack.pushAll(integers);

		Collection<Object> objects = new ArrayList<>();
		numberStack.popAll(objects);

		System.out.println(objects);
	}
}
