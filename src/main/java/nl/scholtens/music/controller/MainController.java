package nl.scholtens.music.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @RequestMapping(value = "/mymusic", method = RequestMethod.GET)
    public String start() {
        return "menu";
    }
}
