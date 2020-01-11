package studenti;

import java.util.ArrayList;

import javax.swing.JOptionPane;



public class Pretraga_studenta{
	public Boolean search_mode=false;
	private static ArrayList<Student> originalna_lista= new ArrayList<Student>(BazaStudenata.getInstance().getStudenti().getLista_studenata());
	

	
   public static ArrayList<Student> getOriginalna_lista() {
		return originalna_lista;
	}





public Pretraga_studenta(String pretraga) {
	String[] splits = pretraga.split(";");
	ArrayList<Student> listazapretragu= new ArrayList<Student>(BazaStudenata.getInstance().getStudenti().getLista_studenata());
	Boolean b=false;

	
	for(String s: splits) {
		
		ArrayList<Student> pomocnalista =new ArrayList<Student>();
		String[] upit=s.split(":");
		
		if(upit.length!=2) {
			
			JOptionPane.showMessageDialog(null, "Losa pretraga!");
			return;
		}else if(upit[0].equals("ime")) {
			
			for(Student st:listazapretragu) {
				if(!st.getIme().equals(upit[1])) {
					pomocnalista.add(st);
				}
				
		}
			
			
		}
		else if(upit[0].equals("prezime")) {
				for(Student st:listazapretragu) {
						if(!st.getPrezime().equals(upit[1])) {
							pomocnalista.add(st);
						}
				}
			}

		else if(upit[0].equals("indeks")) {
			for(Student st:listazapretragu) {
					if(!st.getBroj_indeksa().equals(upit[1])) {
						pomocnalista.add(st);
					}}}
			
       else {
			JOptionPane.showMessageDialog(null, "Losa pretraga!");
			b=false;
			break;
		}
		
		listazapretragu.removeAll(pomocnalista);
		
	}
	
	if(listazapretragu.isEmpty()) {
		
		JOptionPane.showMessageDialog(null, "Nema studenata sa datim podacima!");
		
	}else if(!b) {
		BazaStudenata.getInstance().getStudenti().setLista_studenata(listazapretragu);
		//search_mode=true;
		StudentiJTable.azurirajPrikaz();
		
		
	}}}
