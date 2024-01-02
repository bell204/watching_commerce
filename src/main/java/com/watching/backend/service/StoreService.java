package com.watching.backend.service;

import com.watching.backend.domain.store.Store;
import com.watching.backend.domain.store.StoreDTO;
import com.watching.backend.domain.store.StoreRepository;
import com.watching.backend.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

    public void insertStore(HashMap params) {

        long nextSeq = storeRepository.getNextId();
        Store store = new Store();
        store.setId(nextSeq);
        store.setName(params.get("name").toString());
        store.setPhone(params.get("phone").toString());
        store.setAddress(params.get("address").toString());
        store.setOpenStatus(params.get("openStatus").toString());
        store.setIntroduction(params.get("introduction").toString());
        store.setCategoryId(params.get("categoryId").toString()); // 화면단에서 지정해줘야 함.
        storeRepository.save(store);
    }
}
