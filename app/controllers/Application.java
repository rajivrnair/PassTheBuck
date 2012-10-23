package controllers;

import models.Category;
import models.Task;
import models.Team;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * FIXME: Move all the CUD logic into separate controllers.
 * TODO : Associate categories to team.
 */
public class Application extends Controller {
  
	static Form<Team> teamForm = form(Team.class);
	static Form<Category> categoryForm = form(Category.class);
	static Form<Task> taskForm = form(Task.class);

	public static Result index() {
		return ok(views.html.index.render(Team.all(), teamForm, Category.all(), categoryForm, Task.all(), taskForm));
	}

	public static Result newTeam() {
		Form<Team> filledForm = teamForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return badRequest(views.html.index.render(Team.all(), teamForm, Category.all(), categoryForm, Task.all(), taskForm));
		} else {
			Team.create(filledForm.get());
			return redirect(routes.Application.index());
		}
	}
	
	public static Result newTask() {
		Form<Task> filledForm = taskForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return badRequest(views.html.index.render(Team.all(), teamForm, Category.all(), categoryForm, Task.all(), taskForm));
		} else {
			Task.create(filledForm.get());
			return redirect(routes.Application.index());
		}
	}

	public static Result newCategory() {
		Form<Category> filledForm = categoryForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return badRequest(views.html.index.render(Team.all(), teamForm, Category.all(), categoryForm, Task.all(), taskForm));
		} else {
			Category.create(filledForm.get());
			return redirect(routes.Application.index());
		}
	}

	public static Result deleteTask(Long id) {
		return TODO;
	}
}