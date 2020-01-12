package glavni_prozor;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

import java.util.*;
import java.text.*;
public class TimeFrame extends JFrame implements ActionListener
{
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1226107092955764200L;
	JLabel label;
	  
	  public TimeFrame()
	  {
			SimpleDateFormat sdf = new SimpleDateFormat( "hh:mm dd MMM yyyy" );
		    label = new JLabel( sdf.format( new GregorianCalendar().getTime() ) );
		    label.setHorizontalAlignment( JLabel.RIGHT );
		
		    Timer timer = new Timer( 1000, this );
		    timer.start();
	  }
	  
	  public void actionPerformed( ActionEvent ae )
	  {
			SimpleDateFormat sdf = new SimpleDateFormat( "hh:mm dd MMM yyyy" );
		    label.setText( sdf.format( new GregorianCalendar().getTime() ) );
	  }
	  
	public JLabel getLabel() {
			return label;
	}
	
	public void setLabel(JLabel label) {
			this.label = label;
	}

}