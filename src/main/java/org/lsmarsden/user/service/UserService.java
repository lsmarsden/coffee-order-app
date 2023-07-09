package org.lsmarsden.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.lsmarsden.session.ISessionManager;
import org.lsmarsden.user.model.User;
import org.lsmarsden.user.repository.IUserRepository;

@Component
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final IUserRepository userRepository;

    private final ISessionManager sessionManager;

    @Override
    public User register(String username, String password) {

        String passwordHash = hashPassword(password);

        User user = new User();
        user.setUsername(username);
        user.setPasswordHash(passwordHash);

        return userRepository.save(user);
    }

    @Override
    public User getCurrentUser() {
        return sessionManager.getCurrentUser();
    }

    private String hashPassword(String password) {
        StringBuilder sb = new StringBuilder(password);
        return sb.reverse().toString();
    }
}
