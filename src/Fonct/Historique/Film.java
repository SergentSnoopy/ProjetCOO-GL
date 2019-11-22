package Fonct.Historique;

import java.util.Objects;

public class Film {
    private String Titre;
    private String Realisateur;
    private int NbDispo;
    private String resume;
    private Boolean TopVente;
    private String Affiche;

    public Film(String titre, String Realisateur,String resume, String Affiche, int NbDispo, Boolean TopVente){
        this.Titre=titre;
        this.Realisateur=Realisateur;
        this.resume=resume;
        this.NbDispo=NbDispo;
        this.TopVente=TopVente;
        this.Affiche=Affiche;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public void louerUnFilm(){
        NbDispo--;
    }

    public void rendreUnFilm(){
        NbDispo++;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String titre) {
        Titre = titre;
    }

    public String getRealisateur() {
        return Realisateur;
    }

    public void setRealisateur(String realisateur) {
        Realisateur = realisateur;
    }

    public int getNbDispo() {
        return NbDispo;
    }

    public void setNbDispo(int nbDispo) {
        NbDispo = nbDispo;
    }

    public Boolean getTopVente() {
        return TopVente;
    }

    public void setTopVente(Boolean topVente) {
        TopVente = topVente;
    }

    public String getAffiche() {
        return Affiche;
    }

    public void setAffiche(String affiche) {
        Affiche = affiche;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return Objects.equals(Titre, film.Titre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Titre);
    }

    @Override
    public String toString() {
        return Titre;
    }
}
