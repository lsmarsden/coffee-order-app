package org.lsmarsden.security;

import lombok.RequiredArgsConstructor;
import org.lsmarsden.user.model.User;
import org.lsmarsden.user.repository.IUserRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ApiKeyService implements IAPIKeyService {

    private final IAPIKeyRepository apiKeyRepository;

    @Override
    public User getUserByApiKey(String apiKey) {
        return apiKeyRepository.findUserByApiKeyValue(apiKey);
    }
}
