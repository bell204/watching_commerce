package com.watching.backend.domain.store;

import com.watching.backend.domain.store.custom.StoreRepositoryCustom;
import com.watching.backend.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {
}
