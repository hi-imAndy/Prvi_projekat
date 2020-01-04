package studenti;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class StudentiJTable extends JTable{
	private static StudentiJTable instance=null;
	public static StudentiJTable getInstance() {
		if (instance == null) {
			instance = new StudentiJTable();
		}
		return instance;
	}
	public StudentiJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setModel(new AbstractTableModelStudenti());
	}
}
