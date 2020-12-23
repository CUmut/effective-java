package Chapter7.item43;

import java.util.Map;
import java.util.TreeMap;

//Frequency table implemented with map.merge, using lambda and method reference 
public class Freq {

	public static void main(String[] args) {
		Map<String, Integer> frequencyTable = new TreeMap<>();

		for (String s : args)
			frequencyTable.merge(s, 1, (count, incr) -> count + incr); // Lambda
		System.out.println(frequencyTable);

		frequencyTable.clear();
		for (String s : args)
			frequencyTable.merge(s, 1, Integer::sum); // Method reference
		System.out.println(frequencyTable);

	}

	/*
	 * In summary, method references often provide a more succinct alternative to
	 * lambdas. Where method references are shorter and clearer, use them; where
	 * they aren’t, stick with lambdas.
	 */

}
