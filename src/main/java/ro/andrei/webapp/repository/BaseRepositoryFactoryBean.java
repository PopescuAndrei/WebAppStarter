package ro.andrei.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Custom {@link org.springframework.beans.factory.FactoryBean} destined for instantiating the custom
 * {@link BaseRepository}
 *
 * @param <T>
 * @param <S>
 * @param <ID>
 *
 * @see {@link JpaRepository}
 * @see {@link JpaRepositoryFactoryBean}
 */
public class BaseRepositoryFactoryBean<T extends JpaRepository<S, ID>, S, ID extends Serializable> extends
        JpaRepositoryFactoryBean<T, S, ID> {

    /**
     * @see org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean#createRepositoryFactory(javax.persistence.EntityManager)
     */
    @Override
    protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
        return new FilterRepositoryFactory(entityManager);
    }


    private static class FilterRepositoryFactory extends JpaRepositoryFactory {
        public FilterRepositoryFactory(EntityManager entityManager) {
            super(entityManager);
        }

        @Override
        @SuppressWarnings( { "unchecked", "rawtypes" })
        protected <T, ID extends Serializable> SimpleJpaRepository<?, ?> getTargetRepository(RepositoryInformation information,
                                                                                             EntityManager entityManager) {
            Class<?> clazz = information.getDomainType();
            return new BaseRepositoryImpl(getEntityInformation(clazz), entityManager);
        }

        @Override
        protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
            return BaseRepositoryImpl.class;
        }
    }
}