package nl.scholtens.music.services;

import nl.scholtens.music.dataInteraction.ArtistRepository;
import nl.scholtens.music.domain.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    ArtistRepository repository;

    @Override
    public List<Artist> findAllArtists() {
        List<Artist> artists = new ArrayList<>();
        Iterable<Artist> all = repository.findAll();
        all.forEach(artists::add);

        return artists;
    }

    @Override
    public Artist findArtistByName(String name) {
        Artist byName = repository.findByName(name);
        return byName;
    }
}
