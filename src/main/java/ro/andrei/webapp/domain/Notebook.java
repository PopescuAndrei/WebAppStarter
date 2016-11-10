package ro.andrei.webapp.domain;

import static ro.andrei.webapp.util.DbNames.ICON;
import static ro.andrei.webapp.util.DbNames.TITLE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import ro.andrei.webapp.domain.support.BaseEntity;

@Entity
public class Notebook extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = TITLE, nullable = false, length = 100)
    private String title;

	@Column(name = ICON, nullable = false, length = 100)
	private String icon;

	@ManyToOne
    private Account owner;
	
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Account getOwner() {
        return owner;
    }

    public void setOwner(Account owner) {
        this.owner = owner;
    }
    
    public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Override
    public void update(BaseEntity entity) {
        if(!(entity instanceof Notebook)) {
            throw new IllegalArgumentException("Entity should be an instance of Notebook");
        }

        Notebook notebook = (Notebook) entity;
        setTitle(notebook.getTitle());
        setOwner(notebook.getOwner());
    }
}
