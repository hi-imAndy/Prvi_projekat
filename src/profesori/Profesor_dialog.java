package profesori;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import glavni_prozor.Glavni_prozor;

public class Profesor_dialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6250100400078563256L;
	static JTextField imeText = new JTextField();
	static JTextField prezimeText = new JTextField();
	static JTextField datumText = new JTextField();
	static JTextField adresaText = new JTextField();
	static JTextField telefonText = new JTextField();
	static JTextField emailText = new JTextField();
	static JTextField adresaKancText = new JTextField();
	static JTextField brojLicneText = new JTextField();
	static JTextField titulaText = new JTextField();
	static JTextField zvanjeText = new JTextField();
	
	public Profesor_dialog(Frame parent) {
		
		super(parent);
		
		Box box=Box.createVerticalBox();
		this.add(box,BorderLayout.CENTER);
		
		imeText.setPreferredSize(new Dimension(160,20));
		prezimeText.setPreferredSize(new Dimension(160,20));
		datumText.setPreferredSize(new Dimension(160,20));
		adresaText.setPreferredSize(new Dimension(160,20));
		telefonText.setPreferredSize(new Dimension(160,20));
		emailText.setPreferredSize(new Dimension(160,20));
		adresaKancText.setPreferredSize(new Dimension(160,20));
		brojLicneText.setPreferredSize(new Dimension(160,20));
		titulaText.setPreferredSize(new Dimension(160,20));
		zvanjeText.setPreferredSize(new Dimension(160,20));
		
		setTitle("Dodavanje profesora");
		setBackground(Color.GREEN);
		setModal(true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double height=screenSize.getHeight();
		double width=screenSize.getWidth();
		height=height*0.7;
		width=width*0.3;
		setBounds(150, 150, (int)width, (int)height);
		
		JPanel panelIme = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelPrezime = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelDatum = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelAdresa = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelTelefon = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelEmail = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelAdresaKanc = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelBrojLicne = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelTitula = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelZvanje = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		JLabel ime = new JLabel("Ime*");
		JLabel prezime = new JLabel("Prezime*");
		JLabel datum = new JLabel("Datum rodjenja*");
		JLabel adresa = new JLabel("Adresa stanovanja*");
		JLabel telefon = new JLabel("Broj telefona*");
		JLabel email = new JLabel("E-mail*");
		JLabel adresaKanc = new JLabel("Adresa kancelarije*");
		JLabel brojLicne = new JLabel("Broj licne karte*");
		JLabel titula = new JLabel("Titula*");
		JLabel zvanje = new JLabel("Zvanje*");
		
		panelIme.add(ime);
		panelIme.add(imeText);
		box.add(panelIme);
		
		panelPrezime.add(prezime);
		panelPrezime.add(prezimeText);
		box.add(panelPrezime);
		
		panelDatum.add(datum);
		panelDatum.add(datumText);
		box.add(panelDatum);
		
		panelAdresa.add(adresa);
		panelAdresa.add(adresaText);
		box.add(panelAdresa);
		
		panelTelefon.add(telefon);
		panelTelefon.add(telefonText);
		box.add(panelTelefon);
		
		panelEmail.add(email);
		panelEmail.add(emailText);
		box.add(panelEmail);
		
		panelAdresaKanc.add(adresaKanc);
		panelAdresaKanc.add(adresaKancText);
		box.add(panelAdresaKanc);
		
		panelBrojLicne.add(brojLicne);
		panelBrojLicne.add(brojLicneText);
		box.add(panelBrojLicne);
		
		panelTitula.add(titula);
		panelTitula.add(titulaText);
		box.add(panelTitula);
		
		panelZvanje.add(zvanje);
		panelZvanje.add(zvanjeText);
		box.add(panelZvanje);
		
		JPanel panelDole = new JPanel();
		JButton potvrdaButton = new JButton("Potvrda");
		potvrdaButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				String ime = "";
				String prezime = "";
				String datum = "";
				String adresa = "";
				String telefon = "";
				String email = "";
				String adresaKanc = "";
				String brojLicne = "";
				String titula = "";
				String zvanje = "";
				
				try {
					ime = imeText.getText();
				}catch(Exception e) {
					imeText.setText("Neispravno uneto ime!");
				}
				
				try {
					prezime = prezimeText.getText();
				}catch(Exception e) {
					prezimeText.setText("Neispravno uneto prezime!");
				}
				
				try {
					datum = datumText.getText();
				}catch(Exception e) {
					datumText.setText("Neispravno unet datum!");
				}
				
				try {
					adresa = adresaText.getText();
				}catch(Exception e) {
					adresaText.setText("Neispravno uneta adresa!");
				}
				
				try {
					telefon = telefonText.getText();
				}catch(Exception e) {
					telefonText.setText("Neispravno unet telefon!");
				}
				
				try {
					email = emailText.getText();
				}catch(Exception e) {
					emailText.setText("Neispravno unet email!");
				}
				
				try {
					adresaKanc = adresaKancText.getText();
				}catch(Exception e) {
					adresaKancText.setText("Neispravno uneta adresa kancelarije!");
				}
				
				try {
					brojLicne = brojLicneText.getText();
				}catch(Exception e) {
					brojLicneText.setText("Neispravno unet broj licne karte!");
				}
				
				try {
					titula = titulaText.getText();
				}catch(Exception e) {
					titulaText.setText("Neispravno uneta titula!");
				}
				
				try {
					zvanje = zvanjeText.getText();
				}catch(Exception e) {
					zvanjeText.setText("Neispravno uneto zvanje!");
				}
				
				if(ime.equals("") || prezime.equals("") || datum.equals("") || adresa.equals("") || telefon.equals("") || email.equals("") || adresaKanc.equals("") || brojLicne.equals("") || titula.equals("") || zvanje.equals("")) {
					JOptionPane.showMessageDialog(null, "Niste popunili sva polja!");
				}
				else {
					
					BazaProfesora.getInstance().getProfesori().addProfesor(ime, prezime, datum, adresa, telefon, email, adresaKanc, brojLicne, titula, zvanje);
					
					JOptionPane.showMessageDialog(null, "Profesor uspesno unet!");
					setVisible(false);
					Tabela_profesora.azurirajPrikaz();
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
