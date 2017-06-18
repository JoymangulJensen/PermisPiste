package com.permispiste.controller;

import com.permispiste.dao.GameDAO;
import com.permispiste.model.IEntity;
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
public class GameController {
    private GameDAO gameDAO;

    public GameController() {
        super();
        gameDAO = new GameDAO();
    }


    @RequestMapping(value = "/game/list")
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List games = gameDAO.findAll();
        request.setAttribute("games", games);
        return new ModelAndView("games/list");
    }

    @RequestMapping(value = "/game/ajouter")
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        JeuEntity game = new JeuEntity();
        if((request.getParameter("libellejeu")) != null){
            game.setLibellejeu(request.getParameter("libellejeu"));
            gameDAO.insert(game);
            return list(request, response);
        }
        return new ModelAndView("games/add");
    }

    @RequestMapping(value = "/game/supprimer/{id}")
    public ModelAndView remove(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") Integer id) throws Exception {
        gameDAO.deleteById(JeuEntity.class, id);
        return list(request, response);
    }

    @RequestMapping(value = "/game/editer/{id}")
    public ModelAndView edit(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") Integer id) throws Exception {
        JeuEntity game = gameDAO.find(id);
        if(request.getParameter("libellejeu") != null) {
            game.setLibellejeu(request.getParameter("libellejeu"));
            gameDAO.update(game);
            return list(request, response);
        }
        request.setAttribute("game", game);
        return new ModelAndView("games/edit");
    }
}
