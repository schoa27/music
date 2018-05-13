package nl.scholtens.music.services;

import nl.scholtens.music.dataTransferObjects.ArtistDTO;
import nl.scholtens.music.domain.Artist;

import java.util.List;

public interface ArtistService {

    List<Artist> findAllArtists(String item, boolean ascDesc);

    List<Artist> findArtistsByName(ArtistDTO dto);

    Artist findArtistById(Integer id);

    Artist saveArtist(ArtistDTO dto);
}
