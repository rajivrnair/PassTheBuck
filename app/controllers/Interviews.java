package controllers;

import java.text.ParseException;
import java.util.Locale;

import models.Category;
import models.Interview;
import models.Team;
import play.data.Form;
import play.data.format.Formatters;
import play.mvc.Controller;
import play.mvc.Result;

public class Interviews extends Controller {

	static Form<Team> teamForm = form(Team.class);
	static Form<Category> categoryForm = form(Category.class);
	static Form<Interview> interviewForm = form(Interview.class);

	public static Result newInterview() {
		Formatters.register(Category.class, new Formatters.SimpleFormatter<Category>() {

			@Override
			public Category parse(String input, Locale locale)
					throws ParseException {
				Category byId = Category.find.byId(new Long(input));
				return byId;
			}

			@Override
			public String print(Category cat, Locale locale) {
				return cat.id + ":" + cat.name;
			}
		});
		
		Form<Interview> filledForm = interviewForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return badRequest(views.html.index.render(Team.all(), teamForm, Category.all(), categoryForm, Interview.all(), filledForm, Application.getLoggedinUser()));
		} else {
			filledForm.get().save();
			return redirect(routes.Application.index());
		}
	}

	public static Result deleteInterview(Long id) {
		return TODO;
	}
}
