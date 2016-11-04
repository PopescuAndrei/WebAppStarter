package ro.andrei.webapp.repository;

import java.util.List;

import ro.andrei.webapp.domain.Notebook;

public interface NotebookRepository extends BaseRepository<Notebook, Long>{

	List<Notebook> findAllByOwner(Long ownerId);
}
