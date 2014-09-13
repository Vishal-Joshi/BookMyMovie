package bookticket;

import java.util.List;
import java.util.Map;

/**
 * Created by ee on 9/1/2014.
 */
public interface Repository<T extends DbEntity, ID> {

    T findById(ID id);

    T find(Map query);

    void insert(List<T> entities);

    ID save(T entity);

    void update(T entity, Map forUpdate);
}
