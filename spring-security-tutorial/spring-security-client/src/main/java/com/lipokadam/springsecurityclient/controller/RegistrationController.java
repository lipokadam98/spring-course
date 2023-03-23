package com.lipokadam.springsecurityclient.controller;

import com.lipokadam.springsecurityclient.entity.User;
import com.lipokadam.springsecurityclient.entity.VerificationToken;
import com.lipokadam.springsecurityclient.event.RegistrationCompleteEvent;
import com.lipokadam.springsecurityclient.event.ResendTokenEvent;
import com.lipokadam.springsecurityclient.model.PasswordModel;
import com.lipokadam.springsecurityclient.model.UserModel;
import com.lipokadam.springsecurityclient.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class RegistrationController {

    private final UserService userService;

    private final ApplicationEventPublisher publisher;

    public RegistrationController(UserService userService, ApplicationEventPublisher publisher) {
        this.userService = userService;
        this.publisher = publisher;
    }

    @PostMapping("/register")
    public String register(@RequestBody UserModel userModel, final HttpServletRequest httpServletRequest) {
        var user = userService.registerUser(userModel);
        publisher.publishEvent(new RegistrationCompleteEvent(user, applicationUrl(httpServletRequest)));
        return "Success";
    }

    @GetMapping("/verifyRegistration")
    public String verifyRegistration(@RequestParam("token") String token){
       return userService.validateVerificationToken(token);
    }

    @GetMapping("/resendVerifyToken")
    public String resendVerificationToken(@RequestParam("token") String oldToken,
                                          HttpServletRequest request){
        VerificationToken verificationToken = userService.generateNewVerificationToken(oldToken);
        publisher.publishEvent(new ResendTokenEvent(verificationToken.getToken(), applicationUrl(request)));

        return "Verification link sent";

    }

    @PostMapping("/resetPassword")
    public String resetPassword(@RequestBody PasswordModel passwordModel){
        User user = userService.findUserByEmail(passwordModel.getEmail());
        String url= "";
        if(user != null){
            String token = UUID.randomUUID().toString();
            userService.createPasswordResetTokenForUser(user,token);
            //url = passwordResetTokenMail(user,applicationUrl())
        }
        return "";

    }

    @GetMapping("/")
    private String applicationUrl(HttpServletRequest httpServletRequest) {
        return "http://" +
                httpServletRequest.getServerName() +
                ":" +
                httpServletRequest.getServerPort() +
                httpServletRequest.getContextPath();
    }
}
