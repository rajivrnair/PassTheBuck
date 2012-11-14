package controllers;

import models.Category;
import models.Task;
import models.Team;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Teams extends Controller {

	static Form<Team> teamForm = form(Team.class);
	static Form<Category> categoryForm = form(Category.class);
	static Form<Task> taskForm = form(Task.class);
	
	public static Result newTeam() {
		Form<Team> filledForm = teamForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			System.out.println("Errors: " + filledForm.errors());
			return badRequest(views.html.index.render(Team.all(), teamForm, Category.all(), categoryForm, Task.all(), taskForm));
		} else {
			Team team = filledForm.get();
			System.out.println("newTeam(): " + team.id + "|" + team.description);
			Team.create(team);
			return redirect(routes.Application.index());
		}
	}
}
