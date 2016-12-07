
package bjpack;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import bjpack.Card.Rank;
import bjpack.Card.Suit;
/***************************************************************************
* Deck() is used to create a 'deck' of Card() objects using an array.
* 
* * Copyright ©2016. Grand Valley State University. All Rights Reserved. 
* Permission to use, copy, modify, and distribute this software and its 
* documentation for educational, research, and not-for-profit purposes, 
* without fee and without a signed licensing agreement, is hereby granted, 
* provided that the above copyright notice, this paragraph and the following 
* two paragraphs appear in all copies, modifications, and distributions. 
* Contact Technology Commercialization Office, GVSU, 049 James H. 
* Zumberge Hall, 1 Campus Drive, Allendale, Michigan 49401-9403, 
* (616) 331-9528, tco@gvsu.edu , https://www.gvsu.edu/tco/ for commercial 
* licensing opportunities.
* 
* IN NO EVENT SHALL GVSU BE LIABLE TO ANY PARTY FOR DIRECT, INDIRECT, 
* SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES, INCLUDING LOST PROFITS, 
* ARISING OUT OF THE USE OF THIS SOFTWARE AND ITS DOCUMENTATION, EVEN IF 
* GVSU HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
* 
* GVSU SPECIFICALLY DISCLAIMS ANY WARRANTIES, INCLUDING, BUT NOT LIMITED 
* TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A 
* PARTICULAR PURPOSE. THE SOFTWARE AND ACCOMPANYING DOCUMENTATION, IF ANY,
* PROVIDED HEREUNDER IS PROVIDED "AS IS". GVSU HAS NO OBLIGATION TO 
* PROVIDE MAINTENANCE, SUPPORT, UPDATES, ENHANCEMENTS, OR MODIFICATIONS.
* 
* Resources:
* https://docs.oracle.com/javase/tutorial/java/javaOO/examples/Deck.java
* 
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

