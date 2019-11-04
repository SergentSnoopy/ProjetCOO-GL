package Fonct.Historique;

import java.util.Date;

public class HistoriqueLocation {

    private Date Date;
    private Film LocationFilm;
    private int PrixLocation;
    private String typeDaction;

    public HistoriqueLocation(Date Date, Film LocationFilm,int PrixLocation, String typeDaction){
        this.Date=Date;
        this.LocationFilm=LocationFilm;
        this.PrixLocation=PrixLocation;
        this.typeDaction=typeDaction;
    }
}
