package studenti;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import predmeti.BazaPredmeta;
import predmeti.Tabela_predmeta;



public class Brisanje_studenta extends JDialog{
	public Brisanje_studenta(Frame parent) {
		setModal(true);
	    setTitle("Brisanje Studenta");
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double height=screenSize.getHeight();
		double width=screenSize.getWidth();
		height=height*0.2;
		width=width*0.3;
		setBounds(150, 150, (int)width, (int)height);
	

    	//JLabel upit=new JLabel( "Da li ste sigurni da zelite da obrisete studenta?");
    	
    	JButton potvrda=new JButton("Potvrdi");
    	JButton odustanak=new JButton("Odustanak");
    	
    	
    	Box box=Box.createVerticalBox();
    	JPanel panel1=new JPanel(new FlowLayout(FlowLayout.LEFT));
    	JLabel picLabel = new JLabel(new ImageIcon("images/delete.png"));
		JLabel labela = new JLabel("Indeks studenta*");
		JTextField text = new JTextField();
		text.setPreferredSize(new Dimension(160,20));
		
		panel1.add(labela);
		panel1.add(text);
    	
    	panel1.add(picLabel);
    	//panel1.add(upit);
    	box.add(panel1);
    	JPanel panel2=new JPanel(new FlowLayout(FlowLayout.RIGHT));
    	panel2.add(potvrda);
    	panel2.add(odustanak);
    	box.add(panel2);
    	this.add(box);
    	
    	odustanak.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});
    	
    	potvrda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Student s = BazaStudenata.getInstance().getStudenti().findStudent(text.getText());
				if(s == null) {
					JOptionPane.showMessageDialog(null, "Ne postoji student sa tim indexom!");
				}
				else {
				int vrsta=Tabela_predmeta.tab.getSelectedRow();
				if(vrsta==-1)
					JOptionPane.showMessageDialog(parent, "Morate selektovati studenta da bi mogli da ga obrisete!");
				else
				{
					
					BazaPredmeta.getInstance().IzbrisiStudSaPredmeta(text.getText(),vrsta );
					JOptionPane.showMessageDialog(parent, "Student obrisan!");
					setVisible(false);
					return;
				}
				
			}
			}
		});

}}