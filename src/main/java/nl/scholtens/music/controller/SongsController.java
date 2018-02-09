package nl.scholtens.music.controller;

import nl.scholtens.music.domain.Song;
import nl.scholtens.music.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SongsController {

    @Autowired
    private SongService songService;


    @RequestMapping(value = "/songs", method = RequestMethod.GET)
    public ModelAndView getAllSongs(ModelAndView model)  {
        List<Song> songs = songService.findAllSongs();
        model.setViewName("albumlist");
        return model;
    }
}
