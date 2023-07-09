package org.lsmarsden.login;

public interface ILoginService {

    boolean authenticate(String username, String password);
}
