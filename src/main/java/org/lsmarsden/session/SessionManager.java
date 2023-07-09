package org.lsmarsden.session;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.lsmarsden.user.model.User;

@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
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
