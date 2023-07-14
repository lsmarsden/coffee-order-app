package org.lsmarsden.user.service;

import lombok.RequiredArgsConstructor;
import org.lsmarsden.session.ISessionManager;
import org.lsmarsden.user.model.User;
import org.lsmarsden.user.repository.IUserRepository;
import org.lsmarsden.util.IPasswordHasher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final IUserRepository userRepository;

    private final ISessionManager sessionManager;

    private final IPasswordHasher passwordHasher;

    @Override
    public User register(String username, String password) {

        User user = new User();
        user.setUsername(username);
        user.setPasswordHash(passwordHasher.hashPassword(password));

        return userRepository.save(user);
    }

    @Override
    public User getCurrentUser() {
        return sessionManager.getCurrentUser();
    }
}
