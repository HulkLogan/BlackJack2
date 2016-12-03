package bjpack;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

import bjpack.Card.Rank;
import bjpack.Card.Suit;

public class BJPanel extends JPanel{
	//JOption for when no points to bet
	
	private JFrame userFrame;
	private JFrame dealerFrame;
	private boolean userTurnEnd = false;
		
	//BufferedImages
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
	
	//ImageIcons
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
	
	//card dimensions
	private int cwidth = 100;
	private int cheight = 145;
	
	//user card labels
	JLabel lblCard = new JLabel("Card01");
	JLabel lblCard_1 = new JLabel("Card02");
	JLabel lblCard_2 = new JLabel("Card03");
	JLabel lblCard_3 = new JLabel("Card04");
	JLabel lblCard_4 = new JLabel("Card05");
	JLabel lblCard_5 = new JLabel("Card06");
	//dealer card labels
	JLabel dlblCard = new JLabel("Card01");
	JLabel dlblCard_1 = new JLabel("Card02");
	JLabel dlblCard_2 = new JLabel("Card03");
	JLabel dlblCard_3 = new JLabel("Card04");
	JLabel dlblCard_4 = new JLabel("Card05");
	JLabel dlblCard_5 = new JLabel("Card06");
	
	JLabel lblCurrentBet;
	JLabel lblCurrentPoints;
	JLabel lblCurrentHand;
	
	JButton btnStay;
	JButton btnHit;
	JButton btnBet; 
	
	/**
	 * Launch the application.
	 */
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

	
	public BJPanel(final Game game){
		initialize(game);
	}
	
