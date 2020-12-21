package Chapter6.item37;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Stream;

public enum Phase2 {

	SOLID, LIQUID, GAS;

	public enum Transition {
		MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID), BOIL(LIQUID, GAS), CONDENSE(GAS, LIQUID), SUBLIME(SOLID, GAS),
		DEPOSIT(GAS, SOLID);

		private final Phase2 from;
		private final Phase2 to;

		Transition(Phase2 from, Phase2 to) {
			this.from = from;
			this.to = to;
		}

		// Initialize the phase transition map
		private static final Map<Phase2, Map<Phase2, Transition>> m =

				Stream.of(values()).collect(groupingBy(t -> t.from, () -> new EnumMap<>(Phase2.class),
						toMap(t -> t.to, t -> t, (x, y) -> y, () -> new EnumMap<>(Phase2.class))));
	}

	/*
	 * In summary, it is rarely appropriate to use ordinals to index into arrays:
	 * use EnumMap instead. If the relationship you are representing is
	 * multidimensional, use EnumMap<..., EnumMap<...>>. This is a special case of
	 * the general principle that application programmers should rarely, if ever,
	 * use Enum.ordinal (Item 35).
	 */

}
