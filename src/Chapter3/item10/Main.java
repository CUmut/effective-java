package Chapter3.item10;

import java.awt.Color;

public class Main {

	public static void main(String[] args) {

		ColorPoint cp1 = new ColorPoint(new Point(1, 0), Color.RED);
		ColorPoint cp2 = new ColorPoint(new Point(1, 0), Color.RED);

		System.out.println(cp1.equals(cp2));
	}

}
