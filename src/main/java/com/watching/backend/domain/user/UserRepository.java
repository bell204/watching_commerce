package com.watching.backend.domain.user;

import com.watching.backend.domain.user.custom.UserRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {

  User findByUserId(String id);
}
