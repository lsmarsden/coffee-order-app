package org.lsmarsden.security;

import org.lsmarsden.user.model.User;

public interface IAPIKeyService {

    User getUserByApiKey(String apiKey);
}
