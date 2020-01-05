package glavni_prozor;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import predmeti.Tabela_predmeta;
import profesori.Tabela_profesora;

public class Izbor_Toolbar extends JToolBar implements ActionListener{
	
	private JButton btnStudent;
	private JButton btnProfesor;
	private JButton btnPredmet;
	
	public Izbor_Toolbar() {
		super(SwingConstants.HORIZONTAL);
		
		btnStudent = new JButton();
		btnStudent.setToolTipText("Studenti");
		btnStudent.setText("Studenti");
		add(btnStudent);
		
		btnProfesor = new JButton();
		btnProfesor.setToolTipText("Profesori");
		btnProfesor.setText("Profesori");
		add(btnProfesor);
		
		btnPredmet = new JButton();
		btnPredmet.setToolTipText("Predmeti");
		btnPredmet.setText("Predmeti");
		add(btnPredmet);
		
		setBackground(Color.WHITE);
		setFloatable(false);
		
		btnStudent.addActionListener(this);
		btnProfesor.addActionListener(this);
		btnPredmet.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == btnStudent) {
			Glavni_prozor.tabela_predmeta.setVisible(false);
			Glavni_prozor.tabela_profesora.setVisible(false);
			Glavni_prozor.tabela_studenata.setVisible(true);
		}
		else if(event.getSource() == btnProfesor) {
			Glavni_prozor.tabela_predmeta.setVisible(false);
			Glavni_prozor.tabela_profesora.setVisible(true);
			Glavni_prozor.tabela_studenata.setVisible(false);
		}
		else if(event.getSource() == btnPredmet) {
			Glavni_prozor.tabela_profesora.setVisible(false);
			Glavni_prozor.tabela_predmeta.setVisible(true);
			Glavni_prozor.tabela_studenata.setVisible(false);
		}
	}
	
}
