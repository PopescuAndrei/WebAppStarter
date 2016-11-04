package ro.andrei.webapp.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ro.andrei.webapp.domain.Notebook;
import ro.andrei.webapp.repository.BaseRepository;
import ro.andrei.webapp.repository.NotebookRepository;

@Service
@Qualifier("notebookService")
public class NotebookServiceImpl extends EntityServiceImpl<Notebook> implements NotebookService{

	@Autowired
	@Qualifier("notebookRepository")
	private NotebookRepository notebookRepository;
	
	public NotebookServiceImpl(BaseRepository<Notebook, Long> repository) {
		super(repository);
	}

	@Override
	public List<Notebook> findForUser(Long ownerId) {
		return notebookRepository.findAllByOwner(ownerId);
	}
	
    @PostConstruct
    @Override
    protected void init() {
        super.init();
    }
}
