package ro.andrei.webapp.domain;

import static ro.andrei.webapp.util.DbNames.CONTENT;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import ro.andrei.webapp.domain.support.BaseEntity;

@Entity
public class Comment extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = CONTENT, nullable = false, unique = false, length = 100)
	private String content;
	
	@ManyToOne
	private TodoEntry todoEntry;
	
	@OneToOne
	private Account author;
	
	private LocalDateTime timestamp;
	
	private LocalDateTime lastEdit;
	
	/*
	 * Default Constructor
	 */
	public Comment() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public TodoEntry getTodoEntry() {
		return todoEntry;
	}

	public void setTodoEntry(TodoEntry todoEntry) {
		this.todoEntry = todoEntry;
	}

	public Account getAuthor() {
		return author;
	}

	public void setAuthor(Account author) {
		this.author = author;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	
	public LocalDateTime getLastEdit() {
		return lastEdit;
	}

	public void setLastEdit(LocalDateTime lastEdit) {
		this.lastEdit = lastEdit;
	}

	@Override
	public void update(BaseEntity entity) {
		if(!(entity instanceof Comment)) {
            throw new IllegalArgumentException("Entity should be an instance of Comment");
		}
		Comment comment = (Comment) entity;
		this.setContent(comment.getContent());
		this.setLastEdit(comment.getLastEdit());
	}
}
