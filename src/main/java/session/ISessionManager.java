package session;

import user.model.User;

public interface ISessionManager {

    User getCurrentUser();

    void setCurrentUser(User user);

    void clearSession();
}
