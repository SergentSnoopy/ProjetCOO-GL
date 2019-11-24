package Fonct.Historique;

public class HistoriqueLocation {

    private String date;
    private String movieTitle;
    private String director;
    private int locationPrice;
    private String actionType;

    public HistoriqueLocation(String date, String movieTitle, String director, int locationPrice, String actionType) {
        this.date = date;
        this.movieTitle = movieTitle;
        this.director = director;
        this.locationPrice = locationPrice;
        this.actionType = actionType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLocationPrice() {
        return locationPrice;
    }

    public void setLocationPrice(int locationPrice) {
        this.locationPrice = locationPrice;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    @Override
    public String toString() {
        return "Date:" + date + ' ' +
                ", Titre:" + movieTitle + ' ' +
                ", Etat:" + actionType;
    }
}
