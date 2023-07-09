package org.lsmarsden.user.repository;

import org.lsmarsden.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
