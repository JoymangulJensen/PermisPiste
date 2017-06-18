package com.permispiste.dao;

import com.permispiste.errorhandlers.ServiceHibernateException;
import com.permispiste.model.JeuEntity;
import com.permispiste.model.MissionEntity;
import com.permispiste.service.ServiceHibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by JOYMANGUL Jensen Selwyn
 * on 6/18/2017.
 */
public class MissionDAO  extends DAO {
    public long count(){
        return super.count("MissionEntity");
    }

    public List findAll() {
        String request = "SELECT a FROM MissionEntity a ORDER BY a.nummission";
        return getList(request);
    }

    public List findByGame(JeuEntity game) {
        Session session = null;
        List result = null;
        String request = "SELECT a FROM MissionEntity a WHERE a.jeuByNumjeu=:test";
        try {
            session = ServiceHibernate.currentSession();
            Query query = session.createQuery(request);
            query.setParameter("test",game);
            result = query.getResultList();
        } catch (HibernateException ex) {
            throw new ServiceHibernateException("Impossible d'accèder à la SessionFactory: " + ex.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
            }
        }
        return result;
    }

    public MissionEntity find(int id) {
        return (MissionEntity) find(MissionEntity.class, id);
    }
}
