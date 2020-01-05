package studenti;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import predmeti.Predmet;
import studenti.ListaStudenata;
import studenti.Status_studenta;
import studenti.Student;


public class BazaStudenata {

	private static BazaStudenata instance = null;

	public static BazaStudenata getInstance() {
		if (instance == null) {
			instance = new BazaStudenata();
		}
		return instance;
	}



	private ListaStudenata studenti;
	private List<String> kolone;

	private BazaStudenata() {
		
		studenti = new ListaStudenata();
		initStudent();

		this.kolone = new ArrayList<>();
		this.kolone.add("IME");
		this.kolone.add("PREZIME");
		this.kolone.add("DATUM ROÄ�ENJA");
		this.kolone.add("ADRESA");		
		this.kolone.add("TELEFON");
		this.kolone.add("E-MAIL");
		this.kolone.add("BROJ INDEKSA");
		this.kolone.add("DATUM UPISA");
		this.kolone.add("GODINA STUDIJA");
		this.kolone.add("STATUS ");
		this.kolone.add("PROSEÄŒNA OCENA");
		this.kolone.add("PREDMETI");

	}

	private void initStudent() {
		List<Predmet> predmeti=new ArrayList<Predmet>();
		studenti.dodavanjeStudenta(new Student("Ime", "Pre zime", "1111", "SS44", "123456", "1233445", "RA-42-2017", "11111", "1", Status_studenta.B, (float) 1.5));

		
		

	}
	
	public static void setInstanca(BazaStudenata instanca) {
		BazaStudenata.instance=instanca;
	}
	public List<String> getKolone(){
		return kolone;
	}
	
	public ListaStudenata getStudenti() {
		return studenti;
	}

	public void setStudenti(ListaStudenata studenti) {
		this.studenti = studenti;
	}


//	public int getColumnCount() {
//		return 6;
//	}
//
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Student getRow(int rowIndex) {
		return this.studenti.getLista_studenata().get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		Student student= this.studenti.getLista_studenata().get(row);
		switch (column) {
		case 0:
			return student.getIme();
		case 1:
			return student.getPrezime();
		case 2:
			return student.getDatumRodjenja();
		case 3:
			return student.getAdresaStanovanja();
		case 4:
			 return student.getTelefon();
		case 5:
			 return student.getEmail();
		case 6:
			 return student.getBroj_indeksa();
		case 7:
			 return student.getDatum_upisa();
		case 8:
			 return student.getGodina_studija();
		case 9:
			 return student.getStatus().toString();
		case 10:
			 return Double.toString(student.getProsecna_ocena());
		case 11:
			// return student.getSpisak_predmeta_koje_student_slusa();
			return "BICE DOPUNJENO";
		default:
			return null;
		}
	}
	
	
	public void dodajStudenta(String ime,String prezime,String dr,String adresa,String telefon,String email,String brindexa,
			String datupisa,String tgs,Status_studenta s,float prosek) {
		studenti.dodavanjeStudenta(new Student(ime,prezime,dr,adresa,telefon,email,brindexa,datupisa,tgs,s,prosek));
		System.out.println(studenti.getLista_studenata().size());
	}

	public void izbrisiStudenta(String index) {
		for (Student s:studenti.getLista_studenata()) {
			if (s.getBroj_indeksa() == index) {
				studenti.getLista_studenata().remove(index);
				break;
			}
		}
	}

//	public void izmeniStudenta() {
//
//	}


}