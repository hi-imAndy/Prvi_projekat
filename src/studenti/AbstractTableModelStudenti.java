package studenti;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.table.AbstractTableModel;





public class AbstractTableModelStudenti extends AbstractTableModel { 

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex == 11;
	}

	@Override
	public int getRowCount() {
		return BazaStudenata.getInstance().getStudenti().getLista_studenata().size();
	}

	@Override
	public int getColumnCount() {
		return 12;
	}

	@Override
	public String getColumnName(int column) {
	
		return BazaStudenata.getInstance().getColumnName(column);
	}

	// da bismo mogli prikazati dugme
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
		case 10: return String.class;
		case 11: return JPanel.class;
		default:
			return null;
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex < 11)
			return BazaStudenata.getInstance().getValueAt(rowIndex, columnIndex);
		else if (columnIndex == 11) {
			  return "Prikazi";
		}
		return null;
	}

}