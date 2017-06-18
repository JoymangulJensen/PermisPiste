package com.permispiste.controller;

import com.permispiste.dao.ActionDAO;
import com.permispiste.dao.GameDAO;
import com.permispiste.dao.MissionDAO;
import com.permispiste.dao.TraineeDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by JOYMANGUL Jensen Selwyn
 * on 6/17/2017.
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView Afficheindex2(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionDAO actionDAO =  new ActionDAO();
        long countAction = actionDAO.count();

        GameDAO gameDAO =  new GameDAO();
        long countGame = gameDAO.count();

        MissionDAO missionDAO =  new MissionDAO();
        long countMission = missionDAO.count();

        TraineeDAO traineeDAO =  new TraineeDAO();
        long counttrainee = traineeDAO.count();


        request.setAttribute("countAction", countAction);
        request.setAttribute("countGame", countGame);
        request.setAttribute("countMission", countMission);
        request.setAttribute("countTrainee", counttrainee);
        return new ModelAndView("home");
    }
}
