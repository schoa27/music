package nl.scholtens.music.dataInteraction;

import nl.scholtens.music.domain.Group;

import java.util.List;

public interface GroupDao {

    List<Group> getAllSortedGroups(String item, boolean ascDesc);
}
