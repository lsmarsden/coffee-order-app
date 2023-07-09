package org.lsmarsden.session;

import org.lsmarsden.user.model.User;

public interface ISessionManager {

    User getCurrentUser();

    void setCurrentUser(User user);

    void clearSession();
}
