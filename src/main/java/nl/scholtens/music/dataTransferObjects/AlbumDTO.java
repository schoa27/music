package nl.scholtens.music.dataTransferObjects;

import nl.scholtens.music.domain.*;
import java.util.List;

public class AlbumDTO {

    private boolean list;

    private List<Album> albums;

    private List<Group> groups;

    private List<Artist> artists;

    private List<Disk> disks;

    private Album album;

    private Song song;

    private String search;

    private Integer totaldiscs;

    private String[] title;

    private String[] duration;

    private String[] disk;

    public boolean isList() {
        return list;
    }

    public void setList(boolean list) {
        this.list = list;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public List<Disk> getDisks() {
        return disks;
    }

    public void setDisks(List<Disk> disks) {
        this.disks = disks;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public Integer getTotaldiscs() {
        return totaldiscs;
    }

    public void setTotaldiscs(Integer totaldiscs) {
        this.totaldiscs = totaldiscs;
    }

    public String[] getTitle() {
        return title;
    }

    public void setTitle(String[] title) {
        this.title = title;
    }

    public String[] getDuration() {
        return duration;
    }

    public void setDuration(String[] duration) {
        this.duration = duration;
    }

    public String[] getDisk() {
        return disk;
    }

    public void setDisk(String[] disk) {
        this.disk = disk;
    }
}
