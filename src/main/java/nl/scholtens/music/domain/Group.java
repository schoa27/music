package nl.scholtens.music.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "gp_groups")
@Data
public class Group {

    @Id
    @Column(name = "gp_id")
    private int id;

    @Column(name = "gp_name")
    private String name;

    @OneToMany
    @JoinColumn(name = "am_group")
    private List<Album> albums;

    @ManyToMany
    @JoinTable(name = "gp_sg",
              joinColumns = @JoinColumn(name = "gp_id", referencedColumnName = "gp_id"),
              inverseJoinColumns = @JoinColumn(name = "sg_id", referencedColumnName = "sg_id"))
    private List<Song> songs;

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
