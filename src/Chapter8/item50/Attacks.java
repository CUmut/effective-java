package Chapter8.item50;

import java.util.Date;

public class Attacks {

	/*
	 * Even in a safe language, you aren’t insulated from other classes without some
	 * effort on your part. You must program defensively, with the assumption that
	 * clients of your class will do their best to destroy its invariants.
	 */

	/*
	 * To defend against the second attack, merely modify the accessors to return
	 * defensive copies of mutable internal fields:
	 */

	public static void main(String[] args) {
		// Attack the internals of a Period instance
		Date start = new Date();
		Date end = new Date();
		Period p = new Period(start, end);
		end.setYear(78); // Modifies internals of p!
		System.out.println(p);

		// Second attack on the internals of a Period instance
		start = new Date();
		end = new Date();
		p = new Period(start, end);
		p.end().setYear(78); // Modifies internals of p!
		System.out.println(p);
	}

	/*
	 * In summary, if a class has mutable components that it gets from or returns to
	 * its clients, the class must defensively copy these components. If the cost of
	 * the copy would be prohibitive and the class trusts its clients not to modify
	 * the components inappropriately, then the defensive copy may be replaced by
	 * documentation outlining the client’s responsibility not to modify the
	 * affected components.
	 */

}
