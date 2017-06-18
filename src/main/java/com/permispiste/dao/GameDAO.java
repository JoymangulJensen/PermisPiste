package com.permispiste.dao;

/**
 * Created by JOYMANGUL Jensen Selwyn
 * on 6/18/2017.
 */
public class GameDAO  extends DAO {
    public long count(){
        return super.count("JeuEntity");
    }
}
