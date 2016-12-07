package bjpack;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import bjpack.Card.Rank;
import bjpack.Card.Suit;

public class BJTest {

	@Test
	public final void gameTest1() {
		Game game = new Game();
		game.initialDeal();
		assertTrue(game.getUser().getHand() != null);
		assertFalse(game.getDealer().getHand() == null);
	}
	
	@Test
	public final void hitTest() {
		Game game = new Game();
		game.initialDeal();
		Card card = new Card(Rank.KING, Suit.CLUBS);
		game.getUser().getHand().addtoHand(card);
		assertTrue(game.getUser().getHand().size() == 3);
		assertFalse(game.getUser().getHand().size() == 1);
		assertTrue(card.suit() == Suit.CLUBS);
		assertEquals(card.toString(), "KING of CLUBS");
	}
	
	@Test
	public final void dealerTest() {
		Game game = new Game();
		Card card = new Card(Rank.KING, Suit.CLUBS);
		Card card2 = new Card(Rank.NINE, Suit.CLUBS);
		game.getDealer().getHand().addtoHand(card);
		game.getDealer().getHand().addtoHand(card2);
		assertTrue(game.getDealer().handValue() == 19);
		assertFalse(game.getDealer().handValue() == 18);
		assertTrue(!game.getDealer().playerHit());
		assertFalse(game.getDealer().playerHit());
		game.dealerHitStay();
		}
	@Test
	public final void bustCheck() {
		Game game = new Game();
		Card card = new Card(Rank.KING, Suit.CLUBS);
		Card card2 = new Card(Rank.KING, Suit.DIAMONDS);
		Card card3 = new Card(Rank.KING, Suit.SPADES);
		game.getUser().addCard(card3);
		game.getUser().addCard(card2);
		game.getUser().addCard(card);
		assertTrue(game.getUser().playerBust());
		game.getUser().playerWin();
		assertTrue(game.getUser().getEndMessage() == "Win");
		game.getUser().playerLose();
		assertTrue(game.getUser().getEndMessage() == "Loss");
	}
	@Test
	public final void dealerNatWinWithStandoff() {
		Game game = new Game(10);
		Deck deck = game.getMainDeck();
		assertTrue(game.getMainDeck().deckCount() == 52);
		Card card = new Card(Rank.ACE, Suit.CLUBS);
		Card card2 = new Card(Rank.KING, Suit.HEARTS);
		game.getDealer().getHand().addtoHand(card);
		game.getDealer().getHand().addtoHand(card2);
		game.checkNaturals();
		assertTrue(game.getDealer().blackJack());
		game.getUser().getHand().addtoHand(card2);
		game.getUser().getHand().addtoHand(card);
		game.checkNaturals();
		assertTrue(game.getDealer().blackJack());
		assertTrue(game.getUser().getEndMessage() == "Stand-off(Tie)");
		
	}
	@Test
	public final void naturalWinLossTest() {
		Game game = new Game();
		Card k = new Card(Rank.TEN, Suit.HEARTS);
		Card two = new Card(Rank.TWO, Suit.HEARTS);
		Card card = new Card(Rank.ACE, Suit.CLUBS);
		Card card2 = new Card(Rank.KING, Suit.HEARTS);
		game.getDealer().getHand().addtoHand(k);
		game.getDealer().getHand().addtoHand(two);
		game.checkNaturals();
		assertFalse(game.getDealer().blackJack());
		game.getUser().getHand().addtoHand(card2);
		game.getUser().getHand().addtoHand(card);
		game.checkNaturals();
		assertTrue(game.getUser().blackJack());
		game.userWinCheck();
		assertTrue(game.getUser().getEndMessage() == "Win");
	}
	@Test
	public final void userTesting() {
		Game game = new Game();
		game.userHit();
		assertTrue(game.getUser().getHand().size() == 1);
		game.getDealer().playerHit();
		assertTrue(game.getDealer().playerHit());
		Player dealer = game.getDealer();
		Card two = new Card(Rank.FOUR, Suit.HEARTS);
		Card card = new Card(Rank.ACE, Suit.CLUBS);
		dealer.addCard(card);
		dealer.addCard(two);
		game.userWinCheck();
		assertTrue(game.getUser().getEndMessage() == "Loss");
		
	}
	@Test
	public final void dBustCheck() {
		Game game = new Game();
		Player dealer = game.getDealer();
		Card k = new Card(Rank.QUEEN, Suit.HEARTS);
		Card two = new Card(Rank.TWO, Suit.HEARTS);
		Card card = new Card(Rank.KING, Suit.CLUBS);
		dealer.addCard(card);
		dealer.addCard(two);
		dealer.addCard(k);
		game.userWinCheck();
		assertTrue(game.getUser().getEndMessage() == "Win");
		Card th = new Card(Rank.THREE, Suit.HEARTS);
		Card c = new Card(Rank.ACE, Suit.CLUBS);
		Player user = game.getUser();
		user.addCard(c);
		user.addCard(th);
		game.userWinCheck();
		assertTrue(user.getEndMessage() == "Win");
	}
	@Test
	public final void deckTest() {
		Game game = new Game();
		Deck deck = game.getMainDeck();
		game.initialDeal();
		game.initialDeal();
		game.initialDeal();
		game.initialDeal();
		game.initialDeal();
		game.initialDeal();
		game.initialDeal();
		game.initialDeal();
		game.initialDeal();
		game.initialDeal();
		game.initialDeal();
		game.initialDeal();
		deck.deal();
		game.initialDeal();
		deck.deal();
		assertTrue(deck.deckCount() == 47);
		deck.shuffleDeck();
	}
	@Test
	public final void deckTest2() {
		Game game = new Game();
		Deck deck = game.getMainDeck();
		game.initialDeal();
		game.initialDeal();
		game.initialDeal();
		game.initialDeal();
		game.initialDeal();
		game.initialDeal();
		game.initialDeal();
		game.initialDeal();
		game.initialDeal();
		game.initialDeal();
		game.initialDeal();
		game.initialDeal();
		deck.deal();
		assertTrue(deck.deckCount() == 3);
	}
	@Test
	public final void deckListTest() {
		Game game = new Game();
		Card card = new Card(Rank.ACE, Suit.SPADES);
		Player user = game.getUser();
		user.addCard(card);
		user.printHand();
		assertEquals(card.toString(), "ACE of SPADES");
		user.dealerPrintConcealed();
	}
	@Test
	public final void messageTest() {
		Game game = new Game();
		game.getUser().setEndMessage("Win");
		assertEquals(game.getUser().getEndMessage(), "Win");
	}
	@Test
	public final void betTest() {
		Game game = new Game();
		Player user = game.getUser();
		user.setBet(40);
		assertTrue(user.getBet() == 40);
		user.bet();
	}
	@Test
	public final void setTesting() {
		Game game = new Game();
		Player user = game.getUser();
		Hand hand = new Hand();
		Card card = new Card(Rank.FIVE, Suit.HEARTS);
		hand.addtoHand(card);
		assertTrue(card == hand.getCard(0));
	}
}

