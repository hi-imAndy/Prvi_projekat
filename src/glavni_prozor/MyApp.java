package glavni_prozor;

import java.awt.BorderLayout;

import predmeti.ListaPredmeta;
import predmeti.Predmet;
import profesori.Profesor;

public class MyApp {
	
	
	public static void main(String[] args) {
		
		Kreiranje_entiteta kreiranje = new Kreiranje_entiteta();
				
		Glavni_prozor prozor = new Glavni_prozor();
		prozor.setVisible(true);
		
	}

}
