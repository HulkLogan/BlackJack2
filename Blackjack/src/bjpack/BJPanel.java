
package bjpack;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import bjpack.Card.Rank;
import bjpack.Card.Suit;

/****************************************************************************
 * BJPanel() is the GUI for this game. It hold all of the graphical elements
 * and contains the Main() method that creates the game and runs it. 
 * @author Logan Crowe
 ***************************************************************************/
@SuppressWarnings("serial")
public class BJPanel extends JPanel {
	//JOption for when no points to bet
	
	/**********************************************************************
	 * User JFrame to hold the users cards and all game buttons. 
	 *********************************************************************/
	private JFrame userFrame;
	/**********************************************************************
	 * Dealers JFrame that holds the dealer's cards. 
	 *********************************************************************/
	private JFrame dealerFrame;
	/**********************************************************************
	 * Boolean the signifies whether the turn is over or not. False is 
	 * not over, true means the turn has ended. 
	 *********************************************************************/
	private boolean userTurnEnd = false;
	/**********************************************************************
	 * Global for strut size.
	 *********************************************************************/
	private static final int STRUTSIZE = 20;
	/**********************************************************************
	 * Player's JFrame X location.
	 *********************************************************************/
	private static final int USERXLOCATION = 50;
	/**********************************************************************
	 * Player's JFrame Y location.
	 *********************************************************************/
	private static final int USERYLOCATION = 50;
	/**********************************************************************
	 * Dealer's JFrame X location.
	 *********************************************************************/
	private static final int DEALERXLOCATION = 50;
	/**********************************************************************
	 * Dealer's JFrame Y location.
	 *********************************************************************/
	private static final int DEALERYLOCATION = 450;
	/**********************************************************************
	 * The JFrames width.
	 *********************************************************************/
	private static final int FRAMEWIDTH = 1150;
	/**********************************************************************
	 * The JFrames height.
	 *********************************************************************/
	private static final int FRAMEHEIGHT = 400;
		
	/**********************************************************************
	 * There are 54 BufferedImage object to take in the 54 images need to 
	 * for a complete deck, including a card back and an empty card space
	 * for when no cards exist in that spot. The BufferedImages will be 
	 * passed as a resize BufferedImage and then passed again as an 
	 * ImageIcon.
	 *********************************************************************/
	//--empty card
	private BufferedImage emptyImg;
	//--card back
	private BufferedImage backImg;
	//--clubs
	private BufferedImage aceCImg;
	private BufferedImage kingCImg;
	private BufferedImage queenCImg;
	private BufferedImage jackCImg;
	private BufferedImage tenCImg;
	private BufferedImage nineCImg;
	private BufferedImage eightCImg;
	private BufferedImage sevenCImg;
	private BufferedImage sixCImg;
	private BufferedImage fiveCImg;
	private BufferedImage fourCImg;
	private BufferedImage threeCImg;
	private BufferedImage twoCImg;
	//--diamonds
	private BufferedImage aceDImg;
	private BufferedImage kingDImg;
	private BufferedImage queenDImg;
	private BufferedImage jackDImg;
	private BufferedImage tenDImg;
	private BufferedImage nineDImg;
	private BufferedImage eightDImg;
	private BufferedImage sevenDImg;
	private BufferedImage sixDImg;
	private BufferedImage fiveDImg;
	private BufferedImage fourDImg;
	private BufferedImage threeDImg;
	private BufferedImage twoDImg;
	//--hearts
	private BufferedImage aceHImg;
	private BufferedImage kingHImg;
	private BufferedImage queenHImg;
	private BufferedImage jackHImg;
	private BufferedImage tenHImg;
	private BufferedImage nineHImg;
	private BufferedImage eightHImg;
	private BufferedImage sevenHImg;
	private BufferedImage sixHImg;
	private BufferedImage fiveHImg;
	private BufferedImage fourHImg;
	private BufferedImage threeHImg;
	private BufferedImage twoHImg;
	//--spades
	private BufferedImage aceSImg;
	private BufferedImage kingSImg;
	private BufferedImage queenSImg;
	private BufferedImage jackSImg;
	private BufferedImage tenSImg;
	private BufferedImage nineSImg;
	private BufferedImage eightSImg;
	private BufferedImage sevenSImg;
	private BufferedImage sixSImg;
	private BufferedImage fiveSImg;
	private BufferedImage fourSImg;
	private BufferedImage threeSImg;
	private BufferedImage twoSImg;
	
