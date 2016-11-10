package ro.andrei.webapp.domain;

import static ro.andrei.webapp.util.DbNames.CONTENT;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import ro.andrei.webapp.domain.support.BaseEntity;

@Entity
public class Task extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	private TodoEntry todoEntry;
	
	@Column(name = CONTENT, nullable = false, unique = false, length = 100)
	private String content;
	
	public Task() {
		
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

	@Override
	public void update(BaseEntity entity) {
		if(!(entity instanceof Task)) {
            throw new IllegalArgumentException("Entity should be an instance of Task");
		}
		Task task = (Task) entity;
		this.setContent(task.getContent());
	}
	
	
}
