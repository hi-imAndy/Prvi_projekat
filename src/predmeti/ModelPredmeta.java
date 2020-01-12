package predmeti;

import javax.swing.table.AbstractTableModel;

import studenti.BazaStudenata;
import predmeti.ListaPredmeta;

public class ModelPredmeta extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1688169937715664100L;

	@Override
	public int getRowCount() {
		return BazaPredmeta.getInstance().getPredmeti().getListaPredmeta().size();
	}

	@Override
	public int getColumnCount() {
		return 6;
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
