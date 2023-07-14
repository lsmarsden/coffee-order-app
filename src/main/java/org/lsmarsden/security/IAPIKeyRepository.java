package org.lsmarsden.security;

import org.lsmarsden.user.model.APIKey;
import org.lsmarsden.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IAPIKeyRepository extends JpaRepository<APIKey, Long> {

    @Query("SELECT a.user from APIKey a WHERE a.keyValue = :apiKeyValue")
    User findUserByApiKeyValue(@Param("apiKeyValue") String apiKeyValue);
}
