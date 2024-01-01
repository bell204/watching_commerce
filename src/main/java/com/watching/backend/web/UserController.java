package com.watching.backend.web;

import com.watching.backend.domain.user.User;
import com.watching.backend.service.TokenService;
import com.watching.backend.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    private final TokenService tokenService;

    @PostMapping("/signUp")
    public void signUp(@RequestBody HashMap params) {
        userService.signUp(params);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody HashMap params) {
        String id = params.get("id").toString();
        String password = params.get("password").toString();

        //토큰을 만들기전에 사용자의 타입에 따라서 선행 처리한다
        User user = userService.findUserByIdAndPassword(id, password);

        if (user != null) {

            HashMap<String,String> tokens = tokenService.getToken(user);
            //토큰 서비스 호출
            HashMap<String, Object> response = new HashMap<>();
            response.put("access", tokens.get("access"));
            response.put("refresh", tokens.get("refresh"));
            response.put("user", user);

            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
