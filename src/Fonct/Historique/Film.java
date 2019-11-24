package Fonct.Historique;

import java.util.Objects;

public class Film {
    private String title;
    private String director;
    private int nbAvailable;
    private String resume;
    private Boolean topSale;
    private String poster;
    private Boolean novelty;

    public Film(String title, String director, String resume, String poster, int nbAvailable, Boolean topSale, Boolean novelty) {
        this.title = title;
        this.director = director;
        this.resume = resume;
        this.nbAvailable = nbAvailable;
        this.topSale = topSale;
        this.poster = poster;
        this.novelty =novelty;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public void rentMovie() {
        nbAvailable--;
    }

    public void returnMovie() {
        nbAvailable++;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getNbAvailable() {
        return nbAvailable;
    }

    public void setNbAvailable(int nbAvailable) {
        this.nbAvailable = nbAvailable;
    }

    public Boolean getTopSale() {
        return topSale;
    }

    public void setTopSale(Boolean topSale) {
        this.topSale = topSale;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return Objects.equals(title, film.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return title;
    }

    public Boolean getNovelty() {
        return novelty;
    }

    public void setNovelty(Boolean novelty) {
        this.novelty = novelty;
    }
}
