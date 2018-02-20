package nl.scholtens.music.controller;

import nl.scholtens.music.dataTransferObjects.ArtistDTO;
import nl.scholtens.music.domain.Artist;
import nl.scholtens.music.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.ManyToMany;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    /**
     * Ophalen van alle Artiesten.
     * @param model
     * @return
     */
    @RequestMapping(value = "/artists", method = RequestMethod.GET)
    public ModelAndView getAllArtists(HttpServletRequest request, ModelAndView model) {
        ArtistDTO dto = new ArtistDTO();
        initHttpSession(request);

        dto.setArtists(artistService.findAllArtists("", false));
        model.addObject("dto", dto);
        model.setViewName("artistlist");
        return model;
    }

    @RequestMapping(value = "/artists/{column}", method = RequestMethod.GET)
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

        ArtistDTO dto = new ArtistDTO();

        dto.setArtists(artistService.findAllArtists(item, ascDesc));
        model.addObject("dto", dto);
        model.setViewName("artistlist");

        return model;
    }

    /**
     * Opahlen van Artist op id.
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/detail/artist/{item}", method = RequestMethod.GET)
    public ModelAndView getArtistDetails(@PathVariable(name = "item") Integer id, ModelAndView model) {
        ArtistDTO dto = new ArtistDTO();
        dto.setArtist(artistService.findArtistById(id));
        model.addObject("dto", dto);
        model.setViewName("artistdetails");
        return model;
    }

    @RequestMapping(value = "/searchatrist", method = RequestMethod.GET)
    public ModelAndView searchArtists(ModelAndView model) {
        model.setViewName("dummy");
        return model;
    }

    @RequestMapping(value = "/addartist", method = RequestMethod.GET)
    public ModelAndView addArtist(ModelAndView model) {
        model.setViewName("dummy");
        return model;
    }

    private void initHttpSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("name", true);
    }
}
