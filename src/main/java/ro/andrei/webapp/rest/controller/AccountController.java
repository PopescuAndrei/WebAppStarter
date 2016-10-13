package ro.andrei.webapp.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ro.andrei.webapp.domain.Account;
import ro.andrei.webapp.domain.Blog;
import ro.andrei.webapp.service.AccountService;
import ro.andrei.webapp.service.BlogService;

/**
 * Created by epopean on 10/4/2016.
 */

@Controller
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private BlogService blogService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        // FIXME
        // check if account exists by email, too lazy to do it
        Account newAccount = accountService.create(account);
        if(newAccount!=null) {
            return new ResponseEntity<Account>(newAccount, HttpStatus.OK);
        }
        return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="/{accountId}", method = RequestMethod.GET)
    public ResponseEntity<Account> getAccount(@PathVariable("accountId") Long accountId) {
        Account account = accountService.find(accountId);
        if(account!=null) {
            return new ResponseEntity<Account>(account, HttpStatus.OK);
        }
        return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="/{accountId}/blogs", method = RequestMethod.POST)
    public ResponseEntity<Blog> createBlog(@PathVariable Long accountId, @RequestBody Blog blog) {
        Account account = accountService.find(accountId);
        blog.setOwner(account);
        blog = blogService.create(blog);
        if(blog!=null){
            return new ResponseEntity<Blog>(blog, HttpStatus.OK);
        }
        return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
    }
}