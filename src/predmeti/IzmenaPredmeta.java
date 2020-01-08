package predmeti;

import java.awt.BorderLayout;
import java.awt.Color;
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

import profesori.BazaProfesora;
import profesori.Profesor;

public class IzmenaPredmeta extends JDialog{
	
	public IzmenaPredmeta(int sifra, String naziv, int semestar, int godina, int profLicnaKarta) {
	    JTextField sifraText = new JTextField(String.valueOf(sifra));
		JTextField nazivText = new JTextField(naziv);
		JComboBox<String> semestarCombo = new JComboBox<String>();
		JComboBox<String> godinaCombo = new JComboBox<String>();
		JTextField profText = new JTextField(String.valueOf(profLicnaKarta));
		
		sifraText.setEditable(false); // jer po sifri editujemo
		
		setBackground(Color.GREEN);
		setModal(true);
		setTitle("Izmena predmeta");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double height=screenSize.getHeight();
		double width=screenSize.getWidth();
		height=height*0.3;
		width=width*0.3;
		setBounds(150, 150, (int)width, (int)height);
		
		Box box=Box.createVerticalBox();
		this.add(box,BorderLayout.CENTER);
		
		sifraText.setPreferredSize(new Dimension(160,20));
		nazivText.setPreferredSize(new Dimension(160,20));
		profText.setPreferredSize(new Dimension(160,20));
		
		JLabel sifraLabel = new JLabel("Sifra*");
		JLabel nazivLabel = new JLabel("Naziv*");
		JLabel semestarLabel = new JLabel("Semestar*");
		JLabel godinaLabel = new JLabel("Godina*");
		JLabel profLabel = new JLabel("Profesor*");
		
		godinaCombo.addItem("1");
		godinaCombo.addItem("2");
		godinaCombo.addItem("3");
		godinaCombo.addItem("4");
		godinaCombo.setSelectedItem(String.valueOf(godina));
		
		if(godina == 1) {
			semestarCombo.addItem("1");
			semestarCombo.addItem("2");
			if(semestar == 1) {
				semestarCombo.setSelectedIndex(0);
			}
			else
				semestarCombo.setSelectedIndex(1);
		}
		else if(godina == 2) {
			semestarCombo.addItem("3");
			semestarCombo.addItem("4");
			if(semestar == 3) {
				semestarCombo.setSelectedIndex(0);
			}
			else
				semestarCombo.setSelectedIndex(1);
		}
		else if(godina == 3) {
			semestarCombo.addItem("5");
			semestarCombo.addItem("6");
			if(semestar == 5) {
				semestarCombo.setSelectedIndex(0);
			}
			else
				semestarCombo.setSelectedIndex(1);
		}
		else if(godina == 4) {
			semestarCombo.addItem("7");
			semestarCombo.addItem("8");
			if(semestar == 7) {
				semestarCombo.setSelectedIndex(0);
			}
			else
				semestarCombo.setSelectedIndex(1);
		}
		else if(godina == 5) {
			semestarCombo.addItem("9");
			semestarCombo.addItem("10");
			if(semestar == 9) {
				semestarCombo.setSelectedIndex(0);
			}
			else
				semestarCombo.setSelectedIndex(1);
		}
		
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
		
		JPanel sifraPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel nazivPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel semestarPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel godinaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel profPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		sifraPanel.add(sifraLabel);
		sifraPanel.add(sifraText);
		box.add(sifraPanel);
		
		nazivPanel.add(nazivLabel);
		nazivPanel.add(nazivText);
		box.add(nazivPanel);
		
		semestarPanel.add(semestarLabel);
		semestarPanel.add(semestarCombo);
		box.add(semestarPanel);
		
		godinaPanel.add(godinaLabel);
		godinaPanel.add(godinaCombo);
		box.add(godinaPanel);
		
		profPanel.add(profLabel);
		profPanel.add(profText);
		box.add(profPanel);
		
		
		JPanel panelBottom = new JPanel();
		JButton buttonPotvrda=new JButton("Potvrda");
		panelBottom.add(buttonPotvrda);
		JButton buttonOdustanak=new JButton("Odustanak");
		panelBottom.add(buttonOdustanak);
		this.add(panelBottom, BorderLayout.SOUTH);
		
		buttonOdustanak.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				//setVisible(false);
				dispose();
			}
		});
		
		buttonPotvrda.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				int sifraPredmeta = 0;
				String nazivPredmeta = "";
				int semestar = 0;
				int godina = 0;
				int brLicne = 0;
				
				try {
					sifraPredmeta = Integer.parseInt(sifraText.getText());
				}catch(Exception e) {
					sifraText.setText("Neispravno uneta sifra!");
				}
				
				try {
					nazivPredmeta = nazivText.getText();
				}catch(Exception e) {
					nazivText.setText("Neispravno unet naziv!");
				}
				
				try {
					brLicne = Integer.parseInt(profText.getText());
				}catch(Exception e) {
					profText.setText("Neispravno unet profesor!");
				}
				
				semestar = Integer.parseInt(semestarCombo.getSelectedItem().toString());
				godina = Integer.parseInt(godinaCombo.getSelectedItem().toString());
				
				Profesor p;
				
				if(sifraPredmeta == 0 || nazivPredmeta.equals("") || semestar == 0 || godina == 0 || brLicne == 0) {
					JOptionPane.showMessageDialog(null, "Niste popunili sva polja!");
				}
				
				else if((p = BazaProfesora.getInstance().getProfesori().findProfesor(brLicne)) == null) {
					JOptionPane.showMessageDialog(null, "Ne postoji profesor sa tom licnom kartom!");
				}
				
				else {
					
					BazaPredmeta.getInstance().getPredmeti().editPredmet(sifraPredmeta,nazivPredmeta,semestar,godina,p);
					
					
					JOptionPane.showMessageDialog(null, "Predmet uspesno izmenjen!");
					setVisible(false);
					Tabela_predmeta.azurirajPrikaz();
				}
			}
		});
		
		box.add(panelBottom);
		
	}
	
}
