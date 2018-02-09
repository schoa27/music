package nl.scholtens.music.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "sg_songs")
@Data
public class Song {

    @Id
    @Column(name = "sg_id")
    private int id;

    @Column(name = "sg_title")
    private String title;

    @Column(name = "sg_duration")
    private String duration;

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
