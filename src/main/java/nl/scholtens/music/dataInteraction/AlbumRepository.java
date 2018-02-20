package nl.scholtens.music.dataInteraction;

import nl.scholtens.music.domain.Album;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Integer> {

    Album findByTitle(String title);

    Album findById(Integer id);
}
