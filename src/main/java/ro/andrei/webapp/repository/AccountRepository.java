package ro.andrei.webapp.repository;

import ro.andrei.webapp.domain.Account;

/**
 * Created by epopean on 10/4/2016.
 */
public interface AccountRepository extends BaseRepository<Account, Long> {

    Account findByName(String name);
}
