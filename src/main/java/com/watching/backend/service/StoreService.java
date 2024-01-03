package com.watching.backend.service;

import com.watching.backend.domain.category.Category;
import com.watching.backend.domain.category.CategoryRepository;
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

    private final CategoryRepository categoryRepository;

    public void insertStore(HashMap params) {

        long categoryId = categoryRepository.getNextId();

        long nextSeq = storeRepository.getNextId();
        Store store = new Store();
        store.setId(nextSeq);
        store.setName(params.get("name").toString());
        store.setPhone(params.get("phone").toString());
        store.setAddress(params.get("address").toString());
        store.setOpenStatus(params.get("openStatus").toString());
        store.setIntroduction(params.get("introduction").toString());
        store.setCategoryId(categoryId); // 화면단에서 지정해줘야 함.
        storeRepository.save(store);

        Category category = new Category();
        category.setId(categoryId);
        category.setName(params.get("categoryName").toString());
        categoryRepository.save(category);
    }
}
