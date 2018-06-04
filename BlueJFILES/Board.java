import java.io.File;
import java.awt.event.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import sun.audio.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;
import javax.swing.BorderFactory; //need for borders
public class Board implements ActionListener { 
    private boolean gameScreenClicked = false; //not used currently
    private JFrame master; //the window
    private Toolkit theKit;
    private Dimension wndSize;
    private int activeCool = 0;
    
    
    
    //title screen
    private JPanel titleScreen;
    private JLabel backgroundTitle;
    private ImageIcon origBackgroundTitle;
    private Image origBackgroundImgTitle;
    private Image scaledImageTitle;
    private ImageIcon newIconTitle;
    private JButton btnPlayTitle;
    private JButton btnPlay;
    
    // click sound
    File click = new File("Click.WAV");
    //ChampSelect Variables
    private JPanel panelChampSelect;
    private JButton lockInButton;
    
    
    //GameBoard Variables
    private JPanel gameScreen;
    private GridBagConstraints cons; // for adding objects to pannel
    private GridBagConstraints cons2; // for adding panel to board
    private JLabel turnCount;
    private JLabel repCount;
    private JLabel moneyCount;
    private JButton embezzleAction;
    private JButton raiseFundsAction;
    private JButton interactAction;
    private JButton upgradeAction;
    private JButton activeAction;
    private JButton toggleAction;
    private JButton concedeBut;
    private JLabel imageLabel1;
    private JLabel imageLabel2;
    private JLabel imageLabel3;
    private JLabel imageLabel4;
    private JScrollPane display;
    private JTextArea displayWords;
    private Dimension buttonSize;
    private Border picBorder;
    private Border picBorderYourTurn;
    private boolean activeClick; 
    private boolean interactClick;
    private boolean embezzleClick;
    private boolean fundraiseClick;
    private boolean upgradeClick;
    private boolean playClick;
    private JLabel background;
    private ImageIcon origBackground;
    private Image origBackgroundImg;
    private Image scaledImage;
    private ImageIcon newIcon;
    
    
    
    
    //Upgrade Screen
    private JPanel upgradePanel;
    private JLabel backgroundUpgrade;
    private ImageIcon origBackgroundUpgrade;
    private Image origBackgroundImgUpgrade;
    private Image scaledImageUpgrade;
    private ImageIcon newIconUpgrade;
    private JButton upEmbezzle;
    private JButton upUpgrade;
    private JButton upInteract;
    private JButton upFundraise;
    private JButton upActive;
    private JButton backButton;
    private JLabel disEmbezzle;
    private JLabel disRaiseFunds;
    private JLabel disFundRaise;
    private JLabel disInteract;
    private JLabel disUpgrade;
    private boolean leadClick;
    private boolean prClick;
    private boolean espClick;
    private boolean marClick;
    private boolean rdClick;
    private int embezzleLvl;
    private int upgradeLvl;
    private int interactLvl;
    private int fundraiseLvl;
    private int activeLvl;
    
    
    //charScreen
    private String charSelected;
    private JLabel backgroundChar;
    private ImageIcon origBackgroundChar;
    private Image origBackgroundImgChar;
    private Image scaledImageChar;
    private ImageIcon newIconChar;
    private JPanel charPanel;
    private GridBagConstraints cons3;
    private JButton queenSelect;
    private JButton businessSelect;
    private JButton fatherSelect;
    private JButton spySelect;
    private JTextArea queenDesc;
    private JTextArea businessDesc;
    private JTextArea fatherDesc;
    private JTextArea spyDesc; 
    private JLabel queenPic;
    private JLabel businessPic;
    private JLabel fatherPic;
    private JLabel spyPic;
    private boolean charPicked;
    
    //gameWin Screen
    private JPanel gameWinPanel;
    private JLabel tempWin;
    private JLabel backgroundWin;
    private ImageIcon origBackgroundWin;
    private Image origBackgroundImgWin;
    private Image scaledImageWin;
    private ImageIcon newIconWin;
    
    //gameLose Screen
    private JPanel gameLosePanel;
    private JLabel tempLosePic;
    private JLabel backgroundLose;
    private ImageIcon origBackgroundLose;
    private Image origBackgroundImgLose;
    private Image scaledImageLose;
    private ImageIcon newIconLose;
    
    //Card screen
    private JPanel cardPanel;
    private JLabel cardPic;
    private JButton cardBackButton;
    private JButton redrawButton;
    private JLabel backgroundCard;
    private ImageIcon origBackgroundCard;
    private Image origBackgroundImgCard;
    private Image scaledImageCard;
    private ImageIcon newIconCard;
    
    

    
    
    

    public Board() 
    {
        master = new JFrame("The Long Con");          //  title of the window
        master.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        theKit = master.getToolkit();//This gets the tool kit from the frame
        wndSize  = theKit.getScreenSize();//gets the screen size
        master.setPreferredSize(new Dimension(9*wndSize.width/10, 9*wndSize.height/10)); //half the screen, gotta change
        master.setLocation(wndSize.width/16, wndSize.height/16);
        master.getContentPane().setLayout(new GridBagLayout()); // Setting the pane in the master frame to use the GridBagLayout style\
        //master.setResizable(false);
        activeClick = false;
        interactClick = false;
        embezzleClick = false;
        fundraiseClick = false;
        upgradeClick = false;
        playClick = false;
        
        //Upgrade Screen
        leadClick = false;
        prClick = false;
        espClick = false;
        marClick = false;
        rdClick = false;
        

        
        master.pack();//have these at the bottom, to pack everything together and show it
        master.setVisible(true);
        
        
    }
    
