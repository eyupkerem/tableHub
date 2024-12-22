package com.malkoc.tableHub.controller.admin;

import com.malkoc.tableHub.data.constants.Constants;
import com.malkoc.tableHub.data.dto.request.RestaurantSaveRequest;
import com.malkoc.tableHub.data.dto.response.RestaurantResponse;
import com.malkoc.tableHub.service.admin.AdminRestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constants.API_PREFIX + Constants.ADMIN +  "/restaurant")
public class AdminRestaurantController {

    private final AdminRestaurantService adminRestaurantService;

    @PostMapping
    public ResponseEntity<RestaurantResponse> save(@RequestBody RestaurantSaveRequest restaurantSaveRequest){
        return ResponseEntity.ok(adminRestaurantService.save(restaurantSaveRequest));
    }
}
