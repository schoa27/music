package nl.scholtens.music.dataInteraction;

import nl.scholtens.music.domain.Artist;
import nl.scholtens.music.domain.Group;
import nl.scholtens.music.domain.StartEndDate;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class GroupDaoImpl implements GroupDao {

    private Logger logger = Logger.getLogger(GroupDaoImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Group> getAllSortedGroups(String item, boolean ascDesc) {
        String sql = "select g from Group g order by g." + item + (ascDesc ? " asc" : " desc ");
        TypedQuery<Group> query = entityManager.createQuery(sql, Group.class);
        List<Group> resultList = query.getResultList();
        return resultList;
    }

    @Override
    public void saveGroup(Group group, List<Artist> artists, String[] startDates, String[] endDates)  {

            for (int i=0; i < artists.size() ; i++) {
                StartEndDate startEndDate = new StartEndDate();
                startEndDate.setStartDate(startDates[i]);
                startEndDate.setEndDate(endDates[i]);

                group.getArtists().add(artists.get(i));
                artists.get(i).getStartEndDateByGroup().put(startEndDate, group);
                entityManager.persist(group);
                entityManager.persist(artists.get(i));
            }

    }
}
