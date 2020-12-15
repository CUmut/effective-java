package Chapter4.item23.taggedclass;

class Figure {

	/*
	 * SOLİD prensiblerine uygun bir sınıf değil bir sınıfın içinde birden fazla iş
	 * yapmayarak,daha okunabilir, daha genişletilebilir. Sınıfları bölerek var olan
	 * yapıyı,sınıfları değiştmememiz çok önemli böylelik altta ilk 2 solid
	 * prensiblerine de uygun bir yapı olmuş oluyor.. Single-responsibility
	 * principle Open–closed principle'lerine
	 */

	enum Shape {
		RECTANGLE, CIRCLE
	};

	// Tag field - the shape of this figure
	final Shape shape;

	// These fields are used only if shape is RECTANGLE
	double length;
	double width;

	// This field is used only if shape is CIRCLE
	double radius;

	// Constructor for circle
	Figure(double radius) {
		shape = Shape.CIRCLE;
		this.radius = radius;
	}

	// Constructor for rectangle
	Figure(double length, double width) {
		shape = Shape.RECTANGLE;
		this.length = length;
		this.width = width;
	}

	double area() {
		switch (shape) {
		case RECTANGLE:
			return length * width;
		case CIRCLE:
			return Math.PI * (radius * radius);
		default:
			throw new AssertionError(shape);
		}
	}

}
