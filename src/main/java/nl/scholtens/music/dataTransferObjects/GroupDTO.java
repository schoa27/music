package nl.scholtens.music.dataTransferObjects;

import lombok.Data;
import nl.scholtens.music.domain.Group;

import java.util.List;

@Data
public class GroupDTO {

    private List<Group> groups;

    private Group group;

    private String search;
}
