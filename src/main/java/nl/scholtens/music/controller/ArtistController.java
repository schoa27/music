package nl.scholtens.music.controller;

import nl.scholtens.music.dataTransferObjects.ArtistDTO;
import nl.scholtens.music.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    /**
     * Ophalen van alle Artiesten.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/artists", method = RequestMethod.GET)
    public ModelAndView getAllArtists(HttpServletRequest request, ModelAndView model) {
        ArtistDTO dto = new ArtistDTO();

        dto.setArtists(artistService.findAllArtists("", false));
        model.addObject("dto", dto);
        model.setViewName("/view/viewartistlist");
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
        model.setViewName("/view/viewartistlist");
        return model;
    }

    /**
     * Opahlen van Artist op id.
     *
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

    /**
     * Opbouw van het zoekscherm
     * @param model
     * @return
     */
    @RequestMapping(value = "/searchartist", method = RequestMethod.GET)
    public ModelAndView searchArtists(ModelAndView model) {
        ArtistDTO dto = new ArtistDTO();
        model.addObject("object", "artist");
        model.addObject("dto", dto);
        model.setViewName("search");
        return model;
    }

    /**
     * Artist zoeken die voldoen aan de zoekcriteria
     * @param dto
     * @param model
     * @return
     */
    @RequestMapping(value = "/search/artist", method = RequestMethod.POST)
    public ModelAndView getSearchedArtists(@ModelAttribute ArtistDTO dto, ModelAndView model) {
        dto.setArtists(artistService.findArtistsByName(dto));
        model.addObject("dto", dto);
        model.setViewName("/view/viewartistlist");
        return model;
    }

    @RequestMapping(value = "/addartist", method = RequestMethod.GET)
    public ModelAndView addArtistInput(ModelAndView model) {
        ArtistDTO dto = new ArtistDTO();
        model.addObject("dto", dto);
        model.setViewName("/add/addartist");
        return model;
    }

    @RequestMapping(value = "/artist/add", method = RequestMethod.POST)
    public ModelAndView addArtist(@ModelAttribute ArtistDTO dto, ModelAndView model) {
        artistService.saveArtist(dto);
        model.setViewName("dummy");
        return model;
    }

}
