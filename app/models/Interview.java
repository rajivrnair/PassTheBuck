package models;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.joda.time.DateTime;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Interview extends Model {
	private static final long serialVersionUID = 1L;

	@Id
	public Long id;

	@Required
	public String name;
	
	public String description;

	@Required
	public String startDate;

	@Required
	public String startHour;

	@Required
	public String startMinute;

	@ManyToOne
	public Category category;
	
//	@OneToMany(cascade=CascadeType.PERSIST)
	public List<User> assignedTo;
	
//	@OneToOne
	public User createdBy;
	
//	@OneToMany(cascade=CascadeType.PERSIST)
	public List<Comment> comments;
	
	@Enumerated(value=EnumType.STRING)
	public Status status = Status.NOT_STARTED;

	public Interviewee interviewee;
	
	@Enumerated(value=EnumType.STRING)
	public Outcome outcome;

	
	public DateTime scheduledStart() {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String dateTimeString = this.startDate + " " + this.startHour + ":" + this.startMinute;
		try {
			return new DateTime(formatter.parse(dateTimeString));
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	public Category getCategory() {
		return this.category;
	}

//	public static void delete(Long id) {
//		find.ref(id).delete();
//	}
	
	public String getStartTime() {
		return (this.scheduledStart() == null)? "" : scheduledStart().toString("dd-MMM-yyyy / HH:mm");
	}

	public static Finder<Long, Interview> find = new Finder<Long, Interview>(Long.class, Interview.class);
	
	public static List<Interview> all() {
		return find.fetch("category").findList();
	}
}
