package Chapter2.Item2.builder.hierarchicalBuilder;

import static Chapter2.Item2.builder.hierarchicalBuilder.NyPizza.Size.*;
import static Chapter2.Item2.builder.hierarchicalBuilder.Pizza.Topping.*;

public class PizzaTest {

	/*
	 * ÖZET: Kodu okumak ve yazmak teleskop kuruculardan çok daha rahattır.
	 * Parametrelerin çoğu isteğe bağlı ise veya aynı türdeyse iyi bir seçimdir.
	 * JavaBeans'den daha güvenlidir.
	 */

	/*
	 * In summary, the Builder pattern is a good choice when designing classes whose
	 * constructors or static factories would have more than a handful of
	 * parameters, especially if many of the parameters are optional or of identical
	 * type. Client code is much easier to read and write with builders than with
	 * telescoping constructors, and builders are much safer than JavaBeans.
	 */

	/*
	 * A minor advantage of builders over constructors is that builders can have
	 * multiple varargs parameters because each parameter is specified in its own
	 * method. Alternatively, builders can aggregate the parameters passed into
	 * multiple calls to a method into a single field, as demonstrated in the
	 * addToppingmethod earlier. The Builder pattern is quite flexible. A single
	 * builder can be used repeatedly to build multiple objects. The parameters of
	 * the builder can be tweaked between invocations of the build method to vary
	 * the objects that are created. A builder can fill in some fields automatically
	 * upon object creation, such as a serial number that increases each time an
	 * object is created.
	 */

	public static void main(String[] args) {
		NyPizza pizza = new NyPizza.Builder(SMALL).addTopping(SAUSAGE).addTopping(ONION).build();
		Calzone calzone = new Calzone.Builder().addTopping(HAM).sauceInside().build();

		System.out.println(pizza);
		System.out.println(calzone);
	}

	/*
	 * The Builder pattern has disadvantages as well. In order to create an object,
	 * you must first create its builder. While the cost of creating this builder is
	 * unlikely to be noticeable in practice, it could be a problem in
	 * performance-critical situations. Also, the Builder pattern is more verbose
	 * than the telescoping constructor pattern, so it should be used only if there
	 * are enough parameters to make it worthwhile, say four or more. But keep in
	 * mind that you may want to add more parameters in the future. But if you start
	 * out with constructors or static factories and switch to a builder when the
	 * class evolves to the point where the number of parameters gets out of hand,
	 * the obsolete constructors or static factories will stick out like a sore
	 * thumb.
	 */

}
