package nl.scholtens.music.services;

import nl.scholtens.music.dataInteraction.GroupRepository;
import nl.scholtens.music.domain.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository repository;

    @Override
    public List<Group> getAllGroups() {
        List<Group> groups = new ArrayList<>();
        Iterable<Group> all = repository.findAll();
        all.forEach(groups::add);

        return groups;
    }
}
