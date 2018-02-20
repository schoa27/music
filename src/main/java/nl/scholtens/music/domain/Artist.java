package nl.scholtens.music.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "at_artists")
@Data
public class Artist {

    @Id
    @Column(name = "at_id")
    private int id;

    @Column(name = "at_name")
    private String name;

    @Column(name = "at_image")
    private String image;

    @OneToMany
    @JoinColumn(name = "am_artist")
    private List<Album> albums;

    @ManyToMany
    @JoinTable(name = "gp_at",
                joinColumns = @JoinColumn(name = "at_id", referencedColumnName = "at_id"),
                inverseJoinColumns = @JoinColumn(name = "gp_id", referencedColumnName = "gp_id"))
    private List<Group> groups;

    @ManyToMany
    @JoinTable(name = "at_sg",
               joinColumns = @JoinColumn(name = "at_id", referencedColumnName = "at_id"),
               inverseJoinColumns = @JoinColumn(name = "sg_id", referencedColumnName = "sg_id"))
    private List<Song> songs;

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
