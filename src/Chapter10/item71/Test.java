package Chapter10.item71;

import java.io.FileNotFoundException;

public class Test {

	/*
	 * In summary, when used sparingly, checked exceptions can increase the
	 * reliability of programs; when overused, they make APIs painful to use. If
	 * callers won’t be able to recover from failures, throw unchecked exceptions.
	 * If recovery may be possible and you want to force callers to handle
	 * exceptional conditions, first consider returning an optional. Only if this
	 * would provide insufficient information in the case of failure should you
	 * throw a checked exception.
	 */

	public void throwException() throws TheCheckedException {
		throw new TheCheckedException();
	}

	public void testMethod() {
		try {
			throwException();
		} catch (TheCheckedException e) {
			throw new AssertionError(); // Can't happen!
		}

		try {
			throwException();
		} catch (TheCheckedException e) {
			e.printStackTrace(); // Oh well, we lose.
			System.exit(1);
		}

		String[] args = new String[] {};
		if (actionPermitted(args)) {

		} else {

		}

		/*
		 * If you suspect that the trivial calling sequence will be the norm, then the
		 * API refactoring may be appropriate. The resulting API is essentially the
		 * state-testing method API in Item 69 and the same caveats apply: if an object
		 * is to be accessed concurrently without external synchronization or it is
		 * subject to externally induced state transitions, this refactoring is
		 * inappropriate because the object’s state may change between the calls to
		 * actionPermitted and action. If a separate actionPermittedmethod would
		 * duplicate the work of the action method, the refactoring may be ruled out on
		 * performance grounds.
		 */
	}

	public boolean actionPermitted(String[] args) {
		return true;
	}

}

class TheCheckedException extends FileNotFoundException {

}