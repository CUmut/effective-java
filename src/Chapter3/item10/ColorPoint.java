package Chapter3.item10;

import java.awt.Color;
import java.awt.Point;
import java.util.Objects;

public class ColorPoint {

	/*
	 * The lesson is clear: Always use try-with-resources in preference to
	 * try-finally when working with resources that must be closed. The resulting
	 * code is shorter and clearer, and the exceptions that it generates are more
	 * useful. The try-with-resources statement makes it easy to write correct code
	 * using resources that must be closed, which was practically impossible using
	 * try-finally.
	 */

	private final Point point;
	private final Color color;

	public ColorPoint(Point point, Color color) {
		super();
		this.point = point;
		this.color = Objects.requireNonNull(color);
	}

	public Point asPoint() {
		return point;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ColorPoint)) {
			return false;
		}
		ColorPoint cp = (ColorPoint) obj;
		return cp.point.equals(point) && cp.color.equals(color);
	}

}
