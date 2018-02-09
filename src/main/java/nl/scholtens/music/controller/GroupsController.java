package nl.scholtens.music.controller;

import nl.scholtens.music.domain.Group;
import nl.scholtens.music.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class GroupsController {

    @Autowired
    private GroupService groupService;

    @RequestMapping(value = "/groups", method = RequestMethod.GET)
    public ModelAndView getAllGroups(ModelAndView model) {
        List<Group> groups = groupService.getAllGroups();

        model.setViewName("albumlist");
        return model;
    }


    @RequestMapping(value = "/searchgroup", method = RequestMethod.GET)
    public ModelAndView searchGroups(ModelAndView model) {
        model.setViewName("albumlist");
        return model;
    }

    @RequestMapping(value = "/addgroup", method = RequestMethod.GET)
    public ModelAndView addGroup(ModelAndView model) {
        model.setViewName("albumlist");
        return model;
    }
}
