package Chapter6.item37;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Using ordinal() to index into an array - DON'T DO THIS!
public class TestPlant {

	void tt() {
		Set<Plant>[] plantsByLifeCycle = (Set<Plant>[]) new Set[Plant.LifeCycle.values().length];
		for (int i = 0; i < plantsByLifeCycle.length; i++)
			plantsByLifeCycle[i] = new HashSet<>();

		List<Plant> garden = null;
		for (Plant p : garden)
			plantsByLifeCycle[p.lifeCycle.ordinal()].add(p);

	}

	/*
	 * This technique works, but it is fraught with problems. Because arrays are not
	 * compatible with generics (Item 28), the program requires an unchecked cast
	 * and will not compile cleanly. Because the array does not know what its index
	 * represents, you have to label the output manually. But the most serious
	 * problem with this technique is that when you access an array that is indexed
	 * by an enum’s ordinal, it is your responsibility to use the correct int value;
	 * ints do not provide the type safety of enums. If you use the wrong value, the
	 * program will silently do the wrong thing or—if you’re lucky—throw an
	 * ArrayIndexOutOfBoundsException. There is a much better way to achieve the
	 * same effect. The array is effectively serving as a map from the enum to a
	 * value, so you might as well use a Map. More specifically, there is a very
	 * fast Map implementation designed for use with enum keys, known as
	 * java.util.EnumMap. Here is how the program looks when it is rewritten to use
	 * EnumMap:
	 */

}
