package Chapter9.item60;

import java.math.BigDecimal;

public class BigDecimalChange {
	/*
	 * The float and double types are designed primarily for scientific and
	 * engineering calculations. They perform binary floating-point arithmetic,
	 * which was carefully designed to furnish accurate approximations quickly over
	 * a broad range of magnitudes. They do not, however, provide exact results and
	 * should not be used where exact results are required. The float and double
	 * types are particularly ill-suited for monetary calculations because it is
	 * impossible to represent 0.1 (or any other negative power of ten) as a float
	 * or double exactly.
	 */

	/*
	 * Float ve double kesin sonuçlar sağlamaz,kesin sonuç gerektiren para
	 * hesaplamaları gibi durumlarda kullanılmamalıdır.
	 * 
	 * BigDecimal dezavantajı; primitive aritmetic türlere göre daha az
	 * kullanışlıdır ve daha yavaştır.
	 */

	public static void main(String[] args) {
		final BigDecimal TEN_CENTS = new BigDecimal(".10");

		int itemsBought = 0;
		BigDecimal funds = new BigDecimal("1.00");
		for (BigDecimal price = TEN_CENTS; funds.compareTo(price) >= 0; price = price.add(TEN_CENTS)) {
			funds = funds.subtract(price);
			itemsBought++;
		}
		System.out.println(itemsBought + " items bought.");
		System.out.println("Money left over: $" + funds);
	}

	/*
	 * inconvenience and cost of not using a primitive type. Using BigDecimal has
	 * the added advantage that it gives you full control over rounding, letting you
	 * select from eight rounding modes whenever an operation that entails rounding
	 * is performed. This comes in handy if you’re performing business calculations
	 * with legally mandated rounding behavior. If performance is of the essence,
	 * you don’t mind keeping track of the decimal point yourself, and the
	 * quantities aren’t too big, use int or long. If the quantities don’t exceed
	 * nine decimal digits, you can use int; if they don’t exceed eighteen digits,
	 * you can use long. If the quantities might exceed eighteen digits, use
	 * BigDecimal.
	 */

}
