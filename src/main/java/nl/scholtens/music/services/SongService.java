package nl.scholtens.music.services;

import nl.scholtens.music.domain.Song;

import java.util.List;

public interface SongService {

    List<Song> findAllSongs();

    Song findSongByTitle(String title);

}
