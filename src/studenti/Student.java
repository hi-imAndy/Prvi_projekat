package studenti;
import java.util.*;


import osobe.Osoba;
import predmeti.ListaPredmeta;
import predmeti.Predmet;
import profesori.Profesor;

public class Student extends Osoba{

	ListaPredmeta lista_predmeta;
	String broj_indeksa;
	String datum_upisa;
	String godina_studija;
	Status_studenta status;
	double prosecna_ocena;
	
	public Student(String ime, String prezime, String datum_rodjenja, String adresa_stanovanja, String kontakt_telefon,
			String email_adresa, String broj_indeksa, String datum_upisa, String trenutna_godina_studija, Status_studenta status,
			double prosecna_ocena) {
		super(ime, prezime,  datum_rodjenja,  adresa_stanovanja,  kontakt_telefon,  email_adresa);

		this.broj_indeksa = broj_indeksa;
		this.datum_upisa = datum_upisa;
		godina_studija = trenutna_godina_studija;
		this.status = status;
		this.prosecna_ocena = prosecna_ocena;
		
		lista_predmeta = new ListaPredmeta();
	}



	public ListaPredmeta getLista_predmeta() {
		return lista_predmeta;
	}



	public void setLista_predmeta(ListaPredmeta lista_predmeta) {
		this.lista_predmeta = lista_predmeta;
	}



	public String getBroj_indeksa() {
		return broj_indeksa;
	}

	public void setBroj_indeksa(String broj_indeksa) {
		this.broj_indeksa = broj_indeksa;
	}

	public String getDatum_upisa() {
		return datum_upisa;
	}

	public void setDatum_upisa(String datum_upisa) {
		this.datum_upisa = datum_upisa;
	}

	public String getGodina_studija() {
		return godina_studija;
	}

	public void setGodina_studija(String godina_studija) {
		this.godina_studija = godina_studija;
	}

	public Status_studenta getStatus() {
		return status;
	}

	public void setStatus(Status_studenta status) {
		this.status = status;
	}

	public double getProsecna_ocena() {
		return prosecna_ocena;
	}

	public void setProsecna_ocena(double prosecna_ocena) {
		this.prosecna_ocena = prosecna_ocena;
	}

	void addPredmet(String sifra, String naziv, int semestar, int godina, Profesor prof) {
		lista_predmeta.addPredmet(sifra, naziv, semestar, godina, prof);
	}
	
	void removePredmet(String sif) {
		lista_predmeta.deletePredmet(sif);
	}
	
	public String toString() {
		String pV = "";
		pV += getIme() + " " + getPrezime() + "\n" + getDatumRodjenja() + "\n" + getAdresaStanovanja() + " "  + getTelefon() + " "  + getEmail() +  "\n"
				+ broj_indeksa + " " + datum_upisa + godina_studija + " " + status + "\n" + prosecna_ocena + "\n" ;

		return pV;
		
	}
	

	
	

}
