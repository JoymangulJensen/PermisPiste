package com.permispiste.dao;

import java.util.List;

/**
 * Created by JOYMANGUL Jensen Selwyn
 * on 6/18/2017.
 */
public class ActionDAO  extends DAO {

    public List findAll() {
        String request = "SELECT ac FROM ActionEntity ac ORDER BY ac.numaction";
        return getList(request);
    }

    public long count(){
        return super.count("ActionEntity");
    }
}
