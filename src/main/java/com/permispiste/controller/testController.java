package com.permispiste.controller;

import com.permispiste.dao.Service;
import com.permispiste.errorhandlers.ServiceHibernateException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by JOYMANGUL Jensen Selwyn
 * on 6/17/2017.
 */
@Controller
public class testController {

    @RequestMapping(value = "listerAdherent.htm")
    public ModelAndView afficherLesAdrents(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage;
        try {
            // HttpSession session = request.getSession();
            Service unService = new Service();
            request.setAttribute("mesAdherents", unService.consulterListeAdherents());
            destinationPage = "listerAdherent";
        } catch (ServiceHibernateException e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "Erreur";

        }
        return new ModelAndView(destinationPage);
    }
    // /
    // / Affichage de la page d'accueil
    // /
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView Afficheindex2(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new ModelAndView("home");
    }
}
