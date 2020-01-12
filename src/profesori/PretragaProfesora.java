package profesori;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import predmeti.BazaPredmeta;
import predmeti.Predmet;
import predmeti.Tabela_predmeta;

public class PretragaProfesora {
public static List<Profesor> originalna_lista = new ArrayList<Profesor>(BazaProfesora.getInstance().getProfesori().getListaProfesora());
	
	public PretragaProfesora(String query) {
		List<Profesor> search_list = new ArrayList<Profesor>(originalna_lista);
		List<Profesor> add_list = new ArrayList<Profesor>();
		
		String[] data = query.split(";");
		
		for(String s : data) {
			String[] parts = s.split(":");
			
			if(parts[0].equals("ime")) {
				for(Profesor p : search_list) {
					if(!p.getIme().equals(parts[1])) {
						add_list.add(p);
					}
				}
			}
			else if(parts[0].equals("prezime")) {
				for(Profesor p : search_list) {
					if(!p.getPrezime().equals(parts[1])) {
						add_list.add(p);
					}
				}
			}
			else if(parts[0].equals("datum rodjenja")) {
				for(Profesor p : search_list) {
					if(!p.getDatumRodjenja().equals(parts[1])) {
						add_list.add(p);
					}
				}
			}
			else if(parts[0].equals("adresa")) {
				for(Profesor p : search_list) {
					if(!p.getAdresaStanovanja().equals(parts[1])) {
						add_list.add(p);
					}
				}
			}
			else if(parts[0].equals("telefon")) {
				for(Profesor p : search_list) {
					if(!p.getTelefon().equals(parts[1])) {
						add_list.add(p);
					}
				}
			}
			else if(parts[0].equals("adresa kancelarije")) {
				for(Profesor p : search_list) {
					if(!p.getAdresaKancelarije().equals(parts[1])) {
						add_list.add(p);
					}
				}
			}
			else if(parts[0].equals("broj licne karte")) {
				for(Profesor p : search_list) {
					if(!p.getBrojLicne().equals(parts[1])) {
						add_list.add(p);
					}
				}
			}
			else if(parts[0].equals("titula")) {
				for(Profesor p : search_list) {
					if(!p.getTitula().equals(parts[1])) {
						add_list.add(p);
					}
				}
			}
			else if(parts[0].equals("zvanje")) {
				for(Profesor p : search_list) {
					if(!p.getZvanje().equals(parts[1])) {
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
			BazaProfesora.getInstance().getProfesori().setListaProfesora(search_list);
			Tabela_profesora.azurirajPrikaz();
		}
		
	}
}
