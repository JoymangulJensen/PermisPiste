package com.permispiste.controller;

import com.permispiste.dao.ObjectiveDAO;
import com.permispiste.model.ObjectifEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by JOYMANGUL Jensen Selwyn
 * on 6/19/2017.
 */
@Controller
public class ObjectiveController {
    private ObjectiveDAO objectiveDAO;

    public ObjectiveController() {
        super();
        objectiveDAO = new ObjectiveDAO();
    }

    @RequestMapping(value = "/objectifs")
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List objecives = objectiveDAO.findAll();
        request.setAttribute("objecives", objecives);
        return new ModelAndView("objectives/list");
    }

    @RequestMapping(value = "/objectif/ajouter")
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ObjectifEntity objective = new ObjectifEntity();
        if (updateOrInsertValid(objective, request)) {
            objectiveDAO.insert(objective);
            return list(request, response);
        }
        return new ModelAndView("objectives/add");
    }

    @RequestMapping(value = "/objectif/supprimer/{id}")
    public ModelAndView remove(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") Integer id) throws Exception {
        objectiveDAO.deleteById(ObjectifEntity.class, id);
        return list(request, response);
    }

    @RequestMapping(value = "/objectif/editer/{id}")
    public ModelAndView edit(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") Integer id) throws Exception {

        ObjectifEntity objective = objectiveDAO.find(id);
        request.setAttribute("objective", objective);

        if (updateOrInsertValid(objective, request)){
            objectiveDAO.update(objective);
            return list(request, response);
        }
        return new ModelAndView("objectives/edit");
    }

    private boolean updateOrInsertValid(ObjectifEntity objective, final HttpServletRequest request) {
        String label = request.getParameter("label");
        if (label != null){
            objective.setLibobectif(label);
            return true;
        }
        return false;
    }

}
