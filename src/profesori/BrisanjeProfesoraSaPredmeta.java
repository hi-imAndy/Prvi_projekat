package profesori;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import predmeti.BazaPredmeta;
import predmeti.Predmet;
import predmeti.Tabela_predmeta;
import studenti.Student;

public class BrisanjeProfesoraSaPredmeta extends JDialog{
private static String naziv_predmeta;
	
	public BrisanjeProfesoraSaPredmeta(Frame parent,int selektovani_profesor) {
		super(parent);
		setModal(true);
		setTitle("Lista predmeta za profesora");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double height=screenSize.getHeight();
		double width=screenSize.getWidth();
		height=height*0.2;
		width=width*0.3;
		setBounds(150, 150, (int)width, (int)height);
		
		//int vrsta=Tabela_predmeta.tab.getSelectedRow();
		int vrsta = Tabela_profesora.tab.getSelectedRow();
		
		ArrayList<String> nazivi_predmeta = new ArrayList<String>();
		DefaultListModel<String> predmetilista=new DefaultListModel<String>();
		
		for(Predmet predmet : BazaProfesora.getInstance().getProfesori().getListaProfesora().get(vrsta).getPredmeti()) {
			nazivi_predmeta.add(predmet.getNaziv());
		}
		
		for(String s : nazivi_predmeta) {
			predmetilista.addElement(s);
		}
		
		JList lista=new JList(predmetilista);
		JScrollPane sp=new JScrollPane(lista);
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		Box kutija=Box.createVerticalBox();
		kutija.add(sp);
		
		JPanel panelbottom=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton btnobrisi=new JButton("Obrisi");
		JButton btnnazad=new JButton("Nazad");
		panelbottom.add(btnobrisi);
		panelbottom.add(btnnazad);
		
		btnnazad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}});
		
		btnobrisi.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						int dialogButton=JOptionPane.showConfirmDialog(null, "Da li zelite da obrisete profesora sa predmeta?", "", JOptionPane.YES_NO_OPTION);
						if (dialogButton == JOptionPane.YES_OPTION)
						{
							//Predmet predmet=BazaPredmeta.getInstance().getRow(selektovani_predmet);
							Profesor profesor = BazaProfesora.getInstance().getRow(selektovani_profesor);
							//broj_indeksa=lista.getSelectedValue().toString();
							//BazaPredmeta.getInstance().IzbrisiStudSaPredmeta(broj_indeksa,selektovani_predmet);
							//BazaProfesora.getInstance().obrisiPredmetProfesora(brLicne, p);
							
							naziv_predmeta = lista.getSelectedValue().toString();
							
							BazaProfesora.getInstance().izbrisiPredmetProfesora(profesor.getBrojLicne(), naziv_predmeta);
							
							setVisible(false);
						}
						else if(dialogButton == JOptionPane.NO_OPTION)
						{
							setVisible(false);
						}
					}
				});

		kutija.add(panelbottom,BorderLayout.SOUTH);
		
		this.add(kutija,BorderLayout.CENTER);
	}
}
