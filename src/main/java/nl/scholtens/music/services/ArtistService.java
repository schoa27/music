package nl.scholtens.music.services;

import nl.scholtens.music.domain.Artist;

import java.util.List;

public interface ArtistService {

    List<Artist> findAllArtists(String item, boolean ascDesc);

    Artist findArtistByName(String name);

    Artist findArtistById(Integer id);
}
