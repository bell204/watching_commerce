package com.watching.backend.domain.token;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;


/**
 *
 *  토큰발급정보
 *
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class TokenInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;

    private String accessToken;

    private String refreshToken;
}
