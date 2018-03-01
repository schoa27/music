package nl.scholtens.music.controller;

import nl.scholtens.music.dataTransferObjects.ArtistDTO;
import nl.scholtens.music.dataTransferObjects.GroupDTO;
import nl.scholtens.music.domain.Group;
import nl.scholtens.music.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class GroupsController {

    @Autowired
    private GroupService groupService;

    @RequestMapping(value = "/groups", method = RequestMethod.GET)
    public ModelAndView getAllGroups(HttpServletRequest request, ModelAndView model) {
        GroupDTO dto = new GroupDTO();
        initHttpSession(request);

        dto.setGroups(groupService.getAllGroups("", false));
        model.addObject("dto", dto);
        model.setViewName("grouplist");
        return model;
    }


    @RequestMapping(value = "/groups/{column}", method = RequestMethod.GET)
    public ModelAndView getAllArtistSorted(@PathVariable(name = "column") String item,
                                           HttpServletRequest request,
                                           ModelAndView model) {
        HttpSession session = request.getSession();

        boolean ascDesc = (boolean) session.getAttribute(item);

        if (ascDesc) {
            session.setAttribute(item, false);
        } else {
            session.setAttribute(item, true);
        }

        GroupDTO dto = new GroupDTO();

        dto.setGroups(groupService.getAllGroups(item, ascDesc));
        model.addObject("dto", dto);
        model.setViewName("grouplist");

        return model;
    }

    @RequestMapping(value = "/detail/group/{item}", method = RequestMethod.GET)
    public ModelAndView getGroupDetail(@PathVariable(name = "item") Integer id, ModelAndView model) {
        GroupDTO dto = new GroupDTO();
        dto.setGroup(groupService.findGroupById(id));
        model.addObject("dto", dto);
        model.setViewName("groupdetails");
        return model;
    }

    @RequestMapping(value = "/searchgroup", method = RequestMethod.GET)
    public ModelAndView searchGroups(ModelAndView model) {
        GroupDTO dto = new GroupDTO();
        model.addObject("object", "group");
        model.addObject("dto", dto);
        model.setViewName("search");
        return model;
    }

    @RequestMapping(value = "/search/group", method = RequestMethod.POST)
    public ModelAndView getSearchedGroups(@ModelAttribute GroupDTO dto, ModelAndView model) {
        dto.setGroups(groupService.findGroupsByName(dto.getSearch()));
        model.addObject("dto", dto);
        model.setViewName("grouplist");
        return model;
    }

    @RequestMapping(value = "/addgroup", method = RequestMethod.GET)
    public ModelAndView addArtistInput(ModelAndView model) {
        GroupDTO dto = new GroupDTO();
        model.addObject("dto", dto);
        model.setViewName("addgroup");
        return model;
    }

    @RequestMapping(value = "/group/add", method = RequestMethod.POST)
    public ModelAndView addArtist(@ModelAttribute GroupDTO dto, ModelAndView model) {
        groupService.saveGroup(dto.getGroup());
        model.setViewName("dummy");
        return model;
    }
    
    private void initHttpSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("name", true);
    }
}
