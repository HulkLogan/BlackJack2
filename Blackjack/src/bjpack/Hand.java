
package bjpack;

import java.util.ArrayList;
import java.util.List;

/***************************************************************************
* Hand() is List() of Card() objects.
* 
* Copyright ©2016. Grand Valley State University. All Rights Reserved. 
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
* https://en.wikipedia.org/wiki/Blackjack
* http://www.bicyclecards.com/how-to-play/blackjack/
* 
* @author Anthony Dowling
***************************************************************************/
public class Hand {
	/***********************************************************************
	 * List of Card() objects that is the Hand() class.
	 **********************************************************************/
	private List<Card> ihand;
	/***********************************************************************
	 * Hand() constructor. Sets up ArrayList of Card() objects.
	 **********************************************************************/
	public Hand() {
		super();
		ihand = new ArrayList<Card>();
	}
	/***********************************************************************
	 * Hand() constructor. Sets up ArrayList of Card() objects taking 
	 * another Hand() as input.
	 * @param input new Hand() object.
	 **********************************************************************/
	public Hand(final List<Card> input) {
		super();
		ihand = input;
	}
	/***********************************************************************
	 * Adds Card() object to Hand().
	 * @param input card to be added to hand.
	 **********************************************************************/
	public final void addtoHand(final Card input) {
		ihand.add(input);
	}	
	/***********************************************************************
	* handCount() takes a hand, iterates through the cards in the hand, and 
	* counts the values of the cards, adding them and returning the hand 
	* count.
	* @return count int representing the hands value.
	***********************************************************************/
	public final int handCount() {
		int count = 0;
		for (Card card :ihand) {
			switch(card.rank()) {
			case TWO:
				count += 2;
				break;
			case THREE:
				count += 3;
				break;
			case FOUR:
				count += 4;
				break;
			case FIVE:
				count += 5;
				break;
			case SIX:
				count += 6;
				break;
			case SEVEN:
				count += 7;
				break;
			case EIGHT:
				count += 8;
				break;
			case NINE:
				count += 9;
				break;
			case TEN:
				count += 10;
				break;
			case JACK:
				count += 10;
				break;
			case QUEEN:
				count += 10;
				break;
			case KING:
				count += 10;
				break;
			case ACE:
				count += 11;
				break;
			default:
				break;
			}
		}
		if (hasAce() && (count > 21)) {
			count -= 10;
		}
		return count;
	}	
	/***********************************************************************
	 * hasAce() checks a hand for an Ace value and returns true if found.
	 * @return boolean true if Ace Card() is found in hand
	 **********************************************************************/
	public final boolean hasAce() {
		boolean bool = false;
			for (Card card :ihand) {
				switch(card.rank()) {
				case ACE:
					bool = true;
					break;
				default:
					break;
				}
			}
			return bool;
	}
	/***********************************************************************
	 * Gets a specified Card() from the Hand() using an index number.
	 * @param cardNum index of specified Card().
	 * @return Card() object specified.
	 **********************************************************************/
	public final Card getCard(final int cardNum) {
		if (ihand.size() >= cardNum + 1) {
			return ihand.get(cardNum);
		} else {
			return null;
		}
	}
	/************************************************************************
	 * Gets the size of the Hand().
	 * @return hand size, an int.
	 ***********************************************************************/
	public final int size() {
		return ihand.size();
	}
	/************************************************************************
	 * Gets the Hand().
	 * @return ihand player's current Hand().
	 ***********************************************************************/
	public final List<Card> getIhand() {
		return ihand;
	}

}
