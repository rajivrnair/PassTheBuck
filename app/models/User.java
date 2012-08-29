package models;

import java.util.ArrayList;
import java.util.List;

public class User {

	public Long id;
	public String name;
	public String email;
	
	public static List<User> all() {
		return new ArrayList<User>();
	}
	
	public static void create(User user) {
	}
	
	public static void delete(Long id){
	}
}
