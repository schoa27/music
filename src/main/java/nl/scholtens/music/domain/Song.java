package nl.scholtens.music.domain;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "sg_songs")
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
    private String discnr;

    @ManyToMany
    @JoinTable(name = "at_sg",
               joinColumns = @JoinColumn(name = "sg_id", referencedColumnName = "sg_id"),
               inverseJoinColumns = @JoinColumn(name = "at_id", referencedColumnName = "at_id"))
    private List<Artist> artists = new ArrayList<>();

    @ManyToMany
    @JoinTable(name ="gp_sg",
               joinColumns = @JoinColumn(name = "sg_id", referencedColumnName = "sg_id"),
               inverseJoinColumns = @JoinColumn(name = "gp_id", referencedColumnName = "gp_id"))
    private List<Group> groups = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "am_sg",
               joinColumns = @JoinColumn(name = "sg_id", referencedColumnName = "sg_id"),
               inverseJoinColumns = @JoinColumn(name = "am_id", referencedColumnName = "am_id"))
    private List<Album> albums;

    public Song() {
        super();
    }

    public Song(String title, String duration, String disknr) {
        this.title = title;
        this.duration = duration;
        this.discnr = disknr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDiscnr() {
        return discnr;
    }

    public void setDiscnr(String discnr) {
        this.discnr = discnr;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

}
