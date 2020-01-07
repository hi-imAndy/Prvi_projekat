package glavni_prozor;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import predmeti.Predmet_dialog;
import profesori.Profesor_dialog;
import studenti.BazaStudenata;
import studenti.Brisanje_studenta;
import studenti.Dodavanje_studenta;
import studenti.Izmena_studenta;
import studenti.Student;
import studenti.StudentiJTable;
import studenti.Tabela_studenata;
import studenti.dodavanje_studenta1;

public class MojToolbar extends JToolBar{
	
	static JButton btnCreate;
	static JButton btnEdit;
	static JButton btnDelete;
	
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
					//DODAVANJE PROFESORA
				}else if(Tab.getSelectedIndex1()==2)
				{
					//DODAVANJE PREDMETA
				}
					
				
			}
		});
	
	
	//btnCreate.addActionListener(new HandleActionListener());
	//addSeparator();
	
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
				//IZMENA PROFESORA
				
			}else if(Tab.getSelectedIndex1()==2)
			{	
				//IZMENA PREDMETA
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
			
					//BRISANJE PROFESORA
				

			}else if(Tab.getSelectedIndex1()==2)
			{	
			
				    //BRISANJE PREDMETA
			
			}
	
		}
	});
	
	
	JSeparator toolBarSeparator = new JToolBar.Separator();
	
	for(int i = 0; i < 80; i++)
		addSeparator();
	
	JTextField textField = new JTextField(30);
	add(textField);
	
	//addSeparator();
	
	JButton btnSearch = new JButton();
	btnSearch.setToolTipText("Search");
	btnSearch.setIcon(new ImageIcon("slike/search_icon2.png"));
	
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
