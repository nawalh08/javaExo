package org.example;

import java.time.LocalDate;
import java.util.Date;

public class Film {

    private String titre;
    private String realisateur;
    private LocalDate dateSortie;
    private String genre;

    public Film(String titre, String realisateur, LocalDate dateSortie, String genre){
        this.titre = titre;
        this.realisateur = realisateur;
        this.dateSortie = dateSortie;
        this.genre = genre;

    }



    public String getTitre() { // accesseur/getter de Nom
        return titre;
    }

    public void setTitre(String titre) { // mutateur/setter de Nom
        this.titre = titre;
    }
    public String getRealisateur() { // accesseur/getter de Nom
        return realisateur;
    }

    public void setRealisateur(String realisateur) { // mutateur/setter de Nom
        this.realisateur = realisateur;
    }
    public String getGenre() { // accesseur/getter de Nom
        return genre;
    }

    public void setGenre(String genre) { // mutateur/setter de Nom
        this.genre = genre;
    }
    public LocalDate getDateSortie() { // accesseur/getter de Nom
        return dateSortie;
    }

    public void setDateSortie(LocalDate dateSortie) { // mutateur/setter de Nom
        this.dateSortie = dateSortie;
    }
    public String toString(){
        return "Film {titre : '" + this.titre +"', realisateur : '" + this.realisateur + "', dateSortie = " + this.dateSortie+ ", genre : '" + this.genre + "'}";
    }
}
