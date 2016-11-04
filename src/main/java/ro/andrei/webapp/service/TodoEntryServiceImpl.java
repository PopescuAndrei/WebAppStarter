package ro.andrei.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ro.andrei.webapp.domain.TodoEntry;
import ro.andrei.webapp.repository.BaseRepository;
import ro.andrei.webapp.repository.TodoEntryRepository;

@Service
@Qualifier("todoEntryService")
public class TodoEntryServiceImpl extends EntityServiceImpl<TodoEntry> implements TodoEntryService{

	@Autowired
	@Qualifier("todoEntryRepository")
	private TodoEntryRepository todoEntryRepository;
	
	public TodoEntryServiceImpl(BaseRepository<TodoEntry, Long> repository) {
		super(repository);
		// TODO Auto-generated constructor stub
	}

}
