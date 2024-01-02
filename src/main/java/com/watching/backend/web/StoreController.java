package com.watching.backend.web;

import com.watching.backend.annotation.CurrentUserId;
import com.watching.backend.annotation.LoginCheck;
import com.watching.backend.domain.store.StoreDTO;
import com.watching.backend.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

import static com.watching.backend.utils.ResponseEntityConstants.RESPONSE_OK;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/stores")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @PostMapping("/insertStore")
    @LoginCheck(userLevel = LoginCheck.UserLevel.OWNER)
    public ResponseEntity<Void> insertStore(@RequestBody HashMap params) {
        storeService.insertStore(params);

        return RESPONSE_OK;

    }

}
