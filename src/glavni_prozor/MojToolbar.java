package glavni_prozor;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import studenti.Dodavanje_studenta;

public class MojToolbar extends JToolBar{
	
	public MojToolbar(Frame parent) {
	super(SwingConstants.HORIZONTAL);
	
	JButton btnCreate = new JButton();
	btnCreate.setToolTipText("Create");
	btnCreate.setIcon(new ImageIcon("slike/createImg2.jpg"));
	add(btnCreate);
	
	btnCreate.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			//if(TabbedPane.getInstance().getSelectedIndex()==1) {
				Dodavanje_studenta dodavanje_studenta_dijalog=new Dodavanje_studenta(parent);
				dodavanje_studenta_dijalog.setVisible(true);
		//	}
			//else
				
			
		}
	});
	
	
	//btnCreate.addActionListener(new HandleActionListener());
	//addSeparator();
	
	JButton btnEdit = new JButton();
	btnEdit.setToolTipText("Edit");
	btnEdit.setIcon(new ImageIcon("slike/edit_pic2.png"));
	add(btnEdit);

	//addSeparator();
	
	
	JButton btnDelete = new JButton();
	btnDelete.setToolTipText("Delete");
	btnDelete.setIcon(new ImageIcon("slike/delete_img2.png"));
	add(btnDelete);
	
	JSeparator toolBarSeparator = new JToolBar.Separator();
	
	for(int i = 0; i < 80; i++)
		addSeparator();
	
	JTextField textField = new JTextField(30);
	add(textField);
	
	//addSeparator();
	
	JButton btnSearch = new JButton();
	btnSearch.setToolTipText("Search");
	btnSearch.setIcon(new ImageIcon("slike/search_icon2.png"));
	
	add(btnSearch); 
	
	setBackground(Color.LIGHT_GRAY);
	setFloatable(false);
	
	}
}
