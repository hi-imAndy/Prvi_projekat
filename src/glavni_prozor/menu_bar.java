package glavni_prozor;


import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

/*
 * klasa nasleđuje JMenuBar i predstavlja kontejner
 * za komponente JMenu. Instanca ove klase će se 
 * smeštati u glavni prozor aplikacije
 * 
 */
public class menu_bar extends JMenuBar {



	public menu_bar() {

		
		//dugmici
		
		JMenu file = new JMenu("File");
		JMenuItem miNew = new JMenuItem("New");
		JMenuItem miClose = new JMenuItem("Close");
		file.add(miNew);
		file.addSeparator();
		file.add(miClose);
		
		JMenu edit=new JMenu("Edit");
		JMenuItem edit1=new JMenuItem("Edit");
		JMenuItem delete=new JMenuItem("Delete");
		edit.add(edit1);
		edit.addSeparator();
		edit.add(delete);
		
		JMenu help=new JMenu("Help");
		JMenuItem help1=new JMenuItem("Help");
		JMenuItem about=new JMenuItem("About");
		help.add(help1);
		help.add(about);
		
		
		add(file);
		add(edit);
		add(help);
		

		//mnemonici i precice
		
		file.setMnemonic(KeyEvent.VK_F);
		
		
		
		miNew.setMnemonic(KeyEvent.VK_N);
		miNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
		
		miClose.setMnemonic(KeyEvent.VK_C);
		miClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
		
		edit.setMnemonic(KeyEvent.VK_E);
		
		edit1.setMnemonic(KeyEvent.VK_E);
		edit1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
		
		delete.setMnemonic(KeyEvent.VK_D);
		delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
		
		help.setMnemonic(KeyEvent.VK_H);
		
		help1.setMnemonic(KeyEvent.VK_H);
		help1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,ActionEvent.CTRL_MASK));
		
		about.setMnemonic(KeyEvent.VK_A);
		about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
		
		//ikonice

	}

}