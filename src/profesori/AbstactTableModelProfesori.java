package profesori;

import javax.swing.JPanel;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;


	public class AbstactTableModelProfesori extends AbstractTableModel {

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		@Override
		public int getRowCount() {
			return BazaProfesora.getInstance().getProfesori().getListaProfesora().size();
		}

		@Override
		public int getColumnCount() {
			return 11;
		}
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
			case 10: return JPanel.class;
			default:
				return null;
			}
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

}
