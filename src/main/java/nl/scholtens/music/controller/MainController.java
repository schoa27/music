package nl.scholtens.music.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    @RequestMapping(value = "/mymusic", method = RequestMethod.GET)
    public ModelAndView start(HttpServletRequest request, ModelAndView model) {
        initHttpSession(request);
        String images[] = { "ElectricLightOrchestra-ANewWorldRecord"
                           ,"ElectricLightOrchestra-BalanceOfPower"
                           ,"ElectricLightOrchestra-Eldorado"
                           ,"ElectricLightOrchestra-FaceTheMuisc"
                           ,"ElectricLightOrchestra-Zoom" };

        model.addObject("images", images);
        model.setViewName("mainpage");
        return model;
    }

    private void initHttpSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("title", true);
        session.setAttribute("releaseYear", true);
        session.setAttribute("genre", true);
        session.setAttribute("ag", true);
        session.setAttribute("name", true);
    }
}
