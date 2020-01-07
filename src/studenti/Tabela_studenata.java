package studenti;

import java.awt.Dimension;


import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import glavni_prozor.MyApp;


public class Tabela_studenata extends JPanel {
	
	JTable jTable = new JTable();
	DefaultTableModel model = new DefaultTableModel();
	
	public Tabela_studenata() {
		
		
		String[] columns = {"Ime","Prezime","Broj indeksa", "Adresa", "Telefon", "Godina studija" , "Status studenta" , "Peosečna ocena" , "Datum upisa" , "Datum rođenja" , "Broj telefona","E-mail adresa"};
		model.setColumnIdentifiers(columns);
		jTable.setModel(model);
		
		
		String[] data = new String[12];
		
		
			for(Student p : BazaStudenata.getInstance().getStudenti().getLista_studenata()) {
				data[0] = String.valueOf(p.getIme());
				data[1] = String.valueOf(p.getPrezime());
				data[2] = String.valueOf(p.getBroj_indeksa());
				data[3] = String.valueOf(p.getAdresaStanovanja());
				data[4] = String.valueOf(p.getTelefon());
				data[5] = String.valueOf(p.getGodina_studija());
				data[6] = String.valueOf(p.getStatus());
				data[7] = String.valueOf(p.getProsecna_ocena());
				data[8] = String.valueOf(p.getDatum_upisa());
				data[9] = String.valueOf(p.getDatumRodjenja());
				data[10] = String.valueOf(p.getTelefon());
				data[11] = String.valueOf(p.getEmail());
				
				model.addRow(data);
			}
		
		jTable.setPreferredScrollableViewportSize(new Dimension(1000,500));
		jTable.setFillsViewportHeight(true);
		
		JScrollPane jScroll = new JScrollPane(jTable);
		add(jScroll);
	}
	
	public int getRed() {
		return jTable.getSelectedRow();
	}
	
	
	public DefaultTableModel getModel() {
		return model;
	}

	public JTable getjTable() {
		return jTable;
	}

	public void setjTable(JTable jTable) {
		this.jTable = jTable;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}
	
	
}