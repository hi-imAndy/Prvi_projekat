package studenti;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;


public class StudentiMouseListener extends MouseAdapter {
	
	private JTable tabela;
	
	public StudentiMouseListener(JTable tabela_stud)
	{
		this.tabela=tabela_stud;
	}
	
	public void mouseClicked(MouseEvent e)
	{
		Point point=e.getPoint();
		int column=tabela.columnAtPoint(point);
		int row=tabela.rowAtPoint(point);
		int row1=StudentiJTable.getInstance().getRowSorter().convertRowIndexToModel(row);
		
		if(column==11)
		{
			JDialog dijalog=new JDialog(new JFrame(),"Spisak predmeta",true);
			JLabel statusBar=new JLabel();
			dijalog.add(statusBar,BorderLayout.SOUTH);
			statusBar.setPreferredSize(new Dimension(dijalog.getHeight(),25));
			
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			double height=screenSize.getHeight();
			double width=screenSize.getWidth();
			height=height*0.3;
			width=width*0.3;
			dijalog.setBounds(150, 150, (int)width, (int)height);
			
			JPanel panel=new JPanel();
			panel.setLayout(new GridBagLayout());
			dijalog.add(panel,BorderLayout.CENTER);
			
			String nizPredmeta[]=new String[BazaStudenata.getInstance().getStudenti().getLista_studenata().get(row).getLista_predmeta().getListaPredmeta().size()];
			for(int i=0;i<BazaStudenata.getInstance().getStudenti().getLista_studenata().get(row).getLista_predmeta().getListaPredmeta().size();i++)
			{
				nizPredmeta[i]=BazaStudenata.getInstance().getStudenti().getLista_studenata().get(row).getLista_predmeta().getListaPredmeta().get(i).getNaziv();
			}
			
			JList lista=new JList(nizPredmeta);
			
			JScrollPane sp=new JScrollPane(lista);
			sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			GridBagConstraints gbc=new GridBagConstraints();
			gbc.weightx=115;
			gbc.weighty=115;
			gbc.gridx=0;
			gbc.gridy=0;
			
			panel.add(sp,gbc);
			dijalog.setVisible(true);
			
		}
	}

}
