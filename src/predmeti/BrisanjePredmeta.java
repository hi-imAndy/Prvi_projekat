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

import studenti.StudentiController;

public class BrisanjePredmeta extends JDialog{

	public BrisanjePredmeta(Frame parent) {
		setModal(true);
	    setTitle("Brisanje predmeta");
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double height=screenSize.getHeight();
		double width=screenSize.getWidth();
		height=height*0.2;
		width=width*0.3;
		setBounds(150, 150, (int)width, (int)height);
		
		Box box=Box.createVerticalBox();
		
		JLabel upit = new JLabel("Da li ste sigurni da zelite da obrisete predmet?");
		JButton buttonPotvrda = new JButton("Potvrdi");
		JButton buttonOdustanak = new JButton("Odustani");
		
		JPanel panel1=new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel1.add(upit);
		JPanel panel2=new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel2.add(buttonPotvrda);
		panel2.add(buttonOdustanak);
		
		buttonOdustanak.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				setVisible(false);
			}
		});
		
		buttonPotvrda.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				int row = Tabela_predmeta.tab.getSelectedRow();
				setVisible(false);
				if(row==-1)
					JOptionPane.showMessageDialog(parent, "Nije selektovan niti jedan predmet!");
				else
				{
					Predmet p = BazaPredmeta.getInstance().getRow(row);
					BazaPredmeta.getInstance().getPredmeti().deletePredmet(p.getSifraPredmeta());
					JOptionPane.showMessageDialog(parent, "Uspesno obrisan predmet!");
					Tabela_predmeta.azurirajPrikaz();
					setVisible(false);
				}
			}
		});
		
		box.add(panel1);
		box.add(panel2);
		
		this.add(box);
	}
}
