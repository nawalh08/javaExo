package org.example.exercice_6_gestionproduit.service;

import org.example.exercice_6_gestionproduit.interfaces.Repository;
import org.example.exercice_6_gestionproduit.model.Users;
import org.hibernate.query.Query;

import java.util.List;

public class UserService extends BaseService implements Repository<Users> {
    public UserService(){
        super();
    }


    @Override
    public boolean create(Users o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Users o) {
        return false;
    }

    @Override
    public boolean delete(Users o) {
        return false;
    }

    @Override
    public Users findById(int id) {
        session = sessionFactory.openSession();
        Users users = session.get(Users.class,id);
        session.close();
        return users;
    }

    @Override
    public List<Users> findAll() {
        List<Users> usersList = null;
        session = sessionFactory.openSession();
        Query<Users> produitQuery = session.createQuery("from Users ");
        usersList = produitQuery.list();
        session.close();
        return usersList;
    }


    public Users getByparams(String name , String email , String password){
        session = sessionFactory.openSession();
        Users userFind = null ;
        Query<Users> usersQuery = session.createQuery("from Users where name = :name and email = :email and password= :password ");
        usersQuery.setParameter("name", name);
        usersQuery.setParameter("email", email);
        usersQuery.setParameter("password" , password);
        userFind = usersQuery.uniqueResult();
        session.close();
        return userFind;
    }
}
