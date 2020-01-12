package predmeti;

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
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;


import studenti.BazaStudenata;
import studenti.Student;
import studenti.StudentiJTable;

public class Brisanje_studenta_sa_predmeta extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7277023994467752541L;
	private static String broj_indeksa;
	
	public Brisanje_studenta_sa_predmeta(Frame parent,int selektovani_predmet) {
		super(parent);
		setModal(true);
		setTitle("Lista studenata na predmetu");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double height=screenSize.getHeight();
		double width=screenSize.getWidth();
		height=height*0.2;
		width=width*0.3;
		setBounds(150, 150, (int)width, (int)height);
	
		Box box=Box.createVerticalBox();
		
		int vrsta=Tabela_predmeta.tab.getSelectedRow();
		
		ArrayList<String> indeksi = new ArrayList<String>();
		DefaultListModel<String> indeksilista=new DefaultListModel<String>();
		
		for(Student student : BazaPredmeta.getInstance().getPredmeti().getListaPredmeta().get(vrsta).getStudenti()) {
			indeksi.add(student.getBroj_indeksa());
		}
		for(String s : indeksi) {
			indeksilista.addElement(s);
		}
		
		
		JList lista=new JList(indeksilista);
		
		JScrollPane sp=new JScrollPane(lista);
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		
		
		Box kutija=Box.createVerticalBox();
		kutija.add(sp);
		
		JPanel panelbottom=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton btnobrisi=new JButton("Obrisi");
		JButton btnnazad=new JButton("Nazad");
		panelbottom.add(btnobrisi);
		panelbottom.add(btnnazad);
		
		btnobrisi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				
				
				
				btnnazad.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
						
					}
				});
				
				btnobrisi.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						int dialogButton=JOptionPane.showConfirmDialog(null, "Student će biti obrisan", "", JOptionPane.YES_NO_OPTION);
						
						
						if (dialogButton == JOptionPane.YES_OPTION)
						{
							Predmet predmet=BazaPredmeta.getInstance().getRow(selektovani_predmet);
							broj_indeksa=lista.getSelectedValue().toString();
							BazaPredmeta.getInstance().IzbrisiStudSaPredmeta(broj_indeksa,selektovani_predmet);
							setVisible(false);
						}
						else if(dialogButton == JOptionPane.NO_OPTION)
						{
							setVisible(false);
							parent.setVisible(false);
						}
						
						
					}
				});


				
			}

		});
		kutija.add(panelbottom,BorderLayout.SOUTH);
		
		this.add(kutija,BorderLayout.CENTER);
		

	}
}
