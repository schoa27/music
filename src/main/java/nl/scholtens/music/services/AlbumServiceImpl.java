package nl.scholtens.music.services;

import nl.scholtens.music.dataInteraction.AlbumRepository;
import nl.scholtens.music.domain.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumRepository repository;

    @Override
    public List<Album> getAllAlbums() {
        List<Album> albums = new ArrayList<>();
        Iterable<Album> all = repository.findAll();
        all.forEach(albums::add);

        return albums;
    }

    @Override
    public Album getAlbumByName(String name) {
        return repository.findByTitle(name);
    }
}
