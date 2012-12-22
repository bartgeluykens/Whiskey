package be.collections.whiskey.dao.impl;

import be.collections.whiskey.dao.GenericDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Autor bart
 * Omschrijving:
 * Aangemaakt op: 12/14/12
 */
public class GenericDAOImpl <T> implements GenericDAO<T>{

    private Class<T> clazz;

    @Autowired
    protected SessionFactory sessionFactory;

    public GenericDAOImpl() {
    }

    public GenericDAOImpl(Class<T> clazz) {
      this.clazz = clazz;
    }

    public T save(T object) {
      sessionFactory.getCurrentSession().saveOrUpdate(object);
      return object;
    }

    @Override
    public void evict(T object) {
      sessionFactory.getCurrentSession().evict(object);
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(Long id) {
      return (T) sessionFactory.getCurrentSession().get(clazz, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void remove (T object) {
      sessionFactory.getCurrentSession().delete(object);
    }
}
