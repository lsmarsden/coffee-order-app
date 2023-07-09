package org.lsmarsden.util;

import org.springframework.stereotype.Component;

@Component
public class PasswordHasher implements IPasswordHasher {
    @Override
    public String hashPassword(String password) {
        StringBuilder sb = new StringBuilder(password);
        return sb.reverse().toString();
    }
}
