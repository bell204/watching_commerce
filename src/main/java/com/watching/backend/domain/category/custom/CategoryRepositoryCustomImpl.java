package com.watching.backend.domain.category.custom;

import com.watching.backend.domain.store.custom.StoreRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class CategoryRepositoryCustomImpl implements CategoryRepositoryCustom {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public long getNextId() {
        String query = "SELECT MAX(id) FROM category";
        Long maxId = jdbcTemplate.queryForObject(query, Long.class);
        return (maxId != null) ? maxId + 1 : 1;
    }


}
