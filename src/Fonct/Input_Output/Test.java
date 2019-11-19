package Fonct.Input_Output;

import java.io.IOException;
import java.util.ArrayList;

import Fonct.Historique.*;
import Fonct.Personne.*;

public class Test {
	public static void main(String args[]) {
		try {
			BD_Locale bdl = new BD_Locale("BDlocale");
			BD_Distante bdd = new BD_Distante("BDdistante");
			
			ArrayList<Film> films = bdl.getFilms();
			Client client = bdd.identification("7325");
			
			for(Film f : films)
				System.out.println(f.getTitre());
			if(client != null) {
				System.out.println(client.getNom());
				System.out.println(client.getHistorique().getListeHistBancaire().size());
				client.setSoldeActuel(5);
			}
			else
				System.out.println("client not found");
			bdl.commit(films);
			bdd.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
