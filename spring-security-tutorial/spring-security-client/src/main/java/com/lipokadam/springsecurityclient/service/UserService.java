package com.lipokadam.springsecurityclient.service;

import com.lipokadam.springsecurityclient.entity.User;
import com.lipokadam.springsecurityclient.entity.VerificationToken;
import com.lipokadam.springsecurityclient.model.UserModel;

public interface UserService {
    User registerUser(UserModel userModel);

    void saveVerificationTokenForUser(String token, User user);

    String validateVerificationToken(String token);

    VerificationToken generateNewVerificationToken(String oldToken);

    User findUserByEmail(String email);

    void createPasswordResetTokenForUser(User user, String token);
}
