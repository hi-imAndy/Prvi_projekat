package predmeti;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import profesori.BazaProfesora;
import profesori.Profesor;
import studenti.BazaStudenata;
import studenti.ListaStudenata;
import studenti.Status_studenta;
import studenti.Student;
import studenti.StudentiJTable;

public class BazaPredmeta {

	private static BazaPredmeta instance = null;
	File file;
	
	public static BazaPredmeta getInstance() {
		if (instance == null) {
			instance = new BazaPredmeta();
		}
		return instance;
	}

	
	ListaPredmeta predmeti;
	List<String> kolone;
	
	public ListaPredmeta getPredmeti() {
		return predmeti;
	}
	
	public List<String> getKolone(){
		return kolone;
	}
	
	public BazaPredmeta() {
		predmeti = new ListaPredmeta();
		makePredmeti();
		
		this.file=new File("predmeti.txt");
		
		initPredmet();
		
		kolone = new ArrayList<>();
		kolone.add("SIFRA");
		kolone.add("NAZIV");
		kolone.add("SEMESTAR");
		kolone.add("GODINA");
		kolone.add("PROFESOR");
		kolone.add("STUDENTI");
	}
	
	private void initPredmet() {
		
		try
		{
			FileInputStream ulaz=new FileInputStream(file);
			ObjectInputStream ois=new ObjectInputStream(ulaz);
			Object obj=ois.readObject();
			
			ois.close();
			ulaz.close();
			this.predmeti = (ListaPredmeta) obj;
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
	public void sacuvajPredmete()
	{
		try{
			FileOutputStream fos=new FileOutputStream(new File("predmeti.txt"));
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(this.predmeti);
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
	
	private void makePredmeti() {
		Profesor p1 = BazaProfesora.getInstance().getProfesori().findProfesor("007198721");
	    Profesor p2 = BazaProfesora.getInstance().getProfesori().findProfesor("008431903");
	    Profesor p3 = BazaProfesora.getInstance().getProfesori().findProfesor("005671007");
	    Profesor p4 = BazaProfesora.getInstance().getProfesori().findProfesor("009999331");
	    Profesor p5 = new Profesor("","","","","","","","","","");
	    
	    Predmet pred1 = new Predmet("OP301", "Osnove programiranja", 1, 1, p1);
	    Predmet pred2 = new Predmet("DM881", "Diskretna matematika", 3,2, p2);
	    Predmet pred3 = new Predmet("PP007", "Paralelno programiranje", 5, 3, p3);
	    Predmet pred4 = new Predmet("RVP33", "Računarstvo visokih performansi",7, 4, p4);
	    Predmet pred5 = new Predmet("JSD91", "Jezici specifični za domen", 8, 4, p5);
	    
	    predmeti.addPredmet(pred1);
		predmeti.addPredmet(pred2);
		predmeti.addPredmet(pred3);
		predmeti.addPredmet(pred4);
		predmeti.addPredmet(pred5);
		
		p1.addPredmet(pred1);
		p2.addPredmet(pred2);
		p3.addPredmet(pred3);
		p4.addPredmet(pred4);
		
		
	}
	
	public Predmet getRow(int rowIndex) {
		return predmeti.getListaPredmeta().get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
		Predmet predmet= this.predmeti.getListaPredmeta().get(row);
		switch (column) {
		case 0:
			return String.valueOf(predmet.getSifraPredmeta());
		case 1:
			return predmet.getNaziv();
		case 2:
			return String.valueOf(predmet.getSemestar());
		case 3:
			return String.valueOf(predmet.getGodinaStudija());
		case 4:
			 return String.valueOf(predmet.getProfesor().getIme() + " " + predmet.getProfesor().getPrezime());
		default:
			return null;
		}
	}
	
	
	public void IzbrisiStudSaPredmeta(String indeks,int selektovani_predmet)
	{
		
		Predmet predmet = predmeti.getListaPredmeta().get(selektovani_predmet);
		Student zaBrisanje = null;
		
	   for(Student s:predmeti.getListaPredmeta().get(selektovani_predmet).getStudenti())
	   {
		   if(s.getBroj_indeksa().equalsIgnoreCase(indeks))
		   {
			   System.out.println("Student obrisan");
			   zaBrisanje = s;
			  
			   
			   
		   }
		   

	   
	   }
	   if(zaBrisanje != null) {
		   predmeti.getListaPredmeta().get(selektovani_predmet).getStudenti().remove(zaBrisanje);
		   for(Student stud: BazaStudenata.getInstance().getStudenti().getLista_studenata()) {
				if(stud.getBroj_indeksa().equalsIgnoreCase(indeks)) {
					
					stud.getLista_predmeta().getListaPredmeta().remove(predmet);
					
				}
		  
	   }
	   }
	}
	
	public void dodajProfesoraNaPredmet(Profesor prof, int selektovani_predmet) {
		Predmet pred = predmeti.getListaPredmeta().get(selektovani_predmet);
		for(Predmet p : prof.getPredmeti()) {
			if(p.equals(pred)) {
				JOptionPane.showMessageDialog(null, "Profesor je vec na tom predmetu!");
				return;
			}
		}
		prof.addPredmet(pred);
	}
	
	public void DodajStudentaNaPredmet(Student s,int selektovani_predmet)
	{
		
	for(Student st :	predmeti.getListaPredmeta().get(selektovani_predmet).getStudenti()) {
		if(st.getBroj_indeksa().equalsIgnoreCase(s.getBroj_indeksa())) {
			JOptionPane.showMessageDialog(null, "Student vec postoji na predmetu");
			return;
		}
	}
		
		predmeti.getListaPredmeta().get(selektovani_predmet).getStudenti().add(s);
		
		for(Student stud: BazaStudenata.getInstance().getStudenti().getLista_studenata()) {
			if(stud.getBroj_indeksa().equalsIgnoreCase(s.getBroj_indeksa())) {
				stud.getLista_predmeta().getListaPredmeta().add(predmeti.getListaPredmeta().get(selektovani_predmet));
				break;
			}
			
		}
	}
	
}
