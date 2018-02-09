package nl.scholtens.music.controller;

import nl.scholtens.music.domain.Album;
import nl.scholtens.music.domain.Artist;
import nl.scholtens.music.domain.Song;
import nl.scholtens.music.services.AlbumService;
import nl.scholtens.music.services.ArtistService;
import nl.scholtens.music.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @Autowired
    private ArtistService artistService;

    @Autowired
    private SongService songService;

    @RequestMapping(value = "/albums", method = RequestMethod.GET)
    public String getAllAlbums() {
        List<Album> albums = albumService.getAllAlbums();
//        albums.stream().forEach(album -> System.out.println(album));
        return "albumlist";
    }

    @RequestMapping(value = "/searchalbum", method = RequestMethod.GET)
    public String getAllbumByName()  {
    Album byName = albumService.getAlbumByName("hfghghg");
        List<Artist> artists = artistService.findAllArtists();
        return "albumlist";
    }

    @RequestMapping(value = "addalbum", method = RequestMethod.GET)
    public ModelAndView addAlbum(ModelAndView model) {
        model.setViewName("albumlist");
        return model;
    }

}
