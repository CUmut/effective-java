package Chapter2.Item4.utility;

public class UtilityClass {

	// Suppress default constructor for noninstantiability
	private UtilityClass() {
		throw new IllegalStateException("Yapılandırıcı Çağırılamaz");
	}
	/*
	 * constructor private olduğundan sınıf dışında erişilemez hata mesajları
	 * gerekli değildir,fakat yapılandırıcının sınıf dışından çağıırılmasında hiç
	 * bir şekilde çalışıtırılamayacağını belirtir. Tüm yapılandırıcılar bir üst
	 * sınıf kurucusunu çağırmaılıdır.Bir alt sınıfın çağırılacak erişilebilir bir
	 * üst sınıf kurucusu yoktur.
	 */

	public static void main(String[] args) {
		UtilityClass.exampleUtility("TEST 1");
	}

	public static String exampleUtility(String test) {
		return "TEST";
	}

	/*
	 * Such utility classes were not designed to be instantiated: an instance would
	 * be nonsensical. In the absence of explicit constructors, however, the
	 * compiler provides a public, parameterless default constructor. To a user,
	 * this constructor is indistinguishable from any other. It is not uncommon to
	 * see unintentionally instantiable classes in published APIs. Attempting to
	 * enforce noninstantiability by making a class abstract does not work. The
	 * class can be subclassed and the subclass instantiated. Furthermore, it
	 * misleads the user into thinking the class was designed for inheritance .
	 * There is, however, a simple idiom to ensure noninstantiability. A default
	 * constructor is generated only if a class contains no explicit constructors,
	 * so a class can be made noninstantiable by including a private constructor:
	 */

}
