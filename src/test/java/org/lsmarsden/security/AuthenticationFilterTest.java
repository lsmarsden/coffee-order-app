package org.lsmarsden.security;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

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