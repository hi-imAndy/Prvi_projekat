package predmeti;

import profesori.Profesor;

public class Predmet {
	private int sifraPredmeta;
	private String naziv;
	private int semestar;
	private int godinaStudija;
	private Profesor profesor;
	// spisak studenata koji slusaju predmet
	
	public Predmet(int sifra, String naziv, int semestar, int godina, Profesor prof) {
		this.sifraPredmeta = sifra;
		this.naziv = naziv;
		this.semestar = semestar;
		this.godinaStudija = godina;
		this.profesor = prof;
	}
	
	public int getSifraPredmeta() {
		return sifraPredmeta;
	}
	public void setSifraPredmeta(int sifraPredmeta) {
		this.sifraPredmeta = sifraPredmeta;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public int getSemestar() {
		return semestar;
	}
	public void setSemestar(int semestar) {
		this.semestar = semestar;
	}
	public int getGodinaStudija() {
		return godinaStudija;
	}
	public void setGodinaStudija(int godinaStudija) {
		this.godinaStudija = godinaStudija;
	}
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	
	
}
