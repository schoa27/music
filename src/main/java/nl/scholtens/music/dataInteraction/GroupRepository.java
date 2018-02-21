package nl.scholtens.music.dataInteraction;

import nl.scholtens.music.domain.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends CrudRepository<Group, Integer> {

    Group findByName(String name);

    List<Group> findGroupByNameContains(String name);

    Group findById(Integer id);
}
