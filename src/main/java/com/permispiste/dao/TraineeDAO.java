package com.permispiste.dao;

import com.permispiste.errorhandlers.ServiceHibernateException;
import com.permispiste.model.ApprenantEntity;
import com.permispiste.service.ServiceHibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by Gaetan on 18/06/2017.
 * DAO to Trainee
 */
public class TraineeDAO extends DAO {

    public List findAll() {
        String request = "SELECT a FROM ApprenantEntity a ORDER BY a.numapprenant";
        return getList(request);
    }

    public long count(){
        return super.count("ApprenantEntity");
    }

    public ApprenantEntity find(int id) {
        return (ApprenantEntity) find(ApprenantEntity.class, id);
    }

    public List findByGame(int idgame) {
        Session session = null;
        List result = null;
        String request = "SELECT a FROM ApprenantEntity a, InscriptionEntity i WHERE i.numapprenant=a.numapprenant and i.numjeu=:id_game";
        try {
            session = ServiceHibernate.currentSession();
            Query query = session.createQuery(request);
            query.setParameter("id_game",idgame);
            result = query.getResultList();
        } catch (HibernateException ex) {
            throw new ServiceHibernateException("Impossible d'accèder à la SessionFactory: " + ex.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }

}
