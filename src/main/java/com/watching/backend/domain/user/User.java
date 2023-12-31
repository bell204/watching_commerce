package com.watching.backend.domain.user;

import com.watching.backend.annotation.LoginCheck;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String userId;

    private String password;

    private String email;

    private String name;

    private String phone;

    private String address;

    private LoginCheck.UserLevel level;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}