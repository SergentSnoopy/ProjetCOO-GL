package Fonct.Input_Output;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import Fonct.Historique.*;
import Fonct.Personne.*;

public class BD_Distante extends BD {


	ArrayList<DemandeAjoutFilm> ajoutsFilms;
	ArrayList<Client> clients;//liste de numéro de carte des clients/techniciens
	ArrayList<Technicien> techniciens;//liste de numéro de carte des clients/techniciens
	ArrayList<Film> films;//film dispo sur cyber video
	ArrayList<Historique> historiques;


	public class DemandeAjoutFilm {
		String titre;
		String realisateur;
		public DemandeAjoutFilm(String titre, String realisateur) {
			this.titre = titre;
			this.realisateur = realisateur;
		}
	}

	public BD_Distante(String path) throws FileNotFoundException, IOException {
		super(path);
		ajoutsFilms = new ArrayList<DemandeAjoutFilm>();
		clients = new ArrayList<Client>();
		techniciens = new ArrayList<Technicien>();
		films = new ArrayList<Film>();
		historiques = new ArrayList<Historique>();
		getInfos();
	}

	private Historique findClientHist(String idUser) {
		for(int i = 0; i < historiques.size(); i++)
			if(historiques.get(i).getNumCarteUtilisateur().equals(idUser))
				return historiques.get(i);
		return null;
	}

	private void getInfos() throws FileNotFoundException, IOException {
		// hist bancaire
		Infos histsBancaires = super.getInfo("HistoriqueBancaire.txt");
		for(ArrayList<String> info : histsBancaires){
			HistoriqueBancaire hB = new HistoriqueBancaire(info.get(1)
					,Integer.parseInt(info.get(2)));
			Historique hist = findClientHist(info.get(0));
			if(hist != null)
				hist.getListeHistBancaire().add(hB);
			else {
				hist = new Historique(info.get(0));
				hist.getListeHistBancaire().add(hB);
				this.historiques.add(hist);
			}
		}

		// hist loc
		Infos histsLocs = super.getInfo("HistoriqueLocations.txt");
		for(ArrayList<String> info : histsLocs){
			HistoriqueLocation hB = new HistoriqueLocation(info.get(1),info.get(2),info.get(3)
					,Integer.parseInt(info.get(4)),info.get(5));
			Historique hist = findClientHist(info.get(0));
			if(hist != null)
				hist.getListeHistLocation().add(hB);
			else {
				hist = new Historique(info.get(0));
				hist.getListeHistLocation().add(hB);
				historiques.add(hist);
			}
		}

		// Les Clients
		Infos clients = super.getInfo("Clients.txt");
		for(ArrayList<String> info : clients){
			Historique hist = findClientHist(info.get(0));
			hist = (hist == null)?new Historique(info.get(0)):hist;
			Client client = new Client(info.get(0),info.get(1),info.get(2),info.get(3)
					,(info.get(4).equals("true"))?true:false,Integer.parseInt(info.get(5)),hist);
			this.clients.add(client);
		}			

		// Les techniciens
		Infos techniciens = super.getInfo("Techniciens.txt");
		for(ArrayList<String> info : techniciens){
			Technicien technicien = new Technicien(info.get(0));
			this.techniciens.add(technicien);		
		}

		// Films
		Infos films = super.getInfo("Films.txt");
		for(ArrayList<String> info : films){
			Film f = new Film(info.get(0),info.get(1),info.get(2)
					,info.get(3),Integer.parseInt(info.get(4)),false);
			this.films.add(f);			
		}

		// demandes d'ajouts
		Infos demandes = super.getInfo("DemandesFilms.txt");
		for(ArrayList<String> info : demandes) {
			DemandeAjoutFilm daf = new DemandeAjoutFilm(info.get(0),info.get(1));
			ajoutsFilms.add(daf);
		}
	}


