package org.lsmarsden.login;

import org.lsmarsden.decorator.ui.ILoginView;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@RequiredArgsConstructor
public class LoginPresenter implements ILoginPresenter {

    private final ILoginService loginService;

    // must avoid cyclic wiring dependency by setting the view on the presenter after the
    // presenter and view have been initialised
    @Setter(onMethod_ = @Override)
    private ILoginView loginView;

    @Override
    public boolean authenticate(String username, String password) {
        return loginService.authenticate(username, password);
    }
}
