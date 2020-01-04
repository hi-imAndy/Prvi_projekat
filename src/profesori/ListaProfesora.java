package profesori;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import predmeti.Predmet;


public class ListaProfesora {
	private List<Profesor> profesori;
	
	public ListaProfesora() {
		profesori = new ArrayList<Profesor>();
	}
	
	public List<Profesor> getProfesori(){
		return this.profesori;
	}
	
	public List<Profesor> searchProfesor(String stringIn){
		List<Profesor> returnProfesori = new ArrayList<Profesor>();
		HashMap<String, String> data = new HashMap<String, String>();
		
		String[] podaci = stringIn.split(";");
		
		for(String s : podaci) {
			String[] podatak = s.split(":");
			data.put(podatak[0], podatak[1]);
		}
	
		
		
		return returnProfesori;
	}
	
	public void addProfesorNaPredmet(Predmet predmet, int brLicne) {
		for(Profesor p : profesori) {
			if(p.getBrojLicne() == brLicne) {
				p.addPredmet(predmet);
				break;
			}
		}
	}
	
	public void removeProfesorSaPredmeta(Predmet predmet, int brLicne) {
		for(Profesor p : profesori) {
			if(p.getBrojLicne() == brLicne) {
				p.removePredmet(predmet);
				break;
			}
		}
	}
	
	public void addProfesor(String ime, String prz, String datum, String adr, String tel, String email, String adrKanc, int br, String titula, String zvanje) {
		profesori.add(new Profesor(ime,prz,datum,adr,tel,email,adrKanc,br,titula,zvanje));
	}
	
	public void addProfesor(Profesor p) {
		profesori.add(new Profesor(p.getIme(),p.getPrezime(),p.getDatumRodjenja(),p.getAdresaStanovanja(),p.getTelefon(),p.getEmail(),p.getAdresaKancelarije(),p.getBrojLicne(),p.getTitula(),p.getZvanje()));
	}
	
	public void deleteProfesor(int brLicne) {
		for (Profesor p : profesori) {
			if(brLicne == p.getBrojLicne()) {
				profesori.remove(p);
				break;
			}
		}
	}
	
	public void editProfesor(String ime, String prz, String datum, String adr, String tel, String email, String adrKanc, int br, String titula, String zvanje) {
		for (Profesor p : profesori) {
			if (p.getBrojLicne() == br) {
				p.setIme(ime);
				p.setPrezime(prz);
				p.setDatumRodjenja(datum);
				p.setAdresaStanovanja(adr);
				p.setTelefon(tel);
				p.setEmail(email);
				p.setAdresaKancelarije(adrKanc);
				p.setBrojLicne(br);
				p.setTitula(titula);
				p.setZvanje(zvanje);
			}
		}
	}
	
	public void sortProfesoriPoImenu(int sort) {
		if(sort == 0) {  // rastuce
			for(int i = 0; i < profesori.size() - 1; i++) {
				Profesor p = profesori.get(i);
				for(int j = i + 1; j < profesori.size(); j++) {
					Profesor p1 = profesori.get(j);
					if(p.getIme().compareTo(p1.getIme()) > 0) { // positive value => string1 > string2
						Profesor p2 = profesori.get(i);
						Profesor p3 = profesori.get(j);
						profesori.set(j, p2);
						profesori.set(i, p3);
						p1 = profesori.get(j);
						p = profesori.get(i);
					}
				}
			}
		}
		else {  // opadajuce
			for(int i = 0; i < profesori.size() - 1; i++) {
				Profesor p = profesori.get(i);
				for(int j = i + 1; j < profesori.size(); j++) {
					Profesor p1 = profesori.get(j);
					if(p.getIme().compareTo(p1.getIme()) < 0) { 
						Profesor p2 = profesori.get(i);
						Profesor p3 = profesori.get(j);
						profesori.set(j, p2);
						profesori.set(i, p3);
						p1 = profesori.get(j);
						p = profesori.get(i);
					}
				}
			}
		}
	}
	
	public void sortProfesoriPoPrezimenu(int sort) {
		if(sort == 0) {  // rastuce
			for(int i = 0; i < profesori.size() - 1; i++) {
				Profesor p = profesori.get(i);
				for(int j = i + 1; j < profesori.size(); j++) {
					Profesor p1 = profesori.get(j);
					if(p.getPrezime().compareTo(p1.getPrezime()) > 0) { // positive value => string1 > string2
						Profesor p2 = profesori.get(i);
						Profesor p3 = profesori.get(j);
						profesori.set(j, p2);
						profesori.set(i, p3);
						p1 = profesori.get(j);
						p = profesori.get(i);
					}
				}
			}
		}
		else {  // opadajuce
			for(int i = 0; i < profesori.size() - 1; i++) {
				Profesor p = profesori.get(i);
				for(int j = i + 1; j < profesori.size(); j++) {
					Profesor p1 = profesori.get(j);
					if(p.getPrezime().compareTo(p1.getPrezime()) < 0) { 
						Profesor p2 = profesori.get(i);
						Profesor p3 = profesori.get(j);
						profesori.set(j, p2);
						profesori.set(i, p3);
						p1 = profesori.get(j);
						p = profesori.get(i);
					}
				}
			}
		}
	}
	
	public void sortProfesoriPoDatumu(int sort) {
		if(sort == 0) {  // rastuce
			for(int i = 0; i < profesori.size() - 1; i++) {
				Profesor p = profesori.get(i);
				for(int j = i + 1; j < profesori.size(); j++) {
					Profesor p1 = profesori.get(j);
					if(p.getDatumRodjenja().compareTo(p1.getDatumRodjenja()) > 0) { // positive value => string1 > string2
						Profesor p2 = profesori.get(i);
						Profesor p3 = profesori.get(j);
						profesori.set(j, p2);
						profesori.set(i, p3);
						p1 = profesori.get(j);
						p = profesori.get(i);
					}
				}
			}
		}
		else {  // opadajuce
			for(int i = 0; i < profesori.size() - 1; i++) {
				Profesor p = profesori.get(i);
				for(int j = i + 1; j < profesori.size(); j++) {
					Profesor p1 = profesori.get(j);
					if(p.getDatumRodjenja().compareTo(p1.getDatumRodjenja()) < 0) { 
						Profesor p2 = profesori.get(i);
						Profesor p3 = profesori.get(j);
						profesori.set(j, p2);
						profesori.set(i, p3);
						p1 = profesori.get(j);
						p = profesori.get(i);
					}
				}
			}
		}
	}
	
}
