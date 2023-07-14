package org.lsmarsden.security;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.authority.AuthorityUtils;

import static org.assertj.core.api.Assertions.assertThat;

class ApiKeyAuthenticationTest {

    private ApiKeyAuthentication underTest;

    private String apiKey = "apiKey";


    @BeforeEach
    void setup() {
        underTest = new ApiKeyAuthentication(apiKey, AuthorityUtils.NO_AUTHORITIES);

    }

    @Test
    void getCredentialsShouldReturnNull() {

        // exercise & verify
        assertThat(underTest.getCredentials()).isNull();
    }

    @Test
    void getPrincipalShouldReturnApiKey() {

        // exercise & verify
        assertThat(underTest.getPrincipal()).isEqualTo(apiKey);
    }
}