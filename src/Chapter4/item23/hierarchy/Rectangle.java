package Chapter4.item23.hierarchy;

//Class hierarchy replacement for a tagged class  
class Rectangle extends Figure {

	final double length;
	final double width;

	Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}

	@Override
	double area() {
		return length * width;
	}

}
