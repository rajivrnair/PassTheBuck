package controllers;

import models.Category;
import models.Task;
import models.Team;
import play.Routes;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * FIXME: Move all the CUD logic into separate controllers.
 */
public class Application extends Controller {
  
	static Form<Team> teamForm = form(Team.class);
	static Form<Category> categoryForm = form(Category.class);
	static Form<Task> taskForm = form(Task.class);

	public static Result index() {
		return ok(views.html.index.render(Team.all(), teamForm, Category.all(), categoryForm, Task.all(), taskForm));
	}

	public static Result javascriptRoutes() {
		response().setContentType("text/javascript");
		return ok(Routes.javascriptRouter("jsRoutes",
				routes.javascript.Tasks.newTask(),
				routes.javascript.Teams.newTeam(),
				routes.javascript.Categories.newCategory())); // Don't set any params in the brackets, even if the original actions are parameterized.
	}
}