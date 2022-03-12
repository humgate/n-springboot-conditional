package com.example.springbootconditionalapp.controller;

import com.example.springbootconditionalapp.systemprofile.SystemProfile;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@ConfigurationProperties("application.profile")
@Data
public class Controller {
    private boolean dev;
    private final SystemProfile profile;

    public Controller(SystemProfile profile) {
        this.profile = profile;
    }

    @GetMapping("devproperty")
    public String getAppProfileType() {
        return "application.profile.dev=" + dev;
    }

    @GetMapping("profile")
    public String getProfile() {
        return profile.getProfile();
    }
}

