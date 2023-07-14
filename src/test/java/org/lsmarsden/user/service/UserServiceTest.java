package org.lsmarsden.user.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.lsmarsden.session.ISessionManager;
import org.lsmarsden.user.model.User;
import org.lsmarsden.user.repository.IUserRepository;
import org.lsmarsden.util.IPasswordHasher;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    private UserService underTest;

    @Mock
    private IUserRepository userRepository;

    @Mock
    private ISessionManager sessionManager;

    @Mock
    private IPasswordHasher passwordHasher;

    @Captor
    private ArgumentCaptor<User> userCaptor;

    @BeforeEach
    void setup() {
        underTest = new UserService(userRepository, sessionManager, passwordHasher);
    }

    @Test
    void register() {

        // set up
        String username = "user";
        String password = "pass";
        String hashedPassword = "hashed";

        when(passwordHasher.hashPassword(password)).thenReturn(hashedPassword);

        // exercise
        underTest.register(username, password);

        // verify
        verify(userRepository).save(userCaptor.capture());

        User user = userCaptor.getValue();
        assertThat(user.getUsername()).isEqualTo("user");
        assertThat(user.getPasswordHash()).isEqualTo(hashedPassword);
    }

    @Test
    void getCurrentUser() {

        // set up
        User user = new User();

        when(sessionManager.getCurrentUser()).thenReturn(user);

        // exercise & verify
        assertThat(underTest.getCurrentUser()).isSameAs(user);
    }
}