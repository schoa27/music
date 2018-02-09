package nl.scholtens.music.services;

import nl.scholtens.music.domain.Album;

import java.util.List;

public interface AlbumService {

    List<Album> getAllAlbums();

    Album getAlbumByName(String name);
}
