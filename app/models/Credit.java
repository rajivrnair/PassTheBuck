package models;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import play.db.ebean.Model;

public class Credit extends Model {
	private static final long serialVersionUID = 1L;

	public Integer value;
	public CreditSource source;
	public long sourceId;
	public LocalDate awardedDate;
	public LocalTime awardedTime;
}
