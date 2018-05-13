package nl.scholtens.music.domain;


import javax.persistence.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "at_artists")
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public Map<StartEndDate, Group> getStartEndDateByGroup() {
        return startEndDateByGroup;
    }

    public void setStartEndDateByGroup(Map<StartEndDate, Group> startEndDateByGroup) {
        this.startEndDateByGroup = startEndDateByGroup;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public void removeGroup(Group group) {
        Iterator iterator = startEndDateByGroup.entrySet().iterator();
        while (iterator.hasNext()) {
            Group cuurentGroup = ((Map.Entry<StartEndDate, Group>) iterator.next()).getValue();
            if (cuurentGroup.getId() == group.getId()) {
                iterator.remove();
            }
        }
    }


}
