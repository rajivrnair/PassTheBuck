package models;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import play.db.ebean.Model;

public class Comment extends Model {
	private static final long serialVersionUID = 1L;

	public User commenter;
	public String comment;
	public LocalDate commentDate;
	public LocalTime commentTime;

}
