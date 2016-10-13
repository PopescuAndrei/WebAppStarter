package ro.andrei.webapp.service;

import ro.andrei.webapp.domain.Account;

/**
 * Created by epopean on 10/4/2016.
 */
public interface AccountService extends EntityService<Account> {

    Account findByName(String name);
}