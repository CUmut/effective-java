package Chapter9.item61;

public class Unbelievable {

	/*
	 * Java has a two-part type system, consisting of primitives, such as int,
	 * double, and boolean, and reference types, such as String and List. Every
	 * primitive type has a corresponding reference type, called a boxed primitive.
	 * 
	 * The boxed primitives corresponding to int, double, and boolean are Integer,
	 * Double, and Boolean.
	 * 
	 * As mentioned in Item 6, autoboxing and auto-unboxing blur but do not erase
	 * the distinction between the primitive and boxed primitive types. There are
	 * real differences between the two, and it’s important that you remain aware of
	 * which you are using and that you choose carefully between them. There are
	 * three major differences between primitives and boxed primitives. First,
	 * primitives have only their values, whereas boxed primitives have identities
	 * distinct from their value,
	 * 
	 * In other words, two boxed primitive instances can have the same value and
	 * different identities. Second, primitive types have only fully functional
	 * values, whereas each boxed primitive type has one nonfunctional value, which
	 * is null, in addition to all the functional values of the corresponding
	 * primitive type.
	 * 
	 * Last, primitives are more time- and space-efficient than boxed primitives.
	 * All three of these differences can get you into real trouble if you aren’t
	 * careful. Consider the following comparator, which is designed to represent
	 * ascending numerical order on Integer values. (Recall that a comparator’s
	 * compare method returns a number that is negative, zero, or positive,
	 * depending on whether its first argument is less than, equal to, or greater
	 * than its second.) You wouldn’t need to write this comparator in practice
	 * because it implements the natural ordering on Integer, but it makes for an
	 * interesting example:
	 */

	/*
	 * The problem is that i is an Integer, not an int, and like all nonconstant
	 * object reference fields, its initial value is null.
	 */
	static Integer i; // primitive tip değil sarmalayıcı tip kullanırsak (Integer gibi) default
						// olarak
						// değeri
						// null'dır.

	public static void main(String[] args) {
		if (i == 42)
			System.out.println("Unbelievable");
	}

}
