package com.watching.backend.domain.token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TokenInfoRepository extends JpaRepository<TokenInfo, Long> {

//    @Query("SELECT t FROM TokenInfo t WHERE user_id = :userId")
//    List<TokenInfo> findByUserId(@Param("userId") String userId);

    List<TokenInfo> findByUserId(String userId);
}
