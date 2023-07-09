package org.lsmarsden.session;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthenticationManager implements IAuthenticationManager {

    private final ISessionManager sessionManager;

    @Override
    public boolean isAuthenticated() {
        return sessionManager.getCurrentUser() != null;
    }
}
