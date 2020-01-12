package studenti;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import predmeti.Predmet;
import profesori.Profesor;
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
	private File fajl;
	
	
	public BazaStudenata() {
		
		studenti=new ListaStudenata();
		

		
		
		this.fajl=new File("studenti.txt");
		if(fajl.length()!=0)
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

		//makeStudenti();
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
	public void initStudent() {
		
		//ArrayList<?> studenti1=null;
		try
		{
			FileInputStream ulaz=new FileInputStream(fajl);
			ObjectInputStream ois=new ObjectInputStream(ulaz);
			Object obj=ois.readObject();
			//studenti1=(ArrayList<?>) obj;
			
			ois.close();
			ulaz.close();
			studenti = (ListaStudenata) obj;
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (EOFException e)
		{
			e.printStackTrace();
		}
		
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		 
		

	}
	
	public void sacuvajStudente()
	{
		try{
			FileOutputStream fos=new FileOutputStream(new File("studenti.txt"));
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(this.studenti);
			oos.close();
			fos.close();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	private void makeStudenti() {
		
	     Student s1 = new Student("Luka",	"Jovanović"	,"01.01.2000." ,"Karađorđeva 83, Novi Sad","021/333-555","luka.jovanovic@mailinator.com","RA 1/2019","01.07.2019.","Prva",Status_studenta.B,0);
	     Student s2 = new Student( "Sofija","Petrović","16.05.2000.","Miloša Pocerca 55, Šabac","015/343-356","sofija.petrovic@mailinator.com","RA 5/2019","11.07.2019.","Prva",Status_studenta.B,0);
	     Student s3 = new Student ("Stefan","Nikolić",	"18.03.2000." ,	"Knez Mihajlova 16, Beograd" ,	"011/9234-857" ,	"stefan.nikolic@mailinator.com" , 	"RA 3/2019" ,	"03.07.2019." ,	"Prva" ,Status_studenta.B ,0);
	     Student s4 = new Student( "Dunja" , "Ilić" ,	"11.11.2000." ,	"Petefi Šandora 15, Novi Sad" ,	"021/433-958" ,	"dunja.ilic@mailinator.com" ,	"RA 2/2019" ,	"01.07.2019." ,	"Prva",Status_studenta.S ,0);
	     Student s5 = new Student( "Lazar", "Đorđević" ,	"03.12.2000." ,	"Josip Broz Tito 13, Subotica" ,	"024/333-559" ,	"lazar.djordjevic@mailinator.com" ,	"RA 4/2019",	"06.07.2019." ,	"Prva" ,	Status_studenta.S ,0);
	     Student s6 = new Student( "Sara" ,	"Pavlović" ,"03.12.1999." ,	"Vojvode Mišića 23, Šabac" ,	"015/313-061" ,	"sara.pavlovic@mailinator.com" ,	"RA 3/2018" ,	"01.07.2018." ,	"Druga" ,	Status_studenta.B ,0);
	     Student s7 = new Student("Vuk" ,	"Marković" ,"03.12.1999.",	"Temerinska 133, Novi Sad" ,	"021/351-091" ,	"vuk.markovic@mailinator.com" ,	"RA 15/2018" ,	"11.07.2018." ,	"Druga" ,	Status_studenta.B ,0);
	     Student s8 = new Student("Teodora" ,	"Popović" ,	"03.12.1998,",	"Surepova 15, Šabac" ,	"015/324-500" ,	"teodora.popovic@mailinator.com" ,	"RA 133/2017" ,	"03.07.2017." , 	"Druga" ,Status_studenta.S,0);
	     Student s9 = new Student("Filip" ,	"Stojanović" ,"03.12.1998.",	"Francuska 113, Beograd" ,	"011/2333-900" ,	"filip.stojanovic@mailinator.com" ,"RA 122/2017" ,	"02.07.2017." ,	"Druga" ,	Status_studenta.S ,0);
	     Student s10 = new Student("Ana" ,	"Živković" ,"03.12.1998.",	"Kralja Petra 20, Novi Sad" ,	"021/231-114" ,	"ana.zivkovic@mailinator.com" , "RA 201/2017" ,	"04.07.2017." ,	"Druga" ,	Status_studenta.S ,0);
	     Student s11 = new Student( "Viktor" ,	"Janković" ,"03.12.1998.",	"Gogoljeva 3, Novi Sad" ,	"021/135-463" ,	"viktor.jankovic@mailinator.com" ,	"RA 1/2017" ,	"01.07.2017." ,	"Treca" ,	Status_studenta.B ,0);
	     Student s12 = new Student("Petra" ,	"Todorović" ,"03.12.1998.",	"Njegoševa 2, Novi Sad" ,	"021/903-463" ,	"petra.todorovic@mailinator.com" ,	"RA 5/2017" ,	"12.07.2017." ,	"Treca" ,	Status_studenta.B ,0);
	     Student s13 = new Student("Andrej" ,	"Stanković" ,"03.12.1998.",	"Radoja Domanovića 5, Novi Sad" ,	"021/731-067" ,	"andrej.stankovic@mailinator.com" ,	"RA 33/201" ,	"19.07.2017." ,	"Treca" ,	Status_studenta.B ,0);
	     Student s14 = new Student( "Mila" ,	"Ristić" ,"03.12.1997.",	"Vojvode Stepe 183, Beograd" ,	"011/4333-800" ,	"mila.ristic@mailinator.com" ,	"RA 152/2016" ,	"15.07.2016." ,	"Treca" ,	Status_studenta.S ,0);
	     Student s15 = new Student("Pavle" ,	"Kostić" ,"03.12.1997.",	"Crnotravska 13, Beograd" ,	"011/3130-007" ,	"pavle.kostic@mailinator.com" ,	"RA 104/2016" ,	"06.07.2016." ,	"Treca" ,	Status_studenta.S ,0);
	     Student s16 = new Student("Lena" ,	"Kovačević" ,"03.12.1997.",	"Bulevar Oslobođenja 143, Novi Sad" ,	"021/5333-801" ,	"lena.kovacevic@mailinator.com" ,	"RA 1/2016 ",	"01.07.2016." ,	"Cetvrta" ,	Status_studenta.B ,0);
	     Student s17 = new Student("Filip" ,	"Živković" ,"03.12.1997.", "1300 Kaplara, Šabac" ,	"015/333-500" ,	"filip.zivkovic@mailinator.com" ,	"RA 5/2016" ,	"21.07.2016." ,	"Cetvrta" ,	Status_studenta.B ,0);
	     Student s18 = new Student("Filip" ,	"Živković" ,"03.12.1997.", "1300 Kaplara, Šabac" ,	"015/333-500" ,	"filip.zivkovic@mailinator.com" ,	"RA 5/2016" ,	"21.07.2016." ,	"Cetvrta" ,	Status_studenta.B ,0);
	     Student s19 = new Student("Tara" ,	"Dmiitrijević" ,"03.12.1996.",	"Milovana Glišića, Valjevo" ,	"014/303-007" ,	"tara.dimitrijevic@mailinator.com" ,	"RA 33/2015" ,	"23.07.2015." ,	"Cetvrta" ,	Status_studenta.S ,0);
	     Student s20 = new Student("Vasilije" ,	"Micić" ,"03.12.1996.",	"Vuka Karadžića, Loznica"	 , "015/101-909" ,	"vasilije.micic@mailinator.com" ,	"RA 102/2015" ,	"04.07.2015." ,	"Cetvrta" ,	Status_studenta.S ,0);
	     Student s21 = new Student( "Lenka" , "Jović" ,"03.12.1997.",	"Bulevar Mihajla Pupina, Novi Sad",	"021/431-500" ,	"lenka.jovic@mailinator.com" ,	"RA 244/2016" ,"	07.07.2016." ,	"Cetvrta" ,	Status_studenta.S ,0);
	     studenti.getLista_studenata().add(s1);
	     studenti.getLista_studenata().add(s2);
	     studenti.getLista_studenata().add(s3);
	     studenti.getLista_studenata().add(s4);
	     studenti.getLista_studenata().add(s5);
	     studenti.getLista_studenata().add(s6);
	     studenti.getLista_studenata().add(s7);
	     studenti.getLista_studenata().add(s8);
	     studenti.getLista_studenata().add(s9);
	     studenti.getLista_studenata().add(s10);
	     studenti.getLista_studenata().add(s11);
	     studenti.getLista_studenata().add(s12);
	     studenti.getLista_studenata().add(s13);
	     studenti.getLista_studenata().add(s14);
	     studenti.getLista_studenata().add(s15);
	     studenti.getLista_studenata().add(s16);
	     studenti.getLista_studenata().add(s17);
	     studenti.getLista_studenata().add(s18);
	     studenti.getLista_studenata().add(s19);
	     studenti.getLista_studenata().add(s20);
	     studenti.getLista_studenata().add(s21);

	    		 // Luka	Jovanović	01.01.2000.	Karađorđeva 83, Novi Sad	021/333-555	luka.jovanovic@mailinator.com	RA 1/2019	01.07.2019.	1	B
	    		 // "Sofija","Petrović","16.05.2000.","Miloša Pocerca 55, Šabac","015/343-356","sofija.petrovic@mailinator.com","RA 5/2019","11.07.2019.","Prva",Status_studenta.B,0
	    		 //"Stefan","Nikolić",	"18.03.2000." ,	"Knez Mihajlova 16, Beograd" ,	"011/9234-857" ,	"stefan.nikolic@mailinator.com" , 	"RA 3/2019" ,	"03.07.2019." ,	"Prva" ,	B ,0
	    		 // "Dunja" , "Ilić" ,	"11.11.2000." ,	"Petefi Šandora 15, Novi Sad" ,	"021/433-958" ,	"dunja.ilic@mailinator.com" ,	"RA 2/2019" ,	"01.07.2019." ,	"Prva"	Status_studenta.S ,0
	    		 // "Lazar", "Đorđević" ,	"03.12.2000." ,	"Josip Broz Tito 13, Subotica" ,	"024/333-559" ,	"lazar.djordjevic@mailinator.com" ,	"RA 4/2019",	"06.07.2019." ,	"Prva" ,	Status_studenta.S ,0
	    		 //"Sara" ,	"Pavlović" ,"03.12.1999." ,	"Vojvode Mišića 23, Šabac" ,	"015/313-061" ,	"sara.pavlovic@mailinator.com" ,	"RA 3/2018" ,	"01.07.2018." ,	"Druga" ,	Status_studenta.B ,0
	    		 // "Vuk" ,	"Marković" ,"03.12.1999.",	"Temerinska 133, Novi Sad" ,	"021/351-091" ,	"vuk.markovic@mailinator.com" ,	"RA 15/2018" ,	"11.07.2018." ,	"Druga" ,	Status_studenta.B ,0
	    		 //"Teodora" ,	"Popović" ,	"03.12.1998,".	"Surepova 15, Šabac" ,	"015/324-500" ,	"teodora.popovic@mailinator.com" ,	"RA 133/2017" ,	"03.07.2017." , 	"Druga" ,	S,0
	    		 //"Filip" ,	"Stojanović" ,"03.12.1998.",	"Francuska 113, Beograd" ,	"011/2333-900" ,	"filip.stojanovic@mailinator.com" ,"RA 122/2017" ,	"02.07.2017." ,	"Druga" ,	Status_studenta.S ,0
	    		 //"Ana" ,	"Živković" ,"03.12.1998.",	"Kralja Petra 20, Novi Sad" ,	"021/231-114" ,	"ana.zivkovic@mailinator.com" , "RA 201/2017" ,	"04.07.2017." ,	"Druga" ,	Status_studenta.S ,0
	    		 //"Viktor" ,	"Janković" ,"03.12.1998.",	"Gogoljeva 3, Novi Sad" ,	"021/135-463" ,	"viktor.jankovic@mailinator.com" ,	"RA 1/2017" ,	"01.07.2017." ,	"Treca" ,	Status_studenta.B ,0
	    		 //"Petra" ,	"Todorović" ,"03.12.1998.",	"Njegoševa 2, Novi Sad" ,	"021/903-463" ,	"petra.todorovic@mailinator.com" ,	"RA 5/2017" ,	"12.07.2017." ,	"Treca" ,	Status_studenta.B ,0
	    		 //"Andrej" ,	"Stanković" ,"03.12.1998.",	"Radoja Domanovića 5, Novi Sad" ,	"021/731-067" ,	"andrej.stankovic@mailinator.com" ,	"RA 33/201" ,	"19.07.2017." ,	"Treca" ,	Status_studenta.B ,0
	    		 //"Mila" ,	"Ristić" ,"03.12.1997.",	"Vojvode Stepe 183, Beograd" ,	"011/4333-800" ,	"mila.ristic@mailinator.com" ,	"RA 152/2016" ,	"15.07.2016." ,	"Treca" ,	Status_studenta.S ,0
	    		 //"Pavle" ,	"Kostić" ,"03.12.1997.",	"Crnotravska 13, Beograd" ,	"011/3130-007" ,	"pavle.kostic@mailinator.com" ,	"RA 104/2016" ,	"06.07.2016." ,	"Treca" ,	Status_studenta.S ,0
	    		 //"Lena" ,	"Kovačević" ,"03.12.1997.",	"Bulevar Oslobođenja 143, Novi Sad" ,	"021/5333-801" ,	"lena.kovacevic@mailinator.com" ,	"RA 1/2016 ,"	"01.07.2016." ,	"Cetvrta" ,	Status_studenta.B ,0
	    		 //"Filip" ,	"Živković" ,"03.12.1997.", "1300 Kaplara, Šabac" ,	"015/333-500" ,	"filip.zivkovic@mailinator.com" ,	"RA 5/2016" ,	"21.07.2016." ,	"Cetvrta" ,	Status_studenta.B ,0
	    		 //"Tara" ,	"Dmiitrijević" ,"03.12.1996.",	"Milovana Glišića, Valjevo" ,	"014/303-007" ,	"tara.dimitrijevic@mailinator.com" ,	"RA 33/2015" ,	"23.07.2015." ,	"Cetvrta" ,	Status_studenta.S ,0
	    		 //"Vasilije" ,	"Micić" ,"03.12.1996.",	"Vuka Karadžića, Loznica"	 , "015/101-909" ,	"vasilije.micic@mailinator.com" ,	"RA 102/2015" ,	"04.07.2015." ,	"Cetvrta" ,	Status_studenta.S ,0
	    		 //"Lenka" , "Jović" ,"03.12.1997.",	"Bulevar Mihajla Pupina, Novi Sad",	"021/431-500" ,	"lenka.jovic@mailinator.com" ,	"RA 244/2016" ,"	07.07.2016." ,	"Cetvrta" ,	Status_studenta.S ,0
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
		
	