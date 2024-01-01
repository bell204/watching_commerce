package com.watching.backend.domain.store.custom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class StoreRepositoryCustomImpl implements StoreRepositoryCustom {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public long getNextId() {
        String query = "SELECT MAX(id) FROM store";
        Long maxId = jdbcTemplate.queryForObject(query, Long.class);
        return (maxId != null) ? maxId + 1 : 1;
    }


}
