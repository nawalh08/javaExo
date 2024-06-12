package org.example.exercice_5.service;

import org.example.exercice_5.interfaces.Repository;
import org.example.exercice_5.model.Dog;
import org.hibernate.query.Query;

import java.util.List;

public class DogService extends BaseService implements Repository<Dog> {

    public DogService(){ super();}

    @Override
    public boolean create(Dog o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Dog o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Dog o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Dog findById(int id) {
        session = sessionFactory.openSession();
        Dog dog = session.get(Dog.class,id);
        session.close();
        return dog;
    }

    @Override
    public List<Dog> findAll() {
        List<Dog> dogList = null;
        session = sessionFactory.openSession();
        Query<Dog> produitQuery = session.createQuery("from Dog ");
        dogList = produitQuery.list();
        session.close();
        return dogList;
    }
}
