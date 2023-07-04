package login;

import lombok.RequiredArgsConstructor;
import user.model.User;
import user.repository.IUserRepository;
import util.IPasswordHasher;
import util.PasswordHasher;

@RequiredArgsConstructor
public class LoginService implements ILoginService {

    private final IUserRepository userRepository;

    private IPasswordHasher passwordHasher = new PasswordHasher();

    @Override
    public boolean authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);
        return user != null && user.getPasswordHash().equals(passwordHasher.hashPassword(password));
    }
}
