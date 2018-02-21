package nl.scholtens.music.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    @RequestMapping(value = "/mymusic", method = RequestMethod.GET)
    public String start(HttpServletRequest request) {
        initHttpSession(request);
        return "menu";
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
