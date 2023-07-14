package org.lsmarsden.security;

import org.springframework.security.core.Authentication;

public interface IAuthenticationFacade {
    Authentication getAuthentication();

    void setAuthentication(Authentication authentication);

    ApiKeyAuthentication getApiKeyAuthentication();
}
