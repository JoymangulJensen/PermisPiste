package com.permispiste.dao;

import com.permispiste.errorhandlers.ServiceHibernateException;
import com.permispiste.model.IEntity;
import com.permispiste.model.InscriptionEntity;
import com.permispiste.service.ServiceHibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by Gaetan on 19/06/2017.
 */
public class InscriptionDAO extends DAO {



    public long countByTraineeAndGame(int idTrainee, int idGame) {
        long result = 0;
        try {
            Session session = ServiceHibernate.currentSession();
            String request = "SELECT count(*) FROM InscriptionEntity i WHERE i.numapprenant=:id_trainee and i.numjeu=:id_game";

            Query query = session.createQuery(request);
            query.setParameter("id_trainee", idTrainee);
            query.setParameter("id_game", idGame);
            result = (long) query.uniqueResult();
        } catch (HibernateException ex) {
            throw new ServiceHibernateException("Impossible d'accèder à la SessionFactory: " + ex.getMessage());
        }
        return result;
    }

    public void insert(InscriptionEntity entity) {

    }

}
