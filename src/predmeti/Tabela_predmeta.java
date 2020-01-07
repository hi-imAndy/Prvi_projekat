package predmeti;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import glavni_prozor.Kreiranje_entiteta;
import glavni_prozor.MyApp;
import studenti.AbstractTableModelStudenti;

public class Tabela_predmeta extends JTable {
	private static final long serialVersionUID = 6605108349608778614L;
	private static Tabela_predmeta instance=null;
	public static AbstractTableModel model;
	public static int row=-1;
	public static JTable tab;
	
	public static Tabela_predmeta getInstance() {
		if (instance == null) {
			instance = new Tabela_predmeta(); 
		} 
		return instance;
	}
	public Tabela_predmeta() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setModel(new ModelPredmeta());
		this.setAutoCreateRowSorter(true);
		
		model=(AbstractTableModel) this.getModel();
		this.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				tab=(JTable) e.getComponent();
				if(tab.getSelectedRow()!=-1) {
					row=tab.convertRowIndexToModel(tab.getSelectedRow());
				}
			}
		});
	
	}
	
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		
		if (isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}
	public static void azurirajPrikaz() {		
		model.fireTableDataChanged();
		row=-1;
	}
}
