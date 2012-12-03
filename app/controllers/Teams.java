package controllers;

import models.Category;
import models.Interview;
import models.Team;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Teams extends Controller {

	static Form<Team> teamForm = form(Team.class);
	static Form<Category> categoryForm = form(Category.class);
	static Form<Interview> interviewForm = form(Interview.class);
	
	public static Result newTeam() {
		Form<Team> filledForm = teamForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			System.out.println("Errors: " + filledForm.errors());
			return badRequest(views.html.index.render(Team.all(), teamForm, Category.all(), categoryForm, Interview.all(), interviewForm, Application.getLoggedinUser()));
		} else {
			filledForm.get().save();
			return redirect(routes.Application.index());
		}
	}
}
