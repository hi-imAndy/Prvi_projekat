package profesori;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Izmena_profesora extends JDialog {
	
	public Izmena_profesora(String ime,String prezime,String datumrodj,String adresa,String kontakt,String email,
			String adresakancelarije,int brojlokala,String t,String z) 
	{
		JTextField txtIme = new JTextField(ime);
		JTextField txtPrezime = new JTextField(prezime);
		JTextField txtDatumRodjenja = new JTextField(datumrodj);
		JTextField txtAdresaStanovanja = new JTextField(adresa);
		JTextField txtBrojTelefona= new JTextField(kontakt.toString());
        JTextField txtEmailAdresa=new JTextField(email);
		JTextField txtAdresaKancelarije = new JTextField(adresakancelarije);
		JTextField txtBrojLokala = new JTextField(brojlokala);
		JTextField txtTitula=new JTextField(t);
		JTextField txtZvanje=new JTextField(z);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double height=screenSize.getHeight();
		double width=screenSize.getWidth();
		height=height*0.7;
		width=width*0.3;
		setBounds(150, 150, (int)width, (int)height);
		setModal(true);
		setTitle("Dodavanje profesora");
		
		txtIme.setPreferredSize(new Dimension(160,20));
		txtPrezime.setPreferredSize(new Dimension(160,20));
		txtDatumRodjenja.setPreferredSize(new Dimension(160,20));
		txtAdresaStanovanja.setPreferredSize(new Dimension(160,20));
		txtBrojTelefona.setPreferredSize(new Dimension(160,20));
		txtEmailAdresa.setPreferredSize(new Dimension(160,20));
		txtAdresaKancelarije.setPreferredSize(new Dimension(160,20));
		txtBrojLokala.setPreferredSize(new Dimension(160,20));
		
		
		JLabel ime1 = new JLabel("Ime*");
		JLabel prezime1 = new JLabel("Prezime*");
		JLabel datum_rodjenja = new JLabel("Datum rodjenja*");
		JLabel adresa_stanovanja = new JLabel("Adresa stanovanja*");
		JLabel broj_telefona = new JLabel("Broj telefona*");
		JLabel email1 = new JLabel("Email*");
		JLabel adresa_kancelarije = new JLabel("Adresa kancelarije*");
		JLabel broj_lokala = new JLabel("Broj lične karte*");
		JLabel titula = new JLabel("Titula*");
		JLabel zvanje = new JLabel("Zvanje*");
		
		Box centralBox=Box.createVerticalBox();
		this.add(centralBox,BorderLayout.CENTER);
		
		//pravim panele
		JPanel panelIme = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelPrezime = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelDatumRodjenja = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelAdresaStanovanja = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelBrojTelefona = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelEmail = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelAdresaKancelarije = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelBrojLokala = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelTitula = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelZvanje= new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		panelIme.add(ime1);
		panelIme.add(txtIme);
		centralBox.add(panelIme);
		
		panelPrezime.add(prezime1);
		panelPrezime.add(txtPrezime);
		centralBox.add(panelPrezime);
		
		panelDatumRodjenja.add(datum_rodjenja);
		panelDatumRodjenja.add(txtDatumRodjenja);
		centralBox.add(panelDatumRodjenja);
		
		
		panelAdresaStanovanja.add(adresa_stanovanja);
		panelAdresaStanovanja.add(txtAdresaStanovanja);
		centralBox.add(panelAdresaStanovanja);
		
		
		panelBrojTelefona.add(broj_telefona);
		panelBrojTelefona.add(txtBrojTelefona);
		centralBox.add(panelBrojTelefona);
		
		panelEmail.add(email1);
		panelEmail.add(txtEmailAdresa);
		centralBox.add(panelEmail);
		
		panelAdresaKancelarije.add(adresa_kancelarije);
		panelAdresaKancelarije.add(txtAdresaKancelarije);
		centralBox.add(panelAdresaKancelarije);
		
		panelBrojLokala.add(broj_lokala);
		panelBrojLokala.add(txtBrojLokala);
		centralBox.add(panelBrojLokala);
		
		panelTitula.add(titula);
		panelTitula.add(txtTitula);
		centralBox.add(panelTitula);
		
		panelZvanje.add(zvanje);
		panelZvanje.add(txtZvanje);
		centralBox.add(panelZvanje);
		

		

		
		
		JPanel panelBottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton ButtonPotvrda=new JButton("Potvrda");
		panelBottom.add(ButtonPotvrda);
		JButton ButtonOdustanak=new JButton("Odustanak");
		panelBottom.add(ButtonOdustanak);
		centralBox.add(panelBottom);
		
		ButtonOdustanak.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				
			}
		});
		
		ButtonPotvrda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(txtIme.getText().isEmpty() || txtPrezime.getText().isEmpty() || txtDatumRodjenja.getText().isEmpty() ||
						 txtAdresaStanovanja.getText().isEmpty() || txtBrojTelefona.getText().isEmpty() || txtEmailAdresa.getText().isEmpty() ||
						 txtAdresaKancelarije.getText().isEmpty() || txtBrojLokala.getText().isEmpty() || txtTitula.getText().isEmpty() || txtZvanje.getText().isEmpty())
					
					JOptionPane.showMessageDialog(null, "Sva polja moraju biti popunjena da bi mogli izmeniti profesora!");
				else
					{
					

					
					
					ProfesoriController.getInstance().izmeniProfesora(txtIme.getText(),txtPrezime.getText(),txtDatumRodjenja.getText()
							,txtAdresaStanovanja.getText(),txtBrojTelefona.getText(),txtEmailAdresa.getText(),txtAdresaKancelarije.getText()
							,Integer.parseInt(txtBrojLokala.getText()),txtTitula.getText(),txtZvanje.getText());
					setVisible(false);
					}
			}
		});
		
	}

}
