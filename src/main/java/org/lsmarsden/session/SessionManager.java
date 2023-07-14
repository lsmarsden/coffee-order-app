package org.lsmarsden.session;

import org.lsmarsden.user.model.User;
import org.springframework.stereotype.Component;

@Component
public final class SessionManager implements ISessionManager {

    private User currentUser;

    @Override
    public User getCurrentUser() {
        return currentUser;
    }

    @Override
    public void setCurrentUser(User user) {
        this.currentUser = user;
    }

    @Override
    public void clearSession() {
        currentUser = null;
    }
}
