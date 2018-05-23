import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Board implements ActionListener { 
    //This is just going to make the game screen for right now
    private JFrame master; //the window
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
        GridBagConstraints cons = new GridBagConstraints();
        Font newFont = new Font("Serif", Font.PLAIN, 20); //makes a new font Object.setFont(Font);
        Insets spacing = new Insets(20,20,20,20); //part of constraits, makes an inserts object to space out the boxes :  Insets(int top, int left, int bottom, int right)
        Insets buttonSpacing = new Insets(0,20,0,20);
        
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
        
        displayWords = new JTextArea(124,230); //made it smaller than intended , 20 by 20
        display = new JScrollPane(displayWords);
        cons.gridx = 2;
        cons.gridy =1;
        cons.weightx = 1;
        cons.weighty = 1;
        cons.fill = GridBagConstraints.NONE;
        cons.anchor = GridBagConstraints.CENTER;
        master.getContentPane().add(display, cons); //It dont work, and I dont wanna do it rn, ill fix it later
        
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
        master.getContentPane().add(skillTreeAction, cons);
        
        activeAction = new JButton("Active");
        skillTreeAction.setActionCommand("Active");
        skillTreeAction.addActionListener(this);
        cons.gridx = 0;
        cons.gridy = 3;
        cons.weightx = 1;
        cons.weighty = 1;
        cons.insets = buttonSpacing;
        cons.fill = GridBagConstraints.BOTH;
        cons.anchor = GridBagConstraints.CENTER;
        activeAction.setPreferredSize(buttonSize);
        master.getContentPane().add(activeAction, cons);
        
        
       
        
        
        
        
        
        
        
        
        
        master.pack();//have these at the bottom, to pack everything together and show it
        master.setVisible(true);
        
        
    }

    public void actionPerformed(ActionEvent theEvent) {
        
        
    }
    
    

}
