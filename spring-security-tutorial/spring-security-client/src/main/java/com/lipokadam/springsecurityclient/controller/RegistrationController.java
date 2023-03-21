package com.lipokadam.springsecurityclient.controller;

import com.lipokadam.springsecurityclient.event.RegistrationCompleteEvent;
import com.lipokadam.springsecurityclient.model.UserModel;
import com.lipokadam.springsecurityclient.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    private String applicationUrl(HttpServletRequest httpServletRequest) {
        return "http://" +
                httpServletRequest.getServerName() +
                ":" +
                httpServletRequest.getServerPort() +
                httpServletRequest.getContextPath();
    }
}
