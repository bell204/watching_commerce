package com.watching.backend.service;

import com.watching.backend.domain.store.Store;
import com.watching.backend.domain.store.StoreDTO;
import com.watching.backend.domain.store.StoreRepository;
import com.watching.backend.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

    public void insertStore(StoreDTO storeDto) {

        long nextSeq = storeRepository.getNextId();
        Store store = new Store();
        store.setId(nextSeq);
        store.setName("");
        store.setPhone("");
        store.setAddress("");
        store.setOwnerId("");
        store.setOpenStatus("");
        store.setIntroduction("");
        store.setCategoryId(storeDto.getCategoryId()); // 화면단에서 지정해줘야 함.
        storeRepository.save(store);
    }

    public StoreDTO setOwnerID(StoreDTO store, String ownerId) {
        StoreDTO newStore = StoreDTO.builder()
                .name(store.getName())
                .phone(store.getPhone())
                .address(store.getAddress())
                .ownerId(ownerId)
                .introduction(store.getIntroduction())
                .categoryId(store.getCategoryId())
                .build();
        return newStore;
    }
}
