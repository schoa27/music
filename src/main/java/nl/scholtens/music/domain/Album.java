package nl.scholtens.music.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;


@Entity
@Table(name = "am_albums")
public class Album {

    @Id
    @SequenceGenerator(name = "seq_album", sequenceName = "seq_am", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_album")
    @Column(name = "am_id")
    private int id;

    @Column(name = "am_title")
    private String title;

    @Column(name = "am_releaseyear", length = 4)
    private String releaseYear;

    @Column(name = "am_genre")
    private String genre;

    @Column(name = "am_type")
    private String mediaType;

    @Column(name = "am_image")
    private String image;

    @Column(name = "am_collection")
    private boolean collection;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "am_sg",
            joinColumns = @JoinColumn(name = "am_id", referencedColumnName = "am_id"),
            inverseJoinColumns = @JoinColumn(name = "sg_id", referencedColumnName = "sg_id"))
    @JoinColumns({@JoinColumn(name = "at_id", referencedColumnName = "at_id"),
                  @JoinColumn(name = "gp_id", referencedColumnName = "gp_id")})
    private List<Song> songs;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "am_group")
    private Group group;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "am_artist")
    private Artist artist;

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

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isCollection() {
        return collection;
    }

    public void setCollection(boolean collection) {
        this.collection = collection;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

}

