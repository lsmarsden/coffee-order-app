package user.service;

import user.model.User;

public interface IUserService {

    User register(String username, String password);

    User getCurrentUser();
}
