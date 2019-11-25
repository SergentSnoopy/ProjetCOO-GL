package Fonct.Input_Output;

import Fonct.Historique.Film;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class BD_Locale extends BD {

    private ArrayList<FilmWrapper> films;

    public BD_Locale(String path) throws FileNotFoundException, IOException {
        super(path);
        this.films = new ArrayList<FilmWrapper>();
        Infos films = super.getInfo("Films.txt");
        for (ArrayList<String> info : films) {
            Film film = new Film(info.get(0), info.get(1), info.get(2), info.get(3)
                    , Integer.parseInt(info.get(4)), (info.get(5).equals("true")) ? true : false,(info.get(6).equals("true")) ? true : false);
            this.films.add(new FilmWrapper(film, Integer.parseInt(info.get(7))));
        }
    }

    private FilmWrapper findFilmWithKeys(String titre, String realisateur) {//chercher un film dans la BD
        for (FilmWrapper fw : this.films)
            if (fw.film.getTitle().equals(titre) && fw.film.getDirector().equals(realisateur))
                return fw;
        return null;
    }

    public ArrayList<Film> getFilms() {//renvoie la liste de film
        ArrayList<Film> films = new ArrayList<Film>();
        for (FilmWrapper fw : this.films)
            films.add(fw.film);
        return films;
    }

    public int getLoc(Film f) {//renvoie le nombre de location d'un film dans le mois courant
        FilmWrapper fw = this.findFilmWithKeys(f.getTitle(), f.getDirector());
        if (fw != null)
            return fw.nbLoc;
        return -1;
    }

    public void commit(ArrayList<Film> films) throws IOException {
        // reconstruction de la liste de films
        // si on a eu des locations alors màj du nombre de films loués
        // si on a des films qui ne sont plus dispos (suppr par un tech) on les supprime
        ArrayList<FilmWrapper> newFilms = new ArrayList<FilmWrapper>();
        for (Film film : films) {
            FilmWrapper fw = this.findFilmWithKeys(film.getTitle(), film.getDirector());
            if (fw != null) {
                int n = film.getNbAvailable() - fw.nbLoc;
                fw.nbLoc = (n > 0) ? fw.nbLoc + n : fw.nbLoc;
            } else
                fw = new FilmWrapper(film, 0);
            newFilms.add(fw);
        }
        this.films = newFilms;
        write();
    }

    private void write() throws IOException {
        super.write("Films.txt", new Infos.Writable<FilmWrapper>(this.films) {
            public String parse(FilmWrapper fw) {
                Film f = fw.film;
                return f.getTitle() + ";" + f.getDirector() + ";" + f.getResume() + ";" + f.getPoster() + ";" + f.getNbAvailable()
                        + ";" + f.getTopSale() + ";" + f.getNovelty() +";" +fw.nbLoc;
            }
        });
    }

    private class FilmWrapper {
        Film film;
        int nbLoc;

        public FilmWrapper(Film f, int n) {
            this.film = f;
            this.nbLoc = n;
        }
    }
}