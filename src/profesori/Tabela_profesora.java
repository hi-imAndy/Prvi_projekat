package profesori;


import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

import glavni_prozor.MojToolbar;

public class Tabela_profesora extends JTable{

	private static final long serialVersionUID = 6605108349608778614L;
	private static Tabela_profesora instance=null;
	public static AbstractTableModel model;
	public static int row=-1;
	public static JTable tab;
	
	public static Tabela_profesora getInstance() {
		if (instance == null) {
			instance = new Tabela_profesora();
		}
		return instance;
	}
	private Tabela_profesora() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstactTableModelProfesori());
		this.setAutoCreateRowSorter(true);
		this.getTableHeader().setReorderingAllowed(false);
		
		model=(AbstractTableModel) this.getModel();
	
		this.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				tab=(JTable) e.getComponent();
				if(tab.getSelectedRow()!=-1) {
					try {
					row=tab.convertRowIndexToModel(tab.getSelectedRow());
				}catch (Exception e2) {
					// TODO: handle exception
				}
				}
			}
		});
	
	}
		public static void azurirajPrikaz() {		
		model.fireTableDataChanged();
		row=-1;
	}
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		
		if (isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(Color.WHITE);
		}
		MojToolbar.btnProfesorNaPredmet.setVisible(false);
		MojToolbar.btnStudentNaPredmet.setVisible(false);
		return c;
	}

}