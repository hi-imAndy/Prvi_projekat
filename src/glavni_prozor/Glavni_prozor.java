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
import studenti.AbstractTableModelStudenti;
import studenti.StudentiJTable;
import studenti.Tabela_studenata;

public class Glavni_prozor extends JFrame{
	
	private static Glavni_prozor instance = null;
	
	public static Glavni_prozor getInstance() {
		if (instance == null) {
			instance = new Glavni_prozor();
		}
		return instance;
	}
	
	public static Tabela_predmeta tabela_predmeta;
	public static Tabela_profesora tabela_profesora;
	public static Tabela_studenata tabela_studenata;

	public Glavni_prozor() {
		
	Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension screenSize = kit.getScreenSize();
    setTitle("Studentska služba");
    setSize(screenSize.width * 3 / 4, screenSize.height * 3 / 4);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);  // centriranje
    getContentPane().setBackground(Color.WHITE);
    
    MojToolbar toolbar = new MojToolbar(null);
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
	 tabela_studenata = new Tabela_studenata();
	 tabela_studenata.setVisible(false);
	 
	 GridBagConstraints gbc = new GridBagConstraints();
	 gbc.gridx = 0;
	 gbc.gridy = 0;
	 
	 MyPanel2.add(izbor_toolbar);
	 MyPanel2.add(tabela_profesora, gbc);
	 MyPanel2.add(tabela_predmeta, gbc);
	 MyPanel2.add(tabela_studenata,gbc);
	 MyPanel2.setLayout(new FlowLayout(-screenSize.width * 3 / 4,1,1));//u odnosu na centar, izmedju njih, od gore
  	
  	 getContentPane().add( MyPanel1,BorderLayout.NORTH);
  	 
  	 add(MyPanel2);
  	 
  	 
  	 
  	 
	}

	
	public void azurirajPrikaz() {
		AbstractTableModelStudenti model = (AbstractTableModelStudenti) StudentiJTable.getInstance().getModel();
		model.fireTableDataChanged();
		validate();
		setVisible(true);
	}

	
}
