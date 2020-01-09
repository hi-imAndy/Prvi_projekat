package predmeti;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

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
		Profesor p = BazaProfesora.getInstance().getProfesori().findProfesor("007198721");
		Profesor p1 = BazaProfesora.getInstance().getProfesori().findProfesor("008431903");
		Profesor p2 = BazaProfesora.getInstance().getProfesori().findProfesor("005671007");
		Profesor p3 = BazaProfesora.getInstance().getProfesori().findProfesor("009999331");
		predmeti.addPredmet("OP301", "Osnove programiranja", 1, 1, p);
		predmeti.addPredmet("DM881", "Diskretna matematika", 3,2, p1);
		predmeti.addPredmet("PP007", "Paralelno programiranje", 5, 3, p2);
		predmeti.addPredmet("RVP33", "Računarstvo visokih performansi",7, 4, p3);
		predmeti.addPredmet("JSD91", "Jezici specifični za domen", 8, 4, null);
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
	
	
	public void IzbrisiStudSaPredmeta(String indeks,int selektovani_predmet)
	{
		
	   for(Student s:predmeti.getListaPredmeta().get(selektovani_predmet).getStudenti())
	   {
		   if(s.getBroj_indeksa().equals(indeks))
		   {
			   predmeti.getListaPredmeta().get(selektovani_predmet).getStudenti().remove(s);
			   break;
			   
		   }
		  
	   }
	   
	   
	   
		
	}
	
	public void DodajStudentaNaPredmet(Student s,int selektovani_predmet)
	{
		
	for(Student st :	predmeti.getListaPredmeta().get(selektovani_predmet).getStudenti()) {
		if(st.getBroj_indeksa().equalsIgnoreCase(s.getBroj_indeksa())) {
			JOptionPane.showMessageDialog(null, "Student vec postoji na predmetu");
			return;
		}
	}
		
		predmeti.getListaPredmeta().get(selektovani_predmet).getStudenti().add(s);
	}
	
}
