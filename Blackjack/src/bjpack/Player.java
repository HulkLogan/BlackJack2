
package bjpack;
/*****************************************************************************
* Player() holds a Hand() object and ints for points and bet, as well as a
* String for the ending message, which states the win/loss/tie of that player.
* @author Logan Crowe, Anthony Dowling
*****************************************************************************/
public class Player {
	/*************************************************************************
	 * The player's Hand() object which holds their Card() objects.
	 ************************************************************************/
	private Hand hand;
	/*************************************************************************
	 * The player's points.
	 ************************************************************************/
	private int points;
	/*************************************************************************
	 * The player's current bet.
	 ************************************************************************/
	private int bet;
	/*************************************************************************
	 * The player's end message which states whether they won, lost, or tied.
	 ************************************************************************/
	private String endMessage;
	/*************************************************************************
	 * Constant for constructor.
	 ************************************************************************/
	private final static int ONEHUNDRED = 100;
	/*************************************************************************
	 * Constant for game logic.
	 ************************************************************************/
	private final static int SEVENTEEN = 17;
	/*************************************************************************
	 * Constant for game logic.
	 ************************************************************************/
	private final static int TWENTY = 20;
	/*************************************************************************
	 * Constant for game logic.
	 ************************************************************************/
	private final static int TWENTYONE = 21;
	/*************************************************************************
	 * Constant for game logic.
	 ************************************************************************/
	private final static int WINMULTIPLE = 2;
	/*************************************************************************
	 * Constant for game logic.
	 ************************************************************************/
	private final static double NATURALMULTIPLE = 0.5;
	/*************************************************************************
	 * Constant for bet mechanic.
	 ************************************************************************/
	private final static int BETAMT = 10;
	/*************************************************************************
	 * Player() constructor. Sets up Hand() object, points value, bet value,
	 * and instantiates endMessage String.
	 ************************************************************************/
	public Player() {
		super();
		hand = new Hand();
		points = ONEHUNDRED;
		bet = 0;
		endMessage = "";
	}
	/*************************************************************************
	 * Player() constructor. Sets up Hand() object, points value, bet value,
	 * and instantiates endMessage String. Takes in a hand. 
	 * @param ihand Hand() object to be players hand. 
	 ************************************************************************/
	public Player(final Hand ihand) {
		super();
		this.hand = ihand;
		points = ONEHUNDRED;
		bet = 0;
		endMessage = "";
	}
	/*************************************************************************
	 * Logic for whether a player should hit or not. Based on standard 
	 * Vegas rules.
	 * @return boolean true if player's hand value is either less than 17 or 
	 * greater than 17, less than 20, and hand has a Ace.
	 ************************************************************************/
	public final boolean playerHit() {
		//'hard' 17
		if (handValue() < SEVENTEEN || (handValue() > SEVENTEEN 
				&& handValue() < TWENTY && hand.hasAce())) {
			return true;
		} else {
			return false;
		}
	}
	/*************************************************************************
	 * Logic for whether a player had busted.
	 * @return boolean true if player's hand value is greater than 21.
	 ************************************************************************/
	public final boolean playerBust() {
		if (handValue() > TWENTYONE) {
			return true;
		} else {
			return false;
		}
	}
	/*************************************************************************
	 * Logic for whether a player has BlackJack(21).
	 * @return boolean true if player's hand value is 21.
	 ************************************************************************/
	public final boolean blackJack() {
		if (handValue() == TWENTYONE) {
			return true;
		} else {
			return false;
		}
	}
	/*************************************************************************
	 * Prints out a player's hand.
	 ************************************************************************/
	public final void printHand() {
		int cardNum = 1;
		for (Card card : hand.getIhand()) {
			System.out.print("Card #" + cardNum++ + ": ");
		 	System.out.println(card.toString());
	 	}
	 }
	/*************************************************************************
	 * Prints out a player's hand with the first card hidden. Used when 
	 * playing in console mode and for the dealers hand.
	 ************************************************************************/
	public final void dealerPrintConcealed() {
		int cardNum = 1;
		for (Card card : hand.getIhand()) {
			if (cardNum == 1) {
				System.out.print("Card #" + cardNum++ + ": ");
				System.out.println("###### of ######");
			} else {
				System.out.print("Card #" + cardNum++ + ": ");
			 	System.out.println(card.toString());
			}
	 	}
	}
	/*************************************************************************
	 * Called when a player wins. Sets points, bet and endMessage to 
	 * appropriate values.
	 ************************************************************************/
	public final void playerWin() {
		points += (bet * WINMULTIPLE);
		bet = 0;
		endMessage = "Win";
	}
	/*************************************************************************
	 * Called when a player losses. Sets points, bet and endMessage to 
	 * appropriate values.
	 ************************************************************************/
	public final void playerLose() {
		bet = 0;
		endMessage = "Loss";
	}
	/*************************************************************************
	 * Called when a player wins on a 'Natural' or on the initial deal. Sets 
	 * points, bet and endMessage to appropriate values.
	 ************************************************************************/
	public final void playerNatural() {
		points += (int) Math.floor((bet * NATURALMULTIPLE));
		bet = 0;
		endMessage = "Natural Win";
	}
	/*************************************************************************
	 * Called when a player ties. Sets points, bet and endMessage to 
	 * appropriate values.
	 ************************************************************************/
	public final void playerStandOff() {
		points += bet;
		bet = 0;
		endMessage = "Stand-off(Tie)";
	}
	/*************************************************************************
	 * Player's hand value.
	 * @return hand.handCount() player's hand value.
	 ************************************************************************/
	public final int handValue() {
		return hand.handCount();
	}
	/*************************************************************************
	 * Player's hand.
	 * @return hand player's hand.
	 ************************************************************************/
	public final Hand getHand() {
		return hand;
	}
	/*************************************************************************
	 * Sets player's hand value.
	 * @param ihand Hand() to be the player's new hand.
	 ************************************************************************/
	public final void setHand(final Hand ihand) {
		this.hand = ihand;
	}
	/*************************************************************************
	 * Add's a Card() object to player's hand.
	 * @param icard Card() to be added to the hand.
	 ************************************************************************/
	public final void addCard(final Card icard) {
		hand.addtoHand(icard);
	}

	/*************************************************************************
	 * Gets the player's point total.
	 * @return points player's points.
	 ************************************************************************/
	public final int getPoints() {
		return points;
	}
	/*************************************************************************
	 * Sets the player's point total.
	 * @param ipoints new point total.
	 ************************************************************************/
	public final void setPoints(final int ipoints) {
		this.points = ipoints;
	}
	/*************************************************************************
	 * Gets the player's current bet.
	 * @return bet player's current bet.
	 ************************************************************************/
	public final int getBet() {
		return bet;
	}
	/*************************************************************************
	 * Sets the player's bet.
	 * @param ibet new bet.
	 ************************************************************************/
	public final void setBet(final int ibet) {
		this.bet = ibet;
	}
	/*************************************************************************
	 * Increases the player's bet by 10.
	 ************************************************************************/
	public final void bet() {
		if (points < BETAMT) {
			System.out.println("Not enough points to bet!");
		} else {
			points -= BETAMT;
			bet += BETAMT;
		}
	}	
	/*************************************************************************
	 * Gets the player's end message.
	 * @return endMessage player's end message.
	 ************************************************************************/
	public final String getEndMessage() {
		return endMessage;
	}
	/*************************************************************************
	 * Sets the player's end message.
	 * @param iendMessage new end message.
	 ************************************************************************/
	public final void setEndMessage(final String iendMessage) {
		this.endMessage = iendMessage;
	}
	
	
}
