package login;

import lombok.RequiredArgsConstructor;
import session.ISessionManager;
import session.SessionManager;
import user.model.User;
import user.repository.IUserRepository;
import util.IPasswordHasher;
import util.PasswordHasher;

@RequiredArgsConstructor
public class LoginService implements ILoginService {

    private final IUserRepository userRepository;

    private final ISessionManager sessionManager = SessionManager.getInstance();

    private final IPasswordHasher passwordHasher = new PasswordHasher();

    @Override
    public boolean authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);

        if (user != null && user.getPasswordHash().equals(passwordHasher.hashPassword(password))) {
            sessionManager.setCurrentUser(user);
            return true;
        }
        return false;
    }
}
