package predmeti;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class PretragaPredmeta {
	public static List<Predmet> originalna_lista = new ArrayList<Predmet>(BazaPredmeta.getInstance().getPredmeti().getListaPredmeta());
	
	public PretragaPredmeta(String query) {
		List<Predmet> search_list = new ArrayList<Predmet>(originalna_lista);
		List<Predmet> add_list = new ArrayList<Predmet>();
		
		String[] data = query.split(";");
		
		for(String s : data) {
			String[] parts = s.split(":");
			
			if(parts[0].equals("sifra")) {
				for(Predmet p : search_list) {
					if(!p.getSifraPredmeta().equals(parts[1])) {
						add_list.add(p);
					}
				}
			}
			else if(parts[0].equals("naziv")) {
				for(Predmet p : search_list) {
					if(!p.getNaziv().equals(parts[1])) {
						add_list.add(p);
					}
				}
			}
			else if(parts[0].equals("semestar")) {
				for(Predmet p : search_list) {
					if(p.getSemestar() != Integer.parseInt(parts[1])) {
						add_list.add(p);
					}
				}
			}
			else if(parts[0].equals("godina")) {
				for(Predmet p : search_list) {
					if(p.getGodinaStudija() != Integer.parseInt(parts[1])) {
						add_list.add(p);
					}
				}
			}
			else if(parts[0].equals("profesor")) {
				for(Predmet p : search_list) {
					if(!(p.getProfesor().getIme() + " " + p.getProfesor().getPrezime()).equals(parts[1])) {
						add_list.add(p);
					}
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Nije dobro unet jedan od naziva kolona!");
				break;
			}
			
			search_list.removeAll(add_list);
			
		}
		
		if(search_list.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nema predmeta sa tim podacima!");
		}
		else {
			BazaPredmeta.getInstance().getPredmeti().setListaPredmeta(search_list);
			Tabela_predmeta.azurirajPrikaz();
		}
		
	}
	}
