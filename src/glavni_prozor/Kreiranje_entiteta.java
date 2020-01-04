package glavni_prozor;

import predmeti.ListaPredmeta;
import predmeti.Predmet;
import profesori.ListaProfesora;
import profesori.Profesor;

public class Kreiranje_entiteta {

	public static ListaPredmeta listaPredmeta = new ListaPredmeta();
	public static ListaProfesora listaProfesora = new ListaProfesora();
	
	public Kreiranje_entiteta() {
		Profesor prof1 = new Profesor("Milan", "Milanovic", "10.4.1970.", "Partizanska 21 Backa Palanka", "021/6045-789", "milanmilanovic@gmail.com", "Bul. Cara Lazara 34", 0654345, "Dipl.dr. racunarstva i automatike", "Vanredni profesor");
		Profesor prof2 = new Profesor("Luka", "Lukovic", "14.12.1976.", "Bul. Evrope 25", "021/6045-123", "lukalukovic@gmail.com", "Bul. Cara Lazara 34", 0743567, "Dipl.dr. racunarstva i automatike", "Redovni profesor");
		Predmet p1 = new Predmet(1,"Programski prevodioci",5,3,prof1);
		Predmet p2 = new Predmet(2,"Operativni sistemi",3,2,prof1);
		
		listaPredmeta.addPredmet(p1);
		listaPredmeta.addPredmet(p2);
		
		listaProfesora.addProfesor(prof1);
		listaProfesora.addProfesor(prof2);
	}
	
	
	
}
