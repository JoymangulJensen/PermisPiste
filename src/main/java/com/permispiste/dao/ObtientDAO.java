package com.permispiste.dao;

import com.permispiste.errorhandlers.ServiceHibernateException;
import com.permispiste.model.FixeEntity;
import com.permispiste.model.JeuEntity;
import com.permispiste.model.ObtientEntity;
import com.permispiste.service.ServiceHibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import java.util.List;

/**
 * Created by JOYMANGUL Jensen Selwyn
 * on 6/18/2017.
 */
public class ObtientDAO extends DAO {
    public long count(){
        return super.count("ObtientEntity");
    }

    public List findAll() {
        String request = "SELECT o FROM ObtientEntity a";
        return getList(request);
    }

    public ObtientEntity find(int id_trainee, int id_action) {
        Session session = null;
        ObtientEntity result = null;
        String request = "SELECT o FROM ObtientEntity o WHERE o.numapprenant=:id_trainee and o.numaction= :id_action";
        try {
            session = ServiceHibernate.currentSession();
            Query query = session.createQuery(request);
            query.setParameter("id_trainee",id_trainee);
            query.setParameter("id_action",id_action);
            result = (ObtientEntity) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
        catch (HibernateException ex) {
            throw new ServiceHibernateException("Impossible d'accèder à la SessionFactory: " + ex.getMessage());
        }
        return result;
    }

}
