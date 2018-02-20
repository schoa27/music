package nl.scholtens.music.controller;

import nl.scholtens.music.dataTransferObjects.AlbumDTO;
import nl.scholtens.music.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    /**
     * Ophalen van alle Albums
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/albums", method = RequestMethod.GET)
    public ModelAndView getAllAlbums(ModelAndView model, HttpServletRequest request) {
        AlbumDTO dto = new AlbumDTO();
        initHttpSession(request);

        dto.setAlbums(albumService.getAllAlbums("", false));
        model.addObject("dto", dto);
        model.setViewName("albumlist");
        return model;
    }

    /**
     * Sortering op kolomen oplopen of aflopend afhankeljke van de status va de kolom
     * @param item
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/albums/{column}", method = RequestMethod.GET)
    public ModelAndView getAllAlbumsSorted(@PathVariable(name = "column") String item,
                                           ModelAndView model,
                                           HttpServletRequest request) {
        HttpSession session = request.getSession();

        boolean ascDesc = (boolean) session.getAttribute(item);

        if (ascDesc) {
            session.setAttribute(item, false);
        } else {
            session.setAttribute(item, true);
        }

        AlbumDTO dto = new AlbumDTO();

        dto.setAlbums(albumService.getAllAlbums(item, ascDesc));
        model.addObject("dto", dto);
        model.setViewName("albumlist");
        return model;
    }

    /**
     * Ophalen van een Album details op id van de Album
     * @param item
     * @param model
     * @return
     */
    @RequestMapping(value = "/detail/{item}", method = RequestMethod.GET)
    public ModelAndView getAllbumDetails(@PathVariable(name = "item") Integer item, ModelAndView model) {
        AlbumDTO dto = new AlbumDTO();

        dto.setAlbum(albumService.getAlbumById(item));
        model.addObject("dto", dto);
        model.setViewName("details");
        return model;
    }


    @RequestMapping(value = "/searchalbum", method = RequestMethod.GET)
    public ModelAndView searchAlbums(ModelAndView model) {
        model.setViewName("dummy");
        return model;
    }

    @RequestMapping(value = "/addalbum", method = RequestMethod.GET)
    public ModelAndView addAlbum(ModelAndView model) {
        model.setViewName("dummy");
        return model;
    }


    private void initHttpSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("title", true);
        session.setAttribute("releaseYear", true);
        session.setAttribute("genre", true);
        session.setAttribute("ag", true);
    }
}