	private void resizeImages(){
		try{
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
		}
		catch(IOException e){
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
	
	private void initialize(final Game game) {
		 resizeImages();
		 game.initialDeal();
		 userTurnEnd = false;
		
		//##BEGIN USER FRAME##
		userFrame = new JFrame("User Frame");
		userFrame.setBounds(150, 150, 1150, 400);
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
		btnHit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(final ActionEvent e){
				if(game.getUser().playerBust()){
					disableButtons();
					refreshGame(game);
					endGame(game);
				}
				else{
					game.userHit();
					refreshGame(game);
				}
			}
		});
		toolBar.add(btnHit);
		
		btnStay = new JButton("Stay");
		btnStay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e){
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
		btnBet.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				game.getUser().bet();
				refreshToolbar(game);
			}
		});
		toolBar.add(btnBet);
		
		Component horizontalStrut_7 = Box.createHorizontalStrut(20);
		toolBar.add(horizontalStrut_7);
		
		//bet panel
		JLabel lblCurrentBetplac = new JLabel("Current Bet:");
		toolBar.add(lblCurrentBetplac);
		
		lblCurrentBet = new JLabel(Integer.toString(game.getUser().getBet()));
		toolBar.add(lblCurrentBet);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		toolBar.add(horizontalStrut);
		//points panel
		JLabel lblCurrentPointsplac = new JLabel("Current Points:");
		toolBar.add(lblCurrentPointsplac);
		
		lblCurrentPoints = new JLabel(Integer.toString(game.getUser().getPoints()));
		toolBar.add(lblCurrentPoints);
		
		Component horizontalStrut_8 = Box.createHorizontalStrut(20);
		toolBar.add(horizontalStrut_8);
		
		//center panel
		JPanel upanel = new JPanel();
		userFrame.getContentPane().add(upanel, BorderLayout.CENTER);
		upanel.setLayout(new BoxLayout(upanel, BoxLayout.X_AXIS));
		
		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		upanel.add(horizontalStrut_6);
		
		lblCard.setIcon(getIcon(game.getUser().getHand().getCard(0)));
		upanel.add(lblCard);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		upanel.add(horizontalStrut_1);
		
		lblCard_1.setIcon(getIcon(game.getUser().getHand().getCard(1)));
		upanel.add(lblCard_1);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		upanel.add(horizontalStrut_2);
		
		lblCard_2.setIcon(emptyicon);
		upanel.add(lblCard_2);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		upanel.add(horizontalStrut_3);
		
		lblCard_3.setIcon(emptyicon);
		upanel.add(lblCard_3);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		upanel.add(horizontalStrut_4);
		
		lblCard_4.setIcon(emptyicon);
		upanel.add(lblCard_4);
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		upanel.add(horizontalStrut_5);
		
		lblCard_5.setIcon(emptyicon);
		upanel.add(lblCard_5);
		//##END USER FRAME##
		
		//##BEGIN DEALER FRAME##
		dealerFrame = new JFrame("Dealer Frame");
		dealerFrame.setBounds(150, 150, 1150, 400);
		dealerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//center panel
		JPanel dpanel = new JPanel();
		dealerFrame.getContentPane().add(dpanel, BorderLayout.CENTER);
		dpanel.setLayout(new BoxLayout(dpanel, BoxLayout.X_AXIS));
		
		Component dhorizontalStrut_6 = Box.createHorizontalStrut(20);
		dpanel.add(dhorizontalStrut_6);
		
		dlblCard.setIcon(backicon);
		dpanel.add(dlblCard);
		
		Component dhorizontalStrut_1 = Box.createHorizontalStrut(20);
		dpanel.add(dhorizontalStrut_1);
		
		dlblCard_1.setIcon(getIcon(game.getDealer().getHand().getCard(1)));
		dpanel.add(dlblCard_1);
		
		Component dhorizontalStrut_2 = Box.createHorizontalStrut(20);
		dpanel.add(dhorizontalStrut_2);
		
		dlblCard_2.setIcon(emptyicon);
		dpanel.add(dlblCard_2);
		
		Component dhorizontalStrut_3 = Box.createHorizontalStrut(20);
		dpanel.add(dhorizontalStrut_3);
		
		dlblCard_3.setIcon(emptyicon);
		dpanel.add(dlblCard_3);
		
		Component dhorizontalStrut_4 = Box.createHorizontalStrut(20);
		dpanel.add(dhorizontalStrut_4);
		
		dlblCard_4.setIcon(emptyicon);
		dpanel.add(dlblCard_4);
		
		Component dhorizontalStrut_5 = Box.createHorizontalStrut(20);
		dpanel.add(dhorizontalStrut_5);
		
		dlblCard_5.setIcon(emptyicon);
		dpanel.add(dlblCard_5);
		//end center panel
		//##END DEALER FRAME##
	}
	
	private void refreshCards(Game game){
		//user card icons
		//--card1
		if(game.getUser().getHand().getCard(0) != null){
			lblCard.setIcon(getIcon(game.getUser().getHand().getCard(0)));
		}
		//--card2
		if(game.getUser().getHand().getCard(1) != null){
			lblCard_1.setIcon(getIcon(game.getUser().getHand().getCard(1)));
		}
		//--card3
		if(game.getUser().getHand().getCard(2) != null){
			lblCard_2.setIcon(getIcon(game.getUser().getHand().getCard(2)));
		}
		//--card4
		if(game.getUser().getHand().getCard(3) != null){
			lblCard_3.setIcon(getIcon(game.getUser().getHand().getCard(3)));
		}
		//--card5
		if(game.getUser().getHand().getCard(4) != null){
			lblCard_4.setIcon(getIcon(game.getUser().getHand().getCard(4)));
		}
		//--card6
		if(game.getUser().getHand().getCard(5) != null){
			lblCard_5.setIcon(getIcon(game.getUser().getHand().getCard(5)));
		}
		//dealer card icons
		//--card1
		if (userTurnEnd && game.getDealer().getHand().getCard(0) != null) {
			dlblCard.setIcon(getIcon(game.getDealer().getHand().getCard(0)));
		} else if (game.getDealer().getHand().getCard(0) != null) {
			dlblCard.setIcon(backicon);
		}
		//--card2
		if(game.getDealer().getHand().getCard(1) != null){
			dlblCard_1.setIcon(getIcon(game.getDealer().getHand().getCard(1)));
		}
		//--card3
		if(game.getDealer().getHand().getCard(2) != null){
			dlblCard_2.setIcon(getIcon(game.getDealer().getHand().getCard(2)));
		}
		//--card4
		if(game.getDealer().getHand().getCard(3) != null){
			dlblCard_3.setIcon(getIcon(game.getDealer().getHand().getCard(3)));
		}
		//--card5
		if(game.getDealer().getHand().getCard(4) != null){
			dlblCard_4.setIcon(getIcon(game.getDealer().getHand().getCard(4)));
		}
		//--card6
		if(game.getDealer().getHand().getCard(5) != null){
			dlblCard_5.setIcon(getIcon(game.getDealer().getHand().getCard(5)));
		}		
	}
	private static ImageIcon getIcon(Card card){
		//start clubs
		if(card.suit() == Suit.CLUBS){
			if(card.rank() == Rank.ACE){
				return aceCicon;
			}
			else if(card.rank() == Rank.KING){
				return kingCicon;
			}
			else if(card.rank() == Rank.QUEEN){
				return queenCicon;
			}
			else if(card.rank() == Rank.JACK){
				return jackCicon;
			}
			else if(card.rank() == Rank.TEN){
				return tenCicon;
			}
			else if(card.rank() == Rank.NINE){
				return nineCicon;
			}
			else if(card.rank() == Rank.EIGHT){
				return eightCicon;
			}
			else if(card.rank() == Rank.SEVEN){
				return sevenCicon;
			}
			else if(card.rank() == Rank.SIX){
				return sixCicon;
			}
			else if(card.rank() == Rank.FIVE){
				return fiveCicon;
			}
			else if(card.rank() == Rank.FOUR){
				return fourCicon;
			}
			else if(card.rank() == Rank.THREE){
				return threeCicon;
			}
			else if(card.rank() == Rank.TWO){
				return twoCicon;
			}
			else
				return emptyicon;
		}
		//end clubs
		//start hearts
		if(card.suit() == Suit.HEARTS){
			if(card.rank() == Rank.ACE){
				return aceHicon;
			}
			else if(card.rank() == Rank.KING){
				return kingHicon;
			}
			else if(card.rank() == Rank.QUEEN){
				return queenHicon;
			}
			else if(card.rank() == Rank.JACK){
				return jackHicon;
			}
			else if(card.rank() == Rank.TEN){
				return tenHicon;
			}
			else if(card.rank() == Rank.NINE){
				return nineHicon;
			}
			else if(card.rank() == Rank.EIGHT){
				return eightHicon;
			}
			else if(card.rank() == Rank.SEVEN){
				return sevenHicon;
			}
			else if(card.rank() == Rank.SIX){
				return sixHicon;
			}
			else if(card.rank() == Rank.FIVE){
				return fiveHicon;
			}
			else if(card.rank() == Rank.FOUR){
				return fourHicon;
			}
			else if(card.rank() == Rank.THREE){
				return threeHicon;
			}
			else if(card.rank() == Rank.TWO){
				return twoHicon;
			}
			else
				return emptyicon;
		}
		//end hearts
		//start spades
		if(card.suit() == Suit.SPADES){
			if(card.rank() == Rank.ACE){
				return aceSicon;
			}
			else if(card.rank() == Rank.KING){
				return kingSicon;
			}
			else if(card.rank() == Rank.QUEEN){
				return queenSicon;
			}
			else if(card.rank() == Rank.JACK){
				return jackSicon;
			}
			else if(card.rank() == Rank.TEN){
				return tenSicon;
			}
			else if(card.rank() == Rank.NINE){
				return nineSicon;
			}
			else if(card.rank() == Rank.EIGHT){
				return eightSicon;
			}
			else if(card.rank() == Rank.SEVEN){
				return sevenSicon;
			}
			else if(card.rank() == Rank.SIX){
				return sixSicon;
			}
			else if(card.rank() == Rank.FIVE){
				return fiveSicon;
			}
			else if(card.rank() == Rank.FOUR){
				return fourSicon;
			}
			else if(card.rank() == Rank.THREE){
				return threeSicon;
			}
			else if(card.rank() == Rank.TWO){
				return twoSicon;
			}
			else
				return emptyicon;
		}
		//end spades
		//start diamonds
		if(card.suit() == Suit.DIAMONDS){
			if(card.rank() == Rank.ACE){
				return aceDicon;
			}
			else if(card.rank() == Rank.KING){
				return kingDicon;
			}
			else if(card.rank() == Rank.QUEEN){
				return queenDicon;
			}
			else if(card.rank() == Rank.JACK){
				return jackDicon;
			}
			else if(card.rank() == Rank.TEN){
				return tenDicon;
			}
			else if(card.rank() == Rank.NINE){
				return nineDicon;
			}
			else if(card.rank() == Rank.EIGHT){
				return eightDicon;
			}
			else if(card.rank() == Rank.SEVEN){
				return sevenDicon;
			}
			else if(card.rank() == Rank.SIX){
				return sixDicon;
			}
			else if(card.rank() == Rank.FIVE){
				return fiveDicon;
			}
			else if(card.rank() == Rank.FOUR){
				return fourDicon;
			}
			else if(card.rank() == Rank.THREE){
				return threeDicon;
			}
			else if(card.rank() == Rank.TWO){
				return twoDicon;
			}
			else
				return emptyicon;
		}
		//end spades
		else{
			return emptyicon;
		}
		
	}
	private void refreshGame(final Game game){
		refreshCards(game);
		refreshToolbar(game);
		if(game.getUser().playerBust()){
			endGame(game);
		}
		
	}
	private void refreshToolbar(final Game game){
		lblCurrentBet.setText(Integer.toString(game.getUser().getBet()));
		lblCurrentPoints.setText(Integer.toString(game.getUser().getPoints()));
	}
	
	private void disableButtons(){
		btnStay.setEnabled(false);
		btnHit.setEnabled(false);
	}
	
	private void newGame(Game oldgame){
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
	
	/**
	 * endGame() is called in a 'end game' situation and calls the appropriate
	 * methods to generate values needed to complete and display to the user
	 * @param game
	 */
	private void endGame(final Game game) {
		int winTotal = game.getUser().getBet();
		int winmultiple = 1;
		int lossmultiple = -1;
		int tiemultiple = 0;
		double naturalmultiple = 0.5;
		game.userWinCheck();
		System.out.println("User hand: ");
		game.getUser().printHand();
		System.out.println("User total: " + 
				Integer.toString(game.getUser().handValue()));
		System.out.println("User hand: ");
		game.getDealer().printHand();
		System.out.println("Dealer total: " + 
				Integer.toString(game.getDealer().handValue()));
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