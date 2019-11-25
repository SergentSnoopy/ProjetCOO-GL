package Fonct.Input_Output;

import Fonct.Historique.Film;
import Fonct.Historique.Historique;
import Fonct.Historique.HistoriqueBancaire;
import Fonct.Historique.HistoriqueLocation;
import Fonct.Personne.Client;
import Fonct.Personne.Technicien;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class BD_Distante extends BD {

    ArrayList<DemandeAjoutFilm> ajoutsFilms;//liste de films que le technicien devra ajouter
    ArrayList<Client> clients;//liste de numéros de carte des clients
    ArrayList<Technicien> techniciens;//liste de numéros de carte des techniciens
    ArrayList<Film> films;//films dispos sur cyber video
    ArrayList<Historique> historiques;


    public BD_Distante(String path) throws FileNotFoundException, IOException {
        super(path);
        ajoutsFilms = new ArrayList<DemandeAjoutFilm>();
        clients = new ArrayList<Client>();
        techniciens = new ArrayList<Technicien>();
        films = new ArrayList<Film>();
        historiques = new ArrayList<Historique>();
        getInfos();
    }

    private Historique findClientHist(String idUser) { //permet de trouver l'historique d'un client à partir de son ID
        for (int i = 0; i < historiques.size(); i++)
            if (historiques.get(i).getUserCardNumber().equals(idUser))
                return historiques.get(i);
        return null;
    }

    private void getInfos() throws FileNotFoundException, IOException {
        // hist bancaire
        Infos histsBancaires = super.getInfo("HistoriqueBancaire.txt");
        for (ArrayList<String> info : histsBancaires) {
            System.out.println(info.get(0));
            HistoriqueBancaire hB = new HistoriqueBancaire(info.get(1)
                    , Integer.parseInt(info.get(2)));
            Historique hist = findClientHist(info.get(0));
            if (hist != null)
                hist.getBankHistList().add(hB);
            else {
                hist = new Historique(info.get(0));
                hist.getBankHistList().add(hB);
                this.historiques.add(hist);
            }
        }

        // hist loc
        Infos histsLocs = super.getInfo("HistoriqueLocations.txt");
        for (ArrayList<String> info : histsLocs) {
            HistoriqueLocation hB = new HistoriqueLocation(info.get(1), info.get(2), info.get(3)
                    , Integer.parseInt(info.get(4)), info.get(5));
            Historique hist = findClientHist(info.get(0));
            if (hist != null)
                hist.getRentHistList().add(hB);
            else {
                hist = new Historique(info.get(0));
                hist.getRentHistList().add(hB);
                historiques.add(hist);
            }
        }

        // Les Clients
        Infos clients = super.getInfo("Clients.txt");
        for (ArrayList<String> info : clients) {
            Historique hist = findClientHist(info.get(0));
            hist = (hist == null) ? new Historique(info.get(0)) : hist;
            Client client = new Client(info.get(0), info.get(1), info.get(2), info.get(3)
                    , (info.get(4).equals("true")) ? true : false, Integer.parseInt(info.get(5)), hist);
            this.clients.add(client);
        }

        // Les techniciens
        Infos techniciens = super.getInfo("Techniciens.txt");
        for (ArrayList<String> info : techniciens) {
            Technicien technicien = new Technicien(info.get(0));
            this.techniciens.add(technicien);
        }

        // Films
        Infos films = super.getInfo("Films.txt");
        for (ArrayList<String> info : films) {
            Film f = new Film(info.get(0), info.get(1), info.get(2)
                    , info.get(3), Integer.parseInt(info.get(4)), false, false);
            this.films.add(f);
        }

        // demandes d'ajouts
        Infos demandes = super.getInfo("DemandesFilms.txt");
        for (ArrayList<String> info : demandes) {
            DemandeAjoutFilm daf = new DemandeAjoutFilm(info.get(0), info.get(1));
            ajoutsFilms.add(daf);
        }
    }

    public Boolean askFilm(String titre, String realisateur) {
        // Regarde si le film est dans les demandes actuelles
        for (DemandeAjoutFilm daf : ajoutsFilms)
            if (daf.titre.equals(titre) && daf.realisateur.equals(realisateur))
                return false;
        // Regarde si le film existe dans la BD de cyber video
        Boolean found = false;
        int i = 0;
        while (!found && films.size() > i) {
            Film f = films.get(i);
            if (f.getTitle().equals(titre) && f.getDirector().equals(realisateur))
                found = true;
            i++;
        }
        if (!found)// si il n'existe pas dans la BD
            return false;
        ajoutsFilms.add(new DemandeAjoutFilm(titre, realisateur));
        return true;
    }

    public ArrayList<Film> getFilms() {
        return films;
    }

    public ArrayList<DemandeAjoutFilm> getDemandesAjoutsFilms() {
        return ajoutsFilms;
    }

    public Client identification(String numCarte) {
        for (Client c : clients)
            if (c.getCardNumber().equals(numCarte))
                return c;
        return null;
    }

    public Technicien identificationTechnicien(String numCarte) {
        for (Technicien t : techniciens)
            if (t.getCardNumber().equals(numCarte))
                return t;
        return null;
    }

    public Boolean supprimerClient(Client c) {
        for (int i = 0; i < clients.size(); i++) {
            if (c.getCardNumber().equals(clients.get(i).getCardNumber())) {
                clients.remove(i);
                return true;
            }
        }
        return false;
    }

    public Boolean addClient(Client c) {
        if (this.identification(c.getCardNumber()) != null)
            return false;
        clients.add(c);
        return true;
    }

    public void commit() throws IOException {
        // reconstruction des historiques
        ArrayList<Historique> newHistoriques = new ArrayList<Historique>();
        for (Client c : clients)
            newHistoriques.add(c.getHistoric());
        historiques = newHistoriques;
        write();
    }

    private void write() throws IOException {//ecriture des donnees dans les differents fichiers
        // Historiques
        ArrayList<HBWrapper> hbs = new ArrayList<HBWrapper>();
        ArrayList<HLWrapper> hls = new ArrayList<HLWrapper>();
        for (Historique h : historiques) {
            for (HistoriqueBancaire hb : h.getBankHistList())
                hbs.add(new HBWrapper(hb, h.getUserCardNumber()));
            for (HistoriqueLocation hl : h.getRentHistList())
                hls.add(new HLWrapper(hl, h.getUserCardNumber()));
        }

        // historique bancaire
        super.write("HistoriqueBancaire.txt", new Infos.Writable<HBWrapper>(hbs) {
            public String parse(HBWrapper hb) {
                return hb.numCarte + ";" + hb.hb.getDate() + ";"
                        + hb.hb.getAmount();
            }
        });// historique locations
        super.write("HistoriqueLocations.txt", new Infos.Writable<HLWrapper>(hls) {
            public String parse(HLWrapper hl) {
                return hl.numCarte + ";" + hl.hl.getDate() + ";" + hl.hl.getMovieTitle() +
                        ";" + hl.hl.getDirector() + ";" + hl.hl.getLocationPrice() + ";" +
                        hl.hl.getActionType();
            }
        });

        // Clients
        super.write("Clients.txt", new Infos.Writable<Client>(clients) {
            public String parse(Client c) {
                return c.getCardNumber() + ";" + c.getName() + ";" + c.getFirstName() + ";" + c.getAddress() +
                        ";" + c.getIsSubscribed() + ";" + c.getCurrentBalance();
            }
        });

        // Techniciens
        super.write("Techniciens.txt", new Infos.Writable<Technicien>(techniciens) {
            public String parse(Technicien c) {
                return c.getCardNumber();
            }
        });

        // Films
        super.write("Films.txt", new Infos.Writable<Film>(films) {
            public String parse(Film f) {
                return f.getTitle() + ";" + f.getDirector() + ";" + f.getResume() + ";" +
                        f.getPoster() + ";" + f.getNbAvailable();
            }
        });

        // Demandes ajouts de films
        super.write("DemandesFilms.txt", new Infos.Writable<DemandeAjoutFilm>(ajoutsFilms) {
            public String parse(DemandeAjoutFilm daf) {
                return daf.titre + ";" + daf.realisateur;
            }
        });
    }

    public class DemandeAjoutFilm {
        String titre;

        public String getTitre() {
            return titre;
        }

        public String getRealisateur() {
            return realisateur;
        }

        String realisateur;

        public DemandeAjoutFilm(String titre, String realisateur) {
            this.titre = titre;
            this.realisateur = realisateur;
        }
    }

    private class HBWrapper {//HistoriqueBancaireWrapper
        HistoriqueBancaire hb;
        String numCarte;

        public HBWrapper(HistoriqueBancaire hb, String carte) {
            this.hb = hb;
            this.numCarte = carte;
        }
    }

    private class HLWrapper {//HistoriqueLocationWrapper
        HistoriqueLocation hl;
        String numCarte;

        public HLWrapper(HistoriqueLocation hl, String carte) {
            this.hl = hl;
            this.numCarte = carte;
        }
    }
}