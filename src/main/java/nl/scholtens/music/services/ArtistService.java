package nl.scholtens.music.services;

import nl.scholtens.music.domain.Artist;

import java.util.List;

public interface ArtistService {

    List<Artist> findAllArtists();

    Artist findArtistByName(String name);
}
