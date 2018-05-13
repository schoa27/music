package nl.scholtens.music.dataTransferObjects;

import nl.scholtens.music.domain.Artist;

import java.util.List;

public class ArtistDTO {

    private List<Artist>  artists;

    private Artist artist;

    private String search;

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
