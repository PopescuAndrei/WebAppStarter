package ro.andrei.webapp.service;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ro.andrei.webapp.domain.support.BaseEntity;
import ro.andrei.webapp.repository.BaseRepository;
import ro.andrei.webapp.service.support.EntityNotFoundException;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by epopean on 10/12/2016.
 */
public abstract class EntityServiceImpl<T extends BaseEntity> implements EntityService<T> {

    private static final Logger LOG = Logger.getLogger(EntityServiceImpl.class);

    private BaseRepository<T, Long> repository;

    public EntityServiceImpl(BaseRepository<T, Long> repository) {
        this.repository = repository;
    }

    @Override
    public T find(Long id) {
        T entity = repository.findOne(id);
        if (entity == null) {
            LOG.error("Entity with id " + id + " does not exist.");
            throw new EntityNotFoundException("Entity with id " + id + " does not exist.");
        }
        return entity;
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    @Override
    public T create(T entity) {
        T newEntity = repository.save(entity);
        LOG.debug("Added " + entity.getClass().getSimpleName() + " with id " + newEntity.getId() + ".");
        return newEntity;
    }

    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    @Override
    public T update(T updated) {
        checkNotNull(updated, "updated entity cannot be null");

        T entity = find(updated.getId());
        entity.update(updated);
        return entity;
    }

    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    @Override
    public T delete(Long id) {
        T entity = find(id);
        repository.delete(id);
        LOG.debug("Deleted " + entity.getClass().getSimpleName() + " with id " + id + ".");
        return entity;
    }

    protected BaseRepository<T, Long> getRepository() {
        return repository;
    }

    protected void init() {
        checkNotNull(repository, "repository cannot be null");
    }
}
