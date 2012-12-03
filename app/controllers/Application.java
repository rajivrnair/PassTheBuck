package controllers;

import models.Category;
import models.Interview;
import models.Team;
import models.User;
import play.Routes;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import com.feth.play.module.pa.PlayAuthenticate;
import com.feth.play.module.pa.providers.AuthProvider;
import com.feth.play.module.pa.providers.AuthProvider.Registry;

public class Application extends Controller {
  
	public static final String FLASH_MESSAGE_KEY = "message";
	public static final String FLASH_ERROR_KEY = "error";
	
	static Form<Team> teamForm = form(Team.class);
	static Form<Category> categoryForm = form(Category.class);
	static Form<Interview> interviewForm = form(Interview.class);
	
	public static Result index() {
		User localUser = getLoggedinUser();

		if(localUser == null) {
			return login();
		}
		return ok(views.html.index.render(Team.all(), teamForm, Category.all(), categoryForm, Interview.all(), interviewForm, localUser));
	}
	
	public static Result login() {
		AuthProvider authProvider = Registry.get("google");
		
		User localUser = getLoggedinUser();
		return ok(views.html.login.render(authProvider, localUser));
	}
	
	public static User getLoggedinUser() {
		return User.findByAuthUserIdentity(PlayAuthenticate.getUser(session()));
	}

	public static Result javascriptRoutes() {
		response().setContentType("text/javascript");
		return ok(Routes.javascriptRouter("jsRoutes",
				routes.javascript.Interviews.newInterview(),
				routes.javascript.Teams.newTeam(),
				routes.javascript.Categories.newCategory())); // Don't set any params in the brackets, even if the original actions are parameterized.
	}
	
	public static Result oAuthDenied(final String providerKey) {
	    flash(FLASH_ERROR_KEY,
	            "You need to accept the OAuth connection in order to use this website!");
	    
	    return redirect(routes.Application.index());
	}
}