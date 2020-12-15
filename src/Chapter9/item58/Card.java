package Chapter9.item58;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Card {

	/*
	 * • Destructive filtering—If you need to traverse a collection removing
	 * selected elements, then you need to use an explicit iterator so that you can
	 * call its remove method. You can often avoid explicit traversal by using
	 * Collection’s removeIf method, added in Java 8.
	 * 
	 * • Transforming—If you need to traverse a list or array and replace some or
	 * all of the values of its elements, then you need the list iterator or array
	 * index in order to replace the value of an element.
	 * 
	 * • Parallel iteration—If you need to traverse multiple collections in
	 * parallel, then you need explicit control over the iterator or index variable
	 * so that all iterators or index variables can be advanced in lockstep (as
	 * demonstrated unintentionally in the buggy card and dice examples above).
	 * 
	 * In summary, the for-each loop provides compelling advantages over the
	 * traditional for loop in clarity, flexibility, and bug prevention, with no
	 * performance penalty. Use for-each loops in preference to forloops wherever
	 * you can
	 */

	private final Suit suit;
	private final Rank rank;

	// Can you spot the bug?
	enum Suit {
		CLUB, DIAMOND, HEART, SPADE
	}

	enum Rank {
		ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
	}

	static Collection<Suit> suits = Arrays.asList(Suit.values());
	static Collection<Rank> ranks = Arrays.asList(Rank.values());

	Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}

	public static void main(String[] args) {
		List<Card> deck = new ArrayList<>();

		/*
		 * The program doesn’t throw an exception, but it prints only the six “doubles”
		 * (from “ONE ONE” to “SIX SIX”), instead of the expected thirty-six
		 * combinations. To fix the bugs in these examples, you must add a variable in
		 * the scope of the outer loop to hold the outer element:
		 */

		for (Iterator<Suit> i = suits.iterator(); i.hasNext();)
			for (Iterator<Rank> j = ranks.iterator(); j.hasNext();)
				deck.add(new Card(i.next(), j.next()));

//	        // Preferred idiom for nested iteration on collections and arrays
//	        for (Suit suit : suits)
//	            for (Rank rank : ranks)
//	                deck.add(new Card(suit, rank));
	}

}
