package predmeti;

import java.util.ArrayList;
import java.util.List;

import profesori.BazaProfesora;
import profesori.Profesor;
import studenti.BazaStudenata;
import studenti.ListaStudenata;
import studenti.Status_studenta;
import studenti.Student;
import studenti.StudentiJTable;

public class BazaPredmeta {

	private static BazaPredmeta instance = null;

	public static BazaPredmeta getInstance() {
		if (instance == null) {
			instance = new BazaPredmeta();
		}
		return instance;
	}

	
	ListaPredmeta predmeti;
	List<String> kolone;
	
	public ListaPredmeta getPredmeti() {
		return predmeti;
	}
	
	public List<String> getKolone(){
		return kolone;
	}
	
	public BazaPredmeta() {
		predmeti = new ListaPredmeta();
		makePredmeti();
		
		kolone = new ArrayList<>();
		kolone.add("SIFRA");
		kolone.add("NAZIV");
		kolone.add("SEMESTAR");
		kolone.add("GODINA");
		kolone.add("PROFESOR");
		kolone.add("STUDENTI");
	}
	
	private void makePredmeti() {
		Profesor p = BazaProfesora.getInstance().getProfesori().findProfesor(0654345);
		predmeti.addPredmet(1, "Programski prevodioci", 5, 3, p);
		predmeti.addPredmet(1, "Programski prevodioci", 5, 3, p);
		predmeti.addPredmet(1, "Programski prevodioci", 5, 3, p);
		predmeti.addPredmet(1, "Programski prevodioci", 5, 3, p);
		predmeti.addPredmet(1, "Programski prevodioci", 5, 3, p);
	}
	
	public String getValueAt(int row, int column) {
		Predmet predmet= this.predmeti.getListaPredmeta().get(row);
		switch (column) {
		case 0:
			return String.valueOf(predmet.getSifraPredmeta());
		case 1:
			return predmet.getNaziv();
		case 2:
			return String.valueOf(predmet.getSemestar());
		case 3:
			return String.valueOf(predmet.getGodinaStudija());
		case 4:
			 return String.valueOf(predmet.getProfesor().getBrojLicne());
		default:
			return null;
		}
	}
}
