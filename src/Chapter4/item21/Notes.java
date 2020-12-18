package Chapter4.item21;

public class Notes {

	/*
	 * Prior to Java 8, it was impossible to add methods to interfaces without
	 * breaking existing implementations. If you added a new method to an interface,
	 * existing implementations would, in general, lack the method, resulting in a
	 * compile-time error. In Java 8, the default method construct was added [JLS
	 * 9.4], with the intent of allowing the addition of methods to existing
	 * interfaces. But adding new methods to existing interfaces is fraught with
	 * risk. The declaration for a default method includes a default implementation
	 * that is used by all classes that implement the interface but do not implement
	 * the default method. While the addition of default methods to Java makes it
	 * possible to add methods to an existing interface, there is no guarantee that
	 * these methods will work in all preexisting implementations. Default methods
	 * are “injected” into existing implementations without the knowledge or consent
	 * of their implementors. Before Java 8, these implementations were written with
	 * the tacit understanding that their interfaces would never acquire any new
	 * methods. Many new default methods were added to the core collection
	 * interfaces in Java 8, primarily to facilitate the use of lambdas (Chapter 6).
	 * The Java libraries’ default methods are high-quality general-purpose
	 * implementations, and in most cases, they work fine. But it is not always
	 * possible to write a default method that maintains all invariants of every
	 * conceivable implementation. For example, consider the removeIf method, which
	 * was added to the Collection interface in Java 8. This method removes all
	 * elements for which a given boolean function (or predicate) returns true. The
	 * default implementation is specified to traverse the collection using its
	 * iterator, invoking the predicate on each element, and using the iterator’s
	 * remove method to remove the elements for which the predicate returns true.
	 * Presumably the declaration looks something like this: Click here to view code
	 * image // Default method added to the Collection interface in Java 8 default
	 * boolean removeIf(Predicate<? super E> filter) {
	 * Objects.requireNonNull(filter); boolean result = false; for (Iterator<E> it =
	 * iterator(); it.hasNext(); ) { if (filter.test(it.next())) { it.remove();
	 * result = true; } } return result; } This is the best general-purpose
	 * implementation one could possibly write for the removeIf method, but sadly,
	 * it fails on some real-world Collection implementations. For example, consider
	 * org.apache.commons.collections4.-collection.SynchronizedCol
	 * 
	 * lection. This class, from the Apache Commons library, is similar to the one
	 * returned by the static factory Collections.-synchronizedCollection in
	 * java.util. The Apache version additionally provides the ability to use a
	 * client-supplied object for locking, in place of the collection. In other
	 * words, it is a wrapper class (Item 18), all of whose methods synchronize on a
	 * locking object before delegating to the wrapped collection. The Apache
	 * SynchronizedCollection class is still being actively maintained, but as of
	 * this writing, it does not override the removeIf method. If this class is used
	 * in conjunction with Java 8, it will therefore inherit the default
	 * implementation of removeIf, which does not, indeed cannot, maintain the
	 * class’s fundamental promise: to automatically synchronize around each method
	 * invocation. The default implementation knows nothing about synchronization
	 * and has no access to the field that contains the locking object. If a client
	 * calls the removeIf method on a SynchronizedCollection instance in the
	 * presence of concurrent modification of the collection by another thread, a
	 * ConcurrentModificationException or other unspecified behavior may result. In
	 * order to prevent this from happening in similar Java platform libraries
	 * implementations, such as the package-private class returned by
	 * Collections.synchronizedCollection, the JDK maintainers had to override the
	 * default removeIf implementation and other methods like it to perform the
	 * necessary synchronization before invoking the default implementation.
	 * Preexisting collection implementations that were not part of the Java
	 * platform did not have the opportunity to make analogous changes in lockstep
	 * with the interface change, and some have yet to do so. In the presence of
	 * default methods, existing implementations of an interface may compile without
	 * error or warning but fail at runtime. While not terribly common, this problem
	 * is not an isolated incident either. A handful
	 * 
	 * of the methods added to the collections interfaces in Java 8 are known to be
	 * susceptible, and a handful of existing implementations are known to be
	 * affected. Using default methods to add new methods to existing interfaces
	 * should be avoided unless the need is critical, in which case you should think
	 * long and hard about whether an existing interface implementation might be
	 * broken by your default method implementation. Default methods are, however,
	 * extremely useful for providing standard method implementations when an
	 * interface i
	 */

}
