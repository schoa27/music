package nl.scholtens.music.services;

import nl.scholtens.music.dataInteraction.GroupDao;
import nl.scholtens.music.dataInteraction.GroupRepository;
import nl.scholtens.music.domain.Artist;
import nl.scholtens.music.domain.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository repository;

    @Autowired
    private GroupDao groupDao;

    @Override
    public List<Group> getAllGroups(String sorting, boolean ascDesc ) {
        List<Group> groups = new ArrayList<>();

        if (sorting.isEmpty()) {
            Iterable<Group> all = repository.findAll();
            all.forEach(groups::add);
        } else {
            return getsortedList(sorting, ascDesc);
        }
        return groups;
    }

    @Override
    public Group getGroupById(Integer id) {
        return repository.findById(id);
    }
    private List<Group> getsortedList(String sorting, boolean ascDesc) {
        return groupDao.getAllSortedGroups(sorting, ascDesc);
    }

}
