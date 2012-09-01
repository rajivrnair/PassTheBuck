package models;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

public class Comment {

	public User commenter;
	public String comment;
	public LocalDate commentDate;
	public LocalTime commentTime;

}
