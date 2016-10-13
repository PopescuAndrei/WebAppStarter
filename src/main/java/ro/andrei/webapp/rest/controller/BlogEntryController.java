package ro.andrei.webapp.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ro.andrei.webapp.domain.BlogEntry;
import ro.andrei.webapp.service.BlogEntryService;

/**
 * Created by epopean on 10/3/2016.
 */

@Controller
@RequestMapping("/blog-entries")
public class BlogEntryController {

    @Autowired
    private BlogEntryService blogEntryService;

    /**
     * Method for retrieving a list containing all the blog entries
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<BlogEntry>> getAll() {
        List<BlogEntry> blogEntries = blogEntryService.findAll();
        if (!blogEntries.isEmpty()) {
            return new ResponseEntity<List<BlogEntry>>(blogEntries, HttpStatus.OK);
        }
        return new ResponseEntity<List<BlogEntry>>(blogEntries, HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/{blogEntryId}", method = RequestMethod.GET)
    public ResponseEntity<BlogEntry> getBlogEntry(@PathVariable("blogEntryId") Long blogEntryId) {
        BlogEntry blogEntry = blogEntryService.find(blogEntryId);
        if (blogEntry != null) {
            return new ResponseEntity<BlogEntry>(blogEntry, HttpStatus.OK);
        }
        return new ResponseEntity<BlogEntry>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/{blogEntryId}", method = RequestMethod.DELETE)
    public ResponseEntity<BlogEntry> deleteBlogEntry(@PathVariable("blogEntryId") Long blogEntryId) {
        BlogEntry blogEntry = blogEntryService.delete(blogEntryId);
        if (blogEntry != null) {
            return new ResponseEntity<BlogEntry>(blogEntry, HttpStatus.OK);
        }
        return new ResponseEntity<BlogEntry>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/{blogEntryId}", method = RequestMethod.PUT)
    public ResponseEntity<BlogEntry> updateBlogEntry(@PathVariable Long blogEntryId, @RequestBody BlogEntry sentBlogEntry) {
        BlogEntry update = blogEntryService.update(sentBlogEntry);
        if(update != null) {
            return new ResponseEntity<BlogEntry>(update, HttpStatus.OK);
        }
        return new ResponseEntity<BlogEntry>(HttpStatus.NOT_FOUND);
    }
}

