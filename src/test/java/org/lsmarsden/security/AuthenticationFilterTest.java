package org.lsmarsden.security;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AuthenticationFilterTest {

    private AuthenticationFilter underTest;

    @Mock
    private IAuthenticationFacade authenticationFacade;

    @BeforeEach
    void setup() {
        underTest = new AuthenticationFilter(authenticationFacade);
    }

    @Test
    void doFilter() {

        // set up
//        when(authenticationFacade.)


        // exercise

        // verify
    }
}