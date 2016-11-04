package ro.andrei.webapp.service;

import java.util.List;

import ro.andrei.webapp.domain.Notebook;

public interface NotebookService extends EntityService<Notebook> {

	List<Notebook> findForUser(Long ownerId);
}
