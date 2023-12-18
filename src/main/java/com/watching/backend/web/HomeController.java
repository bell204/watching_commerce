package com.watching.backend.web;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {

    @GetMapping("/api/v1")
    public String findHome() {
        return "v1 test1";
    }
}
