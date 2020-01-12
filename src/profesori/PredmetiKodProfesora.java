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
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import predmeti.Predmet;

public class PredmetiKodProfesora {
	
	public PredmetiKodProfesora(int row){
	JDialog dijalog=new JDialog(new JFrame(),"Spisak predmeta",true);
	JLabel statusBar=new JLabel();
	dijalog.add(statusBar,BorderLayout.SOUTH);
	statusBar.setPreferredSize(new Dimension(dijalog.getHeight(),25));
	
	
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	double height=screenSize.getHeight();
	double width=screenSize.getWidth();
	height=height*0.3;
	width=width*0.3;
	dijalog.setBounds(150, 150, (int)width, (int)height);
	
	dijalog.setLocationRelativeTo(null); 
	
	JPanel panel=new JPanel();
	panel.setLayout(new GridBagLayout());
	dijalog.add(panel,BorderLayout.CENTER);
	
	String nizPredmeta[]=new String[BazaProfesora.getInstance().getProfesori().getListaProfesora().get(row).getPredmeti().size()];
	for(int i=0;i<BazaProfesora.getInstance().getProfesori().getListaProfesora().get(row).getPredmeti().size();i++)
	{	
		Predmet p=BazaProfesora.getInstance().getProfesori().getListaProfesora().get(row).getPredmeti().get(i);
		nizPredmeta[i]=p.getSifraPredmeta()+", "+p.getNaziv();
	}
		

	
	
		JList lista=new JList(nizPredmeta);
		
	if(nizPredmeta.length==0) {
		JLabel upit=new JLabel( "Nema predmeta.");
		JPanel panel1=new JPanel(new FlowLayout(FlowLayout.CENTER));
		panel1.add(upit);
		dijalog.add(panel1);
	}else {
	JScrollPane sp=new JScrollPane(lista);
	sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	GridBagConstraints gbc=new GridBagConstraints();
	gbc.weightx=115;
	gbc.weighty=115;
	gbc.gridx=0;
	gbc.gridy=0;
	
	panel.add(sp,gbc);
	}
	dijalog.setVisible(true);
	
}
}
