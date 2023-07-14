package org.lsmarsden.security;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthenticationFacadeTest {

    private AuthenticationFacade underTest;

    @Mock
    private SecurityContext securityContext;

    @Mock
    private Authentication authentication;

    @BeforeEach
    void setup() {
        underTest = new AuthenticationFacade();
    }

    @Test
    void getAuthentication() {

        // set up
        try (MockedStatic<SecurityContextHolder> securityContextHolderMockedStatic = Mockito.mockStatic(SecurityContextHolder.class);) {

            securityContextHolderMockedStatic.when(SecurityContextHolder::getContext).thenReturn(securityContext);
            when(securityContext.getAuthentication()).thenReturn(authentication);

            // exercise & verify
            assertThat(underTest.getAuthentication()).isSameAs(authentication);
        }
    }

    @Test
    void setAuthentication() {

        // set up
        try (MockedStatic<SecurityContextHolder> securityContextHolderMockedStatic = Mockito.mockStatic(SecurityContextHolder.class);) {

            securityContextHolderMockedStatic.when(SecurityContextHolder::getContext).thenReturn(securityContext);

            // exercise
            underTest.setAuthentication(authentication);

            // verify
            verify(securityContext).setAuthentication(authentication);
        }
    }

    @Test
    void getApiKeyAuthentication() {

        // set up
        try (MockedStatic<SecurityContextHolder> securityContextHolderMockedStatic = Mockito.mockStatic(SecurityContextHolder.class);) {

            ApiKeyAuthentication apiKeyAuthentication = new ApiKeyAuthentication("key", AuthorityUtils.NO_AUTHORITIES);
            securityContextHolderMockedStatic.when(SecurityContextHolder::getContext).thenReturn(securityContext);
            when(securityContext.getAuthentication()).thenReturn(apiKeyAuthentication);

            // exercise & verify
            assertThat(underTest.getApiKeyAuthentication()).isSameAs(apiKeyAuthentication);
        }
    }
}