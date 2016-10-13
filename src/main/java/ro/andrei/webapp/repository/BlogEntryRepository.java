package ro.andrei.webapp.repository;

import java.util.List;

import ro.andrei.webapp.domain.BlogEntry;

/**
 * Created by epopean on 10/3/2016.
 */
public interface BlogEntryRepository extends BaseRepository<BlogEntry, Long> {

    List<BlogEntry> findAllByBlogId(Long blogId);
}
