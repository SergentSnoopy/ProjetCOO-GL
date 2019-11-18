package Fonct.Input_Output;

import Fonct.Historique.Film;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BD_locale extends BD {
	
	private class FilmWrapper{
		Film film;
		int nbLoc;
		
		public FilmWrapper(Film f,int n) {
			this.film = f;
			this.nbLoc = n;
		}
	}
	
	private ArrayList<FilmWrapper> films;
	private static int nbCol = 6;
	
    public BD_locale(String path) throws FileNotFoundException, IOException {
		super(path);
		this.films = new ArrayList<FilmWrapper>();
		Infos films = super.getInfo("film.txt");
		for(int i=1;i<films.size();i++){
			ArrayList<String> info=films.get(i);
			if(info.size() == nbCol) {
				Film film = new Film(info.get(0),info.get(1),info.get(2),info.get(3),Integer.parseInt(info.get(4)),Boolean.parseBoolean(info.get(5)));
				// remplir
				this.films.add(new FilmWrapper(film,Integer.parseInt(info.get(nbCol-2))));
			}
		}
	}
    
    private FilmWrapper findFilmWithKey(String key) {
    	for(FilmWrapper fw : this.films)
    		if(fw.film.getTitre() == key)
    			return fw;
    	return null;
    }
    
    public ArrayList<Film> getFilms(){
    	ArrayList<Film> films = new ArrayList<Film>();
    	for(FilmWrapper fw : this.films)
    		films.add(fw.film);
    	return films;
    }
    
    public int getLoc(String key) {
    	FilmWrapper fw = this.findFilmWithKey(key);
    	if(fw != null)
    		return fw.nbLoc;
    	return -1;
    }
    
    public void commit(ArrayList<Film> films) {
    	ArrayList<FilmWrapper> newFilms = new ArrayList<FilmWrapper>();
    	for(Film film : films) {
    		FilmWrapper fw = this.findFilmWithKey(film.getTitre());
    		if(fw != null) {
    			int n = film.getNbDispo() - fw.nbLoc;
    			fw.nbLoc = (n > 0)?fw.nbLoc+n:fw.nbLoc;
    		}else
    			fw = new FilmWrapper(film,0);
    		newFilms.add(fw);
    	}
    	this.films = newFilms;
    }
    
    public void write() throws IOException {
    	super.write("film.txt", new Infos.Writable<FilmWrapper>(this.films) {
    		public String parse(FilmWrapper fw) {
    			Film f = fw.film;
    			// à compléter (il manque des getters)
    			//return f.getTitre()+";"+f.getRealisateur()+";"+;
    			return "";
    		}
		});
    }
}
