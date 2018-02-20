package nl.scholtens.music.dataInteraction;

import nl.scholtens.music.domain.Artist;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class ArtistDaoImpl implements ArtistDao {

    private Logger logger = Logger.getLogger(ArtistDaoImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Artist> getAllSortedArtist(String item, boolean ascDesc) {
        String sql = "select a from Artist a order by a." + item + (ascDesc ? " asc" : " desc");
        TypedQuery<Artist> query = entityManager.createQuery(sql, Artist.class);
        return query.getResultList();
    }
}
