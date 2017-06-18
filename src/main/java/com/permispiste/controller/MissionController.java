package com.permispiste.controller;

import com.permispiste.dao.MissionDAO;
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
}
