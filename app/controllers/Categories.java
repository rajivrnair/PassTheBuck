package controllers;

import models.Category;
import models.Interview;
import models.Team;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Categories extends Controller {

	static Form<Team> teamForm = form(Team.class);
	static Form<Category> categoryForm = form(Category.class);
	static Form<Interview> interviewForm = form(Interview.class);

	public static Result newCategory() {
		Form<Category> filledForm = categoryForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return badRequest(views.html.index.render(Team.all(), teamForm, Category.all(), categoryForm, Interview.all(), interviewForm, Application.getLoggedinUser()));
		} else {
			filledForm.get().save();
			return redirect(routes.Application.index());
		}
	}
}
