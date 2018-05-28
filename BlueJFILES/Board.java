
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;
import javax.swing.BorderFactory; //need for borders
public class Board implements ActionListener { 
    private boolean gameScreenClicked = false; //not used currently
    private JFrame master; //the window
    
    //title screen
    private JPanel titleScreen;
    private JButton btnPlay;
    
    
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
    private JButton skillTreeAction;
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
    private boolean activeClick; 
    private boolean interactClick;
    private boolean embezzleClick;
    private boolean fundraiseClick;
    private boolean skillTreeClick;
    
    public Board() 
    {
        master = new JFrame("Dont Assume");          //  title of the window
        master.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        Toolkit theKit = master.getToolkit();//This gets the tool kit from the frame
        Dimension wndSize  = theKit.getScreenSize();//gets the screen size
        master.setPreferredSize(new Dimension(7*wndSize.width/10, 7*wndSize.height/10)); //half the screen, gotta change
        master.setLocation(wndSize.width/8, wndSize.height/8);
        master.getContentPane().setLayout(new GridBagLayout()); // Setting the pane in the master frame to use the GridBagLayout style
        activeClick = false;
        interactClick = false;
        embezzleClick = false;
        fundraiseClick = false;
        skillTreeClick = false;
        
        

        
        master.pack();//have these at the bottom, to pack everything together and show it
        master.setVisible(true);
        
        
    }
    
    public void makeGameScreen() //this makes it on contentPane
    {
        Font newFont = new Font("Serif", Font.PLAIN, 20); //makes a new font Object.setFont(Font);
        Font wordsFont = new Font("serif", Font.BOLD, 20); //these font are for the displays on the side, turn, money, rep
        Insets spacing = new Insets(20,20,20,20); //part of constraits, makes an inserts object to space out the boxes :  Insets(int top, int left, int bottom, int right)
        Insets buttonSpacing = new Insets(0,20,0,20);
        picBorder = BorderFactory.createLineBorder(Color.gray, 2); //creates a border object whth the color and pixel width
        
        cons = new GridBagConstraints();
        gameScreen = new JPanel();
        gameScreen.setLayout(new GridBagLayout());
        
        turnCount = new JLabel("gay"); //makes a new label, with the words on it
        cons.gridx = 0; // point 0,0 on the grid, which in on the top left corner
        cons.gridy = 0;
        cons.weightx = 1; //gives weights
        cons.weighty = 1;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.NONE; //it doesn't blow up to fill the sapce
        cons.anchor = GridBagConstraints.NORTHWEST; //makes it "stick" to the northwest corner of its space
        gameScreen.add(turnCount, cons);
        turnCount.setFont(wordsFont);
        
        moneyCount = new JLabel("Money: 100");
        cons.gridx = 4;
        cons.gridy = 4;
        cons.weightx = 1;
        cons.weighty = 1;
        moneyCount.setFont(wordsFont);
       
        cons.fill = GridBagConstraints.NONE;
        cons.anchor = GridBagConstraints.SOUTHEAST;
        gameScreen.add(moneyCount, cons);
        
        concedeBut = new JButton("Concede");
        cons.gridx = 4;
        cons.gridy = 0;
        cons.weightx = 1;
        cons.weighty = 1;
        cons.fill = GridBagConstraints.NONE;
        cons.anchor = GridBagConstraints.NORTHEAST;
        gameScreen.add(concedeBut, cons);
        
        repCount = new JLabel("Rep: 50");
        cons.gridx = 0;
        cons.gridy = 4;
        cons.weightx = 1;
        cons.weighty = 1;
        cons.fill = GridBagConstraints.NONE;
        cons.anchor = GridBagConstraints.SOUTHWEST;
        gameScreen.add(repCount, cons);
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
        gameScreen.add(imageLabel1, cons);
        imageLabel1.setBorder(picBorder);
        
        imageLabel2 = new JLabel("");
        imageLabel2.setIcon(new ImageIcon("./pictures/test2.png"));
        cons.gridx = 1;
        cons.gridy = 1;
        cons.weightx = 1;
        cons.weighty = 1;
        cons.fill = GridBagConstraints.NONE;
        cons.anchor = GridBagConstraints.CENTER;
        gameScreen.add(imageLabel2, cons);
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
        gameScreen.add(displayWords, cons); //It dont work, and I dont wanna do it rn, ill fix it later
        
        imageLabel3 = new JLabel("");
        imageLabel3.setIcon(new ImageIcon("./pictures/test3.png"));
        cons.gridx = 3;
        cons.gridy = 1;
        cons.weightx = 1;
        cons.weighty = 1;
        cons.fill = GridBagConstraints.NONE;
        cons.anchor = GridBagConstraints.CENTER;
        gameScreen.add(imageLabel3, cons);
        imageLabel3.setBorder(picBorder);
        
        imageLabel4 = new JLabel("");
        imageLabel4.setIcon(new ImageIcon("./pictures/test4.png"));
        cons.gridx = 2;
        cons.gridy = 2;
        cons.weightx = 1;
        cons.weighty = 1;
        cons.fill = GridBagConstraints.NONE;
        cons.anchor = GridBagConstraints.CENTER;
        gameScreen.add(imageLabel4, cons);
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
        gameScreen.add(embezzleAction, cons);
        
        
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
        gameScreen.add(raiseFundsAction, cons);
        
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
        gameScreen.add(interactAction, cons);
        
        skillTreeAction = new JButton("Skill Tree");
        skillTreeAction.setActionCommand("Skill Tree");
        skillTreeAction.addActionListener(this);
        cons.gridx = 4;
        cons.gridy = 3;
        cons.weightx = 1;
        cons.weighty = 1;
        cons.insets = buttonSpacing;
        cons.fill = GridBagConstraints.BOTH;
        cons.anchor = GridBagConstraints.CENTER;
        skillTreeAction.setPreferredSize(buttonSize);
        skillTreeAction.setFont(newFont);
        gameScreen.add(skillTreeAction, cons);
        
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
        gameScreen.add(activeAction, cons);
        
        cons2 = new GridBagConstraints();
        cons2.gridx = 0;
        cons2.gridy = 0;
        cons2.weightx = 1;
        cons2.weighty = 1;
        
        cons2.fill = GridBagConstraints.BOTH; //how to make it take up the entire screen! 
        
        
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
        skillTreeAction.setVisible(false);
        activeAction.setVisible(false);
    }
    
