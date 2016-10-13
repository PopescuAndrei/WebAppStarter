package ro.andrei.webapp.service;

import ro.andrei.webapp.domain.support.BaseEntity;

import java.util.List;

/**
 * Created by epopean on 10/12/2016.
 */
public interface EntityService<T extends BaseEntity> {

    T find(Long id);

    List<T> findAll();

    T create(T entity);

    T update(T entity);

    T delete(Long id);
}
