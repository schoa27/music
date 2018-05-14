package nl.scholtens.music.dataTransferObjects;

import nl.scholtens.music.domain.Artist;
import nl.scholtens.music.domain.Group;

import java.util.List;

public class GroupDTO {

    private List<Group> groups;

    private List<Artist> artists;

    private Group group;

    private String search;

    private String[] startdate;

    private String[] enddate;

    private boolean message;

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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String[] getStartdate() {
        return startdate;
    }

    public void setStartdate(String[] startdate) {
        this.startdate = startdate;
    }

    public String[] getEnddate() {
        return enddate;
    }

    public void setEnddate(String[] enddate) {
        this.enddate = enddate;
    }

    public boolean isMessage() {
        return message;
    }

    public void setMessage(boolean message) {
        this.message = message;
    }
}
