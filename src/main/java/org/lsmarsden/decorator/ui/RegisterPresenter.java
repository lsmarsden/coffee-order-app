package org.lsmarsden.decorator.ui;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.lsmarsden.user.service.UserService;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@RequiredArgsConstructor
public class RegisterPresenter implements IRegisterPresenter {

    private final UserService userService;

    public void registerUser(String username, String password) {
        userService.register(username, password);
    }
}
