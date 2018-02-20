package nl.scholtens.music.dataInteraction;

import nl.scholtens.music.domain.Artist;

import java.util.List;

public interface ArtistDao {

    List<Artist> getAllSortedArtist(String item, boolean ascDesc);
}
