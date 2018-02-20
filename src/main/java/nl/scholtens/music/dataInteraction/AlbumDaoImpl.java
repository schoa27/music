package nl.scholtens.music.dataInteraction;

import nl.scholtens.music.domain.Album;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class AlbumDaoImpl implements AlbumDao {

    Logger logger = Logger.getLogger(AlbumDaoImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Album> getAllSortedAlbums(String item, boolean ascDesc) {
        String sql = "select a from Album a order by a." + item + (ascDesc ? " asc" : " desc");
        return runQuery(sql);
    }

    /**
     * Navtive queries gebruikt, TypeQuery geeft geen resultaten terug.
     * @param ascDesc
     * @return
     */
    @Override
    public List<Album> getAllAlbumsSortedByArtistGroep(boolean ascDesc) {
        String sql = "SELECT * FROM am_albums WHERE am_collection = FALSE " +
                "ORDER BY am_artist" + (ascDesc ? " ASC" : " DESC") + ", am_group "  +(ascDesc ? " ASC" : " DESC") + ";";

        Query nativeQuery = entityManager.createNativeQuery(sql, Album.class);
        return nativeQuery.getResultList();
    }

    private List<Album> runQuery(String sql) {
        TypedQuery<Album> query = entityManager.createQuery(sql, Album.class);
        return query.getResultList();
    }
}
