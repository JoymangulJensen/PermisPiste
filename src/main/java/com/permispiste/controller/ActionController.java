package com.permispiste.controller;

import com.permispiste.dao.ActionDAO;
import com.permispiste.model.ActionEntity;
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
public class ActionController {
    private ActionDAO actionDAO;

    public ActionController() {
        super();
        actionDAO = new ActionDAO();
    }

    @RequestMapping(value = "/actions", method = RequestMethod.GET)
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setAttribute("actions", actionDAO.findAll());
        return new ModelAndView("actions/list");
    }

    @RequestMapping(value = "/action/ajouter")
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionEntity action = new ActionEntity();
        if (updateOrInsertValid(action, request)) {
            actionDAO.insert(action);
            return list(request, response);
        }
        List actions = new ActionDAO().findAll();
        request.setAttribute("actions", actions);
        return new ModelAndView("actions/add");
    }

    @RequestMapping(value = "/action/editer/{id}")
    public ModelAndView edit(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") Integer id) throws Exception {

        ActionEntity action = actionDAO.find(id);
        request.setAttribute("action", action);

        if (updateOrInsertValid(action, request)){
            actionDAO.update(action);
            return list(request, response);
        }

        List actions = new ActionDAO().findAll();
        request.setAttribute("actions", actions);
        return new ModelAndView("actions/edit");
    }

    @RequestMapping(value = "/action/supprimer/{id}")
    public ModelAndView remove(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") Integer id) throws Exception {
        actionDAO.deleteById(ActionEntity.class, id);
        return list(request, response);
    }

    private boolean updateOrInsertValid(ActionEntity action, final HttpServletRequest request) {
        String label = request.getParameter("label");
        String scoremin = request.getParameter("scoremin");
        String actionPrevId = request.getParameter("action_id");
        if (label != null || scoremin != null || actionPrevId != null){
            action.setLibaction(label);
            action.setScoremin(Integer.parseInt(scoremin));
            action.setActionByActNumaction(null);
            if(!actionPrevId.equals("NONE"))
            {
                ActionEntity actionPrev = actionDAO.find(Integer.parseInt(actionPrevId));
                action.setActionByActNumaction(actionPrev);
            }
            return true;
        }
        return false;
    }
}
