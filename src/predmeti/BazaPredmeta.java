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
		Profesor p1 = BazaProfesora.getInstance().getProfesori().findProfesor(0743567);
		Profesor p2 = BazaProfesora.getInstance().getProfesori().findProfesor(1456345);
		Profesor p3 = BazaProfesora.getInstance().getProfesori().findProfesor(1536234);
		Profesor p4 = BazaProfesora.getInstance().getProfesori().findProfesor(0734611);
		Profesor p5 = BazaProfesora.getInstance().getProfesori().findProfesor(1893484);
		predmeti.addPredmet(1, "Programski prevodioci", 5, 3, p);
		predmeti.addPredmet(2, "Operativni sistemi", 3,2, p1);
		predmeti.addPredmet(3, "Arhitektura racunara", 2, 1, p2);
		predmeti.addPredmet(4, "Fizika", 1, 2, p3);
		predmeti.addPredmet(5, "Osnove elektrotehnike", 1, 2, p4);
		predmeti.addPredmet(6, "Programski jezici", 1, 1, p5);
		predmeti.addPredmet(7, "Algebra", 1,1, p);
		predmeti.addPredmet(8, "Logicko projektovanje racunara", 2, 1, p1);
		predmeti.addPredmet(9, "Matematicka analiza", 1, 1, p2);
		predmeti.addPredmet(10, "Engleski jezik", 1, 1, p3);
	}
	
	public Predmet getRow(int rowIndex) {
		return predmeti.getListaPredmeta().get(rowIndex);
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
			 return String.valueOf(predmet.getProfesor().getIme() + " " + predmet.getProfesor().getPrezime());
		default:
			return null;
		}
	}
}
