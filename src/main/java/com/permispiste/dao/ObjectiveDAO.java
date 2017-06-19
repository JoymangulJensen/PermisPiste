package com.permispiste.dao;

import com.permispiste.errorhandlers.ServiceHibernateException;
import com.permispiste.model.ObjectifEntity;
import com.permispiste.service.ServiceHibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by Gaetan on 18/06/2017.
 * DAO to Trainee
 */
public class ObjectiveDAO extends DAO {

    public List findAll() {
        String request = "SELECT a FROM ObjectifEntity a ORDER BY a.numobjectif";
        return getList(request);
    }

    public long count(){
        return super.count("ApprenantEntity");
    }

    public ObjectifEntity find(int id) {
        return (ObjectifEntity) find(ObjectifEntity.class, id);
    }

    public List findByMission(int idmission) {
        Session session = null;
        List result = null;
        String request = "SELECT o FROM ObjectifEntity o, FixeEntity f WHERE o.numobjectif=f.numobjectif and f.nummission =:idmission";
        try {
            session = ServiceHibernate.currentSession();
            Query query = session.createQuery(request);
            query.setParameter("idmission",idmission);
            result = query.getResultList();
        } catch (HibernateException ex) {
            throw new ServiceHibernateException("Impossible d'accèder à la SessionFactory: " + ex.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
            }
        }
        return result;
    }

}
