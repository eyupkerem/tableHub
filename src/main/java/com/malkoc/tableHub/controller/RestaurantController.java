package com.malkoc.tableHub.controller;

import com.malkoc.tableHub.data.constants.Constants;
import com.malkoc.tableHub.data.dto.response.RestaurantResponse;
import com.malkoc.tableHub.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constants.API_PREFIX + "/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping("/all")
    public ResponseEntity<Page<RestaurantResponse>> getAllRestaurants(@RequestParam(value = "page") int page,
                                                                      @RequestParam (value = "size") int size ){
        return ResponseEntity.ok(restaurantService.getAllRestaurants(page,size));
    }

    @GetMapping
    public ResponseEntity<RestaurantResponse> getRestaurant(@RequestParam(value = "id") Long id){
        return ResponseEntity.ok(restaurantService.getRestaurant(id));
    }
}