    public void makeGameScreen() //this makes it on contentPane
    {
        Font newFont = new Font("Serif", Font.PLAIN, 20); //makes a new font Object.setFont(Font);
        Font wordsFont = new Font("serif", Font.BOLD, 20); //these font are for the displays on the side, turn, money, rep
        Insets spacing = new Insets(20,20,20,20); //part of constraits, makes an inserts object to space out the boxes :  Insets(int top, int left, int bottom, int right)
        Insets buttonSpacing = new Insets(0,20,0,20);
        
        picBorder = BorderFactory.createLineBorder(Color.gray, 3); //creates a border object whth the color and pixel width
        picBorderYourTurn = BorderFactory.createLineBorder(Color.yellow, 2); 
        
        cons = new GridBagConstraints();
        gameScreen = new JPanel();
        gameScreen.setLayout(new GridBagLayout());
        
        origBackground = new ImageIcon("./pictures/TitleBackGround.png");
        origBackgroundImg = origBackground.getImage();
        scaledImage = origBackgroundImg.getScaledInstance(9*wndSize.width/10, 9*wndSize.height/10, Image.SCALE_DEFAULT);
        newIcon = new ImageIcon(scaledImage);
        background = new JLabel(newIcon);
        background.setLayout(new GridBagLayout());
        
        turnCount = new JLabel("gay"); //makes a new label, with the words on it
        cons.gridx = 0; // point 0,0 on the grid, which in on the top left corner
        cons.gridy = 0;
        cons.weightx = 1; //gives weights
        cons.weighty = 1;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.NONE; //it doesn't blow up to fill the sapce
        cons.anchor = GridBagConstraints.NORTHWEST; //makes it "stick" to the northwest corner of its space
        background.add(turnCount, cons);
        turnCount.setFont(wordsFont);
        
        moneyCount = new JLabel("Money: 100");
        cons.gridx = 4;
        cons.gridy = 4;
        cons.weightx = 1;
        cons.weighty = 1;
        moneyCount.setFont(wordsFont);
        cons.fill = GridBagConstraints.NONE;
        cons.anchor = GridBagConstraints.SOUTHEAST;
        background.add(moneyCount, cons);
        
        
        /*
         *         concedeBut = new JButton("Concede");
         *         cons.gridx = 4;
         *         cons.gridy = 0;
         *         cons.weightx = 1;
         *         cons.weighty = 1;
         *         cons.fill = GridBagConstraints.NONE;
         *         cons.anchor = GridBagConstraints.NORTHEAST;
         *         background.add(concedeBut, cons);
         
         */

        
        repCount = new JLabel("Rep: 50");
        cons.gridx = 0;
        cons.gridy = 4;
        cons.weightx = 1;
        cons.weighty = 1;
        cons.fill = GridBagConstraints.NONE;
        cons.anchor = GridBagConstraints.SOUTHWEST;
        background.add(repCount, cons);
        repCount.setFont(wordsFont);
        
        imageLabel1= new JLabel("");//makes it blank
        imageLabel1.setIcon(new ImageIcon("./pictures/test.png")); //references the picture
        cons.gridx = 2;
        cons.gridy = 0;
        cons.weightx = 1;
        cons.weighty = 1;
        cons.fill = GridBagConstraints.NONE;
        cons.anchor = GridBagConstraints.CENTER;
        cons.insets = new Insets(20,0,0,0);
        background.add(imageLabel1, cons);
        imageLabel1.setBorder(picBorder);
        
        imageLabel2 = new JLabel("");
        imageLabel2.setIcon(new ImageIcon("./pictures/test2.png"));
        cons.gridx = 1;
        cons.gridy = 1;
        cons.weightx = 1;
        cons.weighty = 1;
        cons.fill = GridBagConstraints.NONE;
        cons.anchor = GridBagConstraints.CENTER;
        background.add(imageLabel2, cons);
        imageLabel2.setBorder(picBorder);
        
        displayWords = new JTextArea("Gaynald is gay \n next line"); //to combat issue, we print things using ln, have a array of past actions that will get printed and added
        //that way, I dont need to bother with this anymore, we can set the fint and stuff as well.
        //WE have an array os strings(statments), that this will print to the sdcreen using ln and for each loop. we when update that array for new statements, it will cycle
        display = new JScrollPane(displayWords);// think i am scraping this
        displayWords.setFont(displayWords.getFont().deriveFont(18f)); 
        cons.gridx = 2;
        cons.gridy =1;
        cons.weightx = 1;
        cons.weighty = 1;
        displayWords.setBorder(picBorder);
        cons.fill = GridBagConstraints.NONE;
        cons.anchor = GridBagConstraints.CENTER;
        displayWords.setEditable(false); //cant edit it
        displayWords.setLineWrap(true); // so it will wrap around when it gets too big
        displayWords.setColumns(28);
        //displayWords.setRows(20);
        background.add(displayWords, cons); //It dont work, and I dont wanna do it rn, ill fix it later
        
        imageLabel3 = new JLabel("");
        imageLabel3.setIcon(new ImageIcon("./pictures/test3.png"));
        cons.gridx = 3;
        cons.gridy = 1;
        cons.weightx = 1;
        cons.weighty = 1;
        cons.fill = GridBagConstraints.NONE;
        cons.anchor = GridBagConstraints.CENTER;
        background.add(imageLabel3, cons);
        imageLabel3.setBorder(picBorder);
        
        imageLabel4 = new JLabel("");
        imageLabel4.setIcon(new ImageIcon("./pictures/test4.png"));
        cons.gridx = 2;
        cons.gridy = 2;
        cons.weightx = 1;
        cons.weighty = 1;
        cons.fill = GridBagConstraints.NONE;
        cons.anchor = GridBagConstraints.CENTER;
        background.add(imageLabel4, cons);
        imageLabel4.setBorder(picBorder);
        buttonSize = new Dimension(120, 40);
        
        embezzleAction = new JButton("Embezzle");
        embezzleAction.setActionCommand("Embezzle");
        embezzleAction.addActionListener(this);
        cons.gridx = 2;
        cons.gridy = 3;
        cons.weightx = 1;
        cons.weighty = 1;
        cons.fill = GridBagConstraints.BOTH;
        cons.anchor = GridBagConstraints.CENTER;
        embezzleAction.setPreferredSize(buttonSize);
        cons.insets = buttonSpacing;
        embezzleAction.setFont(newFont);
        background.add(embezzleAction, cons);
        
        
        raiseFundsAction = new JButton("Fundraise");
        raiseFundsAction.setActionCommand("Fundraise");
        raiseFundsAction.addActionListener(this);
        cons.gridx = 3;
        cons.gridy = 3;
        cons.weightx = 1;
        cons.weighty = 1;
        cons.insets = buttonSpacing;
        cons.fill = GridBagConstraints.BOTH;
        cons.anchor = GridBagConstraints.CENTER;
        raiseFundsAction.setPreferredSize(buttonSize);
        raiseFundsAction.setFont(newFont);
        background.add(raiseFundsAction, cons);
        
        interactAction = new JButton("Interact");
        interactAction.setActionCommand("Interact");
        interactAction.addActionListener(this);
        cons.gridx = 1;
        cons.gridy = 3;
        cons.weightx = 1;
        cons.weighty = 1;
        cons.insets = buttonSpacing;
        cons.fill = GridBagConstraints.BOTH;
        cons.anchor = GridBagConstraints.CENTER;
        interactAction.setPreferredSize(buttonSize);
        interactAction.setFont(newFont);
        background.add(interactAction, cons);
        
        upgradeAction = new JButton("Upgrade");
        upgradeAction.setActionCommand("Upgrade");
        /*
         * Sorry, Dust. I wanted to label it as an action. 
         */
        upgradeAction.addActionListener(this);
        cons.gridx = 4;
        cons.gridy = 3;
        cons.weightx = 1;
        cons.weighty = 1;
        cons.insets = buttonSpacing;
        cons.fill = GridBagConstraints.BOTH;
        cons.anchor = GridBagConstraints.CENTER;
        upgradeAction.setPreferredSize(buttonSize);
        upgradeAction.setFont(newFont);
        background.add(upgradeAction, cons);
        
        activeAction = new JButton("Active");
        activeAction.setActionCommand("Active");
        activeAction.addActionListener(this);
        cons.gridx = 0;
        cons.gridy = 3;
        cons.weightx = 1;
        cons.weighty = 1;
        cons.insets = buttonSpacing;
        cons.fill = GridBagConstraints.BOTH;
        cons.anchor = GridBagConstraints.CENTER;
        activeAction.setPreferredSize(buttonSize);
        activeAction.setFont(newFont);
        background.add(activeAction, cons);
        
        cons2 = new GridBagConstraints();
        cons2.gridx = 0;
        cons2.gridy = 0;
        cons2.weightx = 1;
        cons2.weighty = 1;
        
        cons2.fill = GridBagConstraints.BOTH; //how to make it take up the entire screen! 
        
        gameScreen.add(background,cons2);
        
        
        master.getContentPane().add(gameScreen,cons2);
        
        
        master.pack();
        //master.setVisible(true);
    
    }
    
    
    public void hideGameScreen()
    {
        gameScreen.setVisible(false);
        embezzleAction.setVisible(false);
        raiseFundsAction.setVisible(false);
        interactAction.setVisible(false);
        upgradeAction.setVisible(false);
        activeAction.setVisible(false);
    }
    
