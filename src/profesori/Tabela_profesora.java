package profesori;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import glavni_prozor.Kreiranje_entiteta;
import predmeti.Predmet;

public class Tabela_profesora extends JPanel{

JTable jTable = new JTable();
	
	public Tabela_profesora() {
		
		DefaultTableModel model = new DefaultTableModel();
		String[] columns = {"Ime","Prezime","Datum rodjenja", "Adresa", "Telefon", "E-mail","Adresa kancelarije", "Licna karta","Titula","Zvanje"};
		model.setColumnIdentifiers(columns);
		jTable.setModel(model);
		
		String[] data = new String[10];
		int i = 0;
		
			for(Profesor p : Kreiranje_entiteta.listaProfesora.getProfesori()) {
				data[0] = p.getIme();
				data[1] = p.getPrezime();
				data[2] = p.getDatumRodjenja();
				data[3] = p.getAdresaStanovanja();
				data[4] = p.getTelefon();
				data[5] = p.getEmail();
				data[6] = p.getAdresaKancelarije();
				data[7] = String.valueOf(p.getBrojLicne());
				data[8] = p.getTitula();
				data[9] = p.getZvanje();
				
				model.addRow(data);
			}
		
		jTable.setPreferredScrollableViewportSize(new Dimension(1000,500));
		jTable.setFillsViewportHeight(true);
		
		JScrollPane jScroll = new JScrollPane(jTable);
		add(jScroll);
	}
	
}
