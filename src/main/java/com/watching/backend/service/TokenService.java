package com.watching.backend.service;

import com.watching.backend.domain.token.TokenInfo;
import com.watching.backend.domain.token.TokenInfoRepository;
import com.watching.backend.domain.user.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class TokenService {

    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    private final TokenInfoRepository tokenInfoRepository;

    private String generateJwtToken(String userId) {
        long expirationMillis = System.currentTimeMillis() + (24 * 60 * 60 * 1000); // 1 day expiration
        Date expirationDate = new Date(expirationMillis);

        return Jwts.builder()
                .setSubject(userId)
                .setExpiration(expirationDate)
                .signWith(SECRET_KEY)
                .compact();
    }

    private String generateRefreshToken(String userId) {
        long expirationMillis = System.currentTimeMillis() + (24 * 60 * 60 * 1000); // 1 day expiration
        Date expirationDate = new Date(expirationMillis);

        return Jwts.builder()
                .setSubject(userId)
                .setExpiration(expirationDate)
                .signWith(SECRET_KEY)
                .compact();
    }

    public HashMap<String, String> getToken(User user) {
        try {

            List<TokenInfo> pastToken = tokenInfoRepository.findByUserId(user.getUserId());

            //accessToken 생성
            String accessToken = this.generateJwtToken(user.getUserId());

            //refreshToken 생성
            String refreshToken = this.generateRefreshToken(user.getUserId());

            if(pastToken != null){
                tokenInfoRepository.deleteAll(pastToken);
            }

            //새로운 토큰을 DB 에 저장한다.
            TokenInfo currentToken = new TokenInfo();
            currentToken.setUserId(user.getUserId());
            currentToken.setAccessToken(accessToken);
            currentToken.setRefreshToken(refreshToken);

            tokenInfoRepository.save(currentToken);

            HashMap<String,String> tokens = new HashMap<>();

            tokens.put("access", accessToken);
            tokens.put("refresh", refreshToken);

            return tokens;


        } catch (Exception e) {
            log.error("{}", e.getMessage());
            throw e;
        }
    }
}

