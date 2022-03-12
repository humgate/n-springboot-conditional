package com.example.springbootconditionalapp.config;

import com.example.springbootconditionalapp.systemprofile.DevProfile;
import com.example.springbootconditionalapp.systemprofile.ProdProfile;
import com.example.springbootconditionalapp.systemprofile.SystemProfile;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
    @Bean
    @ConditionalOnProperty(name = "application.profile.dev", havingValue = "true")
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean
    @ConditionalOnProperty(name = "application.profile.dev", havingValue = "false")
    public SystemProfile prodProfile() {
        return new ProdProfile();
    }
}
