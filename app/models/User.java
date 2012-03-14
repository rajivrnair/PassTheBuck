package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class User extends Model {

	public String userName;
	public String password;
	public String fullName;
	public String email;
	public boolean isAdmin = false;
}
