package Chapter8.item50;

import java.util.Date;

public final class Period {

	private final Date start;
	private final Date end;

	/*
	 * Note that defensive copies are made before checking the validity of the
	 * parameters (Item 49), and the validity check is performed on the copies
	 * rather than on the originals.
	 * 
	 * This would give the attacker free rein over all instances. To prevent this
	 * sort of attack, do not use the clone method to make a defensive copy of a
	 * parameter whose type is subclassable by untrusted parties.
	 */

	/**
	 * @param start the beginning of the period
	 * @param end   the end of the period; must not precede start
	 * @throws IllegalArgumentException if start is after end
	 * @throws NullPointerException     if start or end is null
	 */
	public Period(Date start, Date end) {
		if (start.compareTo(end) > 0)
			throw new IllegalArgumentException(start + " after " + end);
		this.start = start;
		this.end = end;
	}

	public Date start() {
		return start;
	}

	public Date end() {
		return end;
	}

	public String toString() {
		return start + " - " + end;
	}

//    // Repaired constructor - makes defensive copies of parameters (Page 232)
//    public Period(Date start, Date end) {
//        this.start = new Date(start.getTime());
//        this.end   = new Date(end.getTime());
//
//        if (this.start.compareTo(this.end) > 0)
//            throw new IllegalArgumentException(
//                    this.start + " after " + this.end);
//    }
//
//    // Repaired accessors - make defensive copies of internal fields (Page 233)
//    public Date start() {
//        return new Date(start.getTime());
//    }
//
//    public Date end() {
//        return new Date(end.getTime());
//    }

	// Remainder omitted
}
