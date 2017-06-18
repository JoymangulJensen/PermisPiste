package com.permispiste.controller;

import com.permispiste.dao.GameDAO;
import com.permispiste.dao.TraineeDAO;
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

    @RequestMapping(value = "/game/list", method = RequestMethod.GET)
    public ModelAndView Afficheindex2(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List games = gameDAO.findAll();
        request.setAttribute("games", games);
        return new ModelAndView("games/view");
    }

    @RequestMapping(value = "/game/ajouter", method = RequestMethod.GET)
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        JeuEntity game = new JeuEntity();
        if(false){
            game.setLibellejeu(request.getParameter("libelle"));
            gameDAO.insert((IEntity) game);
            return new ModelAndView("games/view");
        }
        return new ModelAndView("games/add");
    }

    @RequestMapping(value = "/game/supprimer/{id}", method = RequestMethod.GET)
    public ModelAndView remove(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") Integer id) throws Exception {
        JeuEntity game = gameDAO.find(id);
        System.out.println(gameDAO.deleteById(JeuEntity.class, Integer.parseInt(request.getParameter("id"))));
        return new ModelAndView("games/view");
    }

    @RequestMapping(value = "/game/editer/{id}", method = RequestMethod.GET)
    public ModelAndView get(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") Integer id) throws Exception {
        JeuEntity game = gameDAO.find(id);
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(game.getLibellejeu());
        request.setAttribute("game", game);
        return new ModelAndView("games/edit");
    }
}
