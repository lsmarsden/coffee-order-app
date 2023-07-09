package org.lsmarsden.user.service;

import org.lsmarsden.user.model.User;

public interface IUserService {

    User register(String username, String password);

    User getCurrentUser();
}
