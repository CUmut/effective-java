package Chapter6.item39;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExceptionTest {

	 Class<? extends Throwable> value();
}
