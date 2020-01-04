package studenti;

import java.util.ArrayList;

import predmeti.Predmet;

public class ListaStudenata {
	private ArrayList<Student> lista_studenata;

	public ListaStudenata() {
		lista_studenata = new ArrayList<Student>();
	}

	public ArrayList<Student> getLista_studenata() {
		return lista_studenata;
	}

	public void setLista_studenata(ArrayList<Student> lista_studenata) {
		this.lista_studenata = lista_studenata;
	}

	public void dodavanjeStudenta(String ime, String prz, String datum, String adr, String tel, String email,
			String indeks, String datum_upisa, int godina_studija, Status_studenta status, float prosecna_ocena) {

		lista_studenata.add(new Student(ime, prz, datum, adr, tel, email, indeks, datum_upisa, godina_studija, status,
				prosecna_ocena));

	}

	public void dodavanjeStudenta(Student student) {

		lista_studenata.add(student);

	}

	public void uklanjanjeStudenta(String indeks) {
		int i = -1;
		int t = 0;
		for (Student var : lista_studenata) {
			if (var.broj_indeksa == indeks) {
				i = t;
				break;
			}
			t++;
		}
		if (i == -1)
			return;
		else
			lista_studenata.remove(i);
	}

	public void izmenaStudenta(String ime, String prz, String datum, String adr, String tel, String email,
			String indeks, String datum_upisa, int godina_studija, Status_studenta status, float prosecna_ocena) {
		for (Student student : lista_studenata) {
			if (student.getBroj_indeksa().equalsIgnoreCase(indeks)) {
				student.setAdresaStanovanja(adr);
				student.setBroj_indeksa(indeks);
				student.setDatum_upisa(datum_upisa);
				student.setDatumRodjenja(datum);
				student.setEmail(email);
				student.setGodina_studija(godina_studija);
				student.setIme(ime);
				student.setPrezime(prz);
				student.setStatus(status);
				student.setTelefon(tel);
				break;
			}
		}
	}

	public Student pretragaStudenta(String upit) {
		String[] razdvojeno = upit.split(";");
		String[] ime = razdvojeno[0].split(":");
		String[] prz = razdvojeno[1].split(":");
		String[] indeks = razdvojeno[1].split(":");
		for (Student var : lista_studenata) {
			if (var.broj_indeksa.equalsIgnoreCase(indeks[1]) && var.getIme().equalsIgnoreCase(ime[1])
					&& var.getPrezime().equalsIgnoreCase(prz[1])) {
				return var;
			}
		}
		return null;
	}
	// ime:Marko;prezime:Marković;indeks:sw-1-2019

	public void sortiranjePoIndeksu(int sort) {// 0 za opadajuce bilo sta drugo za rastuce
		if (sort == 0) { // opadajuce
			for (int i = 0; i < lista_studenata.size() ; i++) {
				Student s = lista_studenata.get(i);
				int s_indeks = Integer.parseInt(s.getBroj_indeksa().split("-")[1]);
				for (int j = 0; j < lista_studenata.size(); j++) {
					Student s1 = lista_studenata.get(j);
					int s1_indeks = Integer.parseInt(s1.getBroj_indeksa().split("-")[1]);
					if (s1_indeks > s_indeks) {
						Student temp1 = lista_studenata.get(i);
						Student temp2 = lista_studenata.get(j);
						lista_studenata.set(j, temp1);
						lista_studenata.set(i, temp2);

					}
				}
			}
		}

		else { // rastuce
			for (int i = 0; i < lista_studenata.size() ; i++) {
				Student s = lista_studenata.get(i);
				int s_indeks = Integer.parseInt(s.getBroj_indeksa().split("-")[1]);
				for (int j = 0; j < lista_studenata.size(); j++) {
					Student s1 = lista_studenata.get(j);
					int s1_indeks = Integer.parseInt(s1.getBroj_indeksa().split("-")[1]);
					if (s1_indeks < s_indeks) {
						Student temp1 = lista_studenata.get(i);
						Student temp2 = lista_studenata.get(j);
						lista_studenata.set(j, temp1);
						lista_studenata.set(i, temp2);

					}
				}
			}
		}
	}

	public void sortiranjePoOceni(int sort) {// 0 za opadajuce bilo sta drugo za rastuce
		if (sort == 0) {//opadajuce
			for (int i = 0; i < lista_studenata.size(); i++) {
				Student s = lista_studenata.get(i);
				float s_ocena = s.prosecna_ocena;
				for (int j = 0; j < lista_studenata.size(); j++) {
					Student s1 = lista_studenata.get(j);
					float s1_ocena = s1.prosecna_ocena;
					if (s1_ocena > s_ocena) {
						Student temp1 = lista_studenata.get(i);
						Student temp2 = lista_studenata.get(j);
						lista_studenata.set(j, temp1);
						lista_studenata.set(i, temp2);
					}
				}
			}
		}

		else { // rastuce
			for (int i = 0; i < lista_studenata.size(); i++) {
				Student s = lista_studenata.get(i);
				float s_ocena = s.prosecna_ocena;
				for (int j =0; j < lista_studenata.size(); j++) {
					Student s1 = lista_studenata.get(j);
					float s1_ocena = s1.prosecna_ocena;
					if (s1_ocena < s_ocena) {
						Student temp1 = lista_studenata.get(i);
						Student temp2 = lista_studenata.get(j);
						lista_studenata.set(j, temp1);
						lista_studenata.set(i, temp2);
					}
				}
			}
		}
	}