    public void showGameScreen()
    {
        gameScreen.setVisible(true);
        embezzleAction.setVisible(true);
        raiseFundsAction.setVisible(true);
        interactAction.setVisible(true);
        upgradeAction.setVisible(true);
        activeAction.setVisible(true);
    }
    
    public void makeTitleScreen()
    {       
       Font newFont = new Font("Serif", Font.PLAIN, 20);
       titleScreen = new JPanel();
       btnPlay = new JButton("Play");
       btnPlay.setActionCommand("Play");
       btnPlay.addActionListener(this);
       
       origBackgroundTitle = new ImageIcon("./pictures/TitleBackground.png");
       origBackgroundImgTitle = origBackgroundTitle.getImage();
       scaledImageTitle = origBackgroundImgTitle.getScaledInstance(9*wndSize.width/10, 9*wndSize.height/10, Image.SCALE_DEFAULT);
       newIconTitle = new ImageIcon(scaledImageTitle);
       backgroundTitle = new JLabel(newIconTitle);
       backgroundTitle.setLayout(new GridBagLayout());
       
       cons = new GridBagConstraints();
       
       backgroundTitle.add(btnPlay, cons);
       
        
       /* GridBagLayout gridBagLayout = new GridBagLayout();
        * gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        * gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        * gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        * gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        * titleScreen.setLayout(gridBagLayout);
        * GridBagConstraints gbc_btnPlay = new GridBagConstraints();
        * gbc_btnPlay.gridx = 0;
        * gbc_btnPlay.gridy = 0;
        * gbc_btnPlay.fill = GridBagConstraints.NONE;
        * //btnPlay.PlaySound();
        * btnPlay.setFont(newFont);
        * titleScreen.add(btnPlay, gbc_btnPlay);
        */
       
       

       GridBagConstraints gbc_panelTitleScreen = new GridBagConstraints();
       gbc_panelTitleScreen.gridheight = 8;
       gbc_panelTitleScreen.gridwidth = 8;
       gbc_panelTitleScreen.insets = new Insets(0, 0, 5, 5);
       gbc_panelTitleScreen.fill = GridBagConstraints.BOTH;
       gbc_panelTitleScreen.gridx = 0;
       gbc_panelTitleScreen.gridy = 0;
       titleScreen.add(backgroundTitle, gbc_panelTitleScreen);
       master.getContentPane().add(titleScreen, gbc_panelTitleScreen);
       master.pack(); //need to pack the screen
       titleScreen.setVisible(false);
       
       
    }
    
