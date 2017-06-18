package com.permispiste.controller;

import com.permispiste.dao.GameDAO;
import com.permispiste.dao.MissionDAO;
import com.permispiste.dao.MissionDAO;
import com.permispiste.model.IEntity;
import com.permispiste.model.MissionEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by JOYMANGUL Jensen Selwyn
 * on 6/17/2017.
 */
@Controller
public class MissionController {

    private MissionDAO missionDAO;

    public MissionController() {
        super();
        missionDAO = new MissionDAO();
    }

    @RequestMapping(value = "/missions", method = RequestMethod.GET)
    public ModelAndView Afficheindex(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List missions = missionDAO.findAll();
        request.setAttribute("missions", missions);
        return new ModelAndView("missions/list");
    }

    @RequestMapping(value = "/mission/ajouter", method = RequestMethod.GET)
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        MissionEntity mission = new MissionEntity();
        GameDAO gameDAO = new GameDAO();
        List games = gameDAO.findAll();
        request.setAttribute("games", games);
        if(false){
            mission.setLibmission(request.getParameter("libmission"));
            missionDAO.insert((IEntity) mission);
            return new ModelAndView("mission/list");
        }
        return new ModelAndView("missions/add");
    }

    @RequestMapping(value = "/mission/supprimer/{id}", method = RequestMethod.GET)
    public ModelAndView remove(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") Integer id) throws Exception {
        MissionEntity trainee = missionDAO.find(id);
        System.out.println(missionDAO.deleteById(MissionEntity.class, Integer.parseInt(request.getParameter("id"))));
        return new ModelAndView("missions/view");
    }

    @RequestMapping(value = "/mission/editer/{id}", method = RequestMethod.GET)
    public ModelAndView get(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") Integer id) throws Exception {
        MissionEntity trainee = missionDAO.find(id);
        System.out.println(trainee.getLibmission());
        request.setAttribute("trainee", trainee);
        return new ModelAndView("missions/edit");
    }
}
