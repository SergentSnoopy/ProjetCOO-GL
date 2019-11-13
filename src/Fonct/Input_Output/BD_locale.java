package IO;
//package Fonct.Input_Output;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BD_locale extends BD {
	
	private class FilmWrapper{
		Fonct.Film film;
		int nbLoc;
		
		public FilmWrapper(Fonct.Film f,int n) {
			this.film = f;
			this.nbLoc = n;
		}
	}
	
	private ArrayList<FilmWrapper> films;
	private static int nbCol = 7;
	
    public BD_locale(String path) throws FileNotFoundException, IOException {
		super(path);
		this.films = new ArrayList<FilmWrapper>();
		Infos films = super.getInfo("film.txt");
		for(ArrayList<String> info : films){
			if(info.size() == nbCol) {
				Fonct.Film film = new Fonct.Film();
				// remplir
				this.films.add(new FilmWrapper(film,Integer.parseInt(info.get(nbCol-1))));
			}
		}
	}
    
    private FilmWrapper findFilmWithKey(String key) {
    	for(FilmWrapper fw : this.films)
    		if(fw.film.getTitre() == key)
    			return fw;
    	return null;
    }
    
    public ArrayList<Fonct.Film> getFilms(){
    	ArrayList<Fonct.Film> films = new ArrayList<Fonct.Film>();
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
    
    public void commit(ArrayList<Fonct.Film> films) {
    	ArrayList<FilmWrapper> newFilms = new ArrayList<FilmWrapper>();
    	for(Fonct.Film film : films) {
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
    			Fonct.Film f = fw.film;
    			// à compléter (il manque des getters)
    			//return f.getTitre()+";"+f.getRealisateur()+";"+;
    			return "";
    		}
		});
    }
}
