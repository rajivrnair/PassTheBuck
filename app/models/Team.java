package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Team extends Model {
	private static final long serialVersionUID = 1L;

	@Id
	public Long id;
	
	@Required
	public String name;
	public String description;
	public List<Task> tasks;
	public List<Category> associatedCategories;
	
	public static Finder<Long, Team> find = new Finder<Long, Team>(Long.class, Team.class);
	
	public static List<Team> all() {
		return find.all();
	}
	
	public static void create(Team team) {
		team.save();
	}
	
	public static void delete(Long id){
		find.ref(id).delete();
	}
}
