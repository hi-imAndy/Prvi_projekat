package predmeti;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;

import profesori.Profesor;
import studenti.Student;

public class Predmet implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8099708621513640889L;
	private String sifraPredmeta;
	private String naziv;
	private int semestar;
	private int godinaStudija;
	private Profesor profesor;
	private List<Student> studenti;
	
	public Predmet(String sifra, String naziv, int semestar, int godina, Profesor prof) {
		this.sifraPredmeta = sifra;
		this.naziv = naziv;
		this.semestar = semestar;
		this.godinaStudija = godina;
		this.profesor = prof;
		this.studenti = new ArrayList<Student>();
	}
	
	public void removeProfesor() {
		profesor = new Profesor("","","","","","","","","","");
	}
	
	public void addStudent(Student s) {
		studenti.add(s);
	}
	
	
	
	public List<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(List<Student> studenti) {
		this.studenti = studenti;
	}

	public String getSifraPredmeta() {
		return sifraPredmeta;
	}
	public void setSifraPredmeta(String sifraPredmeta) {
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

	@Override
	public String toString() {
		return "Predmet [sifraPredmeta=" + sifraPredmeta + ", naziv=" + naziv + ", semestar=" + semestar
				+ ", godinaStudija=" + godinaStudija + ", profesor=" + profesor.getBrojLicne() + "]";
	}
	
	
}