	public Boolean askFilm(String titre, String realisateur){
		// check si dans les demandes actuelles
		for(DemandeAjoutFilm daf : ajoutsFilms)
			if(daf.titre.equals(titre) && daf.realisateur.equals(realisateur))
				return false;
		// check si existe bd
		Boolean found = false;
		int i = 0;
		while(!found && films.size() > i) {
			Film f = films.get(i);
			if(f.getTitre().equals(titre) && f.getRealisateur().equals(realisateur))
				found = true;
			i++;
		}
		if(!found)
			return false;
		ajoutsFilms.add(new DemandeAjoutFilm(titre,realisateur));
		return true;
	}

	public ArrayList<Film> getFilms(){return films;}
	public ArrayList<DemandeAjoutFilm> getDemandesAjoutsFilms(){return ajoutsFilms;}

	public Client identification(String numCarte){
		for(Client c : clients)
			if(c.getNumCarte().equals(numCarte))
				return c;
		return null;
	}

	public Technicien identificationTechnicien(String numCarte){
		for(Technicien t : techniciens)
			if(t.getNumCarte().equals(numCarte))
				return t;
		return null;
	}

	public void commit() throws IOException {
		// reconstruction des historiques
		ArrayList<Historique> newHistoriques = new ArrayList<Historique>();
		for(Client c : clients)
			newHistoriques.add(c.getHistorique());
		historiques = newHistoriques;
		write();
	}

	private class HBWrapper {
		HistoriqueBancaire hb;
		String numCarte;
		public HBWrapper(HistoriqueBancaire hb, String carte) {
			this.hb = hb;
			this.numCarte = carte;
		}
	}

	private class HLWrapper {
		HistoriqueLocation hl;
		String numCarte;
		public HLWrapper(HistoriqueLocation hl, String carte) {
			this.hl = hl;
			this.numCarte = carte;
		}
	}

	private void write() throws IOException {
		// Historiques
		ArrayList<HBWrapper> hbs = new ArrayList<HBWrapper>();
		ArrayList<HLWrapper> hls = new ArrayList<HLWrapper>();
		for(Historique h : historiques) {
			for(HistoriqueBancaire hb : h.getListeHistBancaire())
				hbs.add(new HBWrapper(hb,h.getNumCarteUtilisateur()));
			for(HistoriqueLocation hl : h.getListeHistLocation())
				hls.add(new HLWrapper(hl,h.getNumCarteUtilisateur()));
		}

		// historique bancaire
		super.write("HistoriqueBancaire.txt", new Infos.Writable<HBWrapper>(hbs) {
			public String parse(HBWrapper hb) {
				return hb.numCarte+";"+hb.hb.getDate()+";"
						+hb.hb.getMontant();
			}
		});// historique locations
		super.write("HistoriqueLocations.txt", new Infos.Writable<HLWrapper>(hls) {
			public String parse(HLWrapper hl) {
				return hl.numCarte+";"+hl.hl.getDate()+";"+hl.hl.getTitreFilm()+
						";"+hl.hl.getRealisateur()+";"+hl.hl.getPrixLocation()+";"+
						hl.hl.getTitreFilm();
			}
		});

		// Clients
		super.write("Clients.txt", new Infos.Writable<Client>(clients) {
			public String parse(Client c) {
				return c.getNumCarte()+";"+c.getNom()+";"+c.getPrenom()+";"+c.getAdresse()+
						";"+c.getEstAbonne()+";"+c.getSoldeActuel();
			}
		});

		// Techniciens
		super.write("Techniciens.txt", new Infos.Writable<Technicien>(techniciens) {
			public String parse(Technicien c) {
				return c.getNumCarte();
			}
		});

		// Films
		super.write("Films.txt", new Infos.Writable<Film>(films) {
			public String parse(Film f) {
				return f.getTitre()+";"+f.getRealisateur()+";"+f.getResume()+";"+
						f.getAffiche()+";"+f.getNbDispo();
			}
		});

		// Demandes ajouts de films
		super.write("DemandesFilms.txt", new Infos.Writable<DemandeAjoutFilm>(ajoutsFilms) {
			public String parse(DemandeAjoutFilm daf) {
				return daf.titre+";"+daf.realisateur;
			}
		});
	}
}
