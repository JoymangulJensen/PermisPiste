package com.permispiste.controller;

import com.permispiste.dao.*;
import com.permispiste.model.*;
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
        if(request.getParameter("name") != null && request.getParameter("firstname") != null) {
            trainee.setNomapprenant(request.getParameter("name"));
            trainee.setPrenomapprenant(request.getParameter("firstname"));
            traineeDAO.update(trainee);
            return list(request, response);
        }
        request.setAttribute("trainee", trainee);
        return new ModelAndView("trainees/edit");
    }

    @RequestMapping(value = "/apprenant/games/{id}", method = RequestMethod.GET)
    public ModelAndView games(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") Integer id) {
        ApprenantEntity trainee = traineeDAO.find(id);
        request.setAttribute("trainee", trainee);
        GameDAO gameDAO = new GameDAO();
        List games = gameDAO.findByTrainee(id);
        request.setAttribute("games", games);
        return new ModelAndView("trainees/games");
    }

    @RequestMapping(value = "/apprenant/missions/{idtrainee}/{idgame}")
    public ModelAndView mission(HttpServletRequest request, HttpServletResponse response, @PathVariable("idtrainee") Integer idtrainee, @PathVariable("idgame") Integer idgame) {
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

    @RequestMapping(value = "/apprenant/{idtrainee}/inscription")
    public ModelAndView register(HttpServletRequest request, HttpServletResponse response, @PathVariable("idtrainee") Integer idtrainee) {
        // Games
        List games = new GameDAO().findAll();
        request.setAttribute("games", games);
        // Trainee
        ApprenantEntity trainee = traineeDAO.find(idtrainee);
        request.setAttribute("trainee", trainee);

        InscriptionDAO inscriptionDAO = new InscriptionDAO();
        String id_game_string = request.getParameter("game_id");
        int id_game;

        if (id_game_string != null && inscriptionDAO.countByTraineeAndGame(idtrainee, id_game = Integer.parseInt(id_game_string)) == 0) {
            InscriptionEntity inscription = new InscriptionEntity();
            inscription.setNumapprenant(idtrainee);
            inscription.setNumjeu(id_game);
            inscriptionDAO.insert(inscription);
            return games(request, response, idtrainee);
        }
        return new ModelAndView("trainees/inscription");
    }

    @RequestMapping(value = "/apprenant/{id_trainee}/mission/{id_mission}/objectif/{id_objective}")
    public ModelAndView consultActions(HttpServletRequest request, HttpServletResponse response, @PathVariable("id_trainee") Integer idtrainee, @PathVariable("id_objective") Integer id_objective, @PathVariable("id_mission") Integer id_mission) {
        // Trainee
        ApprenantEntity trainee = traineeDAO.find(idtrainee);
        request.setAttribute("trainee", trainee);

        // Mission
        MissionEntity mission = new MissionDAO().find(id_mission);
        request.setAttribute("mission", mission);

        // Objectif & Actions
        ObjectifEntity objective = new ObjectiveDAO().find(id_objective);
        request.setAttribute("objective", objective);

        return new ModelAndView("trainees/consultActions");
    }
}
