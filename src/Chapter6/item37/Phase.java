package Chapter6.item37;

//Using ordinal()to index array of arrays-DON'TDO THIS!
public enum Phase {

	SOLID, LIQUID, GAS;

	public enum Transition {
		MELT, FREEZE, BOIL, CONDENSE, SUBLIME, DEPOSIT;

		private static final Transition[][] TRANSITIONS = { { null, MELT, SUBLIME }, { FREEZE, null, BOIL },
				{ DEPOSIT, CONDENSE, null } };

		// Maddenin halleri arasındaki geçişleri temsil eden
		// Transition enum sabitlerinden birini döndürüyor
		public static Transition from(Phase from, Phase to) {
			return TRANSITIONS[from.ordinal()][to.ordinal()];
		}
	}
}
