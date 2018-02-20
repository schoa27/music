package nl.scholtens.music.dataInteraction;

import nl.scholtens.music.domain.Album;

import java.util.List;

public interface AlbumDao {

    List<Album> getAllSortedAlbums(String item, boolean ascDesc);

    List<Album> getAllAlbumsSortedByArtistGroep(boolean ascDesc);
}
