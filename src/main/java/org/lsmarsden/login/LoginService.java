package org.lsmarsden.login;

import lombok.RequiredArgsConstructor;
import org.lsmarsden.session.ISessionManager;
import org.lsmarsden.user.model.User;
import org.lsmarsden.user.repository.IUserRepository;
import org.lsmarsden.util.IPasswordHasher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService implements ILoginService {

    private final IUserRepository userRepository;

    private final ISessionManager sessionManager;

    private final IPasswordHasher passwordHasher;

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
