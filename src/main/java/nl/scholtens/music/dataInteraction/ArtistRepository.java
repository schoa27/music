package nl.scholtens.music.dataInteraction;

import nl.scholtens.music.domain.Artist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistRepository extends CrudRepository<Artist, Integer> {

    Artist findByName(String name);

    Artist findArtistById(Integer id);
}


