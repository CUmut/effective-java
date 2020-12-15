package Chapter5.item31;

import java.util.Arrays;
import java.util.List;

public class Swap {

	public static void swap(List<?> list, int i, int j) {
		swapHelper(list, i, j);
	}

	// Private helper method for wildcard capture
	/*
	 * It doesn’t seem right that we can’t put an element back into the list that we
	 * just took it out of. The problem is that the type of list is List<?>, and you
	 * can’t put any value except null into a List<?>. Fortunately, there is a way
	 * to implement this method without resorting to an unsafe cast or a raw type.
	 * The idea is to write a private helper method to capture the wildcard type.
	 * The helper method must be a generic method in order to capture the type.
	 * Here’s how it looks:
	 */
	private static <E> void swapHelper(List<E> list, int i, int j) {
		list.set(i, list.set(j, list.get(i)));
	} 

	public static void main(String[] args) {
		// Swap the first and last argument and print the resulting list
		List<String> argList = Arrays.asList(args);
		swap(argList, 0, argList.size() - 1);
		System.out.println(argList);
	}
}
