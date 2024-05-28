package org.example;

public class RealBook implements Book{

    private String titre;

    private String contenu;

    public RealBook(String titre, String contenu) {
        this.titre = titre;
        this.contenu = contenu;
    }

    @Override
    public void readBook(boolean isUserPremium){


            System.out.println("RealBook{" +
                    "titre='" + titre + '\'' +
                    ", contenu='" + contenu + '\'' +
                    '}');

    };


}
