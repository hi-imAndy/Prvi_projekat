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

import glavni_prozor.MojToolbar;
import glavni_prozor.MyApp;

import studenti.AbstractTableModelStudenti;

public class Tabela_predmeta extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5798281842906951158L;
	public static AbstractTableModel model;
	public static int row=-1;
	public static JTable tab;
	public static boolean tableActive = false;
	
	
	private static Tabela_predmeta instance=null;
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
		this.setModel(new AbstractTableModelPredmeti());
		this.setAutoCreateRowSorter(true);
		this.getTableHeader().setReorderingAllowed(false);
		
		model=(AbstractTableModel) this.getModel();
		this.addMouseListener(new MouseAdapter() {
			
				@Override
				public void mouseReleased(MouseEvent e) {
				    tab= (JTable) e.getComponent();
				    if(tab.getSelectedRow()!=-1) {
				    	try {
				        row = tab.convertRowIndexToModel(tab.getSelectedRow());
				        //System.out.println(rowSelectedIndex);
				    }catch (Exception a) {
						
					}
				    }	
				}
				});
	}
	public static void azurirajPrikaz() {		
		model.fireTableDataChanged();
		row=-1;
	}
	
	
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		
		if (isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(Color.WHITE);
		}
		MojToolbar.btnProfesorNaPredmet.setVisible(true);
		MojToolbar.btnStudentNaPredmet.setVisible(true);
		tableActive = true;
		return c;
	}
}
