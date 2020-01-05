package studenti;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import glavni_prozor.Glavni_prozor;
import glavni_prozor.Kreiranje_entiteta;

public class Dodavanje_studenta extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4748005953045502934L;
	static JTextField txtIme = new JTextField();
	static JTextField txtPrezime = new JTextField();
	static JTextField txtDatumRodjenja = new JTextField();
	static JTextField txtAdresaStanovanja = new JTextField();
	static JTextField txtBrojTelefona= new JTextField();
	static JTextField txtEmailAdresa=new JTextField();
	static JTextField txtBrojIndexa = new JTextField();
	static JTextField txtGodinaStudiranja = new JTextField();
	static JTextField txtDatumUpisa = new JTextField();
	static JTextField txtProsek = new JTextField();
	static JComboBox<String> trengodstud=new JComboBox<String>();
	static JRadioButton budzet=new JRadioButton("Budzet");
	static JRadioButton samofinansiranje=new JRadioButton("Samofinansiranje");
	
	
	public Dodavanje_studenta(Frame parent) {
		
		super(parent);
		
		Box box=Box.createVerticalBox();
		this.add(box,BorderLayout.CENTER);
		
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
		
		setTitle("Dodavanje profesora");
		setModal(true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double height=screenSize.getHeight();
		double width=screenSize.getWidth();
		height=height*0.7;
		width=width*0.3;
		setBounds(150, 150, (int)width, (int)height);
		
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
				setVisible(false);
				
			}
		});
		
		
		JPanel panelDole = new JPanel();
		JButton potvrdaButton = new JButton("Potvrda");
		potvrdaButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				String Ime="";
				String Prezime="";
			    String Datum_rodjenja="";
				String Adresa_stanovanja="";
			    String Kontakt_telefon="";
				String email_adresa="";
				String Broj_indeksa="";
				String Datum_upisa="";
				String Trenutna_godina_studija="";
				double Prosecna_ocena=0;
				Status_studenta status=Status_studenta.B;
				
				Ime=Dodavanje_studenta.txtIme.getText();
				Prezime=Dodavanje_studenta.txtPrezime.getText();
				Adresa_stanovanja=Dodavanje_studenta.txtAdresaStanovanja.getText();
				email_adresa=Dodavanje_studenta.txtEmailAdresa.getText();
				Broj_indeksa=Dodavanje_studenta.txtBrojIndexa.getText();
				Trenutna_godina_studija=Dodavanje_studenta.trengodstud.getSelectedItem().toString();
				Datum_rodjenja=txtDatumRodjenja.getText();
				Datum_upisa=txtDatumUpisa.getText();
				
				Kontakt_telefon=Dodavanje_studenta.txtBrojTelefona.getText();
				try {
					Prosecna_ocena=Float.parseFloat(txtProsek.getText());
				} catch (Exception e) {
					txtProsek.setText("Nije dobro uneto");
				}
				
				
				boolean budzet=false;
				boolean samofinansiranje=false;
				budzet=Dodavanje_studenta.budzet.isSelected();
				samofinansiranje=Dodavanje_studenta.samofinansiranje.isSelected();
				
				if(Ime.equals("") || Prezime.equals("") || Datum_rodjenja==null || Adresa_stanovanja.equals("") ||  Kontakt_telefon.equals("") || email_adresa.equals("")
						||Broj_indeksa.equals("")|| Datum_upisa==null || Trenutna_godina_studija.equals("")|| (budzet==false && samofinansiranje==false) || Prosecna_ocena==0)
				{
					JOptionPane.showMessageDialog(null, "Sva polja moraju biti popunjena!");
				}
				else {
					JOptionPane.showMessageDialog(null, "Student uspesno unet!");
					setVisible(false);
					
					Kreiranje_entiteta.listaStudenata.dodavanjeStudenta(Ime, Prezime, Datum_rodjenja, Adresa_stanovanja, Kontakt_telefon,
							email_adresa, Broj_indeksa, Datum_upisa, Trenutna_godina_studija, status, (float) Prosecna_ocena);
					DefaultTableModel model = Glavni_prozor.tabela_studenata.getModel();
					
					String[] data = new String[12];
					data[0] = Ime;
					data[1] = Prezime;
					data[2] = Broj_indeksa;
					data[3] = Adresa_stanovanja;
					data[4] = Kontakt_telefon;
					data[5] = Trenutna_godina_studija;
					data[6] = String.valueOf(status);
					data[7] = String.valueOf(Prosecna_ocena);
					data[8] = Datum_upisa;
					data[9] = Datum_rodjenja;
					data[10] = Kontakt_telefon;
					data[11] = email_adresa;
							
				    model.addRow(data);
					
					model.fireTableDataChanged();
					//Tabela_profesora tabela_profesora = new Tabela_profesora();
					//tabela_profesora.setVisible(true);
					//Glavni_prozor.getInstance().add(tabela_profesora);
					
					
					for(Student s : Kreiranje_entiteta.listaStudenata.getLista_studenata()) {
						System.out.println(s.toString());
					}
				}
			
			}
		});
		JButton odustanakButton = new JButton("Odustanak");
		odustanakButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event) {
				setVisible(false);
			}
		});
		panelDole.add(odustanakButton);
		panelDole.add(potvrdaButton);
		
		box.add(panelDole);
		
	}
}