package org.lsmarsden.security;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.lsmarsden.user.model.User;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ApiKeyServiceTest {

    private ApiKeyService underTest;

    @Mock
    private IAPIKeyRepository apiKeyRepository;


    @BeforeEach
    void setup() {
        underTest = new ApiKeyService(apiKeyRepository);
    }

    @Test
    void getUserByApiKey() {

        // set up
        String apiKey = "apiKey";
        User user = new User();
        when(apiKeyRepository.findUserByApiKeyValue(apiKey)).thenReturn(user);

        // exercise
        User result = underTest.getUserByApiKey(apiKey);

        // verify
        assertThat(result).isSameAs(user);
    }
}