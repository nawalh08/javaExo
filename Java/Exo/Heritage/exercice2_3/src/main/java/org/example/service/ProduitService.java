package org.example.service;

import org.example.entity.Produit;
import org.example.interfaces.Repository;
import org.hibernate.query.Query;


import java.util.Date;
import java.util.List;
import java.util.Queue;

public class ProduitService extends BaseService implements Repository<Produit> {

    public ProduitService(){
        super();
    }


    @Override
    public boolean create(Produit o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Produit o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Produit o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Produit findById(int id) {
       // Produit produit = null;
        session = sessionFactory.openSession();
        Produit produit = session.get(Produit.class,id);
        session.close();
        return produit;
    }


    // 1. Afficher la totalité des produits
    @Override
    public List<Produit> findAll() {
        List<Produit> produitList = null;
        session = sessionFactory.openSession();
        Query<Produit> produitQuery = session.createQuery("from Produit ");
        produitList = produitQuery.list();
        session.close();
        return produitList;
    }

    public void close(){
        sessionFactory.close();
    }




    //  2. Afficher la liste des produits dont le prix est supérieur à 100 euros
    public List<Produit> filterByPrice(double min) throws Exception {
        if(min > 0) {
            session = sessionFactory.openSession();
            Query<Produit> produitQuery = session.createQuery("from Produit where prix >= :minprice");
            produitQuery.setParameter("minprice",min);
            List<Produit> produitList = produitQuery.list();
            session.close();
            return produitList;
        }
        throw  new Exception("erreur valeur min");
    }

    //  3. Afficher la liste des produits achetés entre deux dates.

    public List<Produit> filterByDate(Date min, Date max) throws Exception{
        if(min.before(max)){
            session = sessionFactory.openSession();
            Query<Produit> produitQuery = session.createQuery("from Produit where dateAchat >= :datemin and dateAchat <= :datemax");
            produitQuery.setParameter("datemin",min);
            produitQuery.setParameter("datemax",max);
            List<Produit> produitList = produitQuery.list();
            session.close();
            return produitList;
        }
        throw  new Exception("erreur date");
    }

    //  2. retourner les numéros et reference des articles dont le stock est inférieur à une valeur lue au clavier.
    public List<Produit> filterByStockMax(int max) throws Exception {
        if(max > 0) {
            session = sessionFactory.openSession();
            Query<Produit> produitQuery = session.createQuery("from Produit where stock < :stockmax");
            produitQuery.setParameter("stockmax",max);
            List<Produit> produitList = produitQuery.list();
            session.close();
            return produitList;
        }
        throw  new Exception("erreur valeur");
    }


    //Afficher la valeur du stock des produits d'une marque choisie.
    public double prixTotalStock(String marque) throws Exception {
        session = sessionFactory.openSession();
        Query<Double> produitQuery = session.createQuery(" SELECT SUM(stock*prix) FROM Produit WHERE marque = :marque");
        produitQuery.setParameter("marque" , marque);
       double value = produitQuery.getSingleResult();
        session.close();
        return value;


    }

    //Calculer le prix moyen des produits.
    public double prixMoyenProduits() throws Exception {
        session = sessionFactory.openSession();
        Query<Double> produitQuery = session.createQuery("SELECT AVG(prix) from Produit");

        double value = produitQuery.getSingleResult();
        session.close();
        return value;
    }

    //Récupérer la liste des produits d'une marque choisie.

    public List<Produit> listProduiMarque(String marque) throws Exception {

            session = sessionFactory.openSession();
            Query<Produit> produitQuery = session.createQuery("from Produit where marque = :marque");
            produitQuery.setParameter("marque",marque);

            List<Produit> produitList = produitQuery.list();
            session.close();
            return produitList;


    }
    // Supprimer les produits d'une marque choisie de la table produit.

    public int deleteByMarque(String marque) {
        // Produit produit = null;
        session = sessionFactory.openSession();
        Query<Produit> produitQuery = session.createQuery("DELETE FROM Produit WHERE marque = :marque");
        produitQuery.setParameter("marque",marque);
        session.getTransaction().begin();
        int success = produitQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return success;
    }

}
