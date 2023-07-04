package user.service;

import lombok.RequiredArgsConstructor;
import user.model.User;
import user.repository.IUserRepository;

@RequiredArgsConstructor
public class UserService implements IUserService {

    private final IUserRepository userRepository;

    @Override
    public User register(String username, String password) {

        String passwordHash = hashPassword(password);

        User user = new User();
        user.setUsername(username);
        user.setPasswordHash(passwordHash);

        return userRepository.save(user);
    }

    private String hashPassword(String password) {
        StringBuilder sb = new StringBuilder(password);
        return sb.reverse().toString();
    }
}