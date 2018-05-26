
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Board implements ActionListener { 
    //This is just going to make the game screen for right now
    private JFrame master; //the window
    
    //title screen
    private JPanel titleScreen;
    private JButton btnPlay;
    
    
    //ChampSelect Variables
    private JPanel panelChampSelect;
    private JButton lockInButton;
    
    
    //GameBoard Variables
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
    
    public Board() 
    {
        master = new JFrame("Dont Assume");          //  title of the window
        master.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        Toolkit theKit = master.getToolkit();//This gets the tool kit from the frame
        Dimension wndSize  = theKit.getScreenSize();//gets the screen size
        master.setPreferredSize(new Dimension(3*wndSize.width/5, 3*wndSize.height/5)); //half the screen, gotta change
        master.setLocation(wndSize.width/8, wndSize.height/8);
        master.getContentPane().setLayout(new GridBagLayout()); // Setting the pane in the master frame to use the GridBagLayout style

        
        master.pack();//have these at the bottom, to pack everything together and show it
        master.setVisible(true);
        
        
    }
    
    public void makeGameScreen() //this makes it on contentPane
    {
        Font newFont = new Font("Serif", Font.PLAIN, 20); //makes a new font Object.setFont(Font);
        Insets spacing = new Insets(20,20,20,20); //part of constraits, makes an inserts object to space out the boxes :  Insets(int top, int left, int bottom, int right)
        Insets buttonSpacing = new Insets(0,20,0,20);GridBagConstraints cons = new GridBagConstraints();
        JLabel turnCount = new JLabel("This is the turn count"); //makes a new label, with the words on it
        cons.gridx = 0; // point 0,0 on the grid, which in on the top left corner
        cons.gridy = 0;
        cons.weightx = 1; //gives weights
        cons.weighty = 1;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.NONE; //it doesn't blow up to fill the sapce
        cons.anchor = GridBagConstraints.NORTHWEST; //makes it "stick" to the northwest corner of its space
        master.getContentPane().add(turnCount, cons);
        
        JLabel moneyCount = new JLabel("This is the money count");
        cons.gridx = 4;
        cons.gridy = 4;
        cons.weightx = 1;
        cons.weighty = 1;
       
        cons.fill = GridBagConstraints.NONE;
        cons.anchor = GridBagConstraints.SOUTHEAST;
        master.getContentPane().add(moneyCount, cons);
        
        JButton  concedeBut = new JButton("Concede");
        cons.gridx = 4;
        cons.gridy = 0;
        cons.weightx = 1;
        cons.weighty = 1;
        cons.fill = GridBagConstraints.NONE;
        cons.anchor = GridBagConstraints.NORTHEAST;
        master.getContentPane().add(concedeBut, cons);
        
        JLabel repCount = new JLabel("This is the rep count");
        cons.gridx = 0;
        cons.gridy = 4;
        cons.weightx = 1;
        cons.weighty = 1;
        cons.fill = GridBagConstraints.NONE;
        cons.anchor = GridBagConstraints.SOUTHWEST;
        master.getContentPane().add(repCount, cons);
        
        imageLabel1= new JLabel("");//makes it blank
        imageLabel1.setIcon(new ImageIcon("./pictures/test.jpg")); //references the picture
        cons.gridx = 2;
        cons.gridy = 0;
        cons.weightx = 1;
        cons.weighty = 1;
        cons.fill = GridBagConstraints.NONE;
        cons.anchor = GridBagConstraints.CENTER;
        cons.insets = new Insets(20,0,0,0);
        master.getContentPane().add(imageLabel1, cons);
        
        imageLabel2 = new JLabel("");
        imageLabel2.setIcon(new ImageIcon("./pictures/test2.png"));
        cons.gridx = 1;
        cons.gridy = 1;
        cons.weightx = 1;
        cons.weighty = 1;
        cons.fill = GridBagConstraints.NONE;
        cons.anchor = GridBagConstraints.CENTER;
        master.getContentPane().add(imageLabel2, cons);
        
        displayWords = new JTextArea("Gaynald is gay \n next line"); //to combat issue, we print things using ln, have a array of past actions that will get printed and added
        //that way, I dont need to bother with this anymore, we can set the fint and stuff as well.
        //WE have an array os strings(statments), that this will print to the sdcreen using ln and for each loop. we when update that array for new statements, it will cycle
        display = new JScrollPane(displayWords);// think i am scraping this
        displayWords.setFont(displayWords.getFont().deriveFont(18f)); 
        cons.gridx = 2;
        cons.gridy =1;
        cons.weightx = 1;
        cons.weighty = 1;
        cons.fill = GridBagConstraints.NONE;
        cons.anchor = GridBagConstraints.CENTER;
        displayWords.setEditable(false); //cant edit it
        displayWords.setLineWrap(true); // so it will wrap around when it gets too big
        displayWords.setColumns(28);
        //displayWords.setRows(20);
        master.getContentPane().add(displayWords, cons); //It dont work, and I dont wanna do it rn, ill fix it later
        
        imageLabel3 = new JLabel("");
        imageLabel3.setIcon(new ImageIcon("./pictures/test3.png"));
        cons.gridx = 3;
        cons.gridy = 1;
        cons.weightx = 1;
        cons.weighty = 1;
        cons.fill = GridBagConstraints.NONE;
        cons.anchor = GridBagConstraints.CENTER;
        master.getContentPane().add(imageLabel3, cons);
        
        imageLabel4 = new JLabel("");
        imageLabel4.setIcon(new ImageIcon("./pictures/test4.png"));
        cons.gridx = 2;
        cons.gridy = 2;
        cons.weightx = 1;
        cons.weighty = 1;
        cons.fill = GridBagConstraints.NONE;
        cons.anchor = GridBagConstraints.CENTER;
        master.getContentPane().add(imageLabel4, cons);
        
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
        master.getContentPane().add(embezzleAction, cons);
        
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
        master.getContentPane().add(raiseFundsAction, cons);
        
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
        master.getContentPane().add(interactAction, cons);
        
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
        master.getContentPane().add(skillTreeAction, cons);
        
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
        master.getContentPane().add(activeAction, cons);
        
        master.pack();
    
    }
    
    public void hideGameScreen()
    {
        master.getContentPane().setVisible(false);
        embezzleAction.setVisible(false);
        raiseFundsAction.setVisible(false);
        interactAction.setVisible(false);
        skillTreeAction.setVisible(false);
        activeAction.setVisible(false);
    }
    
    public void showGameScreen()
    {
        master.getContentPane().setVisible(true);
        embezzleAction.setVisible(true);
        raiseFundsAction.setVisible(true);
        interactAction.setVisible(true);
        skillTreeAction.setVisible(true);
        activeAction.setVisible(true);
    }
    
    public void makeTitleScreen()
    {       
        /*btnPlay = new JButton("Play");
        titleScreen = new JPanel();
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        titleScreen.setLayout(gridBagLayout);
        GridBagConstraints gbc_panelTitleScreen = new GridBagConstraints();
        gbc_panelTitleScreen.gridheight = 8;
        gbc_panelTitleScreen.gridwidth = 8;
        gbc_panelTitleScreen.insets = new Insets(0, 0, 5, 5);
        gbc_panelTitleScreen.fill = GridBagConstraints.BOTH;
        gbc_panelTitleScreen.gridx = 0;
        gbc_panelTitleScreen.gridy = 0;
        GridBagConstraints gbc_btnPlay = new GridBagConstraints();
        gbc_btnPlay.gridx = 6;
        gbc_btnPlay.gridy = 7;
        titleScreen.setLayout(new GridBagLayout());
        gbc_btnPlay = new GridBagConstraints();
        titleScreen.add(btnPlay, gbc_btnPlay);
        master.getContentPane().add(titleScreen, gbc_panelTitleScreen);
        titleScreen.setVisible(true);
        */
            /*GridBagConstraints gbc_panelTitleScreen = new GridBagConstraints();
        gbc_panelTitleScreen.gridheight = 8;
        gbc_panelTitleScreen.gridwidth = 8;
        gbc_panelTitleScreen.insets = new Insets(0, 0, 5, 5);
        gbc_panelTitleScreen.fill = GridBagConstraints.BOTH;
        gbc_panelTitleScreen.gridx = 0;
        gbc_panelTitleScreen.gridy = 0;
            titleScreen = new JPanel();
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        titleScreen.setLayout(gridBagLayout);
        btnPlay = new JButton("Play");
        GridBagConstraints gbc_btnPlay = new GridBagConstraints();
        gbc_btnPlay.gridx = 6;
        gbc_btnPlay.gridy = 7;
        titleScreen.add(btnPlay, gbc_btnPlay);
        master.getContentPane().add(titleScreen,  gbc_panelTitleScreen);
        titleScreen.setVisible(true);
        */
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
       
        /*lockInButton = new JButton("Lock in Champion");
        panelChampSelect = new JPanel();
        GridBagConstrtitleScreen.setVisible(true);   aints gbc_panelChampSelect = new GridBagConstraints();
        gbc_panelChampSelect.gridheight = 8;
        gbc_panelChampSelect.gridwidth = 8;
        gbc_panelChampSelect.insets = new Insets(0, 0, 5, 5);
        gbc_panelChampSelect.fill = GridBagConstraints.BOTH;
        gbc_panelChampSelect.gridx = 0;
        gbc_panelChampSelect.gridy = 0;
        panelChampSelect.setLayout(new GridBagLayout());
        master.getContentPane().add(panelChampSelect,gbc_panelChampSelect);
        panelChampSelect.setVisible(false);
        */

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
    
    public void updateBoard()
    {
    
    }
    

    public int promptAction()
    {
        return 1; 
    }
    public void actionPerformed(ActionEvent theEvent) 
    {
        if(theEvent.getActionCommand().equals("Play"))
        {
            makeGameScreen();
            hideTitleScreen();
            showGameScreen();
            updateBoard();
        }
        if(theEvent.getActionCommand().equals("Embezzle"))
        {
            System.out.println("Embezzle");
        }
        if(theEvent.getActionCommand().equals("Skill Tree"))
        {
            System.out.println("Skill Tree");
        }
        if(theEvent.getActionCommand().equals("Interact"))
        {
            System.out.println("Interact");
        }
        if(theEvent.getActionCommand().equals("Active"))
        {
            System.out.println("Active");
        }
        if(theEvent.getActionCommand().equals("Fundraise"))
        {
            System.out.println("Fundraise");
        }
    }


}
