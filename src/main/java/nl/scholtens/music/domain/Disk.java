package nl.scholtens.music.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Disk {

    private int diskNumber;

    private List<Song> songs = new ArrayList<>();

}
