package com.malkoc.tableHub.controller.admin;

import com.malkoc.tableHub.data.constants.Constants;
import com.malkoc.tableHub.data.dto.request.admin.AdminFoodSaveRequest;
import com.malkoc.tableHub.data.dto.response.admin.AdminFoodResponse;
import com.malkoc.tableHub.service.admin.AdminFoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constants.API_PREFIX + Constants.ADMIN + "/food")
public class AdminFoodController {

    private final AdminFoodService adminFoodService;

    @PostMapping
    public ResponseEntity<AdminFoodResponse> save(@RequestBody AdminFoodSaveRequest foodSaveRequest){
        return ResponseEntity.ok(adminFoodService.save(foodSaveRequest));
    }
}
