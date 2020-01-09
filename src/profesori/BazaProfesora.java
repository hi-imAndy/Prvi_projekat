package profesori;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import predmeti.BazaPredmeta;
import predmeti.ListaPredmeta;
import predmeti.Predmet;


public class BazaProfesora {

	private static BazaProfesora instance = null;

	public static BazaProfesora getInstance() {
		if (instance == null) {
			instance = new BazaProfesora();
		}
		return instance;
	}

	
	ListaProfesora profesori;
	List<String> kolone;
	
	public ListaProfesora getProfesori() {
		return profesori;
	}
	
	public List<String> getKolone(){
		return kolone;
	}
	
	public Profesor getRow(int rowIndex) {
		return this.profesori.getListaProfesora().get(rowIndex);
	}
	
	
	public BazaProfesora() {
		profesori = new ListaProfesora();
		makeProfesori();
		
		kolone = new ArrayList<>();
		
		this.kolone.add("IME"); 
		this.kolone.add("PREZIME");
		this.kolone.add("DATUM RODJENJA");
		this.kolone.add("ADRESA");		
		this.kolone.add("TELEFON");
		this.kolone.add("EMAIL");
		this.kolone.add("ADRESA KANCELARIJE");
		this.kolone.add("BROJ LICNE KARTE");
		this.kolone.add("TITULA");
		this.kolone.add("ZVANJE");
		this.kolone.add("PREDMETI"); 
	}
	
	private void makeProfesori() {
		profesori.addProfesor("Aleksa", "Petković", "15.1.1965.", "Temerinska 15, Novi Sad", "021/334-990", "aleksa.petkovic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, MI 105", "007198721", "Prof.dr", "Redovni profesor");
		profesori.addProfesor("Jana", "Lazarević", "25.02.1963.", "Jovana Cvijića 26, Novi Sad", "021/435-891", "jana.lazarevic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, Nastavni blok 206", "008431903", "Prof.dr", "Redovni profesor");
		profesori.addProfesor("Nađa", "Aleksić", "23.03.1973.", "Gundulićeva 75, Novi Sad", "021/730-172", "nadja.aleksic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP 307", "005671007", "Dr", "Vanredni profesor");
		profesori.addProfesor("Đorđe", "Spasojević", "24.08.1978..", "Šekspirova 44, Novi Sad", "021/514-893", "djordje.spasojevic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, MI 118", "009999331", "Dr", "Vanredni profesor");
		profesori.addProfesor("Elena", "Milenković", "08.11.1985.", "Tolstojeva 52, Novi Sad", "021/834-901", "elena.milenkovic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, Nastavni blok 217", "003330976", "Dr", "Docent");
		profesori.addProfesor("Teodor", "Mladenović", "14.12.1983.", "Jovana Subotića 33, Novi Sad", "021/441-007", "teodor.mladenovic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP M35", "007441998", "Dr", "Docent");
	
		}
	
	public String getValueAt(int row, int column) {
		Profesor prof= profesori.getListaProfesora().get(row);
		switch (column) {
		case 0:
			return prof.getIme();
		case 1:
			return prof.getPrezime();
		case 2:
			return prof.getDatumRodjenja();
		case 3:
			return prof.getAdresaStanovanja();
		case 4:
			 return prof.getTelefon();
		case 5:
			 return prof.getEmail();
		case 6:
			 return prof.getAdresaKancelarije();
		case 7:
			 return String.valueOf(prof.getBrojLicne());
		case 8:
			 return prof.getTitula();
		case 9:
			 return prof.getZvanje();
		case 10:
			 return null;
		default:
			return null;
		}
	}

	public void dodajProfesora(String ime, String prezime,String datumrodj, String adresastan, String kontakt, String mail,
			String adresakanc, String brlk, String titula, String zvanje) {
		for (Profesor i : profesori.getListaProfesora()) {
			if (i.getBrojLicne().equalsIgnoreCase(brlk)) {
				 JOptionPane.showMessageDialog(null, "Profesor mora da ima jedinstven redni broj!");
				 return;
			}
		}
		this.profesori.addProfesor(new Profesor(ime,prezime,datumrodj,adresastan,kontakt,mail,adresakanc,brlk,titula,zvanje));
											
	}
	
    public void izmeniProf(String ime, String prezime,String datumrodj, String adresastan, String l, String mail,
			String adresakanc, String brlk, String titula, String zvanje)
    {
    	ArrayList<Predmet> predmeti=new ArrayList<Predmet>();
    	Profesor p=BazaProfesora.getInstance().getRow(Tabela_profesora.tab.getSelectedRow());
    	p.setIme(ime);
    	p.setPrezime(prezime);
    	p.setDatumRodjenja(datumrodj);
    	p.setAdresaStanovanja(adresastan);
    	p.setTelefon(l);
    	p.setEmail(mail);
    	p.setAdresaKancelarije(adresakanc);
    	p.setBrojLicne(brlk);
    	p.setTitula(titula);
    	p.setZvanje(zvanje);
    	profesori.editProfesor( ime,  prezime, datumrodj,  adresastan,  l,  mail,
			 adresakanc,  brlk,  titula,  zvanje);
    	
    }
	private String adresaKancelarije;
	private int brojLicne;
	private String titula;
	private String zvanje;
    public void izbrisiProfesora(String i) {
  
		for (Profesor p : profesori.getListaProfesora()) {
			if(p.getBrojLicne().equalsIgnoreCase(i)) {
				profesori.deleteProfesor(p.getBrojLicne());
				break;
			}
		}
    }
}
