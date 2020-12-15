package Chapter6.item35;

import java.math.BigInteger;
import java.util.stream.Stream;

public class MersennePrimes {

	static Stream<BigInteger> primes() {
		return Stream.iterate(TWO, BigInteger::nextProbablePrime);
	}

	public static void main(String[] args) {
		primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE)).filter(mersenne -> mersenne.isProbablePrime(50))
				.limit(20).forEach(mp -> System.out.println(mp.bitLength() + ": " + mp));
	}

}