	/**********************************************************************
	 * There are 54 ImageIcons which are for taking the re-sized 
	 * BufferedImages and for use when a card's value needs to be displayed
	 * in the appropriate JLabel location.
	 *********************************************************************/
	//-empty card
	private static ImageIcon emptyicon;
	//--back
	private static ImageIcon backicon;
	//--clubs
	private static ImageIcon aceCicon;
	private static ImageIcon kingCicon;
	private static ImageIcon queenCicon;
	private static ImageIcon jackCicon;
	private static ImageIcon tenCicon;
	private static ImageIcon nineCicon;
	private static ImageIcon eightCicon;
	private static ImageIcon sevenCicon;
	private static ImageIcon sixCicon;
	private static ImageIcon fiveCicon;
	private static ImageIcon fourCicon;
	private static ImageIcon threeCicon;
	private static ImageIcon twoCicon;
	//--diamonds
	private static ImageIcon aceDicon;
	private static ImageIcon kingDicon;
	private static ImageIcon queenDicon;
	private static ImageIcon jackDicon;
	private static ImageIcon tenDicon;
	private static ImageIcon nineDicon;
	private static ImageIcon eightDicon;
	private static ImageIcon sevenDicon;
	private static ImageIcon sixDicon;
	private static ImageIcon fiveDicon;
	private static ImageIcon fourDicon;
	private static ImageIcon threeDicon;
	private static ImageIcon twoDicon;
	//--hearts
	private static ImageIcon aceHicon;
	private static ImageIcon kingHicon;
	private static ImageIcon queenHicon;
	private static ImageIcon jackHicon;
	private static ImageIcon tenHicon;
	private static ImageIcon nineHicon;
	private static ImageIcon eightHicon;
	private static ImageIcon sevenHicon;
	private static ImageIcon sixHicon;
	private static ImageIcon fiveHicon;
	private static ImageIcon fourHicon;
	private static ImageIcon threeHicon;
	private static ImageIcon twoHicon;
	//--spades
	private static ImageIcon aceSicon;
	private static ImageIcon kingSicon;
	private static ImageIcon queenSicon;
	private static ImageIcon jackSicon;
	private static ImageIcon tenSicon;
	private static ImageIcon nineSicon;
	private static ImageIcon eightSicon;
	private static ImageIcon sevenSicon;
	private static ImageIcon sixSicon;
	private static ImageIcon fiveSicon;
	private static ImageIcon fourSicon;
	private static ImageIcon threeSicon;
	private static ImageIcon twoSicon;
	
	/**********************************************************************
	 * The width of the re-sized BufferedImage files. 
	 *********************************************************************/
	private int cwidth = 100;
	/**********************************************************************
	 * The height of the re-sized BufferedImage files. 
	 *********************************************************************/
	private int cheight = 145;
	
	/**********************************************************************
	 * JLabel for users 1st card.
	 *********************************************************************/
	private JLabel lblCard1 = new JLabel("Card01");
	/**********************************************************************
	 * JLabel for users 2nd card.
	 *********************************************************************/
	private JLabel lblCard2 = new JLabel("Card02");
	/**********************************************************************
	 * JLabel for users 3rd card.
	 *********************************************************************/
	private JLabel lblCard3 = new JLabel("Card03");
	/**********************************************************************
	 * JLabel for users 4th card.
	 *********************************************************************/
	private JLabel lblCard4 = new JLabel("Card04");
	/**********************************************************************
	 * JLabel for users 5th card.
	 *********************************************************************/
	private JLabel lblCard5 = new JLabel("Card05");
	/**********************************************************************
	 * JLabel for users 6th card.
	 *********************************************************************/
	private JLabel lblCard6 = new JLabel("Card06");
	/**********************************************************************
	 * JLabel for dealers 1st card.
	 *********************************************************************/
	private JLabel dlblCard1 = new JLabel("Card01");
	/**********************************************************************
	 * JLabel for dealers 2nd card.
	 *********************************************************************/
	private JLabel dlblCard2 = new JLabel("Card02");
	/**********************************************************************
	 * JLabel for dealers 3rd card.
	 *********************************************************************/
	private JLabel dlblCard3 = new JLabel("Card03");
	/**********************************************************************
	 * JLabel for dealers 4th card.
	 *********************************************************************/
	private JLabel dlblCard4 = new JLabel("Card04");
	/**********************************************************************
	 * JLabel for dealers 5th card.
	 *********************************************************************/
	private JLabel dlblCard5 = new JLabel("Card05");
	/**********************************************************************
	 * JLabel for dealers 6th card.
	 *********************************************************************/
	private JLabel dlblCard6 = new JLabel("Card06");
	
	/**********************************************************************
	 * JLabel for the user's current bet.
	 *********************************************************************/
	private JLabel lblCurrentBet;
	/**********************************************************************
	 * JLabel for the user's current point total.
	 *********************************************************************/
	private JLabel lblCurrentPoints;
	
	/**********************************************************************
	 * JButton for the 'stay' button.
	 *********************************************************************/
	private JButton btnStay;
	/**********************************************************************
	 * JButton for the 'hit' button.
	 *********************************************************************/
	private JButton btnHit;
	/**********************************************************************
	 * JButton for the bet button.
	 *********************************************************************/
	private JButton btnBet; 
	
