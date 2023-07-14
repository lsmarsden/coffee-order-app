package org.lsmarsden.session;

import org.junit.jupiter.api.Test;
import org.lsmarsden.user.model.User;

import static org.assertj.core.api.Assertions.assertThat;

class SessionManagerTest {

    private SessionManager underTest = new SessionManager();

    private User user = new User();

    @Test
    void clearSession() {

        // set up
        underTest.setCurrentUser(user);

        // exercise
        underTest.clearSession();

        // verify
        assertThat(underTest.getCurrentUser()).isNull();
    }

    @Test
    void getCurrentUser() {

        // set up
        underTest.setCurrentUser(user);

        // exercise & verify
        assertThat(underTest.getCurrentUser()).isSameAs(user);
    }
}