package models;

import java.util.Date;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Task extends Model {

	public String title;
	public Date start; 
	public Date end;
	public User assignee;
}
