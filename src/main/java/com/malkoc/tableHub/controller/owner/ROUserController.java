package com.malkoc.tableHub.controller.owner;

import com.malkoc.tableHub.data.constants.Constants;
import com.malkoc.tableHub.data.dto.request.restaurantOwner.ROUserSaveRequest;
import com.malkoc.tableHub.data.dto.response.UserResponse;
import com.malkoc.tableHub.service.owner.RestaurantOwnerUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constants.API_PREFIX + Constants.RESTAURANT_OWNER + "/user")
public class ROUserController {

    private final RestaurantOwnerUserService restaurantOwnerUserService;

    @PostMapping("/new-user")
    public ResponseEntity<UserResponse> saveUser(@RequestBody ROUserSaveRequest userSaveRequest){
        return ResponseEntity.ok(restaurantOwnerUserService.save(userSaveRequest));
    }

}
