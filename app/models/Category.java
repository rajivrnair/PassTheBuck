package models;

import java.util.ArrayList;
import java.util.List;

import play.db.ebean.Model;

public class Category extends Model{
	private static final long serialVersionUID = 1L;

	public Long id;
	public String name;
	public Integer durationInMinutes = 30;
	public Integer credits = 0;

	public static List<Category> all() {
		return new ArrayList<Category>();
	}

	public static void create(Category category) {
	}

	public static void delete(Long id) {
	}
}
