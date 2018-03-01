package nl.scholtens.music.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "sg_songs")
@Data
public class Song {

    @Id
    @SequenceGenerator(name = "seq_song", sequenceName = "seq_sg", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_song")
    @Column(name = "sg_id")
    private int id;

    @Column(name = "sg_title")
    private String title;

    @Column(name = "sg_duration")
    private String duration;

    @Column(name = "sg_disc")
    private Integer discnr;

    @ManyToMany
    @JoinTable(name = "at_sg",
               joinColumns = @JoinColumn(name = "sg_id", referencedColumnName = "sg_id"),
               inverseJoinColumns = @JoinColumn(name = "at_id", referencedColumnName = "at_id"))
    private List<Artist> artists;

    @ManyToMany
    @JoinTable(name ="gp_sg",
               joinColumns = @JoinColumn(name = "sg_id", referencedColumnName = "sg_id"),
               inverseJoinColumns = @JoinColumn(name = "gp_id", referencedColumnName = "gp_id"))
    private List<Group> groups;

    @ManyToMany
    @JoinTable(name = "am_sg",
               joinColumns = @JoinColumn(name = "sg_id", referencedColumnName = "sg_id"),
               inverseJoinColumns = @JoinColumn(name = "am_id", referencedColumnName = "am_id"))
    private List<Album> albums;

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}
