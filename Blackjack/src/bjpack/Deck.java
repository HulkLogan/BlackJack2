
package bjpack;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import bjpack.Card.Rank;
import bjpack.Card.Suit;
/***************************************************************************
* Deck() is used to create a 'deck' of Card() objects using an array. 
* @author Logan Crowe, Anthony Dowling
***************************************************************************/
public class Deck {
	/*********************************************************************
	 * List of Card() objects that holds the Deck.
	 ********************************************************************/
	private List<Card> deckList;
	/*********************************************************************
	 * Deck() creates an array of Card objects and shuffles them. 
	 ********************************************************************/
	public Deck() {
    	newDeck();
 		Collections.shuffle(deckList);
	}
	/*********************************************************************
	 * Deal() is used to deal a single card from the deck. The decks
	 * size is revalued to take into account the missing card. 
	 * @return Card a card from the deck. 
	 ********************************************************************/
	public final Card deal() {
		//safety. so we don't pull from empty deck
		if (deckCount() > 0) {
			Card dealtCard;
			dealtCard = deckList.get(0);
			deckList = deckList.subList(1, deckCount());
			return dealtCard;
		} else {
			newDeck();
			Card dealtCard;
			dealtCard = deckList.get(0);
			deckList = deckList.subList(1, deckCount());
			return dealtCard;
		}
	}
	/*********************************************************************
	 * @return deckCount an int that represents the current size of the 
	 * deck.
	 ********************************************************************/
	public final int deckCount() {
		return deckList.size();
	}
	/*********************************************************************
	 * Shuffles the deck. 
	 ********************************************************************/
	public final void shuffleDeck() {
		Collections.shuffle(deckList);
	}
	
	/*********************************************************************
	 * newDeck() makes a new Deck() object.
	 ********************************************************************/
	public final void newDeck() {
		deckList = new ArrayList<Card>();
		for (Suit suit: Suit.values()) {
    		for (Rank value: Rank.values()) {
    			deckList.add(new Card(value, suit));
    		}
    	}
	}

}
