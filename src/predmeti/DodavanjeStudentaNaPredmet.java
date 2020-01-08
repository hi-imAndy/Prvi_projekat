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

import studenti.BazaStudenata;
import studenti.Student;

public class DodavanjeStudentaNaPredmet extends JDialog{

	public DodavanjeStudentaNaPredmet(Frame parent) {
		setModal(true);
		setTitle("Dodavanje studenta na predmet");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double height=screenSize.getHeight();
		double width=screenSize.getWidth();
		height=height*0.2;
		width=width*0.3;
		setBounds(150, 150, (int)width, (int)height);
	
		Box box=Box.createVerticalBox();
		
		JLabel labela = new JLabel("Indeks studenta*");
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
				String index = "";
				try {
				index = text.getText();
				}catch(Exception e) {
					text.setText("Niste ispravno uneli index");
				}
				
				Student s = BazaStudenata.getInstance().getStudenti().findStudent(index);
				if(s == null) {
					JOptionPane.showMessageDialog(null, "Ne postoji student sa tim indexom!");
				}
				else {
					BazaStudenata.getInstance().getStudenti().dodavanjeStudenta(s.getIme(), s.getPrezime(), s.getDatumRodjenja(), s.getAdresaStanovanja(), s.getTelefon(), s.getEmail(), s.getBroj_indeksa(), s.getDatum_upisa(), s.getGodina_studija(), s.getStatus(), s.getProsecna_ocena());
					JOptionPane.showMessageDialog(parent, "Student uspesno dodat!");
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