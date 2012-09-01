package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

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
	public LocalDate scheduledDate;
	public LocalTime scheduledTime;
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
