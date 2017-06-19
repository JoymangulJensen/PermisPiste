package com.permispiste.controller;

import com.permispiste.dao.ObjectiveDAO;
import org.springframework.stereotype.Controller;
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
}
