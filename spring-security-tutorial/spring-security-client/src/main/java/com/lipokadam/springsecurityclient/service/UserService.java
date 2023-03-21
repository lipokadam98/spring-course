package com.lipokadam.springsecurityclient.service;

import com.lipokadam.springsecurityclient.entity.User;
import com.lipokadam.springsecurityclient.model.UserModel;

public interface UserService {
    User registerUser(UserModel userModel);

    void saveVerificationTokenForUser(String token, User user);
}