	/**********************************************************************
	 * Launch the application.
	 * @param args args
	 *********************************************************************/
	public static void main(final String[] args) {
		Game game = new Game(); 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BJPanel panel = new BJPanel(game);
					panel.userFrame.setVisible(true);
					panel.dealerFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**********************************************************************
	 * BJPanel() initializes the game.
	 * @param game an instantiated game.
	 *********************************************************************/
	public BJPanel(final Game game) {
		initialize(game);
	}
	
	/**********************************************************************
	 * This method takes in all the necessary image files, re-sizes them,
	 * and then assigns them to the appropriate ImageIcon.
	 *********************************************************************/
	private void resizeImages() {
		try {
			//Get Image files
			//--empty card
			 emptyImg = ImageIO.read(new File("bin/Images/EMPTY.png"));
			//--card back
			 backImg = ImageIO.read(new File("bin/Images/BACK.png"));
			//--clubs
			 aceCImg = ImageIO.read(new File("bin/Images/ACE-CLUBS.png"));
			 kingCImg = ImageIO.read(new File("bin/Images/KING-CLUBS.png"));
			 queenCImg = ImageIO.read(new File("bin/Images/QUEEN-CLUBS.png"));
			 jackCImg = ImageIO.read(new File("bin/Images/JACK-CLUBS.png"));
			 tenCImg = ImageIO.read(new File("bin/Images/TEN-CLUBS.png"));
			 nineCImg = ImageIO.read(new File("bin/Images/NINE-CLUBS.png"));
			 eightCImg = ImageIO.read(new File("bin/Images/EIGHT-CLUBS.png"));
			 sevenCImg = ImageIO.read(new File("bin/Images/SEVEN-CLUBS.png"));
			 sixCImg = ImageIO.read(new File("bin/Images/SIX-CLUBS.png"));
			 fiveCImg = ImageIO.read(new File("bin/Images/FIVE-CLUBS.png"));
			 fourCImg = ImageIO.read(new File("bin/Images/FOUR-CLUBS.png"));
			 threeCImg = ImageIO.read(new File("bin/Images/THREE-CLUBS.png"));
			 twoCImg = ImageIO.read(new File("bin/Images/TWO-CLUBS.png"));
			//--diamonds
			 aceDImg = ImageIO.read(new File("bin/Images/ACE-DIAMONDS.png"));
			 kingDImg = ImageIO.read(new File("bin/Images/KING-DIAMONDS.png"));
			 queenDImg 
			 = ImageIO.read(new File("bin/Images/QUEEN-DIAMONDS.png"));
			 jackDImg = ImageIO.read(new File("bin/Images/JACK-DIAMONDS.png"));
			 tenDImg = ImageIO.read(new File("bin/Images/TEN-DIAMONDS.png"));
			 nineDImg = ImageIO.read(new File("bin/Images/NINE-DIAMONDS.png"));
			 eightDImg 
			 = ImageIO.read(new File("bin/Images/EIGHT-DIAMONDS.png"));
			 sevenDImg 
			 = ImageIO.read(new File("bin/Images/SEVEN-DIAMONDS.png"));
			 sixDImg = ImageIO.read(new File("bin/Images/SIX-DIAMONDS.png"));
			 fiveDImg = ImageIO.read(new File("bin/Images/FIVE-DIAMONDS.png"));
			 fourDImg = ImageIO.read(new File("bin/Images/FOUR-DIAMONDS.png"));
			 threeDImg 
			 = ImageIO.read(new File("bin/Images/THREE-DIAMONDS.png"));
			 twoDImg = ImageIO.read(new File("bin/Images/TWO-DIAMONDS.png"));
			//--hearts
			 aceHImg = ImageIO.read(new File("bin/Images/ACE-HEARTS.png"));
			 kingHImg = ImageIO.read(new File("bin/Images/KING-HEARTS.png"));
			 queenHImg = ImageIO.read(new File("bin/Images/QUEEN-HEARTS.png"));
			 jackHImg = ImageIO.read(new File("bin/Images/JACK-HEARTS.png"));
			 tenHImg = ImageIO.read(new File("bin/Images/TEN-HEARTS.png"));
			 nineHImg = ImageIO.read(new File("bin/Images/NINE-HEARTS.png"));
			 eightHImg = ImageIO.read(new File("bin/Images/EIGHT-HEARTS.png"));
			 sevenHImg = ImageIO.read(new File("bin/Images/SEVEN-HEARTS.png"));
			 sixHImg = ImageIO.read(new File("bin/Images/SIX-HEARTS.png"));
			 fiveHImg = ImageIO.read(new File("bin/Images/FIVE-HEARTS.png"));
			 fourHImg = ImageIO.read(new File("bin/Images/FOUR-HEARTS.png"));
			 threeHImg = ImageIO.read(new File("bin/Images/THREE-HEARTS.png"));
			 twoHImg = ImageIO.read(new File("bin/Images/TWO-HEARTS.png"));
			//--spades
			 aceSImg = ImageIO.read(new File("bin/Images/ACE-SPADES.png"));
			 kingSImg = ImageIO.read(new File("bin/Images/KING-SPADES.png"));
			 queenSImg = ImageIO.read(new File("bin/Images/QUEEN-SPADES.png"));
			 jackSImg = ImageIO.read(new File("bin/Images/JACK-SPADES.png"));
			 tenSImg = ImageIO.read(new File("bin/Images/TEN-SPADES.png"));
			 nineSImg = ImageIO.read(new File("bin/Images/NINE-SPADES.png"));
			 eightSImg = ImageIO.read(new File("bin/Images/EIGHT-SPADES.png"));
			 sevenSImg = ImageIO.read(new File("bin/Images/SEVEN-SPADES.png"));
			 sixSImg = ImageIO.read(new File("bin/Images/SIX-SPADES.png"));
			 fiveSImg = ImageIO.read(new File("bin/Images/FIVE-SPADES.png"));
			 fourSImg = ImageIO.read(new File("bin/Images/FOUR-SPADES.png"));
			 threeSImg = ImageIO.read(new File("bin/Images/THREE-SPADES.png"));
			 twoSImg = ImageIO.read(new File("bin/Images/TWO-SPADES.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Resize Images
		//--empty
		 Image emptySizedImg 
		 = emptyImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		//--back
		 Image backSizedImg 
		 = backImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		//--clubs
		 Image aceCsizedImg 
		 = aceCImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		 Image kingCsizedImg 
		 = kingCImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		 Image queenCsizedImg 
		 = queenCImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		 Image jackCsizedImg 
		 = jackCImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		 Image tenCsizedImg 
		 = tenCImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		 Image nineCsizedImg 
		 = nineCImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		 Image eightCsizedImg 
		 = eightCImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		 Image sevenCsizedImg 
		 = sevenCImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		 Image sixCsizedImg 
		 = sixCImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		 Image fiveCsizedImg 
		 = fiveCImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		 Image fourCsizedImg 
		 = fourCImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		 Image threeCsizedImg 
		 = threeCImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		 Image twoCsizedImg 
		 = twoCImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		//--diamonds
		 Image aceDsizedImg 
		 = aceDImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		 Image kingDsizedImg 
		 = kingDImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		 Image queenDsizedImg 
		 = queenDImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		 Image jackDsizedImg 
		 = jackDImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		 Image tenDsizedImg 
		 = tenDImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		 Image nineDsizedImg 
		 = nineDImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		 Image eightDsizedImg 
		 = eightDImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		 Image sevenDsizedImg 
		 = sevenDImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		 Image sixDsizedImg 
		 = sixDImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		 Image fiveDsizedImg 
		 = fiveDImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		 Image fourDsizedImg 
		 = fourDImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		 Image threeDsizedImg 
		 = threeDImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		 Image twoDsizedImg 
		 = twoDImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		//--hearts
		 Image aceHsizedImg 
		 = aceHImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		 Image kingHsizedImg 
		 = kingHImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		 Image queenHsizedImg 
		 = queenHImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		 Image jackHsizedImg 
		 = jackHImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		 Image tenHsizedImg 
		 = tenHImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		 Image nineHsizedImg 
		 = nineHImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		 Image eightHsizedImg 
		 = eightHImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		 Image sevenHsizedImg 
		 = sevenHImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		 Image sixHsizedImg 
		 = sixHImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		 Image fiveHsizedImg 
		 = fiveHImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		 Image fourHsizedImg 
		 = fourHImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		 Image threeHsizedImg 
		 = threeHImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		 Image twoHsizedImg 
		 = twoHImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		//--spades
		 Image aceSsizedImg 
		 = aceSImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		 Image kingSsizedImg 
		 = kingSImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		 Image queenSsizedImg 
		 = queenSImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		 Image jackSsizedImg 
		 = jackSImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		 Image tenSsizedImg 
		 = tenSImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		 Image nineSsizedImg 
		 = nineSImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		 Image eightSsizedImg 
		 = eightSImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		 Image sevenSsizedImg 
		 = sevenSImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		 Image sixSsizedImg 
		 = sixSImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		 Image fiveSsizedImg 
		 = fiveSImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		 Image fourSsizedImg 
		 = fourSImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		 Image threeSsizedImg 
		 = threeSImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		 Image twoSsizedImg 
		 = twoSImg.getScaledInstance(cwidth, cheight, Image.SCALE_SMOOTH);
		
		 //Set Icons
		//--empty card
		  emptyicon = new ImageIcon(emptySizedImg);
		//--back
		  backicon = new ImageIcon(backSizedImg);
		//--clubs
		  aceCicon = new ImageIcon(aceCsizedImg);
		  kingCicon = new ImageIcon(kingCsizedImg);
		  queenCicon = new ImageIcon(queenCsizedImg);
		  jackCicon = new ImageIcon(jackCsizedImg);
		  tenCicon = new ImageIcon(tenCsizedImg);
		  nineCicon = new ImageIcon(nineCsizedImg);
		  eightCicon = new ImageIcon(eightCsizedImg);
		  sevenCicon = new ImageIcon(sevenCsizedImg);
		  sixCicon = new ImageIcon(sixCsizedImg);
		  fiveCicon = new ImageIcon(fiveCsizedImg);
		  fourCicon = new ImageIcon(fourCsizedImg);
		  threeCicon = new ImageIcon(threeCsizedImg);
		  twoCicon = new ImageIcon(twoCsizedImg);
		//--diamonds
		  aceDicon = new ImageIcon(aceDsizedImg);
		  kingDicon = new ImageIcon(kingDsizedImg);
		  queenDicon = new ImageIcon(queenDsizedImg);
		  jackDicon = new ImageIcon(jackDsizedImg);
		  tenDicon = new ImageIcon(tenDsizedImg);
		  nineDicon = new ImageIcon(nineDsizedImg);
		  eightDicon = new ImageIcon(eightDsizedImg);
		  sevenDicon = new ImageIcon(sevenDsizedImg);
		  sixDicon = new ImageIcon(sixDsizedImg);
		  fiveDicon = new ImageIcon(fiveDsizedImg);
		  fourDicon = new ImageIcon(fourDsizedImg);
		  threeDicon = new ImageIcon(threeDsizedImg);
		  twoDicon = new ImageIcon(twoDsizedImg);
		//--hearts
		  aceHicon = new ImageIcon(aceHsizedImg);
		  kingHicon = new ImageIcon(kingHsizedImg);
		  queenHicon = new ImageIcon(queenHsizedImg);
		  jackHicon = new ImageIcon(jackHsizedImg);
		  tenHicon = new ImageIcon(tenHsizedImg);
		  nineHicon = new ImageIcon(nineHsizedImg);
		  eightHicon = new ImageIcon(eightHsizedImg);
		  sevenHicon = new ImageIcon(sevenHsizedImg);
		  sixHicon = new ImageIcon(sixHsizedImg);
		  fiveHicon = new ImageIcon(fiveHsizedImg);
		  fourHicon = new ImageIcon(fourHsizedImg);
		  threeHicon = new ImageIcon(threeHsizedImg);
		  twoHicon = new ImageIcon(twoHsizedImg);
		//--spades
		  aceSicon = new ImageIcon(aceSsizedImg);
		  kingSicon = new ImageIcon(kingSsizedImg);
		  queenSicon = new ImageIcon(queenSsizedImg);
		  jackSicon = new ImageIcon(jackSsizedImg);
		  tenSicon = new ImageIcon(tenSsizedImg);
		  nineSicon = new ImageIcon(nineSsizedImg);
		  eightSicon = new ImageIcon(eightSsizedImg);
		  sevenSicon = new ImageIcon(sevenSsizedImg);
		  sixSicon = new ImageIcon(sixSsizedImg);
		  fiveSicon = new ImageIcon(fiveSsizedImg);
		  fourSicon = new ImageIcon(fourSsizedImg);
		  threeSicon = new ImageIcon(threeSsizedImg);
		  twoSicon = new ImageIcon(twoSsizedImg);
	}
	
	/**********************************************************************
	 * Sets up the initial GUI based on the given Game() object.
	 * @param game a Game() object to be the basis of the GUI.
	 *********************************************************************/
	private void initialize(final Game game) {
		 resizeImages();
		 game.initialDeal();
		 userTurnEnd = false;
		
		//##BEGIN USER FRAME##
		userFrame = new JFrame("BlackJack 2.0");
		userFrame.setBounds(USERXLOCATION, USERYLOCATION,
							FRAMEWIDTH, FRAMEHEIGHT);
		userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		userFrame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNewGame = new JMenuItem("New Game");
		mnFile.add(mntmNewGame);
		
		JMenuItem mntmQuitGame = new JMenuItem("Quit Game");
		mnFile.add(mntmQuitGame);
		
		mntmNewGame.addActionListener((ActionEvent event) -> {	 
	        newGame(game);
		});
		
		mntmQuitGame.addActionListener((ActionEvent event) -> {	 
	        System.exit(0);
		});
		
		//toolbar
		JToolBar toolBar = new JToolBar();
		userFrame.getContentPane().add(toolBar, BorderLayout.SOUTH);
		
		
		btnHit = new JButton("Hit");
		btnHit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				if (game.getUser().playerBust()) {
					disableButtons();
					refreshGame(game);
					endGame(game);
				} else {
					game.userHit();
					refreshGame(game);
				}
			}
		});
		toolBar.add(btnHit);
		
		btnStay = new JButton("Stay");
		btnStay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				userTurnEnd = true;
				game.dealerHitStay();
				refreshCards(game);
				refreshToolbar(game);
				disableButtons();
				endGame(game);
			}
		});
		toolBar.add(btnStay);
		
		btnBet = new JButton("Bet(+10)");
		btnBet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				game.getUser().bet();
				refreshToolbar(game);
			}
		});
		toolBar.add(btnBet);
		
		Component horizontalStrut7 = Box.createHorizontalStrut(STRUTSIZE);
		toolBar.add(horizontalStrut7);
		
		//bet panel
		JLabel lblCurrentBetplac = new JLabel("Current Bet:");
		toolBar.add(lblCurrentBetplac);
		
		lblCurrentBet = new JLabel(Integer.toString(game.getUser().getBet()));
		toolBar.add(lblCurrentBet);
		
		Component horizontalStrut = Box.createHorizontalStrut(STRUTSIZE);
		toolBar.add(horizontalStrut);
		//points panel
		JLabel lblCurrentPointsplac = new JLabel("Current Points:");
		toolBar.add(lblCurrentPointsplac);
		
		lblCurrentPoints 
		= new JLabel(Integer.toString(game.getUser().getPoints()));
		toolBar.add(lblCurrentPoints);
		
		Component horizontalStrut8 = Box.createHorizontalStrut(STRUTSIZE);
		toolBar.add(horizontalStrut8);
		
		//center panel
		JPanel upanel = new JPanel();
		userFrame.getContentPane().add(upanel, BorderLayout.CENTER);
		upanel.setLayout(new BoxLayout(upanel, BoxLayout.X_AXIS));
		
		Component horizontalStrut6 = Box.createHorizontalStrut(STRUTSIZE);
		upanel.add(horizontalStrut6);
		
		lblCard1.setIcon(getIcon(game.getUser().getHand().getCard(0)));
		upanel.add(lblCard1);
		
		Component horizontalStrut1 = Box.createHorizontalStrut(STRUTSIZE);
		upanel.add(horizontalStrut1);
		
		lblCard2.setIcon(getIcon(game.getUser().getHand().getCard(1)));
		upanel.add(lblCard2);
		
		Component horizontalStrut2 = Box.createHorizontalStrut(STRUTSIZE);
		upanel.add(horizontalStrut2);
		
		lblCard3.setIcon(emptyicon);
		upanel.add(lblCard3);
		
		Component horizontalStrut3 = Box.createHorizontalStrut(STRUTSIZE);
		upanel.add(horizontalStrut3);
		
		lblCard4.setIcon(emptyicon);
		upanel.add(lblCard4);
		
		Component horizontalStrut4 = Box.createHorizontalStrut(STRUTSIZE);
		upanel.add(horizontalStrut4);
		
		lblCard5.setIcon(emptyicon);
		upanel.add(lblCard5);
		
		Component horizontalStrut5 = Box.createHorizontalStrut(STRUTSIZE);
		upanel.add(horizontalStrut5);
		
		lblCard6.setIcon(emptyicon);
		upanel.add(lblCard6);
		//##END USER FRAME##
		
		//##BEGIN DEALER FRAME##
		dealerFrame = new JFrame("Dealer");
		dealerFrame.setBounds(DEALERXLOCATION, DEALERYLOCATION, 
							  FRAMEWIDTH, FRAMEHEIGHT);
		dealerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//center panel
		JPanel dpanel = new JPanel();
		dealerFrame.getContentPane().add(dpanel, BorderLayout.CENTER);
		dpanel.setLayout(new BoxLayout(dpanel, BoxLayout.X_AXIS));
		
		Component dhorizontalStrut6 = Box.createHorizontalStrut(STRUTSIZE);
		dpanel.add(dhorizontalStrut6);
		
		dlblCard1.setIcon(backicon);
		dpanel.add(dlblCard1);
		
		Component dhorizontalStrut1 = Box.createHorizontalStrut(STRUTSIZE);
		dpanel.add(dhorizontalStrut1);
		
		dlblCard2.setIcon(getIcon(game.getDealer().getHand().getCard(1)));
		dpanel.add(dlblCard2);
		
		Component dhorizontalStrut2 = Box.createHorizontalStrut(STRUTSIZE);
		dpanel.add(dhorizontalStrut2);
		
		dlblCard3.setIcon(emptyicon);
		dpanel.add(dlblCard3);
		
		Component dhorizontalStrut3 = Box.createHorizontalStrut(STRUTSIZE);
		dpanel.add(dhorizontalStrut3);
		
		dlblCard4.setIcon(emptyicon);
		dpanel.add(dlblCard4);
		
		Component dhorizontalStrut4 = Box.createHorizontalStrut(STRUTSIZE);
		dpanel.add(dhorizontalStrut4);
		
		dlblCard5.setIcon(emptyicon);
		dpanel.add(dlblCard5);
		
		Component dhorizontalStrut5 = Box.createHorizontalStrut(STRUTSIZE);
		dpanel.add(dhorizontalStrut5);
		
		dlblCard6.setIcon(emptyicon);
		dpanel.add(dlblCard6);
		//end center panel
		//##END DEALER FRAME##
	}
	
	/**********************************************************************
	 * Refreshes the card icons based on the current card values.
	 * @param game the current game.
	 *********************************************************************/
	private void refreshCards(final Game game) {
		//user card icons
		//--card1
		if (game.getUser().getHand().getCard(0) != null) {
			lblCard1.setIcon(getIcon(game.getUser().getHand().getCard(0)));
		}
		//--card2
		if (game.getUser().getHand().getCard(1) != null) {
			lblCard2.setIcon(getIcon(game.getUser().getHand().getCard(1)));
		}
		//--card3
		if (game.getUser().getHand().getCard(2) != null) {
			lblCard3.setIcon(getIcon(game.getUser().getHand().getCard(2)));
		}
		//--card4
		if (game.getUser().getHand().getCard(3) != null) {
			lblCard4.setIcon(getIcon(game.getUser().getHand().getCard(3)));
		}
		//--card5
		if (game.getUser().getHand().getCard(4) != null) { 
			lblCard5.setIcon(getIcon(game.getUser().getHand().getCard(4)));
		}
		//--card6
		if (game.getUser().getHand().getCard(5) != null) {
			lblCard6.setIcon(getIcon(game.getUser().getHand().getCard(5)));
		}
		//dealer card icons
		//--card1
		if (userTurnEnd && game.getDealer().getHand().getCard(0) != null) {
			dlblCard1.setIcon(getIcon(game.getDealer().getHand().getCard(0)));
		} else if (game.getDealer().getHand().getCard(0) != null) {
			dlblCard1.setIcon(backicon);
		}
		//--card2
		if (game.getDealer().getHand().getCard(1) != null) {
			dlblCard2.setIcon(getIcon(game.getDealer().getHand().getCard(1)));
		}
		//--card3
		if (game.getDealer().getHand().getCard(2) != null) {
			dlblCard3.setIcon(getIcon(game.getDealer().getHand().getCard(2)));
		}
		//--card4
		if (game.getDealer().getHand().getCard(3) != null) {
			dlblCard4.setIcon(getIcon(game.getDealer().getHand().getCard(3)));
		}
		//--card5
		if (game.getDealer().getHand().getCard(4) != null) {
			dlblCard5.setIcon(getIcon(game.getDealer().getHand().getCard(4)));
		}
		//--card6
		if (game.getDealer().getHand().getCard(5) != null) {
			dlblCard6.setIcon(getIcon(game.getDealer().getHand().getCard(5)));
		}		
	}
	/**********************************************************************
	 * Get's the appropriate ImageIcon based on the parameter Card()
	 * object's card rank and value.
	 * @param card the Card() object for which the icon is needed.
	 * @return ImageIcon for the card.
	 *********************************************************************/
	private static ImageIcon getIcon(final Card card) {
		//start clubs
		if (card.suit() == Suit.CLUBS) {
			if (card.rank() == Rank.ACE) {
				return aceCicon;
			} else if (card.rank() == Rank.KING) {
				return kingCicon;
			} else if (card.rank() == Rank.QUEEN) {
				return queenCicon;
			} else if (card.rank() == Rank.JACK) {
				return jackCicon;
			} else if (card.rank() == Rank.TEN) {
				return tenCicon;
			} else if (card.rank() == Rank.NINE) {
				return nineCicon;
			} else if (card.rank() == Rank.EIGHT) {
				return eightCicon;
			} else if (card.rank() == Rank.SEVEN) {
				return sevenCicon;
			} else if (card.rank() == Rank.SIX) {
				return sixCicon;
			} else if (card.rank() == Rank.FIVE) {
				return fiveCicon;
			} else if (card.rank() == Rank.FOUR) {
				return fourCicon;
			} else if (card.rank() == Rank.THREE) {
				return threeCicon;
			} else if (card.rank() == Rank.TWO) {
				return twoCicon;
			} else {
				return emptyicon;
			}
		}
		//end clubs
		//start hearts
		if (card.suit() == Suit.HEARTS) {
			if (card.rank() == Rank.ACE) {
				return aceHicon;
			} else if (card.rank() == Rank.KING) {
				return kingHicon;
			} else if (card.rank() == Rank.QUEEN) {
				return queenHicon;
			} else if (card.rank() == Rank.JACK) {
				return jackHicon;
			} else if (card.rank() == Rank.TEN) {
				return tenHicon;
			} else if (card.rank() == Rank.NINE) {
				return nineHicon;
			} else if (card.rank() == Rank.EIGHT) {
				return eightHicon;
			} else if (card.rank() == Rank.SEVEN) {
				return sevenHicon;
			} else if (card.rank() == Rank.SIX) {
				return sixHicon;
			} else if (card.rank() == Rank.FIVE) {
				return fiveHicon;
			} else if (card.rank() == Rank.FOUR) {
				return fourHicon;
			} else if (card.rank() == Rank.THREE) {
				return threeHicon;
			} else if (card.rank() == Rank.TWO) {
				return twoHicon;
			} else {
				return emptyicon;
			}
		}
		//end hearts
		//start spades
		if (card.suit() == Suit.SPADES) {
			if (card.rank() == Rank.ACE) {
				return aceSicon;
			} else if (card.rank() == Rank.KING) {
				return kingSicon;
			} else if (card.rank() == Rank.QUEEN) {
				return queenSicon;
			} else if (card.rank() == Rank.JACK) {
				return jackSicon;
			} else if (card.rank() == Rank.TEN) {
				return tenSicon;
			} else if (card.rank() == Rank.NINE) {
				return nineSicon;
			} else if (card.rank() == Rank.EIGHT) {
				return eightSicon;
			} else if (card.rank() == Rank.SEVEN) {
				return sevenSicon;
			} else if (card.rank() == Rank.SIX) {
				return sixSicon;
			} else if (card.rank() == Rank.FIVE) {
				return fiveSicon;
			} else if (card.rank() == Rank.FOUR) {
				return fourSicon;
			} else if (card.rank() == Rank.THREE) {
				return threeSicon;
			} else if (card.rank() == Rank.TWO) {
				return twoSicon;
			} else {
				return emptyicon;
			}
		}
		//end spades
		//start diamonds
		if (card.suit() == Suit.DIAMONDS) {
			if (card.rank() == Rank.ACE) {
				return aceDicon;
			} else if (card.rank() == Rank.KING) {
				return kingDicon;
			} else if (card.rank() == Rank.QUEEN) {
				return queenDicon;
			} else if (card.rank() == Rank.JACK) {
				return jackDicon;
			} else if (card.rank() == Rank.TEN) {
				return tenDicon;
			} else if (card.rank() == Rank.NINE) {
				return nineDicon;
			} else if (card.rank() == Rank.EIGHT) {
				return eightDicon;
			} else if (card.rank() == Rank.SEVEN) {
				return sevenDicon;
			} else if (card.rank() == Rank.SIX) {
				return sixDicon;
			} else if (card.rank() == Rank.FIVE) {
				return fiveDicon;
			} else if (card.rank() == Rank.FOUR) {
				return fourDicon;
			} else if (card.rank() == Rank.THREE) {
				return threeDicon;
			} else if (card.rank() == Rank.TWO) {
				return twoDicon;
			} else {
				return emptyicon;
			} //end spades	
		} else {
			return emptyicon;
		}
		
	}
	/**********************************************************************
	 * Refreshes the game's GUI elements.
	 * @param game the current Game() object.
	 *********************************************************************/
	private void refreshGame(final Game game) {
		refreshCards(game);
		refreshToolbar(game);
		if (game.getUser().playerBust()) {
			endGame(game);
		}
		
	}
	/**********************************************************************
	 * Refreshes the game's tool bar.
	 * @param game the current Game() object.
	 *********************************************************************/
	private void refreshToolbar(final Game game) {
		lblCurrentBet.setText(Integer.toString(game.getUser().getBet()));
		lblCurrentPoints.setText(Integer.toString(game.getUser().getPoints()));
	}
	/**********************************************************************
	 * Disables the appropriate buttons.
	 *********************************************************************/
	private void disableButtons() {
		btnStay.setEnabled(false);
		btnHit.setEnabled(false);
	}
	/**********************************************************************
	 * Makes a new game using the old game's point total to carry forward.
	 * @param oldgame previous Game() object, to be used for point total.
	 *********************************************************************/
	private void newGame(final Game oldgame) {
		userFrame.dispose();
		dealerFrame.dispose();
		Game game = new Game(oldgame.getUser().getPoints());
		try {
			BJPanel panel = new BJPanel(game);
			panel.userFrame.setVisible(true);
			panel.dealerFrame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**********************************************************************
	 * endGame() is called in a 'end game' situation and calls the 
	 * appropriate methods to generate values needed to complete and 
	 * display to the user's end message and winnings total.
	 * @param game current game that is ending.
	 *********************************************************************/
	private void endGame(final Game game) {
		int winTotal = game.getUser().getBet();
		int winmultiple = 1;
		int lossmultiple = -1;
		int tiemultiple = 0;
		double naturalmultiple = 0.5;
		game.userWinCheck();
		System.out.println("User hand: ");
		game.getUser().printHand();
		System.out.println("User total: " 
				+ Integer.toString(game.getUser().handValue()));
		System.out.println("User hand: ");
		game.getDealer().printHand();
		System.out.println("Dealer total: " 
		        + Integer.toString(game.getDealer().handValue()));
		String endMessage = game.getUser().getEndMessage();
		switch (endMessage) {
			case "Win": winTotal = (winTotal * winmultiple);
			break;
			
			case "Loss": winTotal = (winTotal * lossmultiple);
			break;
			
			case "Natural Win": winTotal 
				 = (int) Math.floor((winTotal * naturalmultiple));
			break;
			
			case "Stand-off(Tie)": winTotal = (winTotal * tiemultiple);
			break;
			 
			default: winTotal = (winTotal * winmultiple);
			break;
		}
		int response = JOptionPane.showConfirmDialog(null, "Game Over.\nUser: " 
				+ game.getUser().getEndMessage() +	"\nWinnings:" 
				+ Integer.toString(winTotal) +  "\nStart a new game?", 
				"Confirm", JOptionPane.YES_NO_OPTION, 
				JOptionPane.QUESTION_MESSAGE);
		if (response == JOptionPane.NO_OPTION) {
			System.exit(0);
		} else if (response == JOptionPane.YES_OPTION) {
			newGame(game);
		} else if (response == JOptionPane.CLOSED_OPTION) {
			System.exit(0);
		}
	}
}
