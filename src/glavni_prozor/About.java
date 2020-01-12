package glavni_prozor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class About extends JDialog{
	
	public About() {
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension ScreenSize=kit.getScreenSize();
	int sh=ScreenSize.height;
	setSize(700,sh/2);
	setLocationRelativeTo(null);
	setTitle("About");
	ImageIcon helpIcon=new ImageIcon("images/help_icon.png");
	setIconImage(helpIcon.getImage());
	JPanel panel=new JPanel(new FlowLayout(FlowLayout.CENTER));
	JPanel paneld=new JPanel(new FlowLayout(FlowLayout.RIGHT));
	JButton dugmezatvori=new JButton("Zatvori");
	
	
	paneld.add(dugmezatvori);
	getContentPane().add(paneld,BorderLayout.SOUTH);
	
	dugmezatvori.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			
		}
	});
	JTextArea helpdijalog=new JTextArea(20,20);
	helpdijalog.setEditable(false);
	helpdijalog.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 15));
	helpdijalog.setText("\n"
					   + "Апликацију израдили Алекса Реповић и Андреј Хложан.\n\n"
					   + "Ова апликација представља симулацију студентске службе."
					   + "Израђена је као пројектни задатак\n"
					   + "за предмет Основи информационих система и софтверског инжињерства"

					   + "\n\n\n\t\t\t\tДатум завршетка радова: 12.1.2020.");
	getContentPane().add(helpdijalog);

}}
