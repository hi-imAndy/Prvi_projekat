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



	ListaStudenata studenti;
	private List<String> kolone;

	public BazaStudenata() {
		
		studenti=new ListaStudenata();
		initStudent();

		this.kolone = new ArrayList<>();
		this.kolone.add("IME"); 
		this.kolone.add("PREZIME");
		this.kolone.add("DATUM RODJENJA");
		this.kolone.add("ADRESA");		
		this.kolone.add("TELEFON");
		this.kolone.add("EMAIL");
		this.kolone.add("BROJ INDEXA");
		this.kolone.add("DATUM UPISA");
		this.kolone.add("GODINA STUDIRANJA");
		this.kolone.add("STATUS");
		this.kolone.add("PROSEK");
		this.kolone.add("PREDMETI");

	}

	private void initStudent() {
	    studenti.dodavanjeStudenta(new Student("Maja","Zoric","11.08.1997","jskjff","","","RA-76-2017","","1",Status_studenta.B,(double) 4.5));
		studenti.dodavanjeStudenta(new Student("Zorica","Lakic","11.10.1997","jskjff","","","RA-19-2017","","2",Status_studenta.S,(double)7.5));
		studenti.dodavanjeStudenta(new Student("Aleksandra","Arsic","12.1.1998.","jskjff","","","RA-40-2017","","4",Status_studenta.S,(double)10.0));
		studenti.dodavanjeStudenta(new Student("Aleksandra","Arsic","12.1.1998.","jskjff","","","RA-40-2018","","3",Status_studenta.B,(double)2));
		studenti.dodavanjeStudenta(new Student("Aleksandra","Arsic","12.1.1998.","jskjff","","","SW-40-2017","","4",Status_studenta.B,(double)4.33));
		
		

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


	public int getColumnCount() {
		return 12;
	}

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
			
		default:
			return null;
		}
	}
	
	
	public void dodajStudenta(String ime,String prezime,String dr,String adresa,String telefon,String email,String brindexa,
			String datupisa,String tgs,Status_studenta s,double prosek) {
		studenti.dodavanjeStudenta(new Student(ime,prezime,dr,adresa,telefon,email,brindexa,datupisa,tgs,s,(double) prosek));
	//	System.out.println(studenti.size());
	}

	public void izbrisiStudenta(String index) {

				studenti.uklanjanjeStudenta(index);
			
		
	}
	
	//OVDE SAM STAO
	public void izmeniStudenta(String ime,String prezime,String DatumRodj,String Email,String DatumUpisa,double prosek,String adresa,
			String brtel,String brindexa,String trengodstud,Status_studenta s) {
		
		Student st = BazaStudenata.getInstance().getRow(StudentiJTable.tab.getSelectedRow());
		st.setIme(ime);
		st.setPrezime(prezime);
		st.setAdresaStanovanja(adresa);
		st.setDatum_upisa(DatumRodj);
		st.setTelefon(brtel);
		st.setEmail(Email);
		st.setBroj_indeksa(brindexa);
		st.setProsecna_ocena(prosek);
		st.setDatum_upisa(DatumUpisa);
		st.setGodina_studija(trengodstud);
		st.setStatus(s);
		
		
		
		
	}
	
	
	public boolean StudentPostoji(String index)
	{
		for(Student s:studenti.getLista_studenata())
		{	
			if(s.getBroj_indeksa().equals(index))
			{
				return true;
			} 
		
		}
		return false;
		
	}
	
	public Student VratiStudenta(String index)
	{
		Student st=null;
		for(Student s:studenti.getLista_studenata())
		{
			if(s.getBroj_indeksa().equals(index))
				{
					st=s;
					break;
				}
		}
		return st;
	}
	
	
	}
		
	