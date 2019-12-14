package predmeti;

import java.util.ArrayList;

import profesori.Profesor;

public class ListaPredmeta {
	
	private ArrayList<Predmet> predmeti;
	
	
	public ListaPredmeta() {
		this.predmeti = new ArrayList<Predmet>();
	}
	
	public void addPredmet(int sifra, String naziv, int semestar, int godina, Profesor p) {
		predmeti.add(new Predmet(sifra,naziv,semestar,godina,p));
	}
	
	public void deletePredmet(int sif) {
		for (Predmet p : predmeti) {
			if(sif == p.getSifraPredmeta()) {
				predmeti.remove(sif);
				break;
			}
		}
	}
	
	public void editPredmet(int sifra, String naziv, int semestar, int godina, Profesor prof) {
		for (Predmet p : predmeti) {
			if (p.getSifraPredmeta() == sifra) {
				p.setNaziv(naziv);
				p.setSemestar(semestar);
				p.setGodinaStudija(godina);
				p.setProfesor(prof);
			}
		}
	}
	
	
}
