package glavni_prozor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Timer;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class Status_bar extends JPanel {

 

    /**
	 * 
	 */
	private static final long serialVersionUID = -83298226513146286L;
	protected JPanel leftPanel;
    protected JPanel rightPanel;


    public Status_bar() {
        createPartControl();
    }

    protected void createPartControl() {    
        setLayout(new BorderLayout());


        JLabel tekst = new JLabel("Studentska služba");
        //-------

        //-------
        leftPanel = new JPanel(new FlowLayout(FlowLayout.LEADING, 5, 3));

        add(leftPanel, BorderLayout.WEST);
        leftPanel.add(tekst);
        leftPanel.setBackground(Color.GRAY);
        
        rightPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING, 5, 3));

        add(rightPanel, BorderLayout.EAST);
        rightPanel.add(new TimeFrame().getLabel());
        rightPanel.setBackground(Color.GRAY);
        setBackground(Color.GRAY);

    }

    public void setLeftComponent(JComponent component) {
        leftPanel.add(component);
    }

    public void addRightComponent(JComponent component) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEADING, 5, 0));
        panel.add(component);
        rightPanel.add(panel);
    }



}