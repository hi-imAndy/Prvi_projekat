package glavni_prozor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class Glavni_prozor extends JFrame{

	public Glavni_prozor() {
		
	Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension screenSize = kit.getScreenSize();
    
    setTitle("Studentska služba");
    setSize(screenSize.width * 3 / 4, screenSize.height * 3 / 4);
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    setLocationRelativeTo(null);  // centriranje
    
    getContentPane().setBackground(Color.WHITE);
    
    MojToolbar toolbar = new MojToolbar();
	//add(toolbar, BorderLayout.NORTH);
	
	menu_bar menu_bar1 = new menu_bar();
	//add(menu_bar1,NORTH);
	
	JPanel MyPanel1 = new JPanel();
	 
	MyPanel1.setLayout( new BorderLayout() );

	//Status_BAR//
	Status_bar status_bar = new Status_bar();
	add(status_bar,BorderLayout.SOUTH);
	//Status_BAR//
  	 MyPanel1.add(menu_bar1,BorderLayout.NORTH);
  	 MyPanel1.add(toolbar,BorderLayout.SOUTH);
   
  	 getContentPane().add( MyPanel1,BorderLayout.NORTH);   // Add MyPanel1 to North

	}

}
