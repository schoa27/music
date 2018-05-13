package nl.scholtens.music.services;

import nl.scholtens.music.dataInteraction.AlbumDao;
import nl.scholtens.music.dataInteraction.AlbumRepository;
import nl.scholtens.music.dataTransferObjects.AlbumDTO;
import nl.scholtens.music.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private GroupService groupService;

    @Autowired
    private ArtistService artistService;

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
    public List<Disk> setDisk(Album album) {
        String nr = "0";
        Disk d = null;

        List<Disk> disks = new ArrayList<>();
        List<Song> songs = album.getSongs();

        for (Song song : songs) {
            if (nr.equals(song.getDiscnr())) {
                d.setDiskNumber(song.getDiscnr());
                d.getSongs().add(song);
            } else {
                d = new Disk();
                nr = song.getDiscnr();
                d.setDiskNumber(song.getDiscnr());
                d.getSongs().add(song);
                disks.add(d);
            }
        }
        return disks;
    }

    @Override
    public List<Album> getAlbumsByName(AlbumDTO dto) {
        return repository.findAlbumsByTitleContains(dto.getSearch());
    }

    @Override
    public void saveAlbum(AlbumDTO dto) {
        Album album = dto.getAlbum();

        getArtistOrGroup(album);
        List<Song> songs = getSongOfAlbum(dto.getTitle(), dto.getDuration(), dto.getDisk());
        album.setSongs(songs);

        repository.save(album);
    }

    private void getArtistOrGroup(Album album) {
        if (album.getArtist().getId() > 0) {
            Artist artist = artistService.findArtistById(album.getArtist().getId());
            album.setArtist(artist);
            album.setGroup(null);
        }
        if (album.getGroup().getId() > 0) {
            Group group = groupService.findGroupById(album.getGroup().getId());
            album.setGroup(group);
            album.setArtist(null);
        }
    }

    private List<Song> getSongOfAlbum(String[]title, String[] duration, String[] disnr) {
        List<Song> songs = new ArrayList<>();
        for (int i = 0; i < title.length; i++ ) {
            songs.add(new Song(title[i], duration[i], disnr[i]));
        }
        return songs;
    }

    private List<Album> getsortedList(String item, boolean ascDesc) {
        return item.equals("ag") ? albumDao.getAllAlbumsSortedByArtistGroep(ascDesc)
                : albumDao.getAllSortedAlbums(item, ascDesc);
    }

}
