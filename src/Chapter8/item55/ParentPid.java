package Chapter8.item55;

import java.util.Optional;

public class ParentPid {

	public static void main(String[] args) {
		ProcessHandle ph = ProcessHandle.current();

		// Inappropriate use of isPresent
		Optional<ProcessHandle> parentProcess = ph.parent();
		System.out.println(
				"Parent PID: " + (parentProcess.isPresent() ? String.valueOf(parentProcess.get().pid()) : "N/A"));

		// Equivalent (and superior) code using orElse
		System.out.println("Parent PID: " + ph.parent().map(h -> String.valueOf(h.pid())).orElse("N/A"));
	}

	/*
	 * Returning an optional that contains a boxed primitive type is prohibitively
	 * expensive compared to returning a primitive type because the optional has two
	 * levels of boxing instead of zero. Therefore, the library designers saw fit to
	 * provide analogues of Optional<T> for the primitive types int, long, and
	 * double. These optional types are OptionalInt, OptionalLong, and
	 * OptionalDouble. They contain most, but not all, of the methods on
	 * Optional<T>. Therefore, you should never return an optional of a boxed
	 * primitive type, with the possible exception of the “minor primitive types,”
	 * Boolean, Byte, Character, Short, and Float. Thus far, we have discussed
	 * returning optionals and processing them after they are returned. We have not
	 * discussed other possible uses, and that is because most other uses of
	 * optionals are suspect.
	 * 
	 * you should never use optionals as map values. If you do, you have two ways of
	 * expressing a key’s logical absence from the map: either the key can be absent
	 * from the map, or it can be present and map to an empty optional. This
	 * represents needless complexity with great potential for confusion and errors.
	 * More generally, it is almost never appropriate to use an optional as a key,
	 * value, or element in a collection or array.
	 * 
	 * In summary, if you find yourself writing a method that can’t always return a
	 * value and you believe it is important that users of the method consider this
	 * possibility every time they call it, then you should probably return an
	 * optional. You should, however, be aware that there are real performance
	 * consequences associated with returning optionals; for performance-critical
	 * methods, it may be better to return a null or throw an exception. Finally,
	 * you should rarely use an optional in any other capacity than as a return
	 * value.F
	 */

}
