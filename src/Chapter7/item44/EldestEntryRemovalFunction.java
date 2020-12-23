package Chapter7.item44;

import java.util.Map;

//Unnecessary functional interface ; use a standard one instead
@FunctionalInterface
public interface EldestEntryRemovalFunction<K, V> {

	boolean remove(Map<K, V> map, Map.Entry<K, V> eldest);

	/*
	 * In summary, now that Java has lambdas, it is imperative that you design your
	 * APIs with lambdas in mind. Accept functional interface types on input and
	 * return them on output. It is generally best to use the standard interfaces
	 * provided in java.util.function.Function, but keep your eyes open for the
	 * relatively rare cases where you would be better off writing your own
	 * functional interface.
	 */
}
