package org.lsmarsden.security;

import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.BadCredentialsException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthenticationServiceTest {

    private AuthenticationService underTest;

    @Mock
    private HttpServletRequest request;

    @Test
    void getAuthentication() {

        // set up
        String apiKey = "Lewis";
        when(request.getHeader("X-API-KEY")).thenReturn(apiKey);

        // exercise
        ApiKeyAuthentication authentication = underTest.getAuthentication(request);

        // verify
        assertThat(authentication.getAuthorities()).isEmpty();
        assertThat(authentication.getPrincipal()).isEqualTo(apiKey);
    }

    @ParameterizedTest
    @ValueSource(strings = {"invalid"})
    @NullAndEmptySource
    void getAuthenticationShouldThrowIfApiKeyDoesNotMatch(String invalidApiKey) {

        // set up
        when(request.getHeader("X-API-KEY")).thenReturn(invalidApiKey);

        // exercise & verify
        assertThatExceptionOfType(BadCredentialsException.class)
                .isThrownBy(() -> underTest.getAuthentication(request))
                .withMessage("Invalid API Key");
    }
}