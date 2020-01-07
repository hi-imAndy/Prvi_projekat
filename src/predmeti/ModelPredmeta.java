package predmeti;

import javax.swing.table.AbstractTableModel;

import studenti.BazaStudenata;
import predmeti.ListaPredmeta;

public class ModelPredmeta extends AbstractTableModel{
	@Override
	public int getRowCount() {
		return BazaPredmeta.getInstance().getPredmeti().getListaPredmeta().size();
	}

	@Override
	public int getColumnCount() {
		return 5;
	}


	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
			return BazaPredmeta.getInstance().getValueAt(rowIndex, columnIndex);
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		super.setValueAt(aValue, rowIndex, columnIndex);
	}
	
	public String getColumnName(int columnIndex) {
		return BazaPredmeta.getInstance().getKolone().get(columnIndex);
	}
}
