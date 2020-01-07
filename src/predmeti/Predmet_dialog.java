package predmeti;

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
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import glavni_prozor.Glavni_prozor;
import glavni_prozor.Kreiranje_entiteta;
import profesori.Profesor;

public class Predmet_dialog extends JDialog{
	static JTextField sifraText = new JTextField();
	static JTextField nazivText = new JTextField();
	static JComboBox<String> semestarCombo;
	static JComboBox<String> godinaCombo;
	static JTextField profesorText = new JTextField();
	
	public Predmet_dialog(Frame parent) {
		
		super(parent);
		
		Box box=Box.createVerticalBox();
		this.add(box,BorderLayout.CENTER);
		
		sifraText.setPreferredSize(new Dimension(160,20));
		nazivText.setPreferredSize(new Dimension(160,20));
		profesorText.setPreferredSize(new Dimension(160,20));
		
		setTitle("Dodavanje predmeta");
		setBackground(Color.GREEN);
		setModal(true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double height=screenSize.getHeight();
		double width=screenSize.getWidth();
		height=height*0.3;
		width=width*0.3;
		setBounds(100, 100, (int)width, (int)height);
		
		JPanel panelSifra = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelNaziv = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelSemestar = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelGodina = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelProfesor = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		JLabel sifra = new JLabel("Sifra*");
		JLabel naziv = new JLabel("Naziv*");
		JLabel semestar = new JLabel("Semestar*");
		JLabel godina = new JLabel("Godina*");
		JLabel profesor = new JLabel("Profesor*");
		
		godinaCombo = new  JComboBox<String>();
		semestarCombo = new JComboBox<String>();
		
		godinaCombo.addItem("1");
		godinaCombo.addItem("2");
		godinaCombo.addItem("3");
		godinaCombo.addItem("4");
		godinaCombo.addItem("5");
		
		semestarCombo.addItem("1");
		semestarCombo.addItem("2");
		
		godinaCombo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				if(godinaCombo.getSelectedItem() == "1") {
					semestarCombo.removeAllItems();
					semestarCombo.addItem("1");
					semestarCombo.addItem("2");
				}
				else if(godinaCombo.getSelectedItem() == "2") {
					semestarCombo.removeAllItems();
					semestarCombo.addItem("3");
					semestarCombo.addItem("4");
				}
				else if(godinaCombo.getSelectedItem() == "3") {
					semestarCombo.removeAllItems();
					semestarCombo.addItem("5");
					semestarCombo.addItem("6");
				}
				else if(godinaCombo.getSelectedItem() == "4") {
					semestarCombo.removeAllItems();
					semestarCombo.addItem("7");
					semestarCombo.addItem("8");
				}
				else if(godinaCombo.getSelectedItem() == "5") {
					semestarCombo.removeAllItems();
					semestarCombo.addItem("9");
					semestarCombo.addItem("10");
				}
			}
		});
		
		panelSifra.add(sifra);
		panelSifra.add(sifraText);
		box.add(panelSifra);
		
		panelNaziv.add(naziv);
		panelNaziv.add(nazivText);
		box.add(panelNaziv);
		
		panelSemestar.add(semestar);
		panelSemestar.add(semestarCombo);
		box.add(panelSemestar);
		
		panelGodina.add(godina);
		panelGodina.add(godinaCombo);
		box.add(panelGodina);
		
		panelProfesor.add(profesor);
		panelProfesor.add(profesorText);
		box.add(panelProfesor);
		
		JPanel panelDole = new JPanel();
		JButton potvrdaButton = new JButton("Potvrda");
		potvrdaButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				int sifra = 0;
				String naziv = "";
				int semestar = 0;
				int godina = 0;
				int profesor = 0;
				
				try {
					sifra = Integer.parseInt(sifraText.getText());
				}catch(Exception e) {
					sifraText.setText("Neispravno uneta sifra!");
				}
				
				try {
					naziv = nazivText.getText();
				}catch(Exception e) {
					nazivText.setText("Neispravno unet naziv!");
				}
				
				try {
					profesor = Integer.parseInt(profesorText.getText());
				}catch(Exception e) {
					profesorText.setText("Neispravno unet profesor!");
				}
				
				semestar = Integer.parseInt(semestarCombo.getSelectedItem().toString());
				godina = Integer.parseInt(godinaCombo.getSelectedItem().toString());
				
				Profesor p;
				
				if(sifra == 0 || naziv.equals("") || semestar == 0 || godina == 0 || profesor == 0) {
					JOptionPane.showMessageDialog(null, "Niste popunili sva polja!");
				}
				
				else if((p = Kreiranje_entiteta.listaProfesora.findProfesor(profesor)) == null) {
					JOptionPane.showMessageDialog(null, "Ne postoji profesor sa tom licnom kartom!");
				}
				
				else {
					
					Kreiranje_entiteta.listaPredmeta.addPredmet(sifra,naziv,semestar,godina,p);
					/*DefaultTableModel model = Glavni_prozor.tabela_predmeta.getModel();
					
					String[] data = new String[10];
					data[0] = String.valueOf(sifra);
					data[1] = naziv;
					data[2] = String.valueOf(semestar);
					data[3] = String.valueOf(godina);
					data[4] = String.valueOf(profesor);
					
				    model.addRow(data);
					
					model.fireTableDataChanged();
					//Tabela_profesora tabela_profesora = new Tabela_profesora();
					//tabela_profesora.setVisible(true);
					//Glavni_prozor.getInstance().add(tabela_profesora);*/
					
					JOptionPane.showMessageDialog(null, "Predmet uspesno unet!");
					setVisible(false);
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
