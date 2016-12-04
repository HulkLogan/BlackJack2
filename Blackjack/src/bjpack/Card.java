
package bjpack;

/***************************************************************************
* Card() - used to create card object for use within the game. Objects will 
* store two main variable: value - a String, holds the value used to 
* calculate points in a certain hand; suit - a String, holds the suit of 
* the card. 
* @author Logan Crowe, Anthony Dowling
***************************************************************************/
public class Card {
	
	/***********************************************************************
	 * Array of Enums for rank values. Values possible: TWO, THREE, FOUR, FIVE, 
	 * SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
	 **********************************************************************/
	public enum Rank { TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, 
		JACK, QUEEN, KING, ACE }
	/***********************************************************************
	 * Array of Enums for suit values. Values possible: 
	 * CLUBS, DIAMONDS, HEARTS, SPADES. 
	 **********************************************************************/
	public enum Suit { CLUBS, DIAMONDS, HEARTS, SPADES }
	/***********************************************************************
	 * Rank of the Card() object.
	 **********************************************************************/
	private final Rank value;
	/***********************************************************************
	 * Suit of the Card() object.
	 **********************************************************************/
	private final Suit suit;
    /***********************************************************************
     * Card() constructor.
     * @param ivalue the rank value of the object
     * @param isuit the suit value of the object
     **********************************************************************/
    public Card(final Rank ivalue, final Suit isuit) {
		super();
		this.value = ivalue;
		this.suit = isuit;
	}
    /***********************************************************************
     * @return objects rank value
     **********************************************************************/
    public final Rank rank() {
    	return value; }
    /***********************************************************************
     * @return objects suit value
     **********************************************************************/
    public final Suit suit() {
    	return suit; }
    /***********************************************************************
     * @see java.lang.Object#toString()
     * @return String formatted as 'Rank of Suit' of Card() object.
     **********************************************************************/
    public final String toString() {
    	return value + " of " + suit; } 
}