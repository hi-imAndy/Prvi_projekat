package glavni_prozor;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import predmeti.Tabela_predmeta;
import profesori.Tabela_profesora;

public class Glavni_prozor extends JFrame{
	
	public static Tabela_predmeta tabela_predmeta;
	public static Tabela_profesora tabela_profesora;

	public Glavni_prozor() {
		
	Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension screenSize = kit.getScreenSize();
    setTitle("Studentska slu�ba");
    setSize(screenSize.width * 3 / 4, screenSize.height * 3 / 4);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);  // centriranje
    getContentPane().setBackground(Color.WHITE);
    
    MojToolbar toolbar = new MojToolbar();
    Izbor_Toolbar izbor_toolbar = new Izbor_Toolbar();
	menu_bar menu_bar1 = new menu_bar();
	JPanel MyPanel1 = new JPanel();
	 
	 MyPanel1.setLayout( new BorderLayout() );
	 MyPanel1.add(menu_bar1,BorderLayout.NORTH);

	MyPanel1.setLayout( new BorderLayout() );

	//Status_BAR//
	Status_bar status_bar = new Status_bar();
	add(status_bar,BorderLayout.SOUTH);
	//Status_BAR//
  	 MyPanel1.add(menu_bar1,BorderLayout.NORTH);
  	 MyPanel1.add(toolbar,BorderLayout.SOUTH);
  	 
  	 JPanel MyPanel2 = new JPanel();
  	 
  	 tabela_predmeta = new Tabela_predmeta();
  	 tabela_predmeta.setVisible(false);
	 tabela_profesora = new Tabela_profesora();
	 tabela_profesora.setVisible(false);
	 
	 GridBagConstraints gbc = new GridBagConstraints();
	 gbc.gridx = 0;
	 gbc.gridy = 0;
	 
	 MyPanel2.add(izbor_toolbar);
	 MyPanel2.add(tabela_profesora, gbc);
	 MyPanel2.add(tabela_predmeta, gbc);
	 MyPanel2.setLayout(new FlowLayout(-screenSize.width * 3 / 4,1,1));//u odnosu na centar, izmedju njih, od gore
  	
  	 getContentPane().add( MyPanel1,BorderLayout.NORTH);
  	 
  	 add(MyPanel2);
  	 
	}

}
