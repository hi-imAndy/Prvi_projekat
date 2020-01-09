package predmeti;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import profesori.Profesor;
import studenti.BazaStudenata;
import studenti.Student;

public class ListaPredmeta {
	
	private List<Predmet> predmeti;
	
	public ListaPredmeta() {
		predmeti = new ArrayList<Predmet>();
	}
	
	public List<Predmet> getListaPredmeta(){
		return predmeti;
	}
	
	public List<Predmet> searchPredmet(String stringIn){
		List<Predmet> returnProfesori = new ArrayList<Predmet>();
		HashMap<String, String> data = new HashMap<String, String>();
		
		String[] podaci = stringIn.split(";");
		
		for(String s : podaci) {
			String[] podatak = s.split(":");
			data.put(podatak[0], podatak[1]);
		}
	
		
		
		return returnProfesori;
	}
	
	public void addPredmet(String sifra, String naziv, int semestar, int godina, Profesor prof) {
		if(prof == null) {
			prof = new Profesor("","","","","","","","","","");
		}
		predmeti.add(new Predmet(sifra,naziv,semestar,godina,prof));
	}
	
	public void addPredmet(Predmet p) {
		predmeti.add(new Predmet(p.getSifraPredmeta(),p.getNaziv(),p.getSemestar(),p.getGodinaStudija(),p.getProfesor()));
	}
	
	public boolean findPredmet(String sifra) {
		for(Predmet p : predmeti) {
			if(sifra.equals(p.getSifraPredmeta())) {
				return true;
			}
		}
		return false;
	}
	
	public void deletePredmet(String sif) {
		for (Predmet p : predmeti) {
			if(sif.equals(p.getSifraPredmeta())) {
				predmeti.remove(p);
				break;
			}
		}
	}
	
	public void editPredmet(String sifra, String naziv, int semestar, int godina, Profesor prof) {
		for (Predmet p : predmeti) {
			if (p.getSifraPredmeta().equalsIgnoreCase(sifra)) {
				p.setNaziv(naziv);
				p.setSemestar(semestar);
				p.setGodinaStudija(godina);
				p.setProfesor(prof);
			}
		}
	}
	/*
	public void sortPredmetiPoSifri(int sort) {
		if(sort == 0) {  // rastuce
			for(int i = 0; i < predmeti.size() - 1; i++) {
				Predmet p = predmeti.get(i);
				for(int j = i + 1; j < predmeti.size(); j++) {
					Predmet p1 = predmeti.get(j);
					if(p1.getSifraPredmeta().compareTo(p.getSifraPredmeta() < 1) {
						Predmet p2 = predmeti.get(i);
						Predmet p3 = predmeti.get(j);
						predmeti.set(j, p2);
						predmeti.set(i, p3);
						p1 = predmeti.get(j);
						p = predmeti.get(i);
					}
				}
			}
		}
		else {  // opadajuce
			for(int i = 0; i < predmeti.size() - 1; i++) {
				Predmet p = predmeti.get(i);
				for(int j = i + 1; j < predmeti.size(); j++) {
					Predmet p1 = predmeti.get(j);
					if(p1.getSifraPredmeta() > p.getSifraPredmeta()) {
						Predmet p2 = predmeti.get(i);
						Predmet p3 = predmeti.get(j);
						predmeti.set(j, p2);
						predmeti.set(i, p3);
						p1 = predmeti.get(j);
						p = predmeti.get(i);
					}
				}
			}
		}
	}
	
	public void sortPredmetiPoNazivu(int sort) {
		if(sort == 0) {  // rastuce
			for(int i = 0; i < predmeti.size() - 1; i++) {
				Predmet p = predmeti.get(i);
				for(int j = i + 1; j < predmeti.size(); j++) {
					Predmet p1 = predmeti.get(j);
					if(p.getNaziv().compareTo(p1.getNaziv()) > 0) { // positive value => string1 > string2
						Predmet p2 = predmeti.get(i);
						Predmet p3 = predmeti.get(j);
						predmeti.set(j, p2);
						predmeti.set(i, p3);
						p1 = predmeti.get(j);
						p = predmeti.get(i);
					}
				}
			}
		}
		else {  // opadajuce
			for(int i = 0; i < predmeti.size() - 1; i++) {
				Predmet p = predmeti.get(i);
				for(int j = i + 1; j < predmeti.size(); j++) {
					Predmet p1 = predmeti.get(j);
					if(p.getNaziv().compareTo(p1.getNaziv()) < 0) { // negative value => string1 < string2
						Predmet p2 = predmeti.get(i);
						Predmet p3 = predmeti.get(j);
						predmeti.set(j, p2);
						predmeti.set(i, p3);
						p1 = predmeti.get(j);
						p = predmeti.get(i);
					}
				}
			}
		}
	}
	
	public void sortPredmetiPoSemestru(int sort) {
		if(sort == 0) {  // rastuce
			for(int i = 0; i < predmeti.size() - 1; i++) {
				Predmet p = predmeti.get(i);
				for(int j = i + 1; j < predmeti.size(); j++) {
					Predmet p1 = predmeti.get(j);
					if(p1.getSemestar() < p.getSemestar()) {
						Predmet p2 = predmeti.get(i);
						Predmet p3 = predmeti.get(j);
						predmeti.set(j, p2);
						predmeti.set(i, p3);
						p1 = predmeti.get(j);
						p = predmeti.get(i);
					}
				}
			}
		}
		else {  // opadajuce
			for(int i = 0; i < predmeti.size() - 1; i++) {
				Predmet p = predmeti.get(i);
				for(int j = i + 1; j < predmeti.size(); j++) {
					Predmet p1 = predmeti.get(j);
					if(p1.getSemestar() > p.getSemestar()) {
						Predmet p2 = predmeti.get(i);
						Predmet p3 = predmeti.get(j);
						predmeti.set(j, p2);
						predmeti.set(i, p3);
						p1 = predmeti.get(j);
						p = predmeti.get(i);
					}
				}
			}
		}
	}
	
	public void sortPredmetiPoGodini(int sort) {
		if(sort == 0) {  // rastuce
			for(int i = 0; i < predmeti.size() - 1; i++) {
				Predmet p = predmeti.get(i);
				for(int j = i + 1; j < predmeti.size(); j++) {
					Predmet p1 = predmeti.get(j);
					if(p1.getGodinaStudija() < p.getGodinaStudija()) {
						Predmet p2 = predmeti.get(i);
						Predmet p3 = predmeti.get(j);
						predmeti.set(j, p2);
						predmeti.set(i, p3);
						p1 = predmeti.get(j);
						p = predmeti.get(i);
					}
				}
			}
		}
		else {  // opadajuce
			for(int i = 0; i < predmeti.size() - 1; i++) {
				Predmet p = predmeti.get(i);
				for(int j = i + 1; j < predmeti.size(); j++) {
					Predmet p1 = predmeti.get(j);
					if(p1.getGodinaStudija() > p.getGodinaStudija()) {
						Predmet p2 = predmeti.get(i);
						Predmet p3 = predmeti.get(j);
						predmeti.set(j, p2);
						predmeti.set(i, p3);
						p1 = predmeti.get(j);
						p = predmeti.get(i);
					}
				}
			}
		}
	}*/
	
}
