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

@Entity
public class TodoEntry extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = TITLE, nullable = false, unique = false, length = 100)
	private String title;

	@Column(name = CONTENT, nullable = false, unique = false, length = 100)
	private String content;

	@ManyToOne
	private Notebook notebook;

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

	public Notebook getBlog() {
		return notebook;
	}

	public void setBlog(Notebook notebook) {
		this.notebook = notebook;
	}

	@Override
	public void update(BaseEntity entity) {
		if (!(entity instanceof TodoEntry)) {
			throw new IllegalArgumentException("Entity should be a TodoEntry");
		}

		TodoEntry todoEntry = (TodoEntry) entity;
		setTitle(todoEntry.getTitle());
		setContent(todoEntry.getContent());
		setBlog(todoEntry.getBlog());
	}
}
