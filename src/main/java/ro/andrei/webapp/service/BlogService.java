package ro.andrei.webapp.service;

import ro.andrei.webapp.domain.Blog;
import ro.andrei.webapp.domain.BlogEntry;

import java.util.List;

/**
 * Created by epopean on 10/4/2016.
 */
public interface BlogService extends EntityService<Blog> {

    Blog findByTitle(String title);

    List<BlogEntry> findAllBlogEntries(Long blogId);
}