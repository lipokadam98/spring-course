package com.lipokadam.springsecurityclient.service;

import com.lipokadam.springsecurityclient.entity.PasswordResetToken;
import com.lipokadam.springsecurityclient.entity.User;
import com.lipokadam.springsecurityclient.entity.VerificationToken;
import com.lipokadam.springsecurityclient.model.UserModel;
import com.lipokadam.springsecurityclient.repository.PasswordResetTokenRepository;
import com.lipokadam.springsecurityclient.repository.UserRepository;
import com.lipokadam.springsecurityclient.repository.VerificationTokenRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final PasswordResetTokenRepository passwordResetTokenRepository;

    private final VerificationTokenRepository verificationTokenRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           PasswordResetTokenRepository passwordResetTokenRepository,
                           VerificationTokenRepository verificationTokenRepository){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.passwordResetTokenRepository = passwordResetTokenRepository;
        this.verificationTokenRepository = verificationTokenRepository;
    }
    @Override
    public User registerUser(UserModel userModel) {
        User user = new User();
        user.setEmail(userModel.getEmail());
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());
        user.setRole("USER");
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public void saveVerificationTokenForUser(String token, User user) {
        VerificationToken verificationToken = new VerificationToken(user,token);
        this.verificationTokenRepository.save(verificationToken);
    }

    @Override
    public String validateVerificationToken(String token) {
        VerificationToken verificationToken = verificationTokenRepository.getVerificationTokenByToken(token);

        if(verificationToken == null){
            return "Invalid";
        }

        if(verificationToken.getExpirationTime().before(new Date())){
            verificationTokenRepository.delete(verificationToken);
            userRepository.delete(verificationToken.getUser());
            return "Invalid";
        }
        userRepository.enableUserById(verificationToken.getUser().getId());
        return "Valid";
    }

    @Override
    public VerificationToken generateNewVerificationToken(String oldToken) {
        var verificationToken = verificationTokenRepository.getVerificationTokenByToken(oldToken);
        verificationToken.setToken(UUID.randomUUID().toString());
        verificationTokenRepository.save(verificationToken);
        return verificationToken;
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public void createPasswordResetTokenForUser(User user, String token) {
        PasswordResetToken passwordResetToken = new PasswordResetToken(user,token);
        passwordResetTokenRepository.save(passwordResetToken);
    }
}
