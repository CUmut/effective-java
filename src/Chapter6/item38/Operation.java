package Chapter6.item38;

public interface Operation {
	double apply(double x, double y);

	public enum BasicOperation implements Operation {
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

	/*
	 * While the enum type (BasicOperation) is not extensible, the interface type
	 * (Operation) is, and it is the interface type that is used to represent
	 * operations in APIs. You can define another enum type that implements this
	 * interface and use instances of this new type in place of the base type. For
	 * example, suppose you want to define an extension to the operation type shown
	 * earlier, consisting of the exponentiation and remainder operations. All you
	 * have to do is write an enum type that implements the Operation interface:
	 */

}