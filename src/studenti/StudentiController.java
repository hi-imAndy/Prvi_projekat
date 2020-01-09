package studenti;

import java.util.List;

import glavni_prozor.Glavni_prozor;
import predmeti.ListaPredmeta;
import predmeti.Predmet;

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
			String datupisa,String tgs,Status_studenta s,double prosek) {
		// izmena modela
		BazaStudenata.getInstance().dodajStudenta(ime,prezime,dr,adresa,telefon,email,brindexa,datupisa,tgs,s,prosek);
		// azuriranje prikaza
		StudentiJTable.azurirajPrikaz();
	}
	
	public void izbrisiStudenta(int rowSelectedIndex) {
		
		 
		Student student = BazaStudenata.getInstance().getRow(rowSelectedIndex);
		BazaStudenata.getInstance().izbrisiStudenta(student.getBroj_indeksa());
		
	StudentiJTable.azurirajPrikaz();
	}

	public void izmeniStudenta(String ime,String prezime,String DatumRodj,String Email,String DatumUpisa,double prosek,String adresa,
			String brtel,String brindexa,String trengodstud,Status_studenta s)
	{
		
		BazaStudenata.getInstance().izmeniStudenta(ime,prezime,DatumRodj,Email,DatumUpisa,prosek,adresa,brtel,brindexa,trengodstud,s);
		StudentiJTable.azurirajPrikaz();
	}

	   public boolean StudentPostoji(String index)
	{
		if(BazaStudenata.getInstance().StudentPostoji(index))
			return true;
		else
			return false;
	}
	   
	public Student VratiStudenta(String index)
	{
		return BazaStudenata.getInstance().VratiStudenta(index);
	}
	
	

	
}