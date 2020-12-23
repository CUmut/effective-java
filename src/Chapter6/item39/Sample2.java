package Chapter6.item39;

public class Sample2 {
	
	 @ExceptionTest(ArithmeticException.class)
	    public static void m1() {  // Bu test geçecektir
	        int i = 0;
	        i = i / i; 
	    }
	    @ExceptionTest(ArithmeticException.class)
	    public static void m2() {  // Başarısız! (yanlış aykırı durum)
	        int[] a = new int[0];
	        int i = a[1];
	    }
	    @ExceptionTest(ArithmeticException.class)
	    public static void m3() { }  // Başarısız (aykırı durum yok)

}
