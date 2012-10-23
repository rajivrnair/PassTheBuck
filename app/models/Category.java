package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Category extends Model{
	private static final long serialVersionUID = 1L;

	@Id
	public Long id;

	@Required
	public String name;

	public Integer durationInMinutes = 30;
	public Integer credits = 0;

	public static Finder<Long, Category> find = new Finder<Long, Category>(Long.class, Category.class);
	
	public static List<Category> all() {
		return find.all();
	}

	public static void create(Category category) {
		category.save();
	}

	public static void delete(Long id) {
		find.ref(id).delete();
	}
}
