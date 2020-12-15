package Chapter2.item9.trywithresources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TopLineWithDefault {

	// try-with-resources with a catch clause
	static String firstLineOfFile(String path, String defaultVal) {
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			return br.readLine();
		} catch (IOException e) {
			return defaultVal;
		}
	}

	public static void main(String[] args) throws IOException {
		String path = args[0];
		System.out.println(firstLineOfFile(path, "Toppy McTopFace"));
	}

	/*
	 * The lesson is clear: Always use try-with-resources in preference to
	 * try-finally when working with resources that must be closed. The resulting
	 * code is shorter and clearer, and the exceptions that it generates are more
	 * useful. The try-with-resources statement makes it easy to write correct code
	 * using resources that must be closed, which was practically impossible using
	 * try-finally.
	 */

}
