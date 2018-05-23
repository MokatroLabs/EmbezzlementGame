import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class board implements ActionListener { 
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
	private JLabel imageLabel;
	
	public board() 
	{
        master = new JFrame("Dont Assume");          //  title of the window
        master.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        Toolkit theKit = master.getToolkit();//This gets the tool kit from the frame
        Dimension wndSize  = theKit.getScreenSize();//gets the screen size
        master.setPreferredSize(new Dimension(wndSize.width/2, wndSize.height/2)); //half the screen
        master.setLocation(wndSize.width/8, wndSize.height/8);
        master.getContentPane().setLayout(new GridBagLayout()); // Setting the pane in the master frame to use the GridBagLayout style
        GridBagConstraints cons = new GridBagConstraints();
        Font newFont = new Font("Serif", Font.PLAIN, 20); //makes a new font
        Insets spacing = new Insets(20,20,20,20); //part of constraits, makes an inserts object to space out the boxes
        
        JLabel turnCount = new JLabel("This is the turn count"); //makes a new label, with the words on it
        cons.gridx = 0; // point 0,0 on the grid, which in on the top left corner
        cons.gridy = 0;
        cons.weightx = 1; //gives weights
        cons.weighty = 1;
        cons.fill = GridBagConstraints.NONE; //it doesn't blow up to fill the sapce
        cons.anchor = GridBagConstraints.NORTHWEST; //makes it "stick" to the northwest corner of its space
        master.getContentPane().add(turnCount, cons);
        
        JLabel moneyCount = new JLabel("This is the money count");
        cons.gridx = 2;
        cons.gridy = 5;
        cons.weightx = 1;
        cons.weighty = 1;
        cons.fill = GridBagConstraints.NONE;
        cons.anchor = GridBagConstraints.SOUTHEAST;
        master.getContentPane().add(moneyCount, cons);
        
        JButton  concedeBut = new JButton("Concede");
        cons.gridx = 2;
        cons.gridy = 0;
        cons.weightx = 1;
        cons.weighty = 1;
        cons.fill = GridBagConstraints.NONE;
        cons.anchor = GridBagConstraints.NORTHEAST;
        master.getContentPane().add(concedeBut, cons);
        
        JLabel repCount = new JLabel("This is the rep count");
        cons.gridx = 0;
        cons.gridy = 5;
        cons.weightx = 1;
        cons.weighty = 1;
        cons.fill = GridBagConstraints.NONE;
        cons.anchor = GridBagConstraints.SOUTHWEST;
        master.getContentPane().add(repCount, cons);
        
        imageLabel= new JLabel("");//makes it blank
        imageLabel.setIcon(new ImageIcon("./pictures/test.jpg")); //references the picture
        cons.gridx = 1;
        cons.gridy = 1;
        cons.weightx = 1;
        cons.weighty = 1;
        cons.fill = GridBagConstraints.NONE;
        cons.anchor = GridBagConstraints.CENTER;
        master.getContentPane().add(imageLabel, cons);
        
        
        
        
        
        
        
        
        
        
        
        master.pack();//have these at the bottom, to pack everything together and show it
        master.setVisible(true);
        
		
	}

	public void actionPerformed(ActionEvent theEvent) {
		
		
	}
	
	

}
