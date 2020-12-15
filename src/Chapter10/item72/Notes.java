package Chapter10.item72;

public class Notes {

	/*
	 * STANDARD EXCEPTIONS An attribute that distinguishes expert programmers from
	 * less experienced ones is that experts strive for and usually achieve a high
	 * degree of code reuse. Exceptions are no exception to the rule that code reuse
	 * is a good thing. The Java libraries provide a set of exceptions that covers
	 * most of the exception-throwing needs of most APIs. Reusing standard
	 * exceptions has several benefits. Chief among them is that it makes your API
	 * easier to learn and use because it matches the established conventions that
	 * programmers are already familiar with. A close second is that programs using
	 * your API are easier to read because they aren’t cluttered with unfamiliar
	 * exceptions. Last (and least), fewer exception classes means a smaller memory
	 * footprint and less time spent loading classes. The most commonly reused
	 * exception type is IllegalArgumentException (Item 49). This is generally the
	 * exception to throw when the caller passes in an argument whose value is
	 * inappropriate. For example, this would be the exception to throw if the
	 * caller passed a negative number in a parameter representing the number of
	 * times some action was to be repeated. Another commonly reused exception is
	 * IllegalStateException. This is generally the exception to throw if the
	 * invocation is illegal because of the state of the receiving object. For
	 * example, this would be the exception to throw if the caller attempted to use
	 * some object before it had been properly initialized. Arguably, every
	 * erroneous method invocation boils down to an illegal argument or state, but
	 * other exceptions are standardly used for certain kinds of illegal arguments
	 * and states. If a caller passes nullin some parameter for which null values
	 * are prohibited, convention dictates that NullPointerException be thrown
	 * rather than IllegalArgumentException. Similarly, if a caller passes an
	 * out-of-range value in a parameter representing an index into a sequence,
	 * IndexOutOfBoundsException should be thrown rather than
	 * IllegalArgumentException. Another reusable exception is
	 * ConcurrentModificationException. It should be thrown if an object that was
	 * designed for use by a single thread (or with external synchronization)
	 * detects that it is being modified concurrently. This exception is at best a
	 * hint because it is impossible to reliably detect concurrent modification. A
	 * last standard exception of note is UnsupportedOperationException. This is the
	 * exception to throw if an object does not support an attempted operation. Its
	 * use is rare because most objects support all of their methods. This exception
	 * is used by classes that fail to implement one or more optional operations
	 * defined by an interface they implement. For example, an append-only List
	 * implementation would throw this exception if someone tried to delete an
	 * element from the list. Do not reuse Exception, RuntimeException, Throwable,
	 * or Error directly. Treat these classes as if they were abstract. You can't
	 * reliably test for these exceptions because they are superclasses of other
	 * exceptions that a method may throw. This table summarizes the most commonly
	 * reused exceptions:
	 */

	// IllegalArgumentException : Non-null parameter value is inappropriate
	// IllegalStateException : Object state is inappropriate for method invocati
	// NullPointerException : Parameter value is null where prohibited
	// IndexOutOfBoundsException :Index parameter value is out of range
	// ConcurrentModificationException : Concurrent modification of an object has
	// been d prohibited
	// UnsupportedOperationException : Object does not support method

	/*
	 * Choosing which exception to reuse can be tricky because the “occasions for
	 * use” in the table above do not appear to be mutually exclusive. Consider the
	 * case of an object representing a deck of cards, and suppose there were a
	 * method to deal a hand from the deck that took as an argument the size of the
	 * hand. If the caller passed a value larger than the number of cards remaining
	 * in the e deck, it could be construed as an IllegalArgumentException (the
	 * handSize parameter value is too high) or an IllegalStateException (the deck
	 * contains too few cards). Under these circumstances, the rule is to throw
	 * IllegalStateException if no argument values would have worked, otherwise
	 * throw IllegalArgumentException.
	 */

}
