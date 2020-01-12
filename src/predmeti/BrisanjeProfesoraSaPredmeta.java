package predmeti;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import profesori.BazaProfesora;
import profesori.Profesor;
import profesori.Tabela_profesora;
import studenti.BazaStudenata;
import studenti.Student;

public class BrisanjeProfesoraSaPredmeta extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2152757028573143860L;
	public static JList lista;
	public static DefaultListModel model;
	
	public BrisanjeProfesoraSaPredmeta(String br) {
		setModal(true);
		setTitle("Spisak predmeta");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double height=screenSize.getHeight();
		double width=screenSize.getWidth();
		height=height*0.3;
		width=width*0.2;
		setBounds(150, 150, (int)width, (int)height);
	
		Box box=Box.createVerticalBox();
		
		lista = new JList();
		model = new DefaultListModel();
		
		Profesor prof = BazaProfesora.getInstance().getProfesori().findProfesor(br);
		
		for(Predmet pred : prof.getPredmeti()) {
			model.addElement(pred.getSifraPredmeta());
		}
		lista.setModel(model);
		
		lista.setVisible(true);
		
		JButton btnPotvrda = new JButton("Potvrda");
		JButton btnOdustanak = new JButton("Odustanak");
		JPanel panel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel.add(btnPotvrda);
		panel.add(btnOdustanak);
		panel.setVisible(true);
		
		btnPotvrda.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				
				String sifra = lista.getSelectedValue().toString();
				
				Predmet pred = BazaPredmeta.getInstance().getPredmeti().returnPredmet(sifra);
				
				BazaProfesora.getInstance().getProfesori().removeProfesorSaPredmeta(pred, br);
				
				BazaPredmeta.getInstance().getPredmeti().removeProfesor(sifra);
					
					JOptionPane.showMessageDialog(null, "Profesor uspesno uklonjen sa predmeta!");
					setVisible(false);
				
			}
		});
		
		btnOdustanak.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		box.add(lista);
		box.add(panel);
		
		add(box);
	}
}
