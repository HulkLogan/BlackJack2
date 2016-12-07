
package bjpack;

/***************************************************************************
* Game() holds most of Black's mechanics and generates most of the games
* elements for play. Specifically it generates the deck, the dealer, and 
* the user elements for play. 
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
	/**********************************************************************
	 * Called when the user 'hits', dealing them a new card. 
	 *********************************************************************/
	public final void userHit() {
		user.getHand().addtoHand(mainDeck.deal());
		
	}
	/**********************************************************************
	 * Checks the hit/stay logic of playerHit() in Player(), and deals
	 * a card if true.
	 *********************************************************************/
	public final void dealerHitStay() {
		while (dealer.playerHit()) {
			dealer.getHand().addtoHand(mainDeck.deal());
		}
	}
	/**********************************************************************
	 * Called at the end of a round to determine the users win/loss/tie
	 * situation and calls the appropriate Player() method. 
	 *********************************************************************/
	public final void userWinCheck() {
		if (user.playerBust()) {
			user.playerLose();
		} else if (user.handValue() > dealer.handValue() 
				|| dealer.playerBust()) {
			user.playerWin();
		} else if (user.handValue() == dealer.handValue()) {
			user.playerStandOff();
		} else {
			user.playerLose();
		}
	}
	/**********************************************************************
	 * Gets the game's deck.
	 * @return mainDeck the game's deck.
	 *********************************************************************/
	public final Deck getMainDeck() {
		return mainDeck;
	}
	/**********************************************************************
	 * Set's the game's deck to a given deck.
	 * @param newDeck new deck to be the game's deck. 
	 *********************************************************************/
	public final void setMainDeck(final Deck newDeck) {
		this.mainDeck = newDeck;
	} 
	/**********************************************************************
	 * Get's the dealer.
	 * @return dealer the game's dealer.
	 *********************************************************************/
	public final Player getDealer() {
		return dealer;
	}
	/**********************************************************************
	 * Get's the user.
	 * @return user the game's user player.
	 *********************************************************************/
	public final Player getUser() {
		return user;
	}	
}
