package nl.scholtens.music.services;

import nl.scholtens.music.dataInteraction.ArtistDao;
import nl.scholtens.music.dataInteraction.ArtistRepository;
import nl.scholtens.music.domain.Album;
import nl.scholtens.music.domain.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    ArtistRepository repository;

    @Autowired
    ArtistDao artistDao;

    @Override
    public List<Artist> findAllArtists(String sorting, boolean ascDesc) {
        List<Artist> artists = new ArrayList<>();
        if (sorting.isEmpty()) {
            Iterable<Artist> all = repository.findAll();
            all.forEach(artists::add);
        } else {
            return getsortedList(sorting, ascDesc);
        }
        return artists;
    }

    @Override
    public List<Artist> findArtistsByName(String name) {
        return repository.findAristsByNameContains(name);
    }


    @Override
    public Artist findArtistByName(String name) {
        Artist byName = repository.findByName(name);
        return byName;
    }

    @Override
    public Artist findArtistById(Integer id) {
        return repository.findArtistById(id);
    }

    private List<Artist> getsortedList(String item, boolean ascDesc) {
       return artistDao.getAllSortedArtist(item, ascDesc);
    }
}
