package profesori;

import java.util.ArrayList;
import java.util.Date;

import predmeti.Predmet;



public class ProfesoriController {
	private static ProfesoriController instance = null;

	public static ProfesoriController getInstance() {
		if (instance == null) {
			instance = new ProfesoriController();
		}
		return instance;
	}
	
	private ProfesoriController() {}
	
	public void dodajProfesora(String ime, String prezime,String datumrodj, String adresastan, String kontakt, String mail,
			String adresakanc, int brlk, String titula, String zvanje) {
		
		BazaProfesora.getInstance().dodajProfesora(ime,prezime,datumrodj,adresastan,kontakt,mail,adresakanc,brlk,titula,zvanje);
	
		Tabela_profesora.azurirajPrikaz();
	}
	
     public void izmeniProfesora(String ime,String prezime,String datumrodjenja
							,String adresastanovanja,String l,String email,String adresakanc,int brlk,String titula,String zvanje)
     {
    	  BazaProfesora.getInstance().izmeniProf(ime,prezime,datumrodjenja,adresastanovanja,l,email,adresakanc,brlk,titula,zvanje);
    	 Tabela_profesora.azurirajPrikaz();
     }
     
     public void brisanjeProfesora(int rowSelectedIndex) {

 		Profesor p = BazaProfesora.getInstance().getRow(rowSelectedIndex);
 		BazaProfesora.getInstance().izbrisiProfesora(p.getBrojLicne());
 		Tabela_profesora.azurirajPrikaz();
 	}
}
