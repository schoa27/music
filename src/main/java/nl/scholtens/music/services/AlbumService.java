package nl.scholtens.music.services;

import nl.scholtens.music.dataTransferObjects.AlbumDTO;
import nl.scholtens.music.domain.Album;
import nl.scholtens.music.domain.Disk;

import java.util.List;

public interface AlbumService {

    long countAlbums();

    List<Album> getAllAlbums(String sorting, boolean ascDesc);

    Album getAlbumById(Integer id);

    List<Disk> setDisk(Album album);

    List<Album> getAlbumsByName(AlbumDTO dto);

    void saveAlbum(AlbumDTO dto);
}
