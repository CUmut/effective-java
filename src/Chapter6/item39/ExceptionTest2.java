package Chapter6.item39;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExceptionTest2 {

	Class<? extends Throwable>[] value();

	/*
	 * The syntax for array parameters in annotations is flexible. It is optimized
	 * for single-element arrays. All of the previous ExceptionTest annotations are
	 * still valid with the new array-parameter version of ExceptionTest and result
	 * in single-element arrays. To specify a multiple-element array, surround the
	 * elements with curly braces and separate them with commas:
	 */
}
