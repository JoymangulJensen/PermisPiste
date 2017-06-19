package com.permispiste.controller;

import com.permispiste.dao.FixeDAO;
import com.permispiste.dao.GameDAO;
import com.permispiste.dao.MissionDAO;
import com.permispiste.dao.ObjectiveDAO;
import com.permispiste.model.JeuEntity;
import com.permispiste.model.MissionEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping(value = "/missions")
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List missions = missionDAO.findAll();
        request.setAttribute("missions", missions);
        return new ModelAndView("missions/list");
    }

    @RequestMapping(value = "/mission/ajouter")
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        MissionEntity mission = new MissionEntity();
        if (updateOrInsertValid(mission, request)) {
            missionDAO.insert(mission);
            return list(request, response);
        }

        List games = new GameDAO().findAll();
        request.setAttribute("games", games);
        return new ModelAndView("missions/add");
    }

    @RequestMapping(value = "/mission/supprimer/{id}")
    public ModelAndView remove(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") Integer id) throws Exception {
        missionDAO.deleteById(MissionEntity.class, id);
        return list(request, response);
    }

    @RequestMapping(value = "/mission/editer/{id}")
    public ModelAndView edit(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") Integer id) throws Exception {

        MissionEntity mission = missionDAO.find(id);
        request.setAttribute("mission", mission);

        if (updateOrInsertValid(mission, request)){
            missionDAO.update(mission);
            return list(request, response);
        }

        List games = new GameDAO().findAll();
        request.setAttribute("games", games);
        return new ModelAndView("missions/edit");
    }

    private boolean updateOrInsertValid(MissionEntity mission, final HttpServletRequest request) {
        String label = request.getParameter("label");
        if (label != null){
            mission.setLibmission(label);
            int game_id = Integer.parseInt(request.getParameter("game_id"));
            JeuEntity game = new GameDAO().find(game_id);
            mission.setJeuByNumjeu(game);
            return true;
        }
        return false;
    }

    @RequestMapping(value = "/mission/objectifs/{id}")
    public ModelAndView listObjectifs(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") Integer id) throws Exception {
        ObjectiveDAO objectifDAO = new ObjectiveDAO();
        List objectives = objectifDAO.findByMission(id);
        request.setAttribute("objectives", objectives);

        MissionEntity mission = missionDAO.find(id);
        request.setAttribute("mission", mission);
        return new ModelAndView("missions/objective/list");
    }

    @RequestMapping(value = "/mission/objectif/ajouter/{idmission}")
    public ModelAndView addObjective(HttpServletRequest request, HttpServletResponse response, @PathVariable("idmission") int idmission) throws Exception {
        ObjectiveDAO objectiveDAO = new ObjectiveDAO();
        List objectives = objectiveDAO.findAll();
        request.setAttribute("objectives", objectives);
        return new ModelAndView("missions/objective/add");
    }

    @RequestMapping(value = "/mission/objectif/supprimer/{idmission}/{idobjectif}")
    public ModelAndView removeObjectif(HttpServletRequest request, HttpServletResponse response, @PathVariable("idmission") int idmission, @PathVariable("idobjectif") int idobjectif) throws Exception {
        FixeDAO fixeDAO = new FixeDAO();
        fixeDAO.delete(idmission, idobjectif);
        return listObjectifs(request, response, idmission);
    }
}
