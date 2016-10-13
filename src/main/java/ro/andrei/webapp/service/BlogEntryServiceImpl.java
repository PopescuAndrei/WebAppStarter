package ro.andrei.webapp.service;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import ro.andrei.webapp.domain.BlogEntry;
import ro.andrei.webapp.repository.BlogEntryRepository;

/**
 * Created by epopean on 10/3/2016.
 */
@Service
public class BlogEntryServiceImpl extends EntityServiceImpl<BlogEntry> implements BlogEntryService {

	public BlogEntryServiceImpl(BlogEntryRepository repository) {
		super(repository);
	}

	@PostConstruct
	@Override
	protected void init() {
		super.init();
	}
}
