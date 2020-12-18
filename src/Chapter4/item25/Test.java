package Chapter4.item25;

public class Test {

	/*
	 * If you’re lucky enough to compile the program with the command javac
	 * Main.java Dessert.java, the compilation will fail, and the compiler will tell
	 * you that you’ve multiply defined the classes Utensil and Dessert. This is so
	 * because the compiler will first compile Main.java, and when it sees the
	 * reference to Utensil (which precedes the reference to Dessert), it will look
	 * in Utensil.java for this class and find both Utensil and Dessert. When the
	 * compiler encounters Dessert.java on the command line, it will pull in that
	 * file too, causing it to encounter both definitions of Utensil and Dessert. If
	 * you compile the program with the command javac Main.java or javac Main.java
	 * Utensil.java, it will behave as it did before you wrote the Dessert.java
	 * file, printing pancake. But if you compile the program with the command javac
	 * Dessert.java Main.java, it will print potpie. The behavior of the program is
	 * thus affected by the order in which the source files are passed to the
	 * compiler, which is clearly unacceptable. Fixing the problem is as simple as
	 * splitting the top-level classes (Utensil and Dessert, in the case of our
	 * example) into separate source files. If you are tempted to put multiple
	 * top-level classes into a single source file, consider using static member
	 * classes (Item 24) as an alternative to splitting the classes into separate
	 * source files. If the classes are subservient to another class, making them
	 * into static member classes is generally the better alternative because it
	 * enhances readability and makes it possible to reduce the accessibility of the
	 * classes by declaring them private (Item 15). Here is how our example looks
	 * with static member classes:
	 */

	public static void main(String[] args) {
		System.out.println(Utensil.NAME + Dessert.NAME);
	}

	private static class Utensil {
		static final String NAME = "pan";
	}

	private static class Dessert {
		static final String NAME = "cake";
	}

	/*
	 * The lesson is clear: Never put multiple top-level classes or interfaces in a
	 * single source file.Following this rule guarantees that you can’t have
	 * multiple definitions for a single class at compile time. This in turn
	 * guarantees that the class files generated by compilation, and the behavior of
	 * the resulting program, are independent of the order in which the source files
	 * are passed to the compiler.
	 */

}
