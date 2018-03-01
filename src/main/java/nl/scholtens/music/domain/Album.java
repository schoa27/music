package nl.scholtens.music.domain;

import com.google.common.collect.Multimap;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "am_albums")
@Data
public class Album {

    @Id
    @SequenceGenerator(name = "seq_album", sequenceName = "seq_am", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_album")
    @Column(name = "am_id")
    private int id;

    @Column(name = "am_title")
    private String title;

    @Column(name = "am_releaseyear", length = 4)
    private String releaseYear;

    @Column(name = "am_genre")
    private String genre;

    @Column(name = "am_type")
    private String mediaType;

    @Column(name = "am_image")
    private String image;

    @Column(name = "am_collection")
    private boolean collection;

    @OneToMany
    @JoinColumn(name = "sg_albums")
    private List<Song> songs;

    @OneToOne
    @JoinColumn(name = "am_group")
    private Group group;

    @OneToOne
    @JoinColumn(name= "am_artist")
    private Artist artist;

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseYear='" + releaseYear + '\'' +
                ", genre='" + genre + '\'' +
                ", mediaType='" + mediaType + '\'' +
                ", image='" + image + '\'' +
                ", collection=" + collection +
                ", songs=" + songs +
                ", group=" + group +
                ", artist=" + artist +
                '}';
    }
}

