package com.permispiste.dao;

import com.permispiste.errorhandlers.ServiceHibernateException;
import com.permispiste.service.ServiceHibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by Gaetan on 18/06/2017.
 * DAO
 */
public abstract class DAO {

    protected List getList(String request) {
        List result = null;
        try {
            Session session = ServiceHibernate.currentSession();
            Query query = session.createQuery(request);
            result = query.getResultList();
            session.close();
        } catch (HibernateException ex) {
            throw new ServiceHibernateException("Impossible d'accèder à la SessionFactory: " + ex.getMessage());
        }
        return result;
    }

    protected long count(String entity)
    {
        long result = 0;
        try {
            Session session = ServiceHibernate.currentSession();
            String request = "SELECT count(*) FROM " + entity;
            Query query = session.createQuery(request);
            result = (long) query.uniqueResult();
            session.close();
        } catch (HibernateException ex) {
            throw new ServiceHibernateException("Impossible d'accèder à la SessionFactory: " + ex.getMessage());
        }
        return result;
    }

}
