package controllers;

import models.Category;
import models.Task;
import models.Team;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Categories extends Controller {

	static Form<Team> teamForm = form(Team.class);
	static Form<Category> categoryForm = form(Category.class);
	static Form<Task> taskForm = form(Task.class);

	public static Result newCategory() {
		Form<Category> filledForm = categoryForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return badRequest(views.html.index.render(Team.all(), teamForm, Category.all(), categoryForm, Task.all(), taskForm));
		} else {
			Category.create(filledForm.get());
			return redirect(routes.Application.index());
		}
	}
}
