package controllers;

import java.text.ParseException;
import java.util.Locale;

import models.Category;
import models.Task;
import models.Team;
import play.Routes;
import play.data.Form;
import play.data.format.Formatters;
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
	
	public static Result newTask() {
		
		Formatters.register(Category.class, new Formatters.SimpleFormatter<Category>() {

			@Override
			public Category parse(String input, Locale locale)
					throws ParseException {
				Category byId = Category.find.byId(new Long(input));
				System.out.println(print(byId, Locale.getDefault()));
				return byId;
			}

			@Override
			public String print(Category cat, Locale locale) {
				return cat.id + ":" + cat.name;
			}
		});
		
		Form<Task> filledForm = taskForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return badRequest(views.html.index.render(Team.all(), teamForm, Category.all(), categoryForm, Task.all(), taskForm));
		} else {
			Task task = filledForm.get();
			System.out.println("Application.newTask() for " + task.category.name);
			Task.create(task);
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
	
	public static Result javascriptRoutes() {
		response().setContentType("text/javascript");
		return ok(Routes.javascriptRouter("jsRoutes", 
				routes.javascript.Application.newCategory(), // Don't set any params in the brackets, even if the original actions are parameterized.
				routes.javascript.Application.newTask(),
				routes.javascript.Application.newTeam()));
	}
}