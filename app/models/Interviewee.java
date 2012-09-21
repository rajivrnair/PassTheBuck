package models;

import play.db.ebean.Model;

public class Interviewee extends Model {
	private static final long serialVersionUID = 1L;

	public String name;
	public String contactNumber;
	public Integer yearsOfExperience;
	public String notes;
}
