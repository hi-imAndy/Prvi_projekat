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
		profesori.addProfesor("Milan", "Milanovic", "10.4.1970.", "Partizanska 21 Backa Palanka", "021/6045-789", "milanmilanovic@gmail.com", "Bul. Cara Lazara 34", 0654345, "Dipl.dr. racunarstva i automatike", "Vanredni profesor");
		profesori.addProfesor("Luka", "Lukovic", "14.12.1976.", "Bul. Evrope 25", "021/6045-123", "lukalukovic@gmail.com", "Bul. Cara Lazara 34", 0743567, "Dipl.dr. racunarstva i automatike", "Redovni profesor");
		profesori.addProfesor("Milan", "Milanovic", "10.4.1970.", "Partizanska 21 Backa Palanka", "021/6045-789", "milanmilanovic@gmail.com", "Bul. Cara Lazara 34", 0654345, "Dipl.dr. racunarstva i automatike", "Vanredni profesor");
		profesori.addProfesor("Luka", "Lukovic", "14.12.1976.", "Bul. Evrope 25", "021/6045-123", "lukalukovic@gmail.com", "Bul. Cara Lazara 34", 0743567, "Dipl.dr. racunarstva i automatike", "Redovni profesor");
		profesori.addProfesor("Milan", "Milanovic", "10.4.1970.", "Partizanska 21 Backa Palanka", "021/6045-789", "milanmilanovic@gmail.com", "Bul. Cara Lazara 34", 0654345, "Dipl.dr. racunarstva i automatike", "Vanredni profesor");
		profesori.addProfesor("Luka", "Lukovic", "14.12.1976.", "Bul. Evrope 25", "021/6045-123", "lukalukovic@gmail.com", "Bul. Cara Lazara 34", 0743567, "Dipl.dr. racunarstva i automatike", "Redovni profesor");
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
			String adresakanc, int brlk, String titula, String zvanje) {
		for (Profesor i : profesori.getListaProfesora()) {
			if (i.getBrojLicne()==brlk) {
				 JOptionPane.showMessageDialog(null, "Profesor mora da ima jedinstven redni broj!");
				 return;
			}
		}
		this.profesori.addProfesor(new Profesor(ime,prezime,datumrodj,adresastan,kontakt,mail,adresakanc,brlk,titula,zvanje));
											
	}
	
    public void izmeniProf(String ime, String prezime,String datumrodj, String adresastan, String l, String mail,
			String adresakanc, int brlk, String titula, String zvanje)
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
    public void izbrisiProfesora(int i) {
  
		for (Profesor p : profesori.getListaProfesora()) {
			if(p.getBrojLicne()==i) {
				profesori.deleteProfesor(p.getBrojLicne());
				break;
			}
		}
    }
}
