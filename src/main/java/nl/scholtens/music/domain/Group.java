package nl.scholtens.music.domain;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "gp_groups")
@Data
public class Group {

    @Id
    @SequenceGenerator(name = "seq_group", sequenceName = "seq_gp", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_group")
    @Column(name = "gp_id")
    private int id;

    @Column(name = "gp_name")
    private String name;

    @Column(name = "gp_image")
    private String image;

    @OneToMany
    @JoinColumn(name = "am_group")
    private List<Album> albums;

    @ManyToMany(mappedBy = "startEndDateByGroup")
    private List<Artist> artists;

    @ManyToMany
    @JoinTable(name = "gp_sg",
            joinColumns = @JoinColumn(name = "gp_id", referencedColumnName = "gp_id"),
            inverseJoinColumns = @JoinColumn(name = "sg_id", referencedColumnName = "sg_id"))
    private List<Song> songs;

    public Group() {
        artists = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", albums=" + albums +
                ", artists=" + artists +
                ", songs=" + songs +
                '}';
    }
}
