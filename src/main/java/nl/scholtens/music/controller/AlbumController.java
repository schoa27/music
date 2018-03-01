package nl.scholtens.music.controller;

import nl.scholtens.music.dataTransferObjects.AlbumDTO;
import nl.scholtens.music.domain.Album;
import nl.scholtens.music.domain.Artist;
import nl.scholtens.music.domain.Disk;
import nl.scholtens.music.domain.Group;
import nl.scholtens.music.services.AlbumService;
import nl.scholtens.music.services.ArtistService;
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
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @Autowired
    private GroupService groupService;

    @Autowired
    private ArtistService artistService;

    /**
     * Ophalen van alle Albums
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/albums", method = RequestMethod.GET)
    public ModelAndView getAllAlbums(ModelAndView model, HttpServletRequest request) {
        AlbumDTO dto = new AlbumDTO();

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
     * Ophalen van Album op id van de Album
     * @param item
     * @param model
     * @return
     */
    @RequestMapping(value = "/detail/album/{item}", method = RequestMethod.GET)
    public ModelAndView getAllbumDetails(@PathVariable(name = "item") Integer item, ModelAndView model) {
        AlbumDTO dto = new AlbumDTO();

        Album albumById = albumService.getAlbumById(item);
        List<Disk> disks = albumService.setDisk(albumById);
        dto.setAlbum(albumById);
        dto.setDisks(disks);
        model.addObject("dto", dto);
        model.setViewName("albumdetails");
        return model;
    }

    /**
     * Opbouw van het zoekscherm
     * @param model
     * @return
     */
    @RequestMapping(value = "/searchalbum", method = RequestMethod.GET)
    public ModelAndView searchAlbums(ModelAndView model) {
        AlbumDTO dto = new AlbumDTO();
        model.addObject("object","album");
        model.addObject("dto", dto);
        model.setViewName("search");
        return model;
    }

    /**
     * Albums zoeken die voldoen aan de zoekcriteria
     * @param dto
     * @param model
     * @return
     */
    @RequestMapping(value = "/search/album", method = RequestMethod.POST)
    public ModelAndView getSearchAlbums(@ModelAttribute AlbumDTO dto, ModelAndView model) {
        dto.setAlbums(albumService.getAlbumsByName(dto.getSearch()));
        model.addObject("dto", dto);
        model.setViewName("albumlist");
        return model;
    }

    @RequestMapping(value = "/addalbum", method = RequestMethod.GET)
    public ModelAndView addAlbum(ModelAndView model) {
        AlbumDTO dto = new AlbumDTO();

        dto.setGroups(groupService.getAllGroups("name",true));
        dto.setArtists(artistService.findAllArtists("name", true));
        model.addObject("dto", dto);
        model.setViewName("addalbum");
        return model;
    }

    @RequestMapping(value = "/album/add", method = RequestMethod.POST)
    public ModelAndView addAlbum(@ModelAttribute AlbumDTO dto, ModelAndView model) {
        if (dto.getAlbum().getArtist().getId() > 0 ) {
            Artist artist = artistService.findArtistById(dto.getAlbum().getArtist().getId());
            dto.getAlbum().setArtist(artist);
        }
        if (dto.getAlbum().getGroup().getId() > 0 ) {
            Group group = groupService.findGroupById(dto.getAlbum().getGroup().getId());
            dto.getAlbum().setGroup(group);
        }

        model.addObject("dto", dto);
        model.setViewName("addsongs");
        return model;
    }


    @RequestMapping(value = "/album/addsongs", method = RequestMethod.POST)
    public ModelAndView addAlbumSongs(@ModelAttribute AlbumDTO dto, ModelAndView model) {

        model.addObject("dto", dto);
        model.setViewName("addsongs");
        return model;
    }

}