    public void hideTitleScreen()
    {
        titleScreen.setVisible(false);
        btnPlay.setVisible(false);
    }
    
    public void showTitleScreen()
    {
        titleScreen.setVisible(true);
        btnPlay.setVisible(true);
    }
    
    public void makeCharScreen()
    {

        charPicked = false;
        
        charPanel = new JPanel();
        cons3 = new GridBagConstraints();
        charPanel.setLayout(new GridBagLayout());
        //Insets spacing = new Insets(20,20,20,20); //part of constraits, makes an inserts object to space out the boxes :  Insets(int top, int left, int bottom, int right)
        //Insets buttonSpacing = new Insets(0,20,0,20);
        
        queenSelect = new JButton("Queen");
        queenSelect.setActionCommand("queenSelect");
        queenSelect.addActionListener(this);
        cons3.gridx = 0;
        cons3.gridy = 0;
        cons3.weightx = 1;
        cons3.weighty = 1;
        cons3.fill = GridBagConstraints.NONE;
        charPanel.add(queenSelect, cons3);
        
        businessSelect = new JButton("Business Man");
        businessSelect.setActionCommand("businessSelect");
        businessSelect.addActionListener(this);
        cons3.gridx = 1;
        cons3.gridy = 0;
        cons3.weightx = 1;
        cons3.weighty = 1;
        cons3.fill = GridBagConstraints.NONE;
        charPanel.add(businessSelect, cons3);
        
        fatherSelect = new JButton("Father");
        fatherSelect.setActionCommand("fatherSelect");
        fatherSelect.addActionListener(this);
        cons3.gridx = 2;
        cons3.gridy = 0;
        cons3.weightx = 1;
        cons3.weighty = 1;
        cons3.fill = GridBagConstraints.NONE;
        charPanel.add(fatherSelect, cons3);
        
        spySelect = new JButton("Spy");
        spySelect.setActionCommand("spySelect");
        spySelect.addActionListener(this);
        cons3.gridx = 3;
        cons3.gridy = 0;
        cons3.weightx = 1;
        cons3.weighty = 1;
        cons3.fill = GridBagConstraints.NONE;
        charPanel.add(spySelect, cons3);
        
        queenDesc= new JTextArea("Nobody messes with the Queen. Nobody. \n\n As a Queen, she is able to get more money when she \n fundraises; however, she must always show her actions to \n the world. \n And, her royal privilege is showcased through her active \n ability Royal Wealth which gives her a significant money \n boost , especially in the early game.\n\n Preferred Victory: Science ", 10, 30);
        queenDesc.setLineWrap(true);
        queenDesc.setEditable(false);
        cons3.gridx = 0;
        cons3.gridy = 1;
        cons3.weightx = 1;
        cons3.weighty = 1;
        cons3.fill = GridBagConstraints.NONE;
        cons3.anchor = GridBagConstraints.CENTER;
        cons3.insets = new Insets(20,0,0,0);
        charPanel.add(queenDesc,cons3);        
        /**
         * Nobody messes with the Queen. Nobody.
         * As a Queen, she is able to get more money when she fundraises; however, she must always show her actions to the world.
         * And, her royal privilege is showcased through her active ability Royal Wealth which gives her a significant money boost , especially in the early game.
         * Preferred Victory: Science
         */
        
        queenPic = new JLabel("");
        queenPic.setIcon(new ImageIcon("./pictures/test4.png")); //references the picture
        cons3.gridx = 0;
        cons3.gridy = 2;
        cons3.weightx = 1;
        cons3.weighty = 1;
        cons3.fill = GridBagConstraints.NONE;
        cons3.anchor = GridBagConstraints.CENTER;
        cons3.insets = new Insets(20,0,0,0);
        charPanel.add(queenPic, cons3);
        queenPic.setBorder(picBorder);
        
        
        businessDesc= new JTextArea("If Money is King, then the Businessman is God. \n\n He is a true entrepeneur always looking for cheap ways to make money. Although he boasts a very low reputation at thestart, his ability to to gain money everyday makes him a \ntough opponent. He is also very defensive focused with a \nactive  ability of Class Action Lawsuit which increases all \nother opponent's cooldown times by 2. \n\n Preferred Victory: Time ", 10, 30);
        businessDesc.setLineWrap(true);
        businessDesc.setEditable(false);
        cons3.gridx = 1;
        cons3.gridy = 1;
        cons3.weightx = 1;
        cons3.weighty = 1;
        cons3.fill = GridBagConstraints.NONE;
        cons3.anchor = GridBagConstraints.CENTER;
        cons3.insets = new Insets(20,0,0,0);
        charPanel.add(businessDesc,cons3);
        /**
         * If Money is King, then the Businessman is God. He is a true entrepeneur always looking for cheap ways to make money.
         * Although he boasts a very low reputation at the start, his ability to to gain money everyday makes him a tough opponent.
         * He is also very defensive focused with a active ability of Class Action Lawsuit which increases all other opponent's cooldown times by 2.
         * Preferred Victory: Time
         */
        
        businessPic= new JLabel("");
        businessPic.setIcon(new ImageIcon("./pictures/test.png")); //references the picture
        cons3.gridx = 1;
        cons3.gridy = 2;
        cons3.weightx = 1;
        cons3.weighty = 1;
        cons3.fill = GridBagConstraints.NONE;
        cons3.anchor = GridBagConstraints.CENTER;
        cons3.insets = new Insets(20,0,0,0);
        charPanel.add(businessPic, cons3);
        businessPic.setBorder(picBorder);
        
        fatherDesc= new JTextArea("56 people. The father has killed 56 people in cold blood \nbefore for crossing him.\n\nAlthough the father has trouble upgrading his skills, he is \nable to redraw his chance card when he interacts. His active ability Power of the Mobster can force all other players to pay a fee to the Father.\n\n\nPreferred Victory: Diplomatic ", 10,30);
        fatherDesc.setLineWrap(true);
        fatherDesc.setEditable(false);
        cons3.gridx = 2;
        cons3.gridy = 1;
        cons3.weightx = 1;
        cons3.weighty = 1;
        cons3.fill = GridBagConstraints.NONE;
        cons3.anchor = GridBagConstraints.CENTER;
        cons3.insets = new Insets(20,0,0,0);
        charPanel.add(fatherDesc,cons3);
        /**
         * 56 people. The father has killed 56 people in cold blood before for crossing him.
         * Although the father has trouble upgrading his skills, he is able to redraw his chance card when he interacts.
         * His active ability Power of the Mobster can force all other players to pay a fee to the Father.
         * Preferred Victory: Diplomatic
         */
        
        fatherPic = new JLabel("");
        fatherPic.setIcon(new ImageIcon("./pictures/test2.png")); //references the picture
        cons3.gridx = 2;
        cons3.gridy = 2;
        cons3.weightx = 1;
        cons3.weighty = 1;
        cons3.fill = GridBagConstraints.NONE;
        cons3.anchor = GridBagConstraints.CENTER;
        cons3.insets = new Insets(20,0,0,0);
        charPanel.add(fatherPic, cons3);
        fatherPic.setBorder(picBorder);
        
        spyDesc= new JTextArea("A master of deception and manipulation, the Spy can be a \nvery dangerous foe to fight against.\n\nDespite his inability to fundraise, he can embezzle \nmore money from the money pot and can evade audits \neasily, making him a late-game powerhouse. Not to mentionhis active ability Sabotage can inflict reputation and money penalties to an enemy of his choosing. \n\nPreferred Victory: Domination",10,30);
        cons3.gridx = 3;
        cons3.gridy = 1;
        cons3.weightx = 1;
        cons3.weighty = 1;
        cons3.fill = GridBagConstraints.NONE;
        cons3.anchor = GridBagConstraints.CENTER;
        cons3.insets = new Insets(20,0,0,0);
        spyDesc.setLineWrap(true);
        spyDesc.setEditable(false);
        charPanel.add(spyDesc,cons3);
        /**
         * A master of deception and manipulation, the Spy can be a very dangerous foe to fight against.
         * Despite his inability to fundraise, he can embezzle more money from the money pot and can evade audits easily, making him a late-game powerhouse.
         * Not to mention, his active ability Sabotage can inflict reputation and money penalties to an enemy of his choosing
         * Preferred Victory: Domination
         */
        spyPic = new JLabel("");
        spyPic.setIcon(new ImageIcon("./pictures/test3.png")); //references the picture
        cons3.gridx = 3;
        cons3.gridy = 2;
        cons3.weightx = 1;
        cons3.weighty = 1;
        cons3.fill = GridBagConstraints.NONE;
        cons3.anchor = GridBagConstraints.CENTER;
        cons3.insets = new Insets(20,0,0,0);
        charPanel.add(spyPic, cons3);
        spyPic.setBorder(picBorder);
        
        
        cons3 = new GridBagConstraints();
        cons3.gridx = 0;
        cons3.gridy = 0;
        cons3.weightx = 1;
        cons3.weighty = 1;
        
        cons3.fill = GridBagConstraints.BOTH; //how to make it take up the entire screen! 
        
        
        master.getContentPane().add(charPanel,cons3);
        
        
        master.pack();

    }
    
    public void hideCharScreen()
    {
        charPanel.setVisible(false);
    
    }
    
    public void showCharScreen()
    {
        charPanel.setVisible(true);
    
    }
    
    public void makeUpgradeScreen()
    {
        embezzleLvl = 0;
        upgradeLvl = 0;
        interactLvl = 0;
        fundraiseLvl = 0;
        activeLvl = 0;
        
        upgradePanel = new JPanel();
        cons = new GridBagConstraints();
        upgradePanel.setLayout(new GridBagLayout());
        backButton = new JButton("Back");
        backButton.setActionCommand("Back");
        backButton.addActionListener(this);
        cons.gridx = 0;
        cons.gridy = 0;
        cons.weightx =1;
        cons.weighty = 1;
        cons.fill = GridBagConstraints.NONE;

        upgradePanel.add(backButton, cons);
        
        upActive = new JButton("Leadership: lv 0");
        upActive.setActionCommand("upActive");
        upActive.addActionListener(this);
        cons.gridx = 0;
        cons.gridy = 1;
        cons.weightx =1;
        cons.weighty = 1;
        cons.fill = GridBagConstraints.NONE;
        cons.ipadx = 40;
        cons.ipady = 40;
        upgradePanel.add(upActive, cons);
        
        upInteract = new JButton("Public Relations: lv 0");
        upInteract.setActionCommand("upInteract");
        upInteract.addActionListener(this);
        cons.gridx = 2;
        cons.gridy = 1;
        cons.weightx =1;
        cons.weighty = 1;
        cons.fill = GridBagConstraints.NONE;
        cons.ipadx = 40;
        cons.ipady = 40;
        upgradePanel.add(upInteract, cons);
        
        upEmbezzle = new JButton("Espionage: lv 0");
        upEmbezzle.setActionCommand("upEmbezzle");
        upEmbezzle.addActionListener(this);
        cons.gridx = 3;
        cons.gridy = 1;
        cons.weightx =1;
        cons.weighty = 1;
        cons.fill = GridBagConstraints.NONE;
        cons.ipadx = 40;
        cons.ipady = 40;
        upgradePanel.add(upEmbezzle, cons);
        
        upFundraise = new JButton("Marketing: lv 0");
        upFundraise.setActionCommand("upFundraise");
        upFundraise.addActionListener(this);
        cons.gridx = 4;
        cons.gridy = 1;
        cons.weightx =1;
        cons.weighty = 1;
        cons.fill = GridBagConstraints.NONE;
        cons.ipadx = 40;
        cons.ipady = 40;
        upgradePanel.add(upFundraise, cons);
        
        upUpgrade = new JButton("Research and Development: lv 0");
        upUpgrade.setActionCommand("upUpgrade");
        upUpgrade.addActionListener(this);
        cons.gridx = 5;
        cons.gridy = 1;
        cons.weightx =1;
        cons.weighty = 1;
        cons.fill = GridBagConstraints.NONE;
        cons.ipadx = 40;
        cons.ipady = 40;
        upgradePanel.add(upUpgrade, cons);

        cons2 = new GridBagConstraints();
        cons2.gridx = 0;
        cons2.gridy = 0;
        cons2.weightx = 1;
        cons2.weighty = 1;
        
        cons2.fill = GridBagConstraints.BOTH; //how to make it take up the entire screen! 
        
        
        master.getContentPane().add(upgradePanel,cons2);
        
        
        master.pack();
        
        
    }
    
    public void hideUpgradeScreen()
    {
        upEmbezzle.setVisible(false);
        upUpgrade.setVisible(false);
        upInteract.setVisible(false);
        upFundraise.setVisible(false);
        upActive.setVisible(false);
        upgradePanel.setVisible(false);
    }
    
    public void showUpgradeScreen()
    {
        upEmbezzle.setVisible(true);
        upUpgrade.setVisible(true);
        upInteract.setVisible(true);
        upFundraise.setVisible(true);
        upActive.setVisible(true);
        upgradePanel.setVisible(true);
    }
    
    public void makeGameWinScreen()
    {
        gameWinPanel = new JPanel();
        tempWin = new JLabel(new ImageIcon("./pictures/winTitle.png"));
        cons.gridx = 0;
        cons.gridy=0;
        gameWinPanel.add(tempWin, cons);
        
        
        cons2 = new GridBagConstraints();
        cons2.gridx = 0;
        cons2.gridy = 0;
        cons2.weightx = 1;
        cons2.weighty = 1;
        
        cons2.fill = GridBagConstraints.BOTH; //how to make it take up the entire screen! 
        
        
        master.getContentPane().add(gameWinPanel,cons2);
        
        master.pack();
    }
    
    public void showGameWinScreen()
    {
        gameWinPanel.setVisible(true);
    }

    public void makeGameLoseScreen()
    {
        gameLosePanel = new JPanel();
        cons2 = new GridBagConstraints();
        cons2.gridx = 0;
        cons2.gridy = 0;
        cons2.weightx = 1;
        cons2.weighty = 1;
        
        tempLosePic = new JLabel("");
        tempLosePic.setIcon(new ImageIcon("./pictures/loseTitle.png"));
        gameLosePanel.add(tempLosePic, cons2);
        
        
        cons2.fill = GridBagConstraints.BOTH; //how to make it take up the entire screen! 
        master.getContentPane().add(gameLosePanel,cons2);
        
        master.pack();
    }
    
    public void showGameLoseScreen()
    {
        gameLosePanel.setVisible(true);
    }
    
    public void makeCardScreen()
    {
        cardPanel = new JPanel();
        cons = new GridBagConstraints();
        
        cardBackButton = new JButton("Back");
        cons.gridx = 0;
        cons.gridy = 0;
        cons.weightx = 1;
        cons.weighty = 1;
        cardBackButton.setActionCommand("cardBack");
        cardBackButton.addActionListener(this);
        cardPanel.add(cardBackButton, cons);

        cardPic = new JLabel("");
        cardPic.setIcon(new ImageIcon("./pictures/pic/cardImage.jpg")); //references the picture
        cons.gridx = 1;
        cons.gridy = 3;
        cons.weightx = 1;
        cons.weighty = 1;
        cardPanel.add(cardPic, cons);
        
        redrawButton = new JButton("ReDraw!");
        cons.gridx = 1;
        cons.gridy = 2;
        cons.weightx = 1;
        cons.weighty = 1;
        cardPanel.add(redrawButton, cons);
        
        
        
        cons2 = new GridBagConstraints();
        cons2.gridx = 0;
        cons2.gridy = 0;
        cons2.weightx = 1;
        cons2.weighty = 1;
        
        master.getContentPane().add(cardPanel, cons2);
        
        master.pack();
    }
    
    public void showCardScreen()
    {
        cardPanel.setVisible(true);
        cardPic.setVisible(true);
        cardBackButton.setVisible(true);
    }
    
    public void hideCardScreen()
    {
        cardPanel.setVisible(false);
        cardPic.setVisible(false);
        cardBackButton.setVisible(false);
    }
    
    public int promptUpgrade(){
        boolean upgradePick = false;
        int count = 0;
        while(!upgradePick){
            if (count == 100000)
            {
                System.out.println("in loop");
                count =0;
            }
            if(getLeadClick() == true)
            {
                setLeadClick(false);
                upgradePick = true;
                hideUpgradeScreen();
                showGameScreen();
                return 1;
            }
            if(getPrClick() == true)
            {
                setPrClick(false);
                upgradePick = true;
                hideUpgradeScreen();
                showGameScreen();
                return 2;
            }
            if(getEspClick() == true)
            {
                setEspClick(false);
                upgradePick = true;
                hideUpgradeScreen();
                showGameScreen();
                return 3;
            }
            if(getMarClick() == true)
            {
                setMarClick(false);
                upgradePick = true;
                hideUpgradeScreen();
                showGameScreen();
                return 4;
            }
            if(getRdClick() == true)
            {
                setRdClick(false);
                upgradePick = true;
                hideUpgradeScreen();
                showGameScreen();
                return 5;
            }
        }
        count++;
        return 0;      
    }
    
