package Fonct.Historique;

public class Film {
    private String Titre;
    private String Realisateur;
    private int NbDispo;
    private Boolean TopVente;
    private String Affiche;

    public void RetirerUnFilm(){
        NbDispo--;
    }

    public void RendreUnFilm(){
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
}
