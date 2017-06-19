package com.permispiste.dao;

import com.permispiste.errorhandlers.ServiceHibernateException;
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
public class GameDAO  extends DAO {
    public long count(){
        return super.count("JeuEntity");
    }

    public List findAll() {
        String request = "SELECT a FROM JeuEntity a ORDER BY a.numjeu";
        return getList(request);
    }

    public JeuEntity find(int id) {
        return (JeuEntity) find(JeuEntity.class, id);
    }

    public List findByTrainee(int id_trainee) {
        Session session = null;
        List result = null;
        String request = "SELECT j FROM JeuEntity j, InscriptionEntity i WHERE i.numjeu=j.numjeu and i.numapprenant=:id_trainee";
        try {
            session = ServiceHibernate.currentSession();
            Query query = session.createQuery(request);
            query.setParameter("id_trainee",id_trainee);
            result = query.getResultList();
        } catch (HibernateException ex) {
            throw new ServiceHibernateException("Impossible d'accèder à la SessionFactory: " + ex.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
//                session.close();
            }
        }
        return result;
    }
}
