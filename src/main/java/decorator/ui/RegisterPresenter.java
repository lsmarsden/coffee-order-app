package decorator.ui;

import lombok.RequiredArgsConstructor;
import user.service.UserService;

@RequiredArgsConstructor
public class RegisterPresenter {

    private final UserService userService;

    public void registerUser(String username, String password) {
        userService.register(username, password);
    }
}
