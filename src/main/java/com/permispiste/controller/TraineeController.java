package com.permispiste.controller;

import com.permispiste.dao.TraineeDAO;
import com.permispiste.model.ApprenantEntity;
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

    @RequestMapping(value = "/apprenant/ajouter", method = RequestMethod.GET)
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ApprenantEntity trainee = new ApprenantEntity();
        if(request.getParameter("name") != ""){
            trainee.setNomapprenant(request.getParameter("name"));
            trainee.setPrenomapprenant(request.getParameter("firstname"));
            traineeDAO.insert(trainee);
            return new ModelAndView("trainees/add");
        }
        return new ModelAndView("trainees/add");
    }

    @RequestMapping(value = "/apprenant/supprimer/{id}", method = RequestMethod.GET)
    public ModelAndView remove(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") Integer id) throws Exception {
        ApprenantEntity trainee = traineeDAO.find(id);
        System.out.println(traineeDAO.deleteById(ApprenantEntity.class, Integer.parseInt(request.getParameter("id"))));
        return new ModelAndView("trainees/list");
    }

    @RequestMapping(value = "/apprenant/editer/{id}", method = RequestMethod.GET)
    public ModelAndView get(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") Integer id) throws Exception {
        ApprenantEntity trainee = traineeDAO.find(id);
        System.out.println(trainee.getNomapprenant());
        request.setAttribute("trainee", trainee);
        return new ModelAndView("trainees/detail");
    }
}
