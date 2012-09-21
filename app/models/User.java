package models;

import java.util.ArrayList;
import java.util.List;

import play.db.ebean.Model;

public class User extends Model {
	private static final long serialVersionUID = 1L;

	public Long id;
	public String name;
	public String email;
	public List<Team> participatingTeams;
	public List<Credit> creditHistory;
	
	public static List<User> all() {
		return new ArrayList<User>();
	}
	
	public static void create(User user) {
	}
	
	public static void delete(Long id){
	}
}
