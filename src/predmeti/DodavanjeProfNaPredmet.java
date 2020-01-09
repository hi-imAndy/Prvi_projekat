package predmeti;

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

import profesori.BazaProfesora;
import profesori.Profesor;
import studenti.BazaStudenata;
import studenti.Student;

public class DodavanjeProfNaPredmet extends JDialog{
	public DodavanjeProfNaPredmet(Frame parent) {
		setModal(true);
		setTitle("Dodavanje profesora na predmet");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double height=screenSize.getHeight();
		double width=screenSize.getWidth();
		height=height*0.2;
		width=width*0.3;
		setBounds(150, 150, (int)width, (int)height);
	
		Box box=Box.createVerticalBox();
		
		JLabel labela = new JLabel("Broj licne karte profesora*");
		JTextField text = new JTextField();
		text.setPreferredSize(new Dimension(160,20));
		
		JPanel panel1=new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel1.add(labela);
		panel1.add(text);
		
		JButton btnPotvrda = new JButton("Potvrda");
		JButton btnOdustanak = new JButton("Odustanak");
		JPanel panel2=new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel2.add(btnPotvrda);
		panel2.add(btnOdustanak);
		
		btnPotvrda.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				String brLicne = "";
				try {
				brLicne = text.getText();
				}catch(Exception e) {
					text.setText("Niste ispravno uneli index");
				}
				
				
				int vrsta=Tabela_predmeta.tab.getSelectedRow();
				
				Profesor p = BazaProfesora.getInstance().getProfesori().findProfesor(brLicne);
				if(p == null) {
					JOptionPane.showMessageDialog(null, "Ne postoji profesor sa tom licnom kartom!");
				}
				else {
					BazaPredmeta.getInstance().dodajProfesoraNaPredmet(p, vrsta);
					//BazaPredmeta.getInstance().DodajStudentaNaPredmet(new Student(s.getIme(), s.getPrezime(),
							//s.getDatumRodjenja(), s.getAdresaStanovanja(), s.getTelefon(),
							//s.getEmail(), s.getBroj_indeksa(), s.getDatum_upisa(), s.getGodina_studija(), s.getStatus(), s.getProsecna_ocena()), vrsta);
					
					JOptionPane.showMessageDialog(parent, "Profesor uspesno dodat na predmet!");
					setVisible(false);
				}
				
				
			}
		});
		
		btnOdustanak.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		box.add(panel1);
		box.add(panel2);
		
		add(box);
	}
}
