package profesori;

import javax.swing.JPanel;
import javax.swing.table.AbstractTableModel;

import predmeti.BazaPredmeta;
import predmeti.ListaPredmeta;
import studenti.BazaStudenata;

public class ModelProfesora extends AbstractTableModel{
	@Override
	public int getRowCount() {
		return BazaProfesora.getInstance().getProfesori().getListaProfesora().size();
	}

	@Override
	public int getColumnCount() {
		return 11;
	}


	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex < 10)
			return BazaProfesora.getInstance().getValueAt(rowIndex, columnIndex);
		else if (columnIndex == 10) {
			  return "Prikazi";
		}
		return null;
	}
	/*
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
		case 10: return JPanel.class;
		default:
			return null;
		}
	}*/
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex == 10;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		super.setValueAt(aValue, rowIndex, columnIndex);
	}
	
	public String getColumnName(int columnIndex) {
		return BazaProfesora.getInstance().getKolone().get(columnIndex);
	}
}
