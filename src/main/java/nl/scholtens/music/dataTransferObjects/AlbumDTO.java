package nl.scholtens.music.dataTransferObjects;

import lombok.Data;
import nl.scholtens.music.domain.Album;

import java.util.List;

@Data
public class AlbumDTO {

    private boolean list;

    private List<Album> albums;

    private Album album;

    private String search;
}
