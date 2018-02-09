package nl.scholtens.music.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "am_albums")
@Data
public class Album {

    @Id
    @Column(name = "am_id")
    private int id;

    @Column(name = "am_title")
    private String title;

    @Column(name = "am_release")
    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    @Column(name = "am_type")
    private String mediaType;

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
                ", releaseDate=" + releaseDate +
                ", mediaType='" + mediaType + '\'' +
                ", collection=" + collection +
                ", songs=" + songs +
                ", group=" + group +
                ", artist=" + artist +
                '}';
    }
}

