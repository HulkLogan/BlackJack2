
package bjpack;

/***************************************************************************
* Card() - used to create card object for use within the game. Objects will 
* store two main variable: value - a String, holds the value used to 
* calculate points in a certain hand; suit - a String, holds the suit of 
* the card. 
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
* https://docs.oracle.com/javase/tutorial/java/javaOO/examples/Card.java
* 
* @author Logan Crowe, Anthony Dowling
***************************************************************************/
public class Card {
	
	/***********************************************************************
	 * Array of Enums for rank values. Values possible: TWO, THREE, FOUR, 
	 * FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
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