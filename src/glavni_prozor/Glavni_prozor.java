package glavni_prozor;

import java.awt.BorderLayout;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import predmeti.BazaPredmeta;
import predmeti.ModelPredmeta;
import predmeti.Tabela_predmeta;
import profesori.BazaProfesora;
import profesori.ModelProfesora;
import profesori.Tabela_profesora;

import studenti.AbstractTableModelStudenti;
import studenti.BazaStudenata;
import studenti.StudentiJTable;


public class Glavni_prozor extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3259399103057356878L;
	private static Glavni_prozor instance = null;
	
	public static Glavni_prozor getInstance() {
		if (instance == null) {
			instance = new Glavni_prozor();
		}
		return instance;
	}
	
	public static Tabela_predmeta tabela_predmeta;
	public static Tabela_profesora tabela_profesora;
	public static StudentiJTable tabela_studenata;

	public Glavni_prozor() {
		
	Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension screenSize = kit.getScreenSize();
    setTitle("Studentska služba");
    setSize(screenSize.width * 3 / 4, screenSize.height * 3 / 4);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);  // centriranje
    getContentPane().setBackground(Color.WHITE);
    
    MojToolbar toolbar = new MojToolbar(this);
	menu_bar menu_bar1 = new menu_bar(this);
	JPanel MyPanel1 = new JPanel();
	 
	 MyPanel1.setLayout( new BorderLayout() );
	 MyPanel1.add(menu_bar1,BorderLayout.NORTH);

	MyPanel1.setLayout( new BorderLayout() );

	Status_bar status_bar = new Status_bar();
	add(status_bar,BorderLayout.SOUTH);

  	 MyPanel1.add(menu_bar1,BorderLayout.NORTH);
  	 MyPanel1.add(toolbar,BorderLayout.SOUTH);
  	 getContentPane().add( MyPanel1,BorderLayout.NORTH);
  	 
  	 
 	 Tab tab=new Tab(); 
	 add(tab,BorderLayout.CENTER);
 	
     this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				//BazaStudenata.getInstance().setStudenti(ToolBar.getInstance().ps.getOriginalna_lista());
				BazaStudenata.getInstance().sacuvajStudente();
				BazaPredmeta.getInstance().sacuvajPredmete();
				BazaProfesora.getInstance().sacuvajProfesore();
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
}
