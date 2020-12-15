package Chapter4.item16;

class Point {

	/*
	 * Because the data fields of such classes are accessed directly, these classes
	 * do not offer the benefits of encapsulation. You can’t change the
	 * representation without changing the API, you can’t enforce invariants, and
	 * you can’t take auxiliary action when a field is accessed. Hard-line
	 * object-oriented programmers feel that such classes are anathema and should
	 * always be replaced by classes with private fields and public accessor methods
	 * (getters) and, for mutable classes, mutators (setters):
	 */

	// private double x;
	// private double y;

	/*
	 * private olarak tanımladığımız alanları dışarıya kapıları kapatıyoruz fakat
	 * set metodları ile aslında ön kapıyı kapatırken arka kapı açık kalmış
	 * oluyor.Final olarak tanımlar isek sadece yapılandırıcı içerisinde değer
	 * verilmesini başka bir yerde değerin değişmesini engelleriz.
	 */

	private final double x; // this is value object!
	private final double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

//	public void setX(double x) {
//		this.x = x;
//	}
//
//	public void setY(double y) {
//		this.y = y;
//	}

}
