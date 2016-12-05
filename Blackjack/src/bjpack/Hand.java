
package bjpack;

import java.util.ArrayList;
import java.util.List;

/***************************************************************************
* Hand() is List() of Card() objects.
* @author Logan Crowe, Anthony Dowling
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
		if (hasAce() && count > 21) {
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
