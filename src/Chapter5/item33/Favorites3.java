package Chapter5.item33;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

public class Favorites3 {

	/*
	 * In summary, the normal use of generics, exemplified by the collections APIs,
	 * restricts you to a fixed number of type parameters per container. You can get
	 * around this restriction by placing the type parameter on the key rather than
	 * the container. You can use Class objects as keys for such typesafe
	 * heterogeneous containers. A Class object used in this fashion is called a
	 * type token. You can also use a custom key type. For example, you could have a
	 * DatabaseRow type representing a database row (the container), and a generic
	 * type Column<T> as its key.
	 */

	public <T extends Annotation> T getAnnotation(Class<T> annotationType) {
		return null;
	}

	static Class<? extends Annotation> getAnnotation(AnnotatedElement element, String annotationTypeName) {
		Class<?> annotationType = null; // Unbounded type token
		try {
			annotationType = Class.forName(annotationTypeName);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException(e);
		}
		return annotationType.asSubclass(Annotation.class);

	}

}
