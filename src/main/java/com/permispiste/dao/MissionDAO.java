package com.permispiste.dao;

import com.permispiste.model.MissionEntity;

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

    public MissionEntity find(int id) {
        return (MissionEntity) find(MissionEntity.class, id);
    }
}
