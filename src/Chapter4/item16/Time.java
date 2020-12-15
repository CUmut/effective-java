package Chapter4.item16;

public final class Time {

	private static final int HOURS_PER_DAY = 24;
	private static final int MINUTES_PER_HOUR = 60;

	/*
	 * While it’s never a good idea for a public class to expose fields directly, it
	 * is less harmful if the fields are immutable. You can’t change the
	 * representation of such a class without changing its API, and you can’t take
	 * auxiliary actions when a field is read, but you can enforce invariants. For
	 * example, this class guarantees that each instance represents a valid time
	 */

	/*
	 * In summary, public classes should never expose mutable fields. It is less
	 * harmful, though still questionable, for public classes to expose immutable
	 * fields. It is, however, sometimes desirable for package-private or private
	 * nested classes to expose fields, whether mutable or immutable.
	 */

	/*
	 * Alanların değişmezliğini final ile güvence altına alabiliyoruz.Time sınıfıda
	 * final olarak tanımlanan bu sınıf türetilemez bir sınıf olarak ayarlanmış
	 * oluyor. Alanlar public olduğu için getter'a ihtiyaç yok.
	 */

	public final int hour;
	public final int minute;

	public Time(int hour, int minute) {
		if (hour < 0 || hour >= HOURS_PER_DAY)
			throw new IllegalArgumentException("Hour: " + hour);
		if (minute < 0 || minute >= MINUTES_PER_HOUR)
			throw new IllegalArgumentException("Min: " + minute);
		this.hour = hour;
		this.minute = minute;
	}

}
