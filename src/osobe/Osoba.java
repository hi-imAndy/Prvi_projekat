package osobe;

public class Osoba {
	protected String ime;
	protected String prezime;
	protected String datumRodjenja;
	protected String adresaStanovanja;
	protected String telefon;
	protected String email;
	
	public Osoba(String ime, String prz, String datum, String adr, String tel, String email) {
		this.ime = ime;
		this.prezime = prz;
		this.datumRodjenja = datum;
		this.adresaStanovanja = adr;
		this.telefon = tel;
		this.email = email;
	}
	
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getDatumRodjenja() {
		return datumRodjenja;
	}
	public void setDatumRodjenja(String datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}
	public String getAdresaStanovanja() {
		return adresaStanovanja;
	}
	public void setAdresaStanovanja(String adresaStanovanja) {
		this.adresaStanovanja = adresaStanovanja;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
