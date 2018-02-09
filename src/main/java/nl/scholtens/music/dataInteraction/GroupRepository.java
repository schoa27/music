package nl.scholtens.music.dataInteraction;

import nl.scholtens.music.domain.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends CrudRepository<Group, Integer> {

    Group findByName(String name);

}
