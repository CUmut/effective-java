package Chapter10.item69;

public class Test {

	public static void main(String[] args) {

		/*
		 * The moral of this story is simple: Exceptions are, as their name implies, to
		 * be used only for exceptional conditions; they should never be used for
		 * ordinary control flow
		 * 
		 * This principle also has implications for API design. A well-designed API must
		 * not force its clients to use exceptions for ordinary control flow.
		 * 
		 * In summary, exceptions are designed for exceptional conditions. Don’t use
		 * them for ordinary control flow, and don’t write APIs that force others to do
		 * so.
		 */

		Mountain[] range = new Mountain[] { new Mountain(), new Mountain() };
		// Horrible abuse of exceptions. Don't ever do this!
		try {
			int i = 0;
			while (true)
				range[i++].climb();
		} catch (ArrayIndexOutOfBoundsException e) {
		}

		for (Mountain m : range)
			m.climb();

	}
}

class Mountain {
	void climb() {

	}
}
