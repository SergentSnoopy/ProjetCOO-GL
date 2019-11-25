package Fonct.Historique;

import java.util.Objects;

public class HistoriqueLocation {

    private String date;
    private String movieTitle;
    private String director;
    private int locationPrice;
    private String actionType;

    //Constructeur de HistoriqueLocation
    public HistoriqueLocation(String date, String movieTitle, String director, int locationPrice, String actionType) {
        this.date = date;
        this.movieTitle = movieTitle;
        this.director = director;
        this.locationPrice = locationPrice;
        this.actionType = actionType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoriqueLocation that = (HistoriqueLocation) o;
        return movieTitle.equals(that.movieTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieTitle);
    }

    public String getDate() {
        return date;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getDirector() {
        return director;
    }

    public int getLocationPrice() {
        return locationPrice;
    }

    public String getActionType() {
        return actionType;
    }

    @Override
    public String toString() {
        return "Date:" + date + ' ' +
                ", Titre:" + movieTitle + ' ' +
                ", Etat:" + actionType;
    }
}
