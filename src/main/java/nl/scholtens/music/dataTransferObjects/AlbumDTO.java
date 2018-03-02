package nl.scholtens.music.dataTransferObjects;

import lombok.Data;
import nl.scholtens.music.domain.*;

import java.util.ArrayList;
import java.util.List;

@Data
public class AlbumDTO {

    private boolean list;

    private List<Album> albums;

    private List<Group> groups;

    private List<Artist> artists;

    private List<Disk> disks;

    private Album album;

    private Song song;

    private String search;

    private Integer totaldiscs;

}
