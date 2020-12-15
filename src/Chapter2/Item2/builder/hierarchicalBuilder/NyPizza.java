package Chapter2.Item2.builder.hierarchicalBuilder;

import java.util.Objects;

public class NyPizza extends Pizza {

	public enum Size {
		SMALL, MEDIUM, LARGE
	}

	/*
	 * Here are two concrete subclasses of Pizza, one of which represents a standard
	 * New-York-style pizza, the other a calzone. The former has a required size
	 * parameter, while the latter lets you specify whether sauce should be inside
	 * or out:
	 */

	private final Size size;

	public static class Builder extends Pizza.Builder<Builder> {
		private final Size size;

		public Builder(Size size) {
			this.size = Objects.requireNonNull(size);
		}

		@Override
		public NyPizza build() {
			return new NyPizza(this);
		}

		@Override
		protected Builder self() {
			return this;
		}
	}

	private NyPizza(Builder builder) {
		super(builder);
		size = builder.size;
	}

	@Override
	public String toString() {
		return "New York Pizza with " + toppings;
	}

}
