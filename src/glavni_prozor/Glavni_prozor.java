package glavni_prozor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Glavni_prozor extends JFrame{

	public Glavni_prozor() {
		
	Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension screenSize = kit.getScreenSize();
    
    setTitle("Studentska služba");
    setSize(screenSize.width * 3 / 4, screenSize.height * 3 / 4);
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    setLocationRelativeTo(null);  // centriranje
    
    getContentPane().setBackground(Color.WHITE);
	
	}

}
