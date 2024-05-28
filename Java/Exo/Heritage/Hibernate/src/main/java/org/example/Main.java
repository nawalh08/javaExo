package org.example;

import org.example.entity.Produit;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.sql.SQLOutput;
import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registre = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registre).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.openSession();
    // creation des produits
        session.getTransaction().begin();
        Produit pr = new Produit();
        Produit pr1 = new Produit();
        Produit pr2 = new Produit();
        Produit pr3 = new Produit();
        Produit pr4 = new Produit();

//        pr.create(new Produit("marque" , "reference", new Date("2020/02/14"), 210, 20));
//        pr.create(new Produit("marque2" , "reference2", new Date("2019/02/14"), 410, 10));
//        pr.create(new Produit("marque3" , "reference3", new Date("2018/02/14"), 210, 20));
//        pr.create(new Produit("marque4" , "reference4", new Date("2017/02/14"), 210, 20));
//        pr.create(new Produit("marque5" , "reference5", new Date("2006/02/14"), 210, 20));

        pr.setMarque("marque");
        pr.setPrix(250);
        pr.setDateAchat(new Date());
        pr.setReference("reference");
        pr.setStock(20);
        session.save(pr);
        System.out.println("Id de la personne : " + pr.getId());


        pr1.setMarque("marque2");
        pr1.setPrix(250);
        pr1.setDateAchat(new Date());
        pr1.setReference("reference");
        pr1.setStock(20);
        session.save(pr1);
        System.out.println("Id de la personne : " + pr1.getId());


        pr2.setMarque("marque3");
        pr2.setPrix(250);
        pr2.setDateAchat(new Date());
        pr2.setReference("reference");
        pr2.setStock(20);
        session.save(pr2);
        System.out.println("Id de la personne : " + pr2.getId());


        pr3.setMarque("marque4");
        pr3.setPrix(250);
        pr3.setDateAchat(new Date());
        pr3.setReference("reference");
        pr3.setStock(20);
        session.save(pr3);
        System.out.println("Id de la personne : " + pr3.getId());


        pr4.setMarque("marque5");
        pr4.setPrix(250);
        pr4.setDateAchat(new Date());
        pr4.setReference("reference");
        pr4.setStock(20);
        session.save(pr4);
        System.out.println("Id de la personne : " + pr4.getId());

        session.getTransaction().commit();

        //Afficher les informations du produit dont id = 2,


        session.getTransaction().begin();
        Produit produit = session.load(Produit.class,2);
        System.out.println(produit.getMarque());

        //  Supprimer le produit dont id = 3,
//        Produit produitD = session.load(Produit.class,3);
//        session.delete(produitD);
//        session.getTransaction().commit();

        // Modifier les informations du produit dont id = 1,
        Produit produitModif = session.load(Produit.class,1);
        produitModif.setMarque("titi");
        session.update(produitModif);
        session.getTransaction().commit();


    }

}