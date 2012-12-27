package controllers;

import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import org.codehaus.jackson.node.ObjectNode;

import models.Category;
import models.Interview;
import models.Team;
import models.User;
import play.data.Form;
import play.data.format.Formatters;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class Interviews extends Controller {

	static Form<Team> teamForm = form(Team.class);
	static Form<Category> categoryForm = form(Category.class);
	static Form<Interview> interviewForm = form(Interview.class);

	public static Result save() {
		Formatters.register(Category.class, new Formatters.SimpleFormatter<Category>() {

			@Override
			public Category parse(String input, Locale locale)
					throws ParseException {
				return Category.find.byId(Long.valueOf(input));
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
			Interview interview = filledForm.get();
			if(interview.id == -1) {
				interview.id = null;
				interview.save();
			} else {
				interview.update();
			}
			return redirect(routes.Application.index());
		}
	}
	
	public static Result list() {
		User localUser = Application.getLoggedinUser();

		if(localUser == null) {
			return Application.login();
		}
		
		// TODO : fetch unassigned or by localuser.id
		List<Interview> interviews = Interview.all();

		ObjectNode result = Json.newObject();
		result.put("user.name", localUser.name);
		result.put("user.id", localUser.id);
		result.put("interviews", Json.toJson(interviews));
		
		// TODO : Get list of users mapped to this team.
		List<User> availableUsers = User.all();
		result.put("available.users", Json.toJson(availableUsers));

		return ok(result);
	}

	public static Result deleteInterview(Long id) {
		return TODO;
	}
}
