package com.permispiste.dao;

import com.permispiste.errorhandlers.ServiceHibernateException;
import com.permispiste.model.ApprenantEntity;
import com.permispiste.model.IEntity;
import com.permispiste.service.ServiceHibernate;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Gaetan on 18/06/2017.
 * DAO
 */
public abstract class DAO {

    protected List getList(String request) {
        Session session = null;
        List result = null;
        try {
            session = ServiceHibernate.currentSession();
            Query query = session.createQuery(request);
            result = query.getResultList();
            session.close();
        } catch (HibernateException ex) {
            throw new ServiceHibernateException("Impossible d'accèder à la SessionFactory: " + ex.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }

    /**
     * Insert the given entity in the database
     *
     * @param entity entity to insert
     */
    public void insert(IEntity entity) {
        Transaction tx = null;
        Session session = null;
        try {
            session = ServiceHibernate.currentSession();
            tx = session.beginTransaction();
            session.save(entity);
            tx.commit();
            session.close();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
        } catch (Exception e) {
            throw new ServiceHibernateException("Impossible d'accèder à la SessionFactory: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

    }

    /**
     * Find an entity by class and by id
     * @param entityClass Class of the entity to find
     * @param id Id to find by
     * @return IEntity corresponding
     */
    protected Object find(Class entityClass, int id) {
        Session session = null;
        Object entity = null;
        try {
            session = ServiceHibernate.currentSession();
            entity = session.load(entityClass, id);
            Hibernate.initialize(entity);
        } catch (Exception e) {
            throw new ServiceHibernateException("Impossible d'accèder à la SessionFactory: " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return entity;
    }

    public boolean deleteById(Class<?> type, Serializable id) {
        Session session = ServiceHibernate.currentSession();
        Object persistentInstance = session.load(type, id);
        if (persistentInstance != null) {
            session.delete(persistentInstance);
            return true;
        }
        return false;
    }

    public void delete(IEntity entity)
    {
        Session session = ServiceHibernate.currentSession();
        session.delete(entity);
        session.flush() ;

    }

    protected long count(String entity)
    {
        long result = 0;
        try {
            Session session = ServiceHibernate.currentSession();
            String request = "SELECT count(*) FROM " + entity;
            Query query = session.createQuery(request);
            result = (long) query.uniqueResult();
        } catch (HibernateException ex) {
            throw new ServiceHibernateException("Impossible d'accèder à la SessionFactory: " + ex.getMessage());
        }
        return result;
    }

}
