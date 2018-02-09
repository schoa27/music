package nl.scholtens.music.controller;

import nl.scholtens.music.domain.Artist;
import nl.scholtens.music.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.ManyToMany;
import java.util.List;

@Controller
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @RequestMapping(value = "/artists", method = RequestMethod.GET)
    public ModelAndView getAllArtists(ModelAndView model) {
        List<Artist> artists = artistService.findAllArtists();
        model.addObject(artists);
        model.setViewName("albumlist");
        return model;
    }

    @RequestMapping(value = "/searchatrist", method = RequestMethod.GET)
    public ModelAndView searchArtists(ModelAndView model) {
        model.setViewName("albumlist");
        return model;
    }

    @RequestMapping(value = "/addartist", method = RequestMethod.GET)
    public ModelAndView addArtist(ModelAndView model) {
        model.setViewName("albumlist");
        return model;
    }
}
