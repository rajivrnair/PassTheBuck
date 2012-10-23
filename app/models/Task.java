package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

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
	
	public Category category;
	public List<User> assignedTo;
	public User createdBy;
	public Status status = Status.NOT_STARTED;
	public List<Comment> comments;

	public static Finder<Long, Task> find = new Finder<Long, Task>(Long.class, Task.class);

	public static List<Task> all() {
		return find.all();
	}

	public static void create(Task task) {
		task.save();
	}

	public static void delete(Long id) {
		find.ref(id).delete();
	}
}
