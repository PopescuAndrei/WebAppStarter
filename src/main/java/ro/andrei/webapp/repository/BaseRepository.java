package ro.andrei.webapp.repository;

import java.io.Serializable;

/**
 * Created by epopean on 10/12/2016.
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import ro.andrei.webapp.domain.support.BaseEntity;

/**
 * Custom repository that allows implementing behavior that is common to all repositories.
 *
 * @param <T> - the entity for which the repository is defined
 * @param <ID> - the primary key of the entities
 */
@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity, ID extends Serializable> extends JpaRepository<T, ID>{

}
