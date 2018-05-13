package nl.scholtens.music.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "gp_groups")
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

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

}
