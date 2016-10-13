package ro.andrei.webapp.service;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import ro.andrei.webapp.domain.Account;
import ro.andrei.webapp.repository.AccountRepository;

/**
 * Created by epopean on 10/4/2016.
 */
@Service
public class AccountServiceImpl extends EntityServiceImpl<Account> implements AccountService {

    public AccountServiceImpl(AccountRepository repository) {
        super(repository);
    }

    @Override
    public Account findByName(String name) {
        return ((AccountRepository) getRepository()).findByName(name);
    }

    @PostConstruct
    @Override
    protected void init() {
        super.init();
    }
}
