import play.Application;
import play.GlobalSettings;
import play.mvc.Call;

import com.feth.play.module.pa.PlayAuthenticate;
import com.feth.play.module.pa.PlayAuthenticate.Resolver;
import com.feth.play.module.pa.exceptions.AccessDeniedException;
import com.feth.play.module.pa.exceptions.AuthException;

import controllers.routes;

/**
 * Defining a Global object in your project allows you to handle global settings
 * for your application. This object must be defined in the root package.
 */

public class Global extends GlobalSettings {

	public void onStart(final Application app) {
		PlayAuthenticate.setResolver(new Resolver() {

			@Override
			public Call login() {
				return routes.Application.login();
			}

			@Override
			public Call afterAuth() {
				// The user will be redirected to this page after authentication
				// if no original URL was saved
				return routes.Application.index();
			}

			@Override
			public Call afterLogout() {
				return routes.Application.login();
			}

			@Override
			public Call auth(final String provider) {
				return com.feth.play.module.pa.controllers.routes.Authenticate
						.authenticate(provider);
			}

			@Override
			public Call onException(final AuthException e) {
				if (e instanceof AccessDeniedException) {
					return routes.Application
							.oAuthDenied(((AccessDeniedException) e)
									.getProviderKey());
				}

				// more custom problem handling here...

				return super.onException(e);
			}

			@Override
			public Call askLink() {
				return null;
			}

			@Override
			public Call askMerge() {
				return null;
			}
		});
	}
}
