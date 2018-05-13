package nl.scholtens.music.dataInteraction;

import nl.scholtens.music.domain.Artist;
import nl.scholtens.music.domain.Group;

import java.util.List;

public interface GroupDao {

    List<Group> getAllSortedGroups(String item, boolean ascDesc);

    void saveGroup(Group group, List<Artist> artists, String[] startDates, String[] endDates);
}
