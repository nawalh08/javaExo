package org.example.Hotel.Models;

public class Client {

    private String nom,prenom,phoneNumber;

    private int idClient;

    private static int nbClient = 1;

    public Client(String nom, String prenom, String phoneNumber) {
        this.nom = nom;
        this.prenom = prenom;
        this.phoneNumber = phoneNumber;
        this.idClient = nbClient;
        nbClient++;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    @Override
    public String toString() {
        return "Client{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", idClient=" + idClient +
                '}';
    }
}
