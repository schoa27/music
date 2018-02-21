package nl.scholtens.music.services;

import nl.scholtens.music.dataInteraction.AlbumDao;
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

    @Autowired
    private AlbumDao albumDao;

    @Override
    public long countAlbums() {
        return repository.count();
    }

    @Override
    public List<Album> getAllAlbums(String sorting, boolean ascDesc) {
        List<Album> albums = new ArrayList<>();
        if (sorting.isEmpty()) {
            Iterable<Album> all = repository.findAll();
            all.forEach(albums::add);
        } else {
            return getsortedList(sorting, ascDesc);
        }
        return albums;
    }

    @Override
    public Album getAlbumById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<Album> getAlbumsByName(String name) {
        return repository.findAlbumsByTitleContains(name);
    }

    private List<Album> getsortedList(String item, boolean ascDesc) {
        return item.equals("ag")? albumDao.getAllAlbumsSortedByArtistGroep(ascDesc)
                              : albumDao.getAllSortedAlbums(item ,ascDesc);
    }

}
