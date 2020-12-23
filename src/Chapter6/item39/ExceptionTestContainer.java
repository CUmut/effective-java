package Chapter6.item39;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Container annotation for the repeatable ExceptionTest annotation (Page 186)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public class ExceptionTestContainer {

	ExceptionTest[] value();
}
