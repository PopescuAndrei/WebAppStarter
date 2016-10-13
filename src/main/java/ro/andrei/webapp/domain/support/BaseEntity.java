package ro.andrei.webapp.domain.support;

import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by epopean on 10/4/2016.
 */
public abstract class BaseEntity extends AbstractEntity<Long>{
    public Long getEntityId() {
        return getId();
    }

    public void setEntityId(Long id) {
        //nothing to do
    }

    /**
     * Abstract method used to update the corresponding attributes of the entity
     * with the information contained in the provided {@code entity}.
     *
     * @param entity
     * 			the information used to updated the considered entity
     * @throws IllegalArgumentException
     */
    public abstract void update(BaseEntity entity);

    /**
     * Method that retrieves a set of non null ids having as input the provided collection
     * of {@code items}.
     *
     * @param items
     * @return
     * 		a set with the ids or
     * 		an empty set if the provided collection of {@code items} is null.
     */
    public static Set<Long> getIds(Collection<? extends AbstractEntity<Long>> items) {
        Set<Long> ids = new HashSet<>();
        if (items == null) {
            return ids;
        }
        for (AbstractEntity<Long> item : items) {
            if (item != null) {
                ids.add(item.getId());
            }
        }
        return ids;
    }

    /**
     * Method that retrieves an array of unique ids having as input the provided collection
     * of {@code items}.
     *
     * @param items
     * @return
     * 		an array with the ids or an empty array if the provided collection of {@code items} is null.
     */
    public static long[] getIdsArray(Collection<? extends AbstractEntity<Long>> items) {
        Set<Long> idSet = getIds(items);
        long[] ids = new long[idSet.size()];
        int i = 0;
        for (Long id : idSet) {
            ids[i++] = id;
        }
        return ids;
    }

    /**
     * Method used to check if two sets are the same.
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean isSetEquals(Set<?> a, Set<?> b) {
        if (CollectionUtils.isEmpty(a) && CollectionUtils.isEmpty(b)) {
            return true;
        }
        if (CollectionUtils.isEmpty(a) && !CollectionUtils.isEmpty(b)) {
            return false;
        }
        return a.equals(b);
    }
}