package controllers;

import models.Team;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Teams extends Controller {

	static Form<Team> teamForm = form(Team.class);

	public static Result index() {
		return ok(views.html.index.render(Team.all(), teamForm));
	}

	public static Result newTeam() {
		Form<Team> filledForm = teamForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return badRequest(views.html.index.render(Team.all(), teamForm));
		} else {
			Team.create(filledForm.get());
			return redirect(routes.Teams.index());
		}
	}

	public static Result deleteTask(Long id) {
		return TODO;
	}
}