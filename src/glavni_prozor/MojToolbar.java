package glavni_prozor;

import java.awt.Color;


import javax.swing.RowSorter;
import javax.swing.SortOrder;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import predmeti.BazaPredmeta;
import predmeti.BrisanjePredmeta;
import predmeti.BrisanjeProfesoraSaPredmeta;
import predmeti.DodavanjeProfNaPredmet;
import predmeti.DodavanjeStudentaNaPredmet;
import predmeti.IzmenaPredmeta;
import predmeti.Predmet;
import predmeti.Predmet_dialog;
import predmeti.Tabela_predmeta;
import profesori.BazaProfesora;
import profesori.BrisanjeProfesora;
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

public class MojToolbar extends JToolBar{
	
	static JButton btnCreate;
	static JButton btnEdit;
	static JButton btnDelete;
	
	public static JButton btnStudentNaPredmet;
	public static JButton btnProfesorNaPredmet;
	
	public static JButton btnStudentSaPredmeta;
	public static JButton btnProfesorSaPredmeta;
	
	public static TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(Tabela_profesora.model);
	
	public MojToolbar(Frame parent) {
	super(SwingConstants.HORIZONTAL);
	
	JButton btnCreate = new JButton();
	btnCreate.setToolTipText("Create");
	btnCreate.setIcon(new ImageIcon("slike/createImg2.jpg"));
	add(btnCreate);

		btnCreate.addActionListener(new ActionListener() {

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
	
	JButton btnEdit = new JButton();
	btnEdit.setToolTipText("Edit");
	btnEdit.setIcon(new ImageIcon("slike/edit_pic2.png"));
	add(btnEdit);

	btnEdit.addActionListener(new ActionListener() {
		
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
	
	
	//addSeparator();
	
	
	JButton btnDelete = new JButton();
	btnDelete.setToolTipText("Delete");
	btnDelete.setIcon(new ImageIcon("slike/delete_img2.png"));
	add(btnDelete);
	
	btnDelete.addActionListener(new ActionListener() {
		
		
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
				if(Tabela_profesora.row==-1)
					JOptionPane.showMessageDialog(null, "Profesor mora biti izabran da bi bio obrisan!");
				else {
				BrisanjeProfesora brisanje=new BrisanjeProfesora(parent);
				brisanje.setVisible(true);
				}

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
	
	btnStudentNaPredmet = new JButton();
	btnStudentNaPredmet.setToolTipText("Add student");
	btnStudentNaPredmet.setIcon(new ImageIcon("slike/stud2.jpg"));
	btnStudentNaPredmet.setVisible(false);
	add(btnStudentNaPredmet);
	
	btnStudentNaPredmet.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(Tabela_predmeta.row==-1)
				JOptionPane.showMessageDialog(null, "Predmet mora biti izabran da biste dodali studenta!");
			else {
				DodavanjeStudentaNaPredmet dsnp = new DodavanjeStudentaNaPredmet(parent);
				dsnp.setVisible(true);
			}
		}
	});
	
	btnProfesorNaPredmet = new JButton();
	btnProfesorNaPredmet.setToolTipText("Add profesor");
	btnProfesorNaPredmet.setIcon(new ImageIcon("slike/prof2.jpg"));
	btnProfesorNaPredmet.setVisible(false);
	add(btnProfesorNaPredmet);
	
	btnProfesorNaPredmet.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(Tabela_predmeta.row==-1)
				JOptionPane.showMessageDialog(null, "Predmet mora biti izabran da biste dodali profesora!");
			else {
				DodavanjeProfNaPredmet d = new DodavanjeProfNaPredmet(parent);
				d.setVisible(true);
			}
		}
	});
	
	
	btnStudentSaPredmeta = new JButton();
	btnStudentSaPredmeta.setToolTipText("Delete student");
	btnStudentSaPredmeta.setIcon(new ImageIcon("slike/delete_student.png"));
	btnStudentSaPredmeta.setVisible(true);
	add(btnStudentSaPredmeta);
	btnStudentSaPredmeta.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(Tabela_predmeta.row==-1)
				JOptionPane.showMessageDialog(null, "Predmet mora biti izabran da biste uklonili studenta!");
			else {
				Brisanje_studenta bsd	= new Brisanje_studenta(parent);
				bsd.setVisible(true);}
		}
	});
	
	btnProfesorSaPredmeta = new JButton();
	btnProfesorSaPredmeta.setToolTipText("Delete profesor");
	btnProfesorSaPredmeta.setIcon(new ImageIcon("slike/delete_student.png"));
	btnProfesorSaPredmeta.setVisible(true);
	add(btnProfesorSaPredmeta);
	btnProfesorSaPredmeta.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(Tabela_profesora.row==-1)
				JOptionPane.showMessageDialog(null, "Profesor mora biti izabran da biste uklonili predmet!");
			else {
				Profesor p = BazaProfesora.getInstance().getProfesori().getListaProfesora().get(Tabela_profesora.row);
				BrisanjeProfesoraSaPredmeta bpsp = new BrisanjeProfesoraSaPredmeta(p.getBrojLicne());
				bpsp.setVisible(true);
				int index = BrisanjeProfesoraSaPredmeta.lista.getSelectedIndex();
				BrisanjeProfesoraSaPredmeta.lista.remove(index);
			}
				
		}
	});
	
	
	for(int i = 0; i < 50; i++)
		addSeparator();
	
	JTextField textField = new JTextField(30);
	add(textField);
	
	//addSeparator();
	
	JButton btnSearch = new JButton();
	btnSearch.setToolTipText("Search");
	btnSearch.setIcon(new ImageIcon("slike/search_icon2.png"));
	
	btnSearch.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent event) {
			BazaProfesora.search(textField.getText());
			Tabela_profesora.azurirajPrikaz();
		}
	});
	
	add(btnSearch); 
	
	setBackground(Color.LIGHT_GRAY);
	setFloatable(false);
	
	}

	public JButton getBtnCreate() {
		return btnCreate;
	}

	public void setBtnCreate(JButton btnCreate) {
		this.btnCreate = btnCreate;
	}
	
	
}
