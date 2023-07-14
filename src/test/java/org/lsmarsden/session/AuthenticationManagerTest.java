package org.lsmarsden.session;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.lsmarsden.user.model.User;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthenticationManagerTest {

    private AuthenticationManager underTest;

    @Mock
    private ISessionManager sessionManager;

    @BeforeEach
    void setup() {
        underTest = new AuthenticationManager(sessionManager);
    }

    @Test
    void isAuthenticatedShouldReturnTrueIfUserNotNull() {

        // set up
        User user = new User();
        when(sessionManager.getCurrentUser()).thenReturn(user);


        // exercise & verify
        assertThat(underTest.isAuthenticated()).isTrue();
    }

    @Test
    void isAuthenticatedShouldReturnFalseIfUserIsNull() {

        // set up
        when(sessionManager.getCurrentUser()).thenReturn(null);

        // exercise & verify
        assertThat(underTest.isAuthenticated()).isFalse();
    }
}