    public int promptAction()
    {
        boolean actionPick = false;
        int count = 0;
        while(!actionPick){
            if (count == 100000)
            {
                System.out.println("in loop");
                count =0;
            }
            if(getEmbezzleClick() == true)
            {
                setEmbezzleClick(false);
                actionPick = true;
                return 1;
            }
            if(getFundraiseClick() == true)
            {
                setFundraiseClick(false);
                actionPick = true;
                return 2;
            }
            if(getInteractClick() == true)
            {
                setInteractClick(false);
                actionPick = true;
                return 3;
            }
            if(getUpgradeClick() == true)
            {
                setUpgradeClick(false);
                actionPick = true;
                return 4;
            }
            if(getActiveClick() == true)
            {
                setActiveClick(false);
                actionPick = true;
                return 5;
            }
        }
        count++;
        return 0;        
    }  
    
    public void updateTurnBorder(int currentPlayer)
    {
        if(currentPlayer == 0)
        {
            imageLabel4.setBorder(picBorderYourTurn);
            imageLabel2.setBorder(picBorder);
            imageLabel3.setBorder(picBorder);
            imageLabel1.setBorder(picBorder);
        }
        else if(currentPlayer ==1)
        {
            imageLabel1.setBorder(picBorder);
            imageLabel2.setBorder(picBorderYourTurn);
            imageLabel3.setBorder(picBorder);
            imageLabel4.setBorder(picBorder);
        }
        else if(currentPlayer == 2)
        {
            imageLabel3.setBorder(picBorder);
            imageLabel2.setBorder(picBorder);
            imageLabel1.setBorder(picBorderYourTurn);
            imageLabel4.setBorder(picBorder);
        }
        else if(currentPlayer == 3)
        {
            imageLabel1.setBorder(picBorder);
            imageLabel2.setBorder(picBorder);
            imageLabel4.setBorder(picBorder);
            imageLabel3.setBorder(picBorderYourTurn);
        }
    }
    
    public void rePic(String charSelect)
    {
        if(charSelect.equals("Queen"))
        {
            imageLabel4.setIcon(new ImageIcon("./pictures/test4.png"));
        }
        else if(charSelect.equals("Father"))
        {
            imageLabel4.setIcon(new ImageIcon("./pictures/test2.png"));
            imageLabel2.setIcon(new ImageIcon("./pictures/test4.png"));
        }
        else if(charSelect.equals("Spy"))
        {
            imageLabel4.setIcon(new ImageIcon("./pictures/test3.png"));
            imageLabel3.setIcon(new ImageIcon("./pictures/test4.png"));
            raiseFundsAction.setVisible(false);
        }
        else if(charSelect.equals("Business"))
        {
            imageLabel4.setIcon(new ImageIcon("./pictures/test.png"));
            imageLabel1.setIcon(new ImageIcon("./pictures/test4.png"));
        }
    
    }
    
    public void checkActive()
    {
        if(activeCool ==0)
        {
            setActiveButton(true);
        }
        else
        {
            activeAction.setVisible(false);
            activeCool--;
        }
    }
    
    public void checkFundraise()
    {
        if(charSelected.equals("Spy"))
        {
            raiseFundsAction.setVisible(false);
        }
    }
    
    //getters;
    public JLabel getTurnLabel()
    {
        return turnCount;
    }
    
    public JLabel getRepCount()
    {
        return repCount;
    }
    
    public JLabel getMoneyCount()
    {
        return moneyCount;
    }
    
    public JTextArea getTextArea()
    {
        return displayWords;
    }
    
    public boolean getPlayClick()
    {
        return playClick;
    }
    
    public boolean getActiveClick()
    {
        return activeClick;
    }
    
    public boolean getInteractClick()
    {
        return interactClick;
    }
    
    public boolean getEmbezzleClick()
    {
        return embezzleClick;
    }
    
    public boolean getFundraiseClick()
    {
        return fundraiseClick;
    }
    
    public boolean getUpgradeClick()
    {
        return upgradeClick;
    }
    
    public boolean getLeadClick(){
        return leadClick;
    }
    
    public boolean getPrClick(){
        return prClick;
    }
    
    public boolean getEspClick(){
        return espClick;
    }
    
    public boolean getMarClick(){
        return marClick;
    }
    
    public boolean getRdClick(){
        return rdClick;
    }
    
    public String getCharSelect()
    {
        return charSelected;
    }
    
    public boolean getCharPicked()
    {
        return charPicked;
    }

    public int getEmbezzleLvl()
    {
        return embezzleLvl;
    }
    
    public int getUpgradeLvl()
    {
        return upgradeLvl;
    }
    
    public int getInteractLvl()
    {
        return interactLvl;
    }
    
    public int getFundraiseLvl()
    {
        return fundraiseLvl;
    }

    public int getActiveLvl()
    {
        return activeLvl;
    }
    
    public int getActiveCool()
    {
        return activeCool;
    }
    
    
    //setters
    public void setTurnCount(String words)
    {
        turnCount.setText(words);
    }
    
    public void setRepCount(String words)
    {
        repCount.setText(words);
    }
    
    public void setMoneyCount(String words)
    {
        moneyCount.setText(words);
    }
    
    public void setTextArea(String words)
    {
        displayWords.setText(words);
    }

    public void setActiveClick(boolean bol)
    {
        activeClick = bol;
    }
    
    public void setInteractClick(boolean bol)
    {
        interactClick = bol;
    }
    
    public void setEmbezzleClick(boolean bol)
    {
        embezzleClick = bol;
    }
    
    public void setFundraiseClick(boolean bol)
    {
        fundraiseClick = bol;
    }
    
    public void setUpgradeClick(boolean bol)
    {
        upgradeClick = bol;
    }
    
    public void setPlayClick(boolean bol)
    {
        playClick = bol;
    }
    
    public void setLeadClick(boolean bol)
    {
        leadClick = bol;
    }
    
    public void setPrClick(boolean bol)
    {
        prClick = bol;
    }
    
    public void setEspClick(boolean bol)
    {
        espClick = bol;
    }
    
