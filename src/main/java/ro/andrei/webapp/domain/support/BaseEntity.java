package ro.andrei.webapp.domain.support;

import java.util.Set;

import org.springframework.util.CollectionUtils;

/**
 * Created by epopean on 10/4/2016.
 */
public abstract class BaseEntity extends AbstractEntity<Long>{

	private static final long serialVersionUID = 1L;

    public abstract void update(BaseEntity entity);

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