package glavni_prozor;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.text.JTextComponent;

public class Help extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1723815505962782394L;

	public Help()
	{
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension ScreenSize=kit.getScreenSize();
		int sh=ScreenSize.height;
		setSize(700,sh/2);
		setLocationRelativeTo(null);
		setTitle("Help");
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
		helpdijalog.setText("Апликација служи за олакшање урављања студентском службом факултета.\n"
				+ "Садржи податке о предметима,студентима и професорима.\nАпликација подржава додавање,брисање,измену већ постојећих података \n"
				+ " и претрагу студената,професора или предмета.\n\n"
				+ "Пречице (у зависности од селектооване табеле) :\n\n"
				+ "Додавање студента,професора или предмета CTRL+N\n"
				+ "Измена студента/професора/предемта         CTRL+E\n"
				+ "Брисање студента/професора/предмета       CTRL+D\n"
				+ "Информације о програму  CTRL+A\n"
				+ "Излазак                                  CTRL+C\n");
		getContentPane().add(helpdijalog);

	}
	
}
