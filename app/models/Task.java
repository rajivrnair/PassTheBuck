package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.joda.time.LocalDateTime;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Task extends Model {
	private static final long serialVersionUID = 1L;

	@Id
	public Long id;

	@Required
	public String name;
	
	public String description;

	@Required
	public String startDate;
	public String startHour;
	public String startMinute;
	// Calculated using the above fields.
	public LocalDateTime scheduledStart;

	// Why is this not fetching?
	@ManyToOne(fetch=FetchType.EAGER)
	public Category category;
	
//	@OneToMany(cascade=CascadeType.PERSIST)
	public List<User> assignedTo;
	
//	@OneToOne
	public User createdBy;
	
//	@OneToMany(cascade=CascadeType.PERSIST)
	public List<Comment> comments;
	
	@Enumerated(value=EnumType.STRING)
	public Status status = Status.NOT_STARTED;

	public static Finder<Long, Task> find = new Finder<Long, Task>(Long.class, Task.class);

	public static List<Task> all() {
		System.out.println("allTasks");
		List<Task> allTasks = find.all();
		for (Task t : allTasks) {
			System.out.println("Task:" + t.id + "|" + t.name);
			System.out.println("Assoc Category:" + t.category.name);
		}
		return allTasks;
	}

	public Category getCategory() {
		return this.category;
	}

	public static void create(Task task) {
		task.save();
	}

	public static void delete(Long id) {
		find.ref(id).delete();
	}
}
