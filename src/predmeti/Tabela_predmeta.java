package predmeti;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import glavni_prozor.Kreiranje_entiteta;
import glavni_prozor.MyApp;

public class Tabela_predmeta extends JPanel {
	JTable jTable = new JTable();
	
	public Tabela_predmeta() {
		
		DefaultTableModel model = new DefaultTableModel();
		String[] columns = {"Sifra predmeta","Naziv","Semestar", "Godina studija", "Profesor(Licna karta)"};
		model.setColumnIdentifiers(columns);
		jTable.setModel(model);
		
		String[] data = new String[5];
		int i = 0;
		
			for(Predmet p : Kreiranje_entiteta.listaPredmeta.getPredmeti()) {
				data[0] = String.valueOf(p.getSifraPredmeta());
				data[1] = p.getNaziv();
				data[2] = String.valueOf(p.getSemestar());
				data[3] = String.valueOf(p.getGodinaStudija());
				data[4] = String.valueOf(p.getProfesor().getBrojLicne());
				
				model.addRow(data);
			}
		
		jTable.setPreferredScrollableViewportSize(new Dimension(1000,500));
		jTable.setFillsViewportHeight(true);
		
		JScrollPane jScroll = new JScrollPane(jTable);
		add(jScroll);
	}
}
