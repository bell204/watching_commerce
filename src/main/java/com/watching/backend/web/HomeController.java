package com.watching.backend.web;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class HomeController {

    private final Environment env;

    @GetMapping("/api/profile")
    public String findProfile() {
        List<String> profiles = Arrays.asList(env.getActiveProfiles());
        List<String> devProfiles = Arrays.asList("dev");
        String defaultProfile = profiles.isEmpty() ? "default" : profiles.get(0);
        return profiles.stream().filter(devProfiles::contains).findAny().orElse(defaultProfile);
    }
}