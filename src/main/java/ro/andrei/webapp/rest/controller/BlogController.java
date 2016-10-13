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

import ro.andrei.webapp.domain.Blog;
import ro.andrei.webapp.service.BlogService;

/**
 * Created by epopean on 10/4/2016.
 */

@Controller
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    /**
     * Method for retrieving a list containing all the blog entries
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Blog>> getAll() {
        List<Blog> blogEntries = blogService.findAll();
        if (!blogEntries.isEmpty()) {
            return new ResponseEntity<List<Blog>>(blogEntries, HttpStatus.OK);
        }
        return new ResponseEntity<List<Blog>>(blogEntries, HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/{blogId}", method = RequestMethod.GET)
    public ResponseEntity<Blog> getBlog(@PathVariable("blogId") Long blogId) {
        Blog blog = blogService.find(blogId);
        if (blog != null) {
            return new ResponseEntity<Blog>(blog, HttpStatus.OK);
        }
        return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/{blogId}", method = RequestMethod.DELETE)
    public ResponseEntity<Blog> deleteBlog(@PathVariable("blogId") Long blogId) {
        Blog blog = blogService.delete(blogId);
        if (blog != null) {
            return new ResponseEntity<Blog>(blog, HttpStatus.OK);
        }
        return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/{blogId}", method = RequestMethod.PUT)
    public ResponseEntity<Blog> updateBlog(@PathVariable Long blogId, @RequestBody Blog sentblog) {
        Blog update = blogService.update(sentblog);
        if(update != null) {
            return new ResponseEntity<Blog>(update, HttpStatus.OK);
        }
        return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
    }
}