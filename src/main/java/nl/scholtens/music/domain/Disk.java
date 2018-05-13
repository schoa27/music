package nl.scholtens.music.domain;


import java.util.ArrayList;
import java.util.List;

public class Disk {

    private String diskNumber;

    private List<Song> songs = new ArrayList<>();

    public String getDiskNumber() {
        return diskNumber;
    }

    public void setDiskNumber(String diskNumber) {
        this.diskNumber = diskNumber;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
