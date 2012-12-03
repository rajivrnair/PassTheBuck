package models;

import java.util.List;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

import com.avaje.ebean.validation.Email;
import com.feth.play.module.pa.providers.oauth2.google.GoogleAuthUser;
import com.feth.play.module.pa.user.AuthUser;
import com.feth.play.module.pa.user.AuthUserIdentity;

@Entity
public class User extends Model {
	private static final long serialVersionUID = 1L;

	@Id
	public Long id;

	public String externalIdentity;

	@Email
	public String email;

	public String name;

	public Locale locale;

	public String picture;

	public List<Team> participatingTeams;
	public List<Credit> creditHistory;

	public static final Finder<Long, User> find = new Finder<Long, User>(Long.class, User.class);

	public static List<User> all() {
		return find.all();
	}

	public static User create(AuthUser authUser) {
		User user = new User();
		if (authUser instanceof GoogleAuthUser) {
			final GoogleAuthUser identity = (GoogleAuthUser) authUser;
			// Remember, even when getting them from FB & Co., emails should be
			// verified within the application as a security breach there might
			// break your security as well!
			user.externalIdentity = identity.getId();
			user.email = identity.getEmail();
			user.name = identity.getName();
			user.locale = identity.getLocale();
			user.picture = identity.getPicture();
			user.save();
			return user;
		}
		throw new RuntimeException("Unsupported Authentication provider!"
				+ authUser);
	}

	public static User findByAuthUserIdentity(AuthUserIdentity identity) {
		if(identity == null) {
			return null;
		}

		return find.where().eq("externalIdentity", identity.getId()).findUnique();
	}
}
