package Chapter2.Item3.staticfactory;

public class Elvis {

	private static final Elvis INSTANCE = new Elvis();

	private Elvis() {
	}

	/*
	 * Elvis.getInstance'ye yapılan çağrılar aynı refereansı döndürür ve başka hiç
	 * bir elvis objesi oluşuturulmaz. public static alan olduğu için herzaman aynı
	 * aynı referansını içerecektir. Daha basittir.
	 */

	public static Elvis getInstance() {
		return INSTANCE;
	}

	public void leaveTheBuilding() {
		System.out.println("Whoa baby, I'm outta here!");
	}

	// This code would normally appear outside the class!
	public static void main(String[] args) {
		Elvis elvis = Elvis.getInstance();
		elvis.leaveTheBuilding();
	}

	/*
	 * One advantage of the static factory approach is that it gives you the
	 * flexibility to change your mind about whether the class is a singleton
	 * without changing its API. The factory method returns the sole instance, but
	 * it could be modified to return, say, a separate instance for each thread that
	 * invokes it.
	 */

	/*
	 * . A second advantage is that you can write a generic singleton factory if
	 * your application requires it
	 */
}
