package com.malkoc.tableHub.controller;

import com.malkoc.tableHub.data.constants.Constants;
import com.malkoc.tableHub.data.dto.request.UserSaveRequest;
import com.malkoc.tableHub.data.dto.response.UserResponse;
import com.malkoc.tableHub.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constants.API_PREFIX + "/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/save")
    public ResponseEntity<UserResponse> save(@RequestBody UserSaveRequest userSaveRequest) {
        return ResponseEntity.ok(userService.save(userSaveRequest));
    }

}