    public void setMarClick(boolean bol)
    {
        marClick = bol;
    }
    
    public void setRdClick(boolean bol)
    {
        rdClick = bol;
    }
    
    public void setUpEmbezzle(String string)
    {
        upEmbezzle.setText(string);
    }
    
    public void setUpUpgrade(String string)
    {
        upUpgrade.setText(string);
    }

    public void setUpInteract(String string)
    {
        upInteract.setText(string);
    }
    
    public void setUpFundraise(String string)
    {
        upFundraise.setText(string);
    }
    
    public void setUpActive(String string)
    {
        upActive.setText(string);
    }
    
    public void setCardPic(int cardNum)
    {
        cardPic.setIcon(new ImageIcon("./pictures/pic/card" + cardNum + ".png"));
    }
    
    public void setActiveCool(int num)
    {
        activeCool = num;
    }
    
    public void setActiveButton(boolean bol)
    {
        activeAction.setVisible(bol);
    }
    
    public void hideAcctiveQ()
    {
        if(activeCool !=0)
        {
            activeAction.setVisible(false);
        }
    }
    

    
    public void actionPerformed(ActionEvent theEvent) 
    {
        PlaySound(click);
        
        if(theEvent.getActionCommand().equals("Play"))
        {
            hideTitleScreen();
            setPlayClick(true);
            //showGameScreen();
            showCharScreen();
            makeCardScreen();
            hideCardScreen();
        }
        
        if(theEvent.getActionCommand().equals("Embezzle"))
        {
            System.out.println("Embezzle");
            embezzleClick = true;
            
        }
        
        /*if(theEvent.getActionCommand().equals("Upgrade"))
        {
            System.out.println("Upgrade");
            upgradeClick = true;
            showUpgradeScreen();
            hideGameScreen();
        }*/
        
        if(theEvent.getActionCommand().equals("Interact"))
        {
            System.out.println("Interact");
            interactClick = true;
            if(!(charSelected.equals("Father")))
            {
                redrawButton.setVisible(false);
            }
            else
            {
                redrawButton.setVisible(true);
            }
            showCardScreen();
            hideGameScreen();
        }
        
        if(theEvent.getActionCommand().equals("Active"))
        {
            System.out.println("Active");
            activeCool = 5;
            setActiveButton(false);
            activeClick = true;
        }
        
        if(theEvent.getActionCommand().equals("Fundraise"))
        {
            if(!(charSelected.equals("Spy")))
            {
                System.out.println("Fundraise");
                fundraiseClick = true;
            }
        }
        
        if(theEvent.getActionCommand().equals("Back"))
        {
            hideUpgradeScreen();
            showGameScreen();
            checkFundraise();
            hideAcctiveQ();
        }
        
        if(theEvent.getActionCommand().equals("queenSelect"))
        {
            charSelected = "Queen";
            hideCharScreen();
            showGameScreen();
            charPicked = true;
        }
        
        if(theEvent.getActionCommand().equals("spySelect"))
        {
            charSelected = "Spy";
            hideCharScreen();
            showGameScreen();
            charPicked = true;
        }
        
        if(theEvent.getActionCommand().equals("fatherSelect"))
        {
            charSelected = "Father";
            hideCharScreen();
            showGameScreen();
            charPicked = true;
        }
        
        if(theEvent.getActionCommand().equals("businessSelect"))
        {
            charSelected = "Business";
            hideCharScreen();
            showGameScreen();
            charPicked = true;
        }
        
        if(theEvent.getActionCommand().equals("upEmbezzle"))
        {
            embezzleLvl++;
            upEmbezzle.setText("Espionage: lv "+ embezzleLvl);
            setEspClick(true);
            hideAcctiveQ();
        }
        
        if(theEvent.getActionCommand().equals("upActive"))
        {
            activeLvl++;
            upActive.setText("Leadership: lv "+ activeLvl);
            setLeadClick(true);
            hideAcctiveQ();
        }
        
        if(theEvent.getActionCommand().equals("upInteract"))
        {
            interactLvl++;
            upInteract.setText("Public Relations: lv "+ interactLvl);
            setPrClick(true);
            hideAcctiveQ();
        }
        
        if(theEvent.getActionCommand().equals("upFundraise"))
        {
            fundraiseLvl++;
            upFundraise.setText("Marketing: lv "+ fundraiseLvl);
            setMarClick(true);
            hideAcctiveQ();
        }
        
        if(theEvent.getActionCommand().equals("upUpgrade"))
        {
            upgradeLvl++;
            upUpgrade.setText("Research and Development: lv "+ upgradeLvl);
            setRdClick(true);
            hideAcctiveQ();
        }
        
        if(theEvent.getActionCommand().equals("cardBack"))
        {
            hideCardScreen();
            showGameScreen();
            checkFundraise();
            hideAcctiveQ();
        }

    }
    public void setLostChar(int number)
    {
        if (number == 1)
            imageLabel1.setIcon(new ImageIcon("./pictures/busX.png"));
        if (number == 2)
            imageLabel2.setIcon(new ImageIcon("./pictures/fatX.png"));
        if (number == 3)
            imageLabel3.setIcon(new ImageIcon("./pictures/spyX.png"));
        if (number == 4)
            imageLabel4.setIcon(new ImageIcon("./pictures/queenX.png"));
    }
    static void PlaySound(File Sound)
    {
        //ContinuousAudioDataStream loop = null;
        //AudioPlayer MGP = AudioPlayer.player;
        //AudioStream BGM;
        //AudioData MD;
        try{
               Clip clip = AudioSystem.getClip();
               clip.open(AudioSystem.getAudioInputStream(Sound));
               clip.start();
               //BGM = new AudioStream(new FileInputStream("OST.WAV"));
               //MD = BGM.getData();
               //loop = new ContinuousAudioDataStream(MD);
            }catch(Exception e)
            {}
        //MGP.start(loop);    
    }

}
 