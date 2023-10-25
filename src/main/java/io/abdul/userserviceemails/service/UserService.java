package io.abdul.userserviceemails.service;

import io.abdul.userserviceemails.domain.User;

public interface UserService {
    User saveUser(User user);
    Boolean verifyToken(String token);
}
