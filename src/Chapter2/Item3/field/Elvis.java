package Chapter2.Item3.field;

public class Elvis {

	public static final Elvis INSTANCE = new Elvis();

	private Elvis() {
	}

	public void leaveTheBuilding() {
		System.out.println("Whoa baby, I'm outta here!");
	}

	// This code would normally appear outside the class!
	public static void main(String[] args) {
		Elvis elvis = Elvis.INSTANCE;
		elvis.leaveTheBuilding();
	}

	/*
	 * The private constructor is called only once, to initialize the public static
	 * final field Elvis.INSTANCE. The lack of a public or protected constructor
	 * guarantees a “monoelvistic” universe: exactly one Elvisinstance will exist
	 * once the Elvis class is initialized—no more, no less. Nothing that a client
	 * does can change this, with one caveat: a privileged client can invoke the
	 * private constructor reflectively the AccessibleObject.setAccessible method.
	 * If you need to defend against this attack, modify the constructor to make it
	 * throw an exception if it’s asked to create a second instance. In the second
	 * approach to implementing singletons, the public member is a static factory
	 * method:
	 */

}
