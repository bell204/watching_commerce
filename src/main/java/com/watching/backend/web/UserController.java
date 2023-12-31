package com.watching.backend.web;

import static com.watching.backend.utils.ResponseEntityConstants.RESPONSE_NOT_FOUND;
import static com.watching.backend.utils.ResponseEntityConstants.RESPONSE_OK;

import com.watching.backend.domain.user.User;
import com.watching.backend.service.LoginService;
import com.watching.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;
    private final LoginService loginService;

    @PostMapping("/signUp")
    public void signUp(@RequestBody HashMap params) {
        userService.signUp(params);
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody HashMap params) {
        String id = params.get("id").toString();
        String password = params.get("password").toString();

        User user = userService.findUserByIdAndPassword(id, password);

        if (user != null) {
            loginService.loginUser(user.getUserId());
            return RESPONSE_OK;
        } else {
            return RESPONSE_NOT_FOUND;
        }
    }
}
