package Chapter6.item35.anagrams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

//Tasteful use of streams enhances clarity and conciseness
public class HybridAnagrams {

	/*
	 * Overusing streams makes programs hard to read and maintain.
	 */

	/*
	 * In summary, some tasks are best accomplished with streams, and others with
	 * iteration. Many tasks are best accomplished by combining the two approaches.
	 * There are no hard and fast rules for choosing which approach to use for a
	 * task, but there are some useful heuristics. In many cases, it will be clear
	 * which approach to use; in some cases, it won’t. If you’re not sure whether a
	 * task is better served by streams or iteration, try both and see which works
	 * better.
	 */

	public static void main(String[] args) throws IOException {
		Path dictionary = Paths.get(args[0]);
		int minGroupSize = Integer.parseInt(args[1]);

		try (Stream<String> words = Files.lines(dictionary)) {
			words.collect(groupingBy(word -> alphabetize(word))).values().stream()
					.filter(group -> group.size() >= minGroupSize)
					.forEach(g -> System.out.println(g.size() + ": " + g));
		}
	}

	private static String alphabetize(String s) {
		char[] a = s.toCharArray();
		Arrays.sort(a);
		return new String(a);
	}

}
