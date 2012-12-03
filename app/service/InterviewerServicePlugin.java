package service;

import models.User;
import play.Application;

import com.feth.play.module.pa.service.UserServicePlugin;
import com.feth.play.module.pa.user.AuthUser;
import com.feth.play.module.pa.user.AuthUserIdentity;

public class InterviewerServicePlugin extends UserServicePlugin {

	public InterviewerServicePlugin(Application app) {
		super(app);
	}

	@Override
	public Object getLocalIdentity(AuthUserIdentity identity) {
		// For production: Caching might be a good idea here...
		// ...and dont forget to sync the cache when users get
		// deactivated/deleted
		final User u = User.findByAuthUserIdentity(identity);
		if (u != null) {
			return u.id;
		} else {
			return null;
		}
	}

	@Override
	public AuthUser link(AuthUser arg0, AuthUser arg1) {
		// linking accounts are not supported
		return null;
	}

	@Override
	public AuthUser merge(AuthUser arg0, AuthUser arg1) {
		// merging accounts are not supported
		return null;
	}

	@Override
	public Object save(AuthUser authUser) {
		return User.create(authUser).id;
	}
}
