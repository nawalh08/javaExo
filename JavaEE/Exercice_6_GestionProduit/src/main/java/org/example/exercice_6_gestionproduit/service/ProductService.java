package org.example.exercice_6_gestionproduit.service;

import org.example.exercice_6_gestionproduit.interfaces.Repository;
import org.example.exercice_6_gestionproduit.model.Products;
import org.hibernate.query.Query;

import java.util.List;

public class ProductService extends BaseService implements Repository<Products> {

    public ProductService(){
        super();
    }
    @Override
    public boolean create(Products o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Products o) {

        return false;
    }

    @Override
    public boolean delete(Products o) {

        return false;
    }

    @Override
    public Products findById(int id) {

        return null;
    }

    @Override
    public List<Products> findAll() {
        List<Products> productList = null;
        session = sessionFactory.openSession();
        Query<Products> produitQuery = session.createQuery("from Products ");
        productList = produitQuery.list();
        session.close();
        return productList;
    }
}
