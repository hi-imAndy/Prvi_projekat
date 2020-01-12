package profesori;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.JDialog;
import javax.swing.JList;

import studenti.BazaStudenata;

public class PredmetiKodProfesora extends JDialog{
	
	public PredmetiKodProfesora( int row){
		setTitle("Dodavanje predmeta");
		setBackground(Color.GREEN);
		setModal(true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double height=screenSize.getHeight();
		double width=screenSize.getWidth();
		height=height*0.3;
		width=width*0.3;
		setBounds(100, 100, (int)width, (int)height);
		
		Box box=Box.createVerticalBox();
		
		int size = BazaProfesora.getInstance().getProfesori().getListaProfesora().get(row).getPredmeti().size();
		String nizProfesora[] = new String[size];
		
		for(int i=0; i<size; i++)
		{
			nizProfesora[i] = BazaProfesora.getInstance().getProfesori().getListaProfesora().get(row).getPredmeti().get(i).getNaziv();
		}
		
		JList lista = new JList(nizProfesora);
		
		box.add(lista);
		
		this.add(box,BorderLayout.CENTER);
	}
}
