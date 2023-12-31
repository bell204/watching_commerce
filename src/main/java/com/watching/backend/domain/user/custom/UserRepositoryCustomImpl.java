package com.watching.backend.domain.user.custom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public long getNextId() {
        String query = "SELECT MAX(id) FROM user";
        Long maxId = jdbcTemplate.queryForObject(query, Long.class);
        return (maxId != null) ? maxId + 1 : 1;
    }


}
