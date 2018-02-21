package nl.scholtens.music.services;

import nl.scholtens.music.domain.Album;

import java.util.List;

public interface AlbumService {

    long countAlbums();

    List<Album> getAllAlbums(String sorting, boolean ascDesc);

    Album getAlbumById(Integer id);

    List<Album> getAlbumsByName(String name);
}
