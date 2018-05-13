package nl.scholtens.music.dataTransferObjects;

import nl.scholtens.music.domain.Artist;

import java.util.List;

public class ArtistDTO {

    private List<Artist>  artists;

    private Artist artist;

    private String search;

    private boolean message;

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

    public boolean isMessage() {
        return message;
    }

    public void setMessage(boolean message) {
        this.message = message;
    }
}
