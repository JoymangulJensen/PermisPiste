package com.permispiste.dao;

import com.permispiste.model.JeuEntity;

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
}
