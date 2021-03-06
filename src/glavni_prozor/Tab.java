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

import predmeti.Brisanje_studenta_sa_predmeta;
import predmeti.Tabela_predmeta;
import profesori.BrisanjeProfesoraSaPredmeta;
import profesori.PredmetiKodProfesora;
import profesori.Tabela_profesora;

import studenti.PredmetiKodStudenta;
import studenti.StudentiJTable;



public class Tab extends JTabbedPane{
 

	/**
	 * 
	 */
	private static final long serialVersionUID = -2066180810046450990L;
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

		Tabela_profesora tabprof = Tabela_profesora.getInstance();
		JScrollPane tabpro=new JScrollPane(tabprof);
		tabpro.setPreferredSize(new Dimension(w-50,h-50));
		prof.add(tabpro,BorderLayout.NORTH);
		
		add("Profesori", prof);
		
		//PREDMET

		Tabela_predmeta tabpred = Tabela_predmeta.getInstance();
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
		
		
		Tabela_predmeta.getInstance().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(e.getClickCount()==1)
				{
					if(Tabela_predmeta.getInstance().getSelectedColumn()==5)
					{
						int row=Tabela_predmeta.getInstance().getSelectedRow();
						Brisanje_studenta_sa_predmeta dijalog=new Brisanje_studenta_sa_predmeta(null, row);
						dijalog.setVisible(true);
					}
				}
			}
			
		});
		/*
		Tabela_profesora.getInstance().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(e.getClickCount()==1)
				{
					if(Tabela_profesora.getInstance().getSelectedColumn() == 10)
					{
						int row=Tabela_profesora.getInstance().getSelectedRow();
						PredmetiKodProfesora dijalog=new PredmetiKodProfesora(row);
						//dijalog.setVisible(true);
					}
				}
			}
		});*/
		
		Tabela_profesora.getInstance().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(e.getClickCount()==1)
				{
					if(Tabela_profesora.getInstance().getSelectedColumn()==10)
					{
						int row=Tabela_profesora.getInstance().getSelectedRow();
						BrisanjeProfesoraSaPredmeta bpsp = new BrisanjeProfesoraSaPredmeta(null,row);
						bpsp.setVisible(true);
					}
				}
			}
		});
		
}}
	
	
