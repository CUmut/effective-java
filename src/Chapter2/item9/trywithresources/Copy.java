package Chapter2.item9.trywithresources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Copy {

	private static final int BUFFER_SIZE = 8 * 1024;

	/*
	 * The lesson is clear: Always use try-with-resources in preference to
	 * try-finally when working with resources that must be closed. The resulting
	 * code is shorter and clearer, and the exceptions that it generates are more
	 * useful. The try-with-resources statement makes it easy to write correct code
	 * using resources that must be closed, which was practically impossible using
	 * try-finally.
	 */

	// try-with-resources on multiple resources - short and sweet
	static void copy(String src, String dst) throws IOException {
		try (InputStream in = new FileInputStream(src); OutputStream out = new FileOutputStream(dst)) {
			byte[] buf = new byte[BUFFER_SIZE];
			int n;
			while ((n = in.read(buf)) >= 0)
				out.write(buf, 0, n);
		}
	}

	public static void main(String[] args) throws IOException {
		String src = args[0];
		String dst = args[1];
		copy(src, dst);
	}

}
