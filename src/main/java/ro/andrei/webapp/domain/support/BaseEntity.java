package ro.andrei.webapp.domain.support;

/**
 * Created by epopean on 10/4/2016.
 */
public abstract class BaseEntity extends AbstractEntity<Long>{

	private static final long serialVersionUID = 1L;

    public abstract void update(BaseEntity entity);

}