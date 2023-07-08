package session;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import user.model.User;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SessionManager implements ISessionManager {

    private static volatile SessionManager instance;

    private User currentUser;

    public static SessionManager getInstance() {
        // double-checked locking
        // is the instance null? Get the lock. Is it STILL null with the lock? Then initialise.
        if (instance == null) {
            synchronized (SessionManager.class) {
                if (instance == null) {
                    instance = new SessionManager();
                }
            }
        }
        return instance;
    }

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
