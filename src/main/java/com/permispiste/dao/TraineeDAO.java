package com.permispiste.dao;

import java.util.List;

/**
 * Created by Gaetan on 18/06/2017.
 * DAO to Trainee
 */
public class TraineeDAO extends DAO {

    public List findAll() {
        String request = "SELECT a FROM ApprenantEntity a ORDER BY a.numapprenant";
        return getList(request);
    }

    public long count(){
        return super.count("ApprenantEntity");
    }

}
