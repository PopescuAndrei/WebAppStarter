package ro.andrei.webapp.repository;

import ro.andrei.webapp.domain.Blog;

/**
 * Created by epopean on 10/4/2016.
 */
public interface BlogRepository extends BaseRepository<Blog, Long> {

    Blog findByTitle(String title);
}
