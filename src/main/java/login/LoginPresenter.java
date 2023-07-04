package login;

import decorator.ui.LoginView;

public class LoginPresenter implements ILoginPresenter {

    private final LoginView loginView;
    private final ILoginService loginService;

    public LoginPresenter(LoginView loginView, ILoginService loginService) {
        this.loginView = loginView;
        this.loginView.setLoginPresenter(this);
        this.loginService = loginService;
    }

    @Override
    public boolean authenticate(String username, String password) {
        return loginService.authenticate(username, password);
    }
}