    public void showGameScreen()
    {
        gameScreen.setVisible(true);
        embezzleAction.setVisible(true);
        raiseFundsAction.setVisible(true);
        interactAction.setVisible(true);
        skillTreeAction.setVisible(true);
        activeAction.setVisible(true);
    }
    
    public void makeTitleScreen()
    {       
       Font newFont = new Font("Serif", Font.PLAIN, 20);
       titleScreen = new JPanel();
       btnPlay = new JButton("Play");
       GridBagLayout gridBagLayout = new GridBagLayout();
       gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
       gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
       gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
       gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
       titleScreen.setLayout(gridBagLayout);
       GridBagConstraints gbc_btnPlay = new GridBagConstraints();
       gbc_btnPlay.gridx = 0;
       gbc_btnPlay.gridy = 0;
       gbc_btnPlay.fill = GridBagConstraints.NONE;
       btnPlay.setActionCommand("Play");
       btnPlay.addActionListener(this);
       btnPlay.setFont(newFont);
       titleScreen.add(btnPlay, gbc_btnPlay);
       GridBagConstraints gbc_panelTitleScreen = new GridBagConstraints();
       gbc_panelTitleScreen.gridheight = 8;
       gbc_panelTitleScreen.gridwidth = 8;
       gbc_panelTitleScreen.insets = new Insets(0, 0, 5, 5);
       gbc_panelTitleScreen.fill = GridBagConstraints.BOTH;
       gbc_panelTitleScreen.gridx = 0;
       gbc_panelTitleScreen.gridy = 0;
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
        panelChampSelect = new JPanel();
        GridBagConstraints gbc_panelChampSelect = new GridBagConstraints();
        gbc_panelChampSelect.gridheight = 8;
        gbc_panelChampSelect.gridwidth = 8;
        gbc_panelChampSelect.insets = new Insets(0, 0, 5, 5);
        gbc_panelChampSelect.fill = GridBagConstraints.BOTH;
        gbc_panelChampSelect.gridx = 0;
        gbc_panelChampSelect.gridy = 0;
        master.getContentPane().add(panelChampSelect, gbc_panelChampSelect);
        GridBagConstraints gbc_btnPlay = new GridBagConstraints();
        gbc_btnPlay.gridx = 6;
        gbc_btnPlay.gridy = 7;
        master.getContentPane().add(btnPlay, gbc_btnPlay);
        panelChampSelect.setVisible(false);
    }
    
    public void hideCharScreen()
    {
        panelChampSelect.setVisible(false);
    
    }
    
    public void showCharScreen()
    {
        panelChampSelect.setVisible(true);
    
    }
 
    public int promptAction()
    {
        return 1; 
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
    
    public boolean getSkillTreeClick()
    {
        return skillTreeClick;
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
    
    public void setSkillTreeClick(boolean bol)
    {
        skillTreeClick = bol;
    }
    
    
    
    public void actionPerformed(ActionEvent theEvent) 
    {
        if(theEvent.getActionCommand().equals("Play"))
        {
            hideTitleScreen();
            showGameScreen();
        }
        if(theEvent.getActionCommand().equals("Embezzle"))
        {
            System.out.println("Embezzle");
            embezzleClick = true;
            
        }
        if(theEvent.getActionCommand().equals("Skill Tree"))
        {
            System.out.println("Skill Tree");
            skillTreeClick = true;
        }
        if(theEvent.getActionCommand().equals("Interact"))
        {
            System.out.println("Interact");
            interactClick = true;
        }
        if(theEvent.getActionCommand().equals("Active"))
        {
            System.out.println("Active");
            activeClick = true;
        }
        if(theEvent.getActionCommand().equals("Fundraise"))
        {
            System.out.println("Fundraise");
            fundraiseClick = true;
        }
    }


}
