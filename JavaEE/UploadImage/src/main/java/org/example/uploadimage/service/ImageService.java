package org.example.uploadimage.service;

import org.example.uploadimage.model.Image;
import org.example.uploadimage.repository.Repository;
import org.hibernate.query.Query;

import java.util.List;

public class ImageService extends BaseService implements Repository {

    @Override
    public boolean create(Object o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Object o) {
        return false;
    }

    @Override
    public boolean delete(Object o) {
        return false;
    }

    @Override
    public Object findById(int id) {
        return null;
    }

    @Override
    public List<Image> findAll() {
        List<Image> imageList = null;
        session =sessionFactory.openSession();
        Query<Image> imageQuery = session.createQuery("from Image ");
        imageList = imageQuery.list();
        session.close();
        return imageList;
    }
}
