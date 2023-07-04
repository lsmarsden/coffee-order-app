package user.repository;

import user.model.User;

import java.util.Optional;

public interface IUserRepository {

    User save(User user);

    User findByUsername(String username);
}
