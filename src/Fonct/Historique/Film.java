package Fonct.Historique;

public class Film {
    private String Titre;
    private String Realisateur;
    private int NbDispo;
    private Boolean TopVente;
    private String Affiche;

    public Film(String titre, String Realisateur,int NbDispo, Boolean TopVente, String Affiche){
        this.Titre=titre;
        this.Realisateur=Realisateur;
        this.NbDispo=NbDispo;
        this.TopVente=TopVente;
        this.Affiche=Affiche;
    }

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