	public void sortirajPoImenu(int sort) {
		if (sort == 0) { // opadajuce
			for (int i = 0; i < lista_studenata.size(); i++) {
				Student p = lista_studenata.get(i);
				for (int j = 0; j < lista_studenata.size(); j++) {
					Student p1 = lista_studenata.get(j);
					if (p.getIme().compareTo(p1.getIme()) < 0) { // positive value => string1 > string2
						Student p2 = lista_studenata.get(i);
						Student p3 = lista_studenata.get(j);
						lista_studenata.set(j, p2);
						lista_studenata.set(i, p3);
					}
				}
			}
		} else { // rastuce
			for (int i = 0; i < lista_studenata.size() ; i++) {
				Student p = lista_studenata.get(i);
				for (int j = 0; j < lista_studenata.size(); j++) {
					Student p1 = lista_studenata.get(j);
					if (p.getIme().compareTo(p1.getIme()) > 0) { // positive value => string1 > string2
						Student p2 = lista_studenata.get(i);
						Student p3 = lista_studenata.get(j);
						lista_studenata.set(j, p2);
						lista_studenata.set(i, p3);

					}
				}
			}
		}
	}

	public void sortirajPoPrezimenu(int sort) {
		if (sort == 0) { // opadajuce
			for (int i = 0; i < lista_studenata.size(); i++) {
				Student p = lista_studenata.get(i);
				for (int j = 0; j < lista_studenata.size(); j++) {
					Student p1 = lista_studenata.get(j);
					if (p.getPrezime().compareTo(p1.getPrezime()) < 0) { // positive value => string1 > string2
						Student p2 = lista_studenata.get(i);
						Student p3 = lista_studenata.get(j);
						lista_studenata.set(j, p2);
						lista_studenata.set(i, p3);
					}
				}
			}
		} else { // rastuce
			for (int i = 0; i < lista_studenata.size(); i++) {
				Student p = lista_studenata.get(i);
				for (int j = 0; j < lista_studenata.size(); j++) {
					Student p1 = lista_studenata.get(j);
					if (p.getPrezime().compareTo(p1.getPrezime()) > 0) { // positive value => string1 > string2
						Student p2 = lista_studenata.get(i);
						Student p3 = lista_studenata.get(j);
						lista_studenata.set(j, p2);
						lista_studenata.set(i, p3);

					}
				}
			}
		}
	}
	
	// ime:Marko;prezime:Marković;indeks:sw-1-2019
	
	public void sortiranjePoGodini(int sort) {// 0 za opadajuce bilo sta drugo za rastuce
		if (sort == 0) { //opadajuce
			for(int i = 0 ; i < lista_studenata.size() ; i++) {
				int indeks1 = Integer.parseInt(lista_studenata.get(i).broj_indeksa.split("-")[2]);
				for(int l = 0 ; l < lista_studenata.size() ; l++) {
					int indeks2 = Integer.parseInt(lista_studenata.get(l).broj_indeksa.split("-")[2]);
					if(indeks1 > indeks2) {
						Student temp1 = lista_studenata.get(i);
						Student temp2 = lista_studenata.get(l);
						lista_studenata.set(i, temp2);
						lista_studenata.set(l, temp1);
					}
				}				
			}
		}

		else { // rastuce
			for(int i = 0 ; i < lista_studenata.size() ; i++) {
				int indeks1 = Integer.parseInt(lista_studenata.get(i).broj_indeksa.split("-")[2]);
				for(int l = 0 ; l < lista_studenata.size() ; l++) {
					int indeks2 = Integer.parseInt(lista_studenata.get(l).broj_indeksa.split("-")[2]);
					if(indeks1 < indeks2) {
						Student temp1 = lista_studenata.get(i);
						Student temp2 = lista_studenata.get(l);
						lista_studenata.set(i, temp2);
						lista_studenata.set(l, temp1);
					}
				}				
			}
		}
	}

	
	public void sortiranjePoStatusu(int sort) {// 0 za opadajuce bilo sta drugo za rastuce
		if (sort == 0) { //opadajuce
			for(int i = 0 ; i < lista_studenata.size() ; i++) {
				Status_studenta status1 = lista_studenata.get(i).getStatus();
				for(int l = 0 ; l < lista_studenata.size() ; l++) {
					Status_studenta status2 = lista_studenata.get(l).getStatus();
					if(status1.getVrednost() > status2.getVrednost()) {
						Student temp1 = lista_studenata.get(i);
						Student temp2 = lista_studenata.get(l);
						lista_studenata.set(i, temp2);
						lista_studenata.set(l, temp1);
					}
				}				
			}
		}

		else { // rastuce
			for(int i = 0 ; i < lista_studenata.size() ; i++) {
				Status_studenta status1 = lista_studenata.get(i).getStatus();
				for(int l = 0 ; l < lista_studenata.size() ; l++) {
					Status_studenta status2 = lista_studenata.get(l).getStatus();
					if(status1.getVrednost() < status2.getVrednost()) {
						Student temp1 = lista_studenata.get(i);
						Student temp2 = lista_studenata.get(l);
						lista_studenata.set(i, temp2);
						lista_studenata.set(l, temp1);
					}
				}				
			}
		}
	}
	//1.1.2018

