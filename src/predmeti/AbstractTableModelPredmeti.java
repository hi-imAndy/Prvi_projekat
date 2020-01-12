package predmeti;


import javax.swing.JPanel;
import javax.swing.table.AbstractTableModel;




public class AbstractTableModelPredmeti extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int getRowCount() {
		return BazaPredmeta.getInstance().getPredmeti().getListaPredmeta().size();
	
	}

	@Override
	public int getColumnCount() {
		return 6;
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex ==5;
	}


	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(columnIndex<5)
			return BazaPredmeta.getInstance().getValueAt(rowIndex, columnIndex);
		else if(columnIndex==5)
			return "Prikazi";
		return null;

	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4: return String.class;
		case 5: return JPanel.class;
		default:
			return null;
		}
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		super.setValueAt(aValue, rowIndex, columnIndex);
	}
	
	public String getColumnName(int columnIndex) {
		return BazaPredmeta.getInstance().getKolone().get(columnIndex);
	}
	
	
	

	public void predmetDodat() {
	
	}
	
	public void predmetUklonjen(int rowIndex) {
		
	}
	
	public void predmetIzmenjen() {
		
	}
	
	public void predmetPronadjen() {
	}
	
}
