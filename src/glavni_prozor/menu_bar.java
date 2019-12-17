package glavni_prozor;


import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

/*
 * klasa nasleđuje JMenuBar i predstavlja kontejner
 * za komponente JMenu. Instanca ove klase će se 
 * smeštati u glavni prozor aplikacije
 * 
 */
public class menu_bar extends JMenuBar {



	public menu_bar() {

		JMenu file = new JMenu("File");
		JMenu edit = new JMenu("Edit");
		JMenu help = new JMenu("Help");
		
		JMenuItem miFileN = new JMenuItem("New");
		JMenuItem miFileC = new JMenuItem("Close");
		
		file.add(miFileN);
		file.addSeparator();
		file.add(miFileC);

		JMenuItem miEditE = new JMenuItem("Edit");
		JMenuItem miEditD = new JMenuItem("Delete");


		edit.add(miEditE);
		edit.addSeparator();
		edit.add(miEditD);
		
		JMenuItem miHelpH = new JMenuItem("Help");
		JMenuItem miHelpA = new JMenuItem("About");
		
		help.add(miHelpH);
		help.addSeparator();
		help.add(miHelpA);
		


		add(file);
		add(edit);
		add(help);

	}

}