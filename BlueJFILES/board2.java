import java.awt.*;


import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class board2 {

    private JFrame frame;



    /**
     * Create the application.
     */
    public board2() {
        frame = new JFrame();
        Toolkit theKit = frame.getToolkit();
        Dimension wndSize = theKit.getScreenSize();
        frame.setPreferredSize(new Dimension(3*wndSize.width/5, 3*wndSize.height/5)); //half the screen, gotta change
        frame.setLocation(wndSize.width/8, wndSize.height/8);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        frame.getContentPane().setLayout(gridBagLayout);
        
        JButton btnNewButton = new JButton("Play");
        //btnNewButton.addActionListener(this); 
           
                
            
        
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
        gbc_btnNewButton.gridx = 6;
        gbc_btnNewButton.gridy = 7;
        frame.getContentPane().add(btnNewButton, gbc_btnNewButton);
        
        frame.pack();//have these at the bottom, to pack everything together and show it
        frame.setVisible(true);
        
        
        
        }
    public void actionPerformed(ActionEvent theEvent) {
        
        if(theEvent.getActionCommand().equals("Play"))
        {
        
        }
            
    }  
    
    public static Container getContentPane()
    {
        return board2.getContentPane();
    }
    


}
