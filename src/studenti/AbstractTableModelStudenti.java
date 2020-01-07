package studenti;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;



public class AbstractTableModelStudenti extends AbstractTableModel { 

	@Override
	public int getRowCount() {
		return BazaStudenata.getInstance().getStudenti().getLista_studenata().size();
	}

	@Override
	public int getColumnCount() {
		return 12;
	}


	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
			return BazaStudenata.getInstance().getValueAt(rowIndex, columnIndex);

	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		super.setValueAt(aValue, rowIndex, columnIndex);
	}
	
	public String getColumnName(int columnIndex) {
		return BazaStudenata.getInstance().getKolone().get(columnIndex); 
	}
}