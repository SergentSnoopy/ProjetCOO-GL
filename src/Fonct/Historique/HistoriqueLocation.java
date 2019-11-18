package Fonct.Historique;

import java.util.Date;

public class HistoriqueLocation {

    private String date;
    private String titreFilm;
    private String realisateur;
    private int prixLocation;
    private String typeDaction;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitreFilm() {
        return titreFilm;
    }

    public void setTitreFilm(String titreFilm) {
        this.titreFilm = titreFilm;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public int getPrixLocation() {
        return prixLocation;
    }

    public void setPrixLocation(int prixLocation) {
        this.prixLocation = prixLocation;
    }

    public String getTypeDaction() {
        return typeDaction;
    }

    public void setTypeDaction(String typeDaction) {
        this.typeDaction = typeDaction;
    }

    public HistoriqueLocation(String date, String titreFilm, String realisateur, int prixLocation, String typeDaction){
        this.date=date;
        this.titreFilm=titreFilm;
        this.realisateur=realisateur;
        this.prixLocation=prixLocation;
        this.typeDaction=typeDaction;
    }

    @Override
    public String toString() {
        return  "date='" + date + '\'' +
                ", titreFilm='" + titreFilm + '\'' +
                ", realisateur='" + realisateur + '\'' +
                ", prixLocation=" + prixLocation +
                ", typeDaction='" + typeDaction;
    }
}
