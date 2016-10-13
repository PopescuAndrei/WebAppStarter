package ro.andrei.webapp.domain;

import static ro.andrei.webapp.util.DbNames.CONTENT;
import static ro.andrei.webapp.util.DbNames.TITLE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import ro.andrei.webapp.domain.support.BaseEntity;

/**
 * Created by epopean on 10/3/2016.
 */
@Entity
public class BlogEntry extends BaseEntity{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = TITLE, nullable = false, unique = false, length = 100)
    private String title;

    @Column(name = CONTENT, nullable = false, unique = false, length = 100)
    private String content;

    @ManyToOne
    private Blog blog;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    @Override
    public void update(BaseEntity entity) {
        if(!(entity instanceof BlogEntry)) {
            throw new IllegalArgumentException("Entity should be a BlogEntry");
        }

        BlogEntry blogEntry = (BlogEntry) entity;
        setTitle(blogEntry.getTitle());
        setContent(blogEntry.getContent());
        setBlog(blogEntry.getBlog());
    }
}
