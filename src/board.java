import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class board implements ActionListener { 
	//This is just gonna make the game screen for right now
	private JFrame master; //the window
	private JTextField turnCount;
	private JTextField repCount;
	private JTextField moneyCount;
	private JButton embezzleAction;
	private JButton raiseFundsAction;
	private JButton interactAction;
	private JButton skillTreeAction;
	private JButton activeAction;
	private JButton toggleAction;
	private Image testImage;
	
	public board() 
	{
        master = new JFrame("Dont Assume");          //  title of the window
        master.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        Toolkit theKit = master.getToolkit();//This gets the tool kit from the frame
        Dimension wndSize  = theKit.getScreenSize();//gets the screen size
        master.setPreferredSize(new Dimension(wndSize.width/2, wndSize.height/2)); //half the screen
        master.getContentPane().setLayout(new GridBagLayout()); // Setting the pane in the master frame to use the GridBagLayout style
        GridBagConstraints cons = new GridBagConstraints();
        Font newFont = new Font("Serif", Font.PLAIN, 20); //makes a new font
        Insets spacing = new Insets(20,20,20,20); //part of constraits, makes an inserts object to space out the boxes
        
        
        
        
        
        master.pack();//have these at the bottom, to pack everything together and show it
        master.setVisible(true);
        
		
	}
	
	

}
