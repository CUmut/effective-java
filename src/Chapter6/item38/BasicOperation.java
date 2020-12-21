package Chapter6.item38;

public enum BasicOperation implements Operation {

	/*
	 * In summary, while you cannot write an extensible enum type, you can emulate
	 * it by writing an interface to accompany a basic enum type that implements the
	 * interface. This allows clients to write their own enums (or other types) that
	 * implement the interface. Instances of these types can then be used wherever
	 * instances of the basic enum type can be used, assuming APIs are written in
	 * terms of the interface.
	 */

	PLUS("+") {

		public double apply(double x, double y) {
			return x + y;
		}

	},
	MINUS("-") {

		public double apply(double x, double y) {
			return x - y;
		}

	},
	TIMES("*") {

		public double apply(double x, double y) {
			return x * y;
		}

	},
	DIVIDE("/") {

		public double apply(double x, double y) {
			return x / y;
		}
	};

	private final String symbol;

	BasicOperation(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return symbol;
	}

}
