
package bjpack;

/***************************************************************************
* Game() holds most of Black's mechanics and generates most of the games
* elements for play.
* @author Logan Crowe, Edward Johnson, Anthony Dowling
***************************************************************************/
public class Game {
	/**********************************************************************
	 * Game's Deck() object.
	 *********************************************************************/
	private Deck mainDeck;
	/**********************************************************************
	 * The dealer, a Player() object.
	 *********************************************************************/
	private Player dealer;
	/**********************************************************************
	 * The user, a Player() object.
	 *********************************************************************/
	private Player user;
	/**********************************************************************
	 * Game constructor. Initializes aiPlayers, mainDeck, dealer and user.
	 *********************************************************************/
	public Game() {
		super();
		mainDeck = new Deck();
		dealer = new Player();
		user = new Player();
	}
	/**********************************************************************
	 * Game constructor. Initializes aiPlayers, mainDeck, dealer and user.
	 * Carries over point from previous round.
	 * @param points previous rounds point total.
	 *********************************************************************/
	public Game(final int points) {
		this();
		this.user.setPoints(points);
	}
	/**********************************************************************
	 * Deals out the first Card() objects to the user and dealer.
	 *********************************************************************/
	public final void initialDeal() {
		//safety. so we don't pull from too small a deck
		if (mainDeck.deckCount() < 4) {
			mainDeck.newDeck();
		}
		dealer.addCard(mainDeck.deal());
		dealer.addCard(mainDeck.deal());
		user.addCard(mainDeck.deal());
		user.addCard(mainDeck.deal());
	}
	/**********************************************************************
	 * Check for natural wins.
	 *********************************************************************/
	public final void checkNaturals() {
		if (dealer.blackJack()) { 
			if (user.blackJack()) {
				user.playerStandOff();
			} else {
				user.playerLose();
			}
		} else { 
			if (user.blackJack()) {
				user.playerNatural();
			}
		}
	}
	/**
	 * 
	 */
	public void userHit(){
		user.getHand().addtoHand(mainDeck.deal());
		
	}
	//performs dealer hit/stay
	public void dealerHitStay(){
		while(dealer.playerHit()){
			dealer.getHand().addtoHand(mainDeck.deal());
		}
	}
	//checks if user won, tied, or lost; sets values
	public void userWinCheck(){
		if(user.playerBust()){
			user.playerLose();
		}
		else if(user.handValue() > dealer.handValue() || dealer.playerBust()){
			user.playerWin();
		}
		else if(user.handValue() == dealer.handValue()){
			user.playerStandOff();
		}
		else
			user.playerLose();
	}
	
	public Deck getMainDeck() {
		return mainDeck;
	}

	public void setMainDeck(Deck mainDeck) {
		this.mainDeck = mainDeck;
	} 
	
	public final int userHandValue() {
		return user.handValue();
	}

	public Player getDealer() {
		return dealer;
	}

	public Player getUser() {
		return user;
	}	
}
