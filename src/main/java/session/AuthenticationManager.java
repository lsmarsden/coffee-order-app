package session;

public class AuthenticationManager implements IAuthenticationManager {

    private final ISessionManager sessionManager = SessionManager.getInstance();

    @Override
    public boolean isAuthenticated() {
        return sessionManager.getCurrentUser() != null;
    }
}
