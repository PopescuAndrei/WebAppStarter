package ro.andrei.webapp.domain;

import static ro.andrei.webapp.util.DbNames.NAME;
import static ro.andrei.webapp.util.DbNames.PASSWORD;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import ro.andrei.webapp.domain.support.BaseEntity;

/**
 * Created by epopean on 10/4/2016.
 */
@Entity
public class Account extends BaseEntity {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = NAME, nullable = false, unique = true, length = 100)
    private String name;
    
    @Column(name = PASSWORD, nullable = false, length = 100)
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void update(BaseEntity entity) {
        if(!(entity instanceof Account)){
            throw new IllegalArgumentException("Entity should be an instance of Account");
        }
        Account account = (Account) entity;
        setName(account.getName());
        setPassword(account.getPassword());
    }
}