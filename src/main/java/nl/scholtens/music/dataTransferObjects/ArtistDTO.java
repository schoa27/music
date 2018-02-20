package nl.scholtens.music.dataTransferObjects;

import lombok.Data;
import nl.scholtens.music.domain.Artist;

import java.util.List;

@Data
public class ArtistDTO {

    private List<Artist>  artists;

    private Artist artist;
}
