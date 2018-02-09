package nl.scholtens.music.services;

import nl.scholtens.music.dataInteraction.SongRepository;
import nl.scholtens.music.domain.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    private SongRepository repository;

    @Override
    public List<Song> findAllSongs() {
        List<Song> songs = new ArrayList<>();
        Iterable<Song> results = repository.findAll();
        results.forEach(songs::add);
        return songs;
    }

    @Override
    public Song findSongByTitle(String title) {
        Song song = repository.findByTitle(title);
        return song;
    }
}
