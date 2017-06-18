package com.permispiste.controller;

import com.permispiste.dao.GameDAO;
import com.permispiste.dao.MissionDAO;
import com.permispiste.dao.TraineeDAO;
import com.permispiste.model.ApprenantEntity;
import com.permispiste.model.JeuEntity;
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
public class TraineeController {

    private TraineeDAO traineeDAO;

    public TraineeController() {
        super();
        traineeDAO = new TraineeDAO();
    }

    @RequestMapping(value = "/apprenants", method = RequestMethod.GET)
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List trainees = traineeDAO.findAll();
        request.setAttribute("trainees", trainees);
        return new ModelAndView("trainees/list");
    }

    @RequestMapping(value = "/apprenant/ajouter")
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ApprenantEntity trainee = new ApprenantEntity();
        if(request.getParameter("name") != null){
            trainee.setNomapprenant(request.getParameter("name"));
            trainee.setPrenomapprenant(request.getParameter("firstname"));
            traineeDAO.insert(trainee);
            return list(request, response);
        }
        return new ModelAndView("trainees/add");
    }

    @RequestMapping(value = "/apprenant/supprimer/{id}")
    public ModelAndView remove(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") Integer id) throws Exception {
        traineeDAO.deleteById(ApprenantEntity.class, id);
        return list(request, response);
    }

    @RequestMapping(value = "/apprenant/editer/{id}")
    public ModelAndView edit(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") Integer id) throws Exception {
        ApprenantEntity trainee = traineeDAO.find(id);
        if(request.getParameter("name") != null) {
            trainee.setNomapprenant(request.getParameter("name"));
            trainee.setPrenomapprenant(request.getParameter("firstname"));
            traineeDAO.update(trainee);
            return list(request, response);
        }
        request.setAttribute("trainee", trainee);
        return new ModelAndView("trainees/edit");
    }

    @RequestMapping(value = "/apprenant/games/{id}", method = RequestMethod.GET)
    public ModelAndView game(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") Integer id) throws Exception {
        ApprenantEntity trainee = traineeDAO.find(id);
        request.setAttribute("trainee", trainee);
        GameDAO gameDAO = new GameDAO();
        List games = gameDAO.findAll();
        request.setAttribute("games", games);
        return new ModelAndView("trainees/games");
    }

    @RequestMapping(value = "/apprenant/missions/{idtrainee}/{idgame}", method = RequestMethod.GET)
    public ModelAndView mission(HttpServletRequest request, HttpServletResponse response, @PathVariable("idtrainee") Integer idtrainee, @PathVariable("idgame") Integer idgame) throws Exception {
        ApprenantEntity trainee = traineeDAO.find(idtrainee);
        request.setAttribute("trainee", trainee);

        GameDAO gameDAO = new GameDAO();
        JeuEntity game = gameDAO.find(idgame);
        request.setAttribute("game", game);

        MissionDAO missionDAO = new MissionDAO();
        List missions = missionDAO.findByGame(game);
        request.setAttribute("missions", missions);
        return new ModelAndView("trainees/missions");
    }
}
