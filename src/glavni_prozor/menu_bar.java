package glavni_prozor;


import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

import predmeti.BazaPredmeta;
import predmeti.BrisanjePredmeta;
import predmeti.IzmenaPredmeta;
import predmeti.Predmet;
import predmeti.Predmet_dialog;
import predmeti.Tabela_predmeta;
import profesori.BazaProfesora;
import profesori.Izmena_profesora;
import profesori.Profesor;
import profesori.Profesor_dialog;
import profesori.Tabela_profesora;
import studenti.BazaStudenata;
import studenti.Brisanje_studenta;
import studenti.Izmena_studenta;
import studenti.Student;
import studenti.StudentiJTable;
import studenti.dodavanje_studenta1;

public class menu_bar extends JMenuBar {



	/**
	 * 
	 */
	private static final long serialVersionUID = 2995242819604801482L;

	public menu_bar(Frame parent) {
		
		JMenu file = new JMenu("File");
		JMenuItem miNew = new JMenuItem("New");
		
		miNew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Tab.getSelectedIndex1()==0) {
					dodavanje_studenta1 dodavanje_studenta_dijalog=new dodavanje_studenta1(parent);
					dodavanje_studenta_dijalog.setVisible(true);
			     }
				else if(Tab.getSelectedIndex1()==1)
				{
					Profesor_dialog profesor_dialog = new Profesor_dialog(parent);
					profesor_dialog.setVisible(true);
				}else if(Tab.getSelectedIndex1()==2)
				{
					Predmet_dialog predmet_dialog = new Predmet_dialog(parent);
					predmet_dialog.setVisible(true);
				}
			}
		});
		
		JMenuItem miClose = new JMenuItem("Close");
		
		miClose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.dispose();
			}
		});
		
		file.add(miNew);
		file.addSeparator();
		file.add(miClose);
		
		JMenu edit=new JMenu("Edit");
		JMenuItem edit1=new JMenuItem("Edit");
		
		edit1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Tab.getSelectedIndex1()==0) {
					if(StudentiJTable.row==-1)
						JOptionPane.showMessageDialog(null, "Mora biti selektovan neki red u tabeli da biste mogli da editujete studenta!");
					else
					{
					Student s = BazaStudenata.getInstance().getRow(StudentiJTable.tab.getSelectedRow());
					Izmena_studenta isd=new Izmena_studenta(s.getIme(),s.getPrezime(),s.getDatum_upisa(),s.getEmail(),
							s.getDatum_upisa(),(double) s.getProsecna_ocena(),s.getAdresaStanovanja(),s.getTelefon(),s.getBroj_indeksa(),
							s.getGodina_studija(),s.getStatus());
					
					isd.setVisible(true);}
			     }
				else if(Tab.getSelectedIndex1()==1)
				{   

					if(Tabela_profesora.row== -1)
						JOptionPane.showMessageDialog(null, "Mora biti selektovan neki red u tabeli da biste mogli da editujete profesora!");
					else
					{
					Profesor p=BazaProfesora.getInstance().getRow(Tabela_profesora.tab.getSelectedRow());
					Izmena_profesora ipd=new Izmena_profesora(p.getIme(), p.getPrezime(), p.getDatumRodjenja(), 
							p.getAdresaStanovanja(),p.getTelefon(),p.getEmail(), p.getAdresaKancelarije(), p.getBrojLicne(), p.getTitula(), p.getZvanje()) ;
					ipd.setVisible(true);
					}
				}else if(Tab.getSelectedIndex1()==2)
				{	
					if(Tabela_predmeta.row==-1)
						JOptionPane.showMessageDialog(null, "Mora biti selektovan neki red u tabeli da biste mogli da editujete predmet!");
					else
					{
						Predmet p = BazaPredmeta.getInstance().getRow(Tabela_predmeta.tab.getSelectedRow());
						IzmenaPredmeta izmena = new IzmenaPredmeta(p.getSifraPredmeta(),p.getNaziv(),p.getSemestar(),p.getGodinaStudija(),p.getProfesor().getBrojLicne());
						izmena.setVisible(true);}
			     	}
				}
		});
		
		JMenuItem delete=new JMenuItem("Delete");
		
		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Tab.getSelectedIndex1()==0) {
					if(StudentiJTable.row==-1)
						JOptionPane.showMessageDialog(null, "Student mora biti izabran da bi bio obrisan!");
					else {
					Brisanje_studenta bs=new Brisanje_studenta(parent);
					bs.setVisible(true);
					}
			     }
				else if(Tab.getSelectedIndex1()==1)
				{	
				
						//BRISANJE PROFESORA
					

				}else if(Tab.getSelectedIndex1()==2)
				{	
				
					if(Tabela_predmeta.row==-1)
						JOptionPane.showMessageDialog(null, "Predmet mora biti izabran da bi bio obrisan!");
					else {
					BrisanjePredmeta brisanje=new BrisanjePredmeta(parent);
					brisanje.setVisible(true);
					}
				
				}
			}
		});
		
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