package nl.scholtens.music.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "at_artists")
@Data
public class Artist {

    @Id
    @SequenceGenerator(name = "seq_artist", sequenceName = "seq_at", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_artist")
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
    @AttributeOverrides({
            @AttributeOverride(name = "startDate", column = @Column(name = "at_startdate")),
            @AttributeOverride(name = "endDate", column = @Column(name = "at_rnddate"))
    })
    private Map<StartEndDate, Group> startEndDateByGroup;


    @ManyToMany
    @JoinTable(name = "at_sg",
               joinColumns = @JoinColumn(name = "at_id", referencedColumnName = "at_id"),
               inverseJoinColumns = @JoinColumn(name = "sg_id", referencedColumnName = "sg_id"))
    private List<Song> songs;

    public void removeGroup(Group group) {
        Iterator iterator = startEndDateByGroup.entrySet().iterator();
        while (iterator.hasNext()) {
            Group cuurentGroup = ((Map.Entry<StartEndDate, Group>) iterator.next()).getValue();
            if (cuurentGroup.getId() == group.getId()) {
                iterator.remove();
            }
        }
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", albums=" + albums +
                ", startEndDateByGroup=" + startEndDateByGroup +
                ", songs=" + songs +
                '}';
    }
}
