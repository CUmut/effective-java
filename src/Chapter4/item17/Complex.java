package Chapter4.item17;

public final class Complex {

	/*
	 * Sınıfları olabilidiğince değişmez tasarlayın,eğer değişmez
	 * tasarlayamıyorsanız iyi bir nedeniniz olsun ! Objenin durum bilgisini
	 * değiştirmemek için sürekli yeni bir nesne yaratarak kullanmak dezavantaj
	 * olabilir. Fakat genel olarak Hata oranları azalacaktır.
	 */

	/*
	 * Immutable objects make great building blocks for other objects, whether
	 * mutable or immutable. It’s much easier to maintain the invariants of a
	 * complex object if you know that its component objects will not change
	 * underneath it. A special case of this principle is that immutable objects
	 * make great map keys and set elements: you don’t have to worry about their
	 * values changing once they’re in the map or set, which would destroy the map
	 * or set’s invariants.
	 */

	/*
	 * Classes should be immutable unless there’s a very good reason to make them
	 * mutable.
	 */

	/*
	 * The major disadvantage of immutable classes is that they require a separate
	 * object for each distinct value.
	 */

	/*
	 * To summarize, resist the urge to write a setter for every getter.
	 */

	/*
	 * If a class cannot be made immutable, limit its mutability as much as
	 * possible. Reducing the number of states in which an object can exist makes it
	 * easier to reason about the object and reduces the likelihood of errors.
	 * Therefore, make every field final unless there is a compelling reason to make
	 * it nonfinal. Combining the advice of this item with that of Item 15, your
	 * natural inclination should be to declare every field private final unless
	 * there’s a good reason to do otherwise.
	 */

	/*
	 * Constructors should create fully initialized objects with all of their
	 * invariants established
	 */

	private final double re;
	private final double im;

	public static final Complex ZERO = new Complex(0, 0);
	public static final Complex ONE = new Complex(1, 0);
	public static final Complex I = new Complex(0, 1);

	public Complex(double re, double im) {
		this.re = re;
		this.im = im;
	}

	public double realPart() {
		return re;
	}

	public double imaginaryPart() {
		return im;
	}

	public Complex plus(Complex c) {
		return new Complex(re + c.re, im + c.im);
	}

	// Static factory, used in conjunction with private constructor
	public static Complex valueOf(double re, double im) {
		return new Complex(re, im);
	}

	public Complex minus(Complex c) {
		return new Complex(re - c.re, im - c.im);
	}

	public Complex times(Complex c) {
		return new Complex(re * c.re - im * c.im, re * c.im + im * c.re);
	}

	public Complex dividedBy(Complex c) {
		double tmp = c.re * c.re + c.im * c.im;
		return new Complex((re * c.re + im * c.im) / tmp, (im * c.re - re * c.im) / tmp);
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Complex))
			return false;
		Complex c = (Complex) o;

		return Double.compare(c.re, re) == 0 && Double.compare(c.im, im) == 0;
	}

	@Override
	public int hashCode() {
		return 31 * Double.hashCode(re) + Double.hashCode(im);
	}

	@Override
	public String toString() {
		return "(" + re + " + " + im + "i)";
	}
}
