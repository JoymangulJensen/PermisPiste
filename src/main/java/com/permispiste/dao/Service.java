package com.permispiste.dao;

import com.permispiste.errorhandlers.ServiceHibernateException;
import com.permispiste.model.ActionEntity;
import com.permispiste.service.ServiceHibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by JOYMANGUL Jensen Selwyn
 * on 5/4/2017.
 */
public class Service {

    public List<ActionEntity> consulterListeAdherents() throws ServiceHibernateException {
        List<ActionEntity> actions = null;
         String marequete = "SELECT a FROM ActionEntity a";
        try {

            Session session = ServiceHibernate.currentSession();
            TypedQuery<ActionEntity> query = session.createQuery(marequete);
            actions = query.getResultList();
            session.close();

        } catch (HibernateException ex) {
            throw new ServiceHibernateException(ex.getMessage());
        }
        return actions;

    }
}
