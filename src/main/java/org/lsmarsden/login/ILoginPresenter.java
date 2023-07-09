package org.lsmarsden.login;

import org.lsmarsden.decorator.ui.ILoginView;

public interface ILoginPresenter {

    boolean authenticate(String username, String password);

    void setLoginView(ILoginView loginView);
}
