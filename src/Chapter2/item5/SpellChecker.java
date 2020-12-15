package Chapter2.item5;

public class SpellChecker {

	/*
	 * public static INSTANCE = new SpellChecker(...); public boolean isValid(String
	 * word) { ... } public List<String> suggestions(String typo) { ... }
	 */

	/*
	 * Static utility classes and singletons are inappropriate for classes whose
	 * behavior is parameterized by an underlying resource. What is required is the
	 * ability to support multiple instances of the class (in our example,
	 * SpellCheckerÏ each of which uses the resource desired by the client in our
	 * example, the dictionary.
	 * 
	 * A simple pattern that satisfies this requirement is to pass the resource into
	 * the constructor when creating a new instance
	 */

	private static final Lexicon dictionary = new Lexicon();

	private SpellChecker() {
	}
	// noninstantiable

	public static boolean isValid(String word) {
		//
		//
		return true;
	}

}

class Lexicon {

}

// Inappropriate use of singleton - inflexible & untestable
class SpellChecker2 {

	private final Lexicon dictionary = new Lexicon();

	public static SpellChecker2 INSTANCE = new SpellChecker2();

	private SpellChecker2() {
	}

	public static boolean isValid(String word) {
		//
		//
		return true;
	};

}
