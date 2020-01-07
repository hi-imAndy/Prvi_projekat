package studenti;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;



public class Izmena_studenta extends JDialog {
	
	 static JRadioButton budzet=new JRadioButton("Budzet");
     static JRadioButton samofinansiranje=new JRadioButton("Samofinansiranje");

	
	public Izmena_studenta(String ime1,String prezime1,String dat_rodj1,String email1,String dat_upisa1,Double prosek1,
			String adresa,String brtel,String brindexa,String tren_god_stud,Status_studenta s) {
		
		
	     JTextField txtIme = new JTextField(ime1);
		 JTextField txtPrezime = new JTextField(prezime1);
		 JTextField txtDatumRodjenja = new JTextField(dat_rodj1);
		 JTextField txtAdresaStanovanja = new JTextField(adresa);
	     JTextField txtBrojTelefona= new JTextField(brtel);
		 JTextField txtEmailAdresa=new JTextField(email1);
		 JTextField txtBrojIndexa = new JTextField(brindexa);
		 JTextField txtGodinaStudiranja = new JTextField(tren_god_stud);
		JTextField txtDatumUpisa = new JTextField(dat_upisa1);
		 JTextField txtProsek = new JTextField(prosek1.toString());
		 JComboBox<String> trengodstud=new JComboBox<String>(); 
		
		 
		 if(s==Status_studenta.B)
			 budzet.setSelected(true);
		 else if(s==Status_studenta.S)
			 samofinansiranje.setSelected(true);
		 
		
		
		
		txtIme.setPreferredSize(new Dimension(160,20));
		txtPrezime.setPreferredSize(new Dimension(160,20));
		txtDatumRodjenja.setPreferredSize(new Dimension(160,20));
		txtAdresaStanovanja.setPreferredSize(new Dimension(160,20));
		txtBrojTelefona.setPreferredSize(new Dimension(160,20));
		txtBrojIndexa.setPreferredSize(new Dimension(160,20));
		txtGodinaStudiranja.setPreferredSize(new Dimension(160,20));
		txtEmailAdresa.setPreferredSize(new Dimension(160,20));
		txtProsek.setPreferredSize(new Dimension(160,20));
		txtDatumUpisa.setPreferredSize(new Dimension(160,20));
	
		
		ButtonGroup group=new ButtonGroup();
		group.add(budzet);
		group.add(samofinansiranje);
		
		setBackground(Color.GREEN);
		setModal(true);
		setTitle("Izmena studenta");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double height=screenSize.getHeight();
		double width=screenSize.getWidth();
		height=height*0.7;
		width=width*0.3;
		setBounds(150, 150, (int)width, (int)height);
		
		JPanel panelBottom = new JPanel();
		JButton ButtonPotvrda=new JButton("Potvrda");
		panelBottom.add(ButtonPotvrda);
		JButton ButtonOdustanak=new JButton("Odustanak");
		JLabel ime = new JLabel("Ime*");
		JLabel prezime = new JLabel("Prezime*");
		JLabel datum_rodjenja = new JLabel("Datum rodjenja*");
		JLabel adresa_stanovanja = new JLabel("Adresa stanovanja*");
		JLabel broj_telefona = new JLabel("Broj telefona*");
		JLabel broj_indexa = new JLabel("Broj indeksa*");
		JLabel trenutna_godina_studiranja = new JLabel("Trenutna godina studiranja*");
		JLabel email = new JLabel("Email*");
		JLabel prosek = new JLabel("Prosek*");
		JLabel datum_upisa = new JLabel("Datum upisa*");
		
		
		
		
		JPanel panelIme = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelPrezime = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelDatumRodjenja = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelBrojIndexa = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelAdresaStanovanja = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelBrojTelefona = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelTrenutnaGodinaStudiranja = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelEmail = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelProsek = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelDatumUpisa = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		
		
		
		Box box=Box.createVerticalBox();
		this.add(box,BorderLayout.CENTER);
		
		
		panelIme.add(ime);
		panelIme.add(txtIme);
		box.add(panelIme);
		
		panelPrezime.add(prezime);
		panelPrezime.add(txtPrezime);
		box.add(panelPrezime);
		
		panelDatumRodjenja.add(datum_rodjenja);
		panelDatumRodjenja.add(txtDatumRodjenja);
		box.add(panelDatumRodjenja);
		
		panelEmail.add(email);
		panelEmail.add(txtEmailAdresa);
		box.add(panelEmail);
		
		panelDatumUpisa.add(datum_upisa);
		panelDatumUpisa.add(txtDatumUpisa);
		box.add(panelDatumUpisa);
		
		panelProsek.add(prosek);
		panelProsek.add(txtProsek);
		box.add(panelProsek);
		
		
		
		panelAdresaStanovanja.add(adresa_stanovanja);
		panelAdresaStanovanja.add(txtAdresaStanovanja);
		box.add(panelAdresaStanovanja);
		
		panelBrojTelefona.add(broj_telefona);
		panelBrojTelefona.add(txtBrojTelefona);
		box.add(panelBrojTelefona);
		
		
		panelBrojIndexa.add(broj_indexa);
		panelBrojIndexa.add(txtBrojIndexa);
		box.add(panelBrojIndexa);
		
		
		trengodstud.addItem("Prva");
		trengodstud.addItem("Druga");
		trengodstud.addItem("Treca");
	   trengodstud.addItem("Cetvrta");
	   
	   if(tren_god_stud.equals("Prva")) {
	    	trengodstud.setSelectedItem("Prva");
	    }else if(tren_god_stud.equals("Druga")) {
	    	trengodstud.setSelectedItem("Druga");
	    }else if(tren_god_stud.equals("Treca")) {
	    	trengodstud.setSelectedItem("Treca");
	    }else if(tren_god_stud.equals("Cetvrta")) {
	    	trengodstud.setSelectedItem("Cetvrta");
	    }
	   
	   panelTrenutnaGodinaStudiranja.add(trenutna_godina_studiranja);
	   panelTrenutnaGodinaStudiranja.add(trengodstud);
	   box.add(panelTrenutnaGodinaStudiranja);
	   

	   
	   JPanel PanelBudzet=new JPanel(new FlowLayout(FlowLayout.LEFT));
	   PanelBudzet.add(budzet);
	    box.add(PanelBudzet);
	    
	    JPanel PanelSamofinansiranje=new JPanel(new FlowLayout(FlowLayout.LEFT));
	    PanelSamofinansiranje.add(samofinansiranje);
	    box.add(PanelSamofinansiranje);
		ButtonOdustanak.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//setVisible(false);
				dispose();
				
			}
		});
		panelBottom.add(ButtonOdustanak);
		this.add(panelBottom, BorderLayout.SOUTH);
		ButtonPotvrda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
		        
				Status_studenta status=null;
				 boolean budzet=false;
				 boolean samofinansiranje=false;

				
				budzet=Izmena_studenta.budzet.isSelected();
				samofinansiranje=Izmena_studenta.samofinansiranje.isSelected();
				
				if(budzet)
				{
					status=Status_studenta.B;
				} else if (samofinansiranje)
					status=Status_studenta.S;
				else
				{
					JOptionPane.showMessageDialog(null,"Mora biti odabrano jedno od polja BUDZET/SAMOFINANSIRANJE");
				}
				
				if(txtIme.getText().isEmpty() || txtPrezime.getText().isEmpty() ||txtDatumRodjenja.getText().isEmpty() ||
						txtEmailAdresa.getText().isEmpty() || txtDatumUpisa.getText().isEmpty() ||txtProsek.getText().isEmpty() ||
						txtAdresaStanovanja.getText().isEmpty() ||txtBrojTelefona.getText().isEmpty() ||txtBrojIndexa.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Sva polja moraju biti popunjena da bi mogli izmeniti studenta!");
				}
				else
				{
					
						StudentiController.getInstance().izmeniStudenta(txtIme.getText(),txtPrezime.getText(),txtDatumRodjenja.getText(),
								txtEmailAdresa.getText(),txtDatumUpisa.getText(),(float) Double.parseDouble(txtProsek.getText()),txtAdresaStanovanja.getText(),txtBrojTelefona.getText(),
								txtBrojIndexa.getText(),trengodstud.getSelectedItem().toString(),status);
						JOptionPane.showMessageDialog(null, "Student izmenjen");
						setVisible(false);
				}
				
			}
			
		});
	}}
