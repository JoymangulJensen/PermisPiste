package com.permispiste.controller;

import com.permispiste.dao.ActionDAO;
import org.springframework.stereotype.Controller;
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
    public ModelAndView Afficheindex2(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List actions = actionDAO.findAll();
        request.setAttribute("actions", actions);
        return new ModelAndView("actions/list");
    }
}
