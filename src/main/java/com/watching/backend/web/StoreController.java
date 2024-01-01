package com.watching.backend.web;

import com.watching.backend.annotation.CurrentUserId;
import com.watching.backend.annotation.LoginCheck;
import com.watching.backend.domain.store.StoreDTO;
import com.watching.backend.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.watching.backend.utils.ResponseEntityConstants.RESPONSE_OK;

@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @PostMapping
    @LoginCheck(userLevel = LoginCheck.UserLevel.OWNER)
    public ResponseEntity<Void> insertStore(StoreDTO store, @CurrentUserId String ownerId) {

        StoreDTO newStore = storeService.setOwnerID(store, ownerId);
        storeService.insertStore(newStore);

        return RESPONSE_OK;

    }

}
