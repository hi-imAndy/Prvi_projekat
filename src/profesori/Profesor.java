package profesori;

import java.util.ArrayList;

import osobe.Osoba;
import predmeti.Predmet;

public class Profesor extends Osoba{
	
	private String adresaKancelarije;
	private String brojLicne;
	private String titula;
	private String zvanje;
	private ArrayList<Predmet> predmeti;// spisak predmeta na kojima je profesor
	
	public Profesor(String ime, String prz, String datum, String adr, String tel, String email, String adrKanc, String br, String titula, String zvanje) {
		super(ime,prz,datum,adr,tel,email);
		this.adresaKancelarije = adrKanc;
		this.brojLicne = br;
		this.titula = titula;
		this.zvanje = zvanje;
		this.predmeti = new ArrayList<Predmet>();
	}
	
	public void addPredmet(Predmet p) {
		predmeti.add(p);
	}
	
	public void removePredmet(Predmet p) {
		predmeti.remove(p);
	}
	
	public ArrayList<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(ArrayList<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	public String getAdresaKancelarije() {
		return adresaKancelarije;
	}
	public void setAdresaKancelarije(String adresaKancelarije) {
		this.adresaKancelarije = adresaKancelarije;
	}
	public String getBrojLicne() {
		return brojLicne;
	}
	public void setBrojLicne(String brojLicne) {
		this.brojLicne = brojLicne;
	}
	public String getTitula() {
		return titula;
	}
	public void setTitula(String titula) {
		this.titula = titula;
	}
	public String getZvanje() {
		return zvanje;
	}
	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}
	
	@Override
	public String toString() {
		return String.format("%6s %6s %6s %6s %6s %6s %6s %10s %6s %6s", ime, prezime, datumRodjenja, adresaStanovanja, telefon, email,adresaKancelarije,  brojLicne, titula, zvanje);
	}
}
