package profesori;

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
			return BazaProfesora.getInstance().getValueAt(rowIndex, columnIndex);
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		super.setValueAt(aValue, rowIndex, columnIndex);
	}
	
	public String getColumnName(int columnIndex) {
		return BazaProfesora.getInstance().getKolone().get(columnIndex);
	}
}