	public void sortiranjePoDatumu(int sort) {// 0 za opadajuce bilo sta drugo za rastuce
		if (sort == 0) { //opadajuce
			for(int i = 0 ; i < lista_studenata.size() ; i++) {
				Student s1 = lista_studenata.get(i);
				int godina1 = Integer.parseInt(s1.getDatumRodjenja().split("\\.")[2]);
				int mesec1 = Integer.parseInt(s1.getDatumRodjenja().split("\\.")[1]);
				int dan1 = Integer.parseInt(s1.getDatumRodjenja().split("\\.")[0]);
				for(int l = 0 ; l < lista_studenata.size() ; l++) {
					Student s2 = lista_studenata.get(l);
					int godina2 = Integer.parseInt(s2.getDatumRodjenja().split("\\.")[2]);
					int mesec2 = Integer.parseInt(s2.getDatumRodjenja().split("\\.")[1]);
					int dan2 = Integer.parseInt(s2.getDatumRodjenja().split("\\.")[0]);
					if(godina1 > godina2) {
						Student temp1 = lista_studenata.get(i);
						Student temp2 = lista_studenata.get(l);
						lista_studenata.set(i, temp2);
						lista_studenata.set(l, temp1);
					}
					else if(godina1  == godina2 && mesec1 > mesec2 ) {
						Student temp1 = lista_studenata.get(i);
						Student temp2 = lista_studenata.get(l);
						lista_studenata.set(i, temp2);
						lista_studenata.set(l, temp1);
					}
					else if(godina1  == godina2 && mesec1 == mesec2 && dan1 > dan2) {
						Student temp1 = lista_studenata.get(i);
						Student temp2 = lista_studenata.get(l);
						lista_studenata.set(i, temp2);
						lista_studenata.set(l, temp1);
					}
				}				
			}
		}

		else { // rastuce
			for(int i = 0 ; i < lista_studenata.size() ; i++) {
				Student s1 = lista_studenata.get(i);
				int godina1 = Integer.parseInt(s1.getDatumRodjenja().split("\\.")[2]);
				int mesec1 = Integer.parseInt(s1.getDatumRodjenja().split("\\.")[1]);
				int dan1 = Integer.parseInt(s1.getDatumRodjenja().split("\\.")[0]);
				for(int l = 0 ; l < lista_studenata.size() ; l++) {
					Student s2 = lista_studenata.get(l);
					int godina2 = Integer.parseInt(s2.getDatumRodjenja().split("\\.")[2]);
					int mesec2 = Integer.parseInt(s2.getDatumRodjenja().split("\\.")[1]);
					int dan2 = Integer.parseInt(s2.getDatumRodjenja().split("\\.")[0]);
					if(godina1 < godina2) {
						Student temp1 = lista_studenata.get(i);
						Student temp2 = lista_studenata.get(l);
						lista_studenata.set(i, temp2);
						lista_studenata.set(l, temp1);
					}
					else if(godina1  == godina2 && mesec1 < mesec2 ) {
						Student temp1 = lista_studenata.get(i);
						Student temp2 = lista_studenata.get(l);
						lista_studenata.set(i, temp2);
						lista_studenata.set(l, temp1);
					}
					else if(godina1  == godina2 && mesec1 == mesec2 && dan1 < dan2) {
						Student temp1 = lista_studenata.get(i);
						Student temp2 = lista_studenata.get(l);
						lista_studenata.set(i, temp2);
						lista_studenata.set(l, temp1);
					}
				}				
			}
		}
	}
	
	
	/*
	 * Sortiranje studenata po (#sortiranje_studenata):
	 * a. indeksu(rastuće/opadajuće)----+ 
	 * b. imenu (rastuće/opadajuće)----+
	 * c. prezimenu(rastuće/opadajuće)----+
	 * d. datumu rođenja (rastuće/opadajuće) ----+
	 * e. godini upisa(rastuće/opadajuće)----+
	 * f. statusu (rastuće/opadajuće)----+
	 * g. prosečnoj oceni(rastuće/opadajuće----+
	 */

	@Override
	public String toString() {// za test
		String pV = "";
		for (Student student : lista_studenata) {
			pV += student.broj_indeksa + "--" + student.prosecna_ocena + "--" + student.getIme() + "--" + student.getStatus() + "--" + student.getDatumRodjenja()+ "\n";
		}
		return pV;

	}
}