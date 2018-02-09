package nl.scholtens.music.dataInteraction;

import nl.scholtens.music.domain.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends CrudRepository<Song, Integer> {

    Song findByTitle(String title);
}
