package com.permispiste.dao;

/**
 * Created by JOYMANGUL Jensen Selwyn
 * on 6/18/2017.
 */
public class MissionDAO  extends DAO {
    public long count(){
        return super.count("MissionEntity");
    }
}
