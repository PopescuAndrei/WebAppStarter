package ro.andrei.webapp.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.andrei.webapp.domain.Blog;
import ro.andrei.webapp.domain.BlogEntry;
import ro.andrei.webapp.repository.BlogEntryRepository;
import ro.andrei.webapp.repository.BlogRepository;

/**
 * Created by epopean on 10/4/2016.
 */
@Service
public class BlogServiceImpl extends EntityServiceImpl<Blog> implements BlogService {

    @Autowired
    private BlogEntryRepository blogEntryRepository;

    public BlogServiceImpl(BlogRepository repository) {
        super(repository);
    }

    @Override
    public Blog findByTitle(String title) {
        return ((BlogRepository) getRepository()).findByTitle(title);
    }

    @Override
    public List<BlogEntry> findAllBlogEntries(Long blogId) {
        return blogEntryRepository.findAllByBlogId(blogId);
    }

    @PostConstruct
    @Override
    protected void init() {
        super.init();
    }
}
