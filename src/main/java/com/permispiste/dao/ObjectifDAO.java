package com.permispiste.dao;

import com.permispiste.model.ObjectifEntity;
import com.permispiste.model.IEntity;

import java.util.List;

/**
 * Created by Gaetan on 18/06/2017.
 * DAO to Trainee
 */
public class ObjectifDAO extends DAO {

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

}
