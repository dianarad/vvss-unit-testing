package Repository;

/**
 * Created by drad on 11/03/2018.
 */

import java.util.List;

public interface BaseRepository<T> {
    void add(T entity);
    void remove(T entity);
    void update(T oldEntity, T newEntity);
    List<T> getAll();
}
