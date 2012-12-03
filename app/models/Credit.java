package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import play.db.ebean.Model;

@Entity
public class Credit extends Model {
	private static final long serialVersionUID = 1L;

	@Id
	public Long id;
	
	public Integer value;
	public CreditSource source;
	public long sourceId;
	public LocalDate awardedDate;
	public LocalTime awardedTime;
}
