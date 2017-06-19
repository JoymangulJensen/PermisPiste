package com.permispiste.dao;

import com.permispiste.errorhandlers.ServiceHibernateException;
import com.permispiste.model.FixeEntity;
import com.permispiste.model.JeuEntity;
import com.permispiste.service.ServiceHibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by JOYMANGUL Jensen Selwyn
 * on 6/18/2017.
 */
public class FixeDAO  extends DAO {
    public long count(){
        return super.count("JeuEntity");
    }

    public FixeEntity find(int idmission, int idobjectif) {
        Session session = null;
        FixeEntity result;
        String request = "SELECT f FROM FixeEntity f WHERE f.nummission=:idmission and f.numobjectif = :idobjectif";
        try {
            session = ServiceHibernate.currentSession();
            Query query = session.createQuery(request);
            query.setParameter("idmission",idmission);
            query.setParameter("idobjectif",idobjectif);
            result = (FixeEntity) query.getSingleResult();
        } catch (HibernateException ex) {
            throw new ServiceHibernateException("Impossible d'accèder à la SessionFactory: " + ex.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
            }
        }
        return result;
    }

    public void delete(int idmission, int idobjectif) {
        FixeEntity fixeEntity = this.find(idmission, idobjectif);
        this.delete(fixeEntity);
        /*
        Session session = null;
        String request = "delete from FixeEntity where nummission = :idmission and numobjectif= :idobjectif";
        try {
            session = ServiceHibernate.currentSession();
            Query query = session.createQuery(request);
            query.setParameter("idmission",idmission);
            query.setParameter("idobjectif",idobjectif);
            query.executeUpdate();
        } catch (HibernateException ex) {
            throw new ServiceHibernateException("Impossible d'accèder à la SessionFactory: " + ex.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
            }
        }
        */
    }
}
