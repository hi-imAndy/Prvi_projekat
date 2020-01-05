package studenti;

import java.util.List;

import glavni_prozor.Glavni_prozor;
import predmeti.ListaPredmeta;
import studenti.Status_studenta;

public class StudentiController {

	private static StudentiController instance = null;
	
	public static StudentiController getInstance() {
		if (instance == null) {
			instance = new StudentiController();
		}
		return instance;
	}
	
	private StudentiController() {}
	
	public void dodajStudenta(String ime,String prezime,String dr,String adresa,String telefon,String email,String brindexa,
			String datupisa,String tgs,Status_studenta s,float prosek,ListaPredmeta predmeti) {
		// izmena modela
		BazaStudenata.getInstance().dodajStudenta(ime,prezime,dr,adresa,telefon,email,brindexa,datupisa,tgs,s,prosek);
		// azuriranje prikaza
	//	Glavni_prozor.getInstance().azurirajPrikaz();
	}}
