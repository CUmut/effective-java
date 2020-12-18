package Chapter5.item33;

import java.util.HashMap;
import java.util.Map;

public class Favorites2 {

	private Map<Class<?>, Object> favorites = new HashMap<>();

	// Achieving runtime type safety with a dynamic cast
	public <T> void putFavorite(Class<T> type, T instance) {
		favorites.put(type, type.cast(instance));
	}

	public <T> T getFavorite(Class<T> type) {
		// The cast method is the dynamic analogue of Java’s cast operator.
		return type.cast(favorites.get(type));

	}

	/*
	 * There are a few subtle things going on here. Each Favorites instance is
	 * backed by a private Map<Class<?>, Object> called favorites. You might think
	 * that you couldn’t put anything into this Map because of the unbounded
	 * wildcard type, but the truth is quite the opposite. The thing to notice is
	 * that the wildcard type is nested: it’s not the type of the map that’s a
	 * wildcard type but the type of its key. This means that every key can have a
	 * different parameterized type: one can be Class<String>, the next
	 * Class<Integer>, and so on. That’s where the heterogeneity comes from. The
	 * next thing to notice is that the value type of the favorites Map is simply
	 * Object. In other words, the Map does not guarantee the type relationship
	 * between keys and values, which is that every value is of the type represented
	 * by its key. In fact, Java’s type system is not powerful enough to express
	 * this. But we know that it’s true, and we take advantage of it when the time
	 * comes to retrieve a favorite. The putFavorite implementation is trivial: it
	 * simply puts into favorites a mapping from the given Class object to the given
	 * favorite instance. As noted, this discards the “type linkage” between the key
	 * and the value; it loses the knowledge that the value is an instance of the
	 * key. But that’s OK, because the getFavorites method can and does reestablish
	 * this linkage. The implementation of getFavorite is trickier than that of
	 * putFavorite. First, it gets from the favorites map the value corresponding to
	 * the given Class object. This is the correct object reference to return, but
	 * it has the wrong compile-time type: it is Object (the value type of the
	 * favoritesmap) and we need to return a T. So, the getFavorite implementation
	 * dynamically casts the object reference to the type represented by the Class
	 * object, using Class’s cast method. The cast method is the dynamic analogue of
	 * Java’s cast operator. It simply checks that its argument is an instance of
	 * the type represented by the Class object. If so, it returns the argument;
	 * otherwise it throws a ClassCastException. We know that the cast invocation in
	 * getFavorite won’t throw ClassCastException, assuming the client code compiled
	 * cleanly. That is to say, we know that the values in the favorites map always
	 * match the types of their keys. So what does the cast method do for us, given
	 * that it simply returns its argument? The signature of the cast method takes
	 * full advantage of the fact that class Class is generic. Its return type is
	 * the type parameter of the Class object:
	 */
}
