package Chapter5.item33;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Favorites {

	/*
	 * For example, a database row can have arbitrarily many columns, and it would
	 * be nice to be able to access all of them in a typesafe manner. Luckily, there
	 * is an easy way to achieve this effect. The idea is to parameterize the key
	 * instead of the container. Then present the parameterized key to the container
	 * to insert or retrieve a value. The generic type system is used to guarantee
	 * that the type of the value agrees with its key. As a simple example of this
	 * approach, consider a Favorites class that allows its clients to store and
	 * retrieve a favorite instance of arbitrarily many types. The Class object for
	 * the type will play the part of the parameterized key. The reason this works
	 * is that class Class is generic. The type of a class literal is not simply
	 * Class, but Class<T>. For example, String.class is of type Class<String>, and
	 * Integer.class is of type Class<Integer>. When a class literal is passed among
	 * methods to communicate both compile-time and runtime type information, it is
	 * called a type token [Bracha04]. The API for the Favorites class is simple. It
	 * looks just like a simple map, except that the key is parameterized instead of
	 * the map. The client presents a Class object when setting and getting
	 * favorites. Here is the API:
	 */

	private Map<Class<?>, Object> favorites = new HashMap<>();

	public <T> void putFavorite(Class<T> type, T instance) {
		favorites.put(Objects.requireNonNull(type), instance);
	}

	public <T> T getFavorite(Class<T> type) {
		// The cast method is the dynamic analogue of Java’s cast operator.
		return type.cast(favorites.get(type));

	}

}
