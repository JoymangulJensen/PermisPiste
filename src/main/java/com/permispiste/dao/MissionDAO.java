package com.permispiste.dao;

import java.util.List;

/**
 * Created by JOYMANGUL Jensen Selwyn
 * on 6/18/2017.
 */
public class MissionDAO  extends DAO {

    public List findAll() {
        String request = "SELECT m FROM MissionEntity m ORDER BY m.nummission";
        return getList(request);
    }

    public long count(){
        return super.count("MissionEntity");
    }
}
