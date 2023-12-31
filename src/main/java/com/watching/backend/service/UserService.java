package com.watching.backend.service;

import com.watching.backend.domain.user.User;
import com.watching.backend.domain.user.UserRepository;
import com.watching.backend.utils.PasswordEncrypter;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;


@Data
@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public void signUp(HashMap params) {
        String encryptedPassword = PasswordEncrypter.encrypt(params.get("password").toString());
        long nextSeq = userRepository.getNextId();

        User user = new User();
        user.setId(nextSeq);
        user.setUserId(params.get("id").toString());
        user.setPassword(encryptedPassword);
        user.setEmail("");
        user.setName("");
        user.setPhone("");
        user.setAddress("");
        user.setLevel(null);
        userRepository.save(user);
    }

    public User findUserByIdAndPassword(String id, String password) {
        User user =  userRepository.findByUserId(id);
        boolean isSamePassword = false;

        if (null != user) {
            isSamePassword = PasswordEncrypter.isMatch(password, user.getPassword());
        }

        if(!isSamePassword){
            log.info("{} : 패스워드 불일치", isSamePassword);
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }
        return user;
    }

}

