package profesori;

import java.util.ArrayList;

import osobe.Osoba;
import predmeti.Predmet;

public class Profesor extends Osoba{
	
	private String adresaKancelarije;
	private int brojLicne;
	private String titula;
	private String zvanje;
	private ArrayList<Predmet> predmeti;// spisak predmeta na kojima je profesor
	
	public Profesor(String ime, String prz, String datum, String adr, String tel, String email, String adrKanc, int br, String titula, String zvanje) {
		super(ime,prz,datum,adr,tel,email);
		this.adresaKancelarije = adrKanc;
		this.brojLicne = br;
		this.titula = titula;
		this.zvanje = zvanje;
		this.predmeti = new ArrayList<Predmet>();
	}
	
	public String getAdresaKancelarije() {
		return adresaKancelarije;
	}
	public void setAdresaKancelarije(String adresaKancelarije) {
		this.adresaKancelarije = adresaKancelarije;
	}
	public int getBrojLicne() {
		return brojLicne;
	}
	public void setBrojLicne(int brojLicne) {
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
}
