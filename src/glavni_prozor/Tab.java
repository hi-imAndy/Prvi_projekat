package glavni_prozor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import predmeti.Tabela_predmeta;
import profesori.Tabela_profesora;
import studenti.PredmetiKodStudenta;
import studenti.StudentiJTable;



public class Tab extends JTabbedPane{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 

	private static int selectedIndex1=0;
	
	public static int getSelectedIndex1() {
		return selectedIndex1;
	}
private static Tab instance=null;
	
	public static Tab getInstance() {
		if (instance == null) { 
			instance = new Tab();
		}
		return instance;
	}


	
	public Tab() {
		Toolkit t=Toolkit.getDefaultToolkit();
		Dimension dim=t.getScreenSize();
		int w=dim.width*3/4;
		int h=dim.height*3/4;
		
		JPanel stud=new JPanel();
		JPanel prof=new JPanel();
		JPanel pred=new JPanel();
		
		//STUD
	    StudentiJTable tabstud=StudentiJTable.getInstance();
		JScrollPane sp1=new JScrollPane(tabstud);
	    sp1.setPreferredSize(new Dimension(w-50,h-50));
	    stud.add(sp1,BorderLayout.NORTH);
		
		
		
		add("Studenti",stud);

		//PROF

		Tabela_profesora tabprof = new Tabela_profesora();
		JScrollPane tabpro=new JScrollPane(tabprof);
		tabpro.setPreferredSize(new Dimension(w-50,h-50));
		prof.add(tabpro,BorderLayout.NORTH);
		
		add("Profesori", prof);
		
		//PREDMET

		Tabela_predmeta tabpred = new Tabela_predmeta();
		JScrollPane tp=new JScrollPane(tabpred);
		tp.setPreferredSize(new Dimension(w-50,h-50));
		pred.add(tp,BorderLayout.NORTH);
		
		add("Predmeti", pred);
	   
		
		this.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				JTabbedPane tp=(JTabbedPane)e.getSource();
				selectedIndex1=tp.getSelectedIndex();
				
			}
		});
		
		StudentiJTable.getInstance().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(e.getClickCount()==1)
				{
					if(StudentiJTable.getInstance().getSelectedColumn()==11)
					{
						int row=StudentiJTable.getInstance().getSelectedRow();
				        PredmetiKodStudenta pks=new PredmetiKodStudenta(row);
					}
				}
			}
		});
		
}}
	
	
