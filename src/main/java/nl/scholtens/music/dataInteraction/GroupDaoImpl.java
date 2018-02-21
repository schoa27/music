package nl.scholtens.music.dataInteraction;

import nl.scholtens.music.domain.Group;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class GroupDaoImpl implements GroupDao {

    private Logger logger = Logger.getLogger(GroupDaoImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Group> getAllSortedGroups(String item, boolean ascDesc) {
        String sql = "select g from Group g order by g." + item + (ascDesc ? " asc" :" desc ");
        TypedQuery<Group> query = entityManager.createQuery(sql, Group.class);
        List<Group> resultList = query.getResultList();
        return resultList;
    }
}
