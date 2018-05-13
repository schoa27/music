package nl.scholtens.music.services;


import nl.scholtens.music.dataTransferObjects.GroupDTO;
import nl.scholtens.music.domain.Artist;
import nl.scholtens.music.domain.Group;

import java.util.List;

public interface GroupService {

    List<Group> getAllGroups(String item, boolean ascDesc);

    List<Group> findGroupsByName(String name);

    Group findGroupById(Integer id);

    void saveGroup(GroupDTO dto);
}
