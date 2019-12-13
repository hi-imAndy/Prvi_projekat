package glavni_prozor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
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
	add(toolbar, BorderLayout.NORTH);
	
	}

}
