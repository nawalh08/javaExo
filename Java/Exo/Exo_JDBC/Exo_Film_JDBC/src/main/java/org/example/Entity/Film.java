package org.example.Entity;

import lombok.Builder;
import lombok.Data;



import java.time.LocalDate;

@Data
@Builder

public class Film {
    private String titre;
    private String realisateur;
    private LocalDate dateSortie;
    private String genre;

    public Film(String titre, String realisateur, LocalDate dateSortie, String genre) {
        this.titre = titre;
        this.realisateur = realisateur;
        this.dateSortie = dateSortie;
        this.genre = genre;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public LocalDate getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(LocalDate dateSortie) {
        this.dateSortie = dateSortie;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Film{" +
                "titre='" + titre + '\'' +
                ", realisateur='" + realisateur + '\'' +
                ", dateSortie=" + dateSortie +
                /*", dateSortie=" + dateSortie.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)) +*/
                ", genre='" + genre + '\'' +
                '}';
    }

    public void afficher() {
        System.out.println(this); // passe par le .toString()
//        System.out.println(this.toString());

//        var str = String.format("Bonjour %s !", "Fares");
//        var str2 = String.format("Bonjour %s ! J'espère que tu vas %s.", "Fares", "bien");
//        var str3 = String.format("Bonjour %2s ! J'espère que tu vas %1s.", "Fares", "bien");

//        System.out.printf("Film: %s, réalisateur: %s, date de sortie: %s, genre: %s\n", titre, realisateur, dateSortie.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)), genre);
    }
}
