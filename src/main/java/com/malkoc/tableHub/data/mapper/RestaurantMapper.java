package com.malkoc.tableHub.data.mapper;

import com.malkoc.tableHub.data.entity.Restaurant;
import com.malkoc.tableHub.data.response.RestaurantResponse;
import org.springframework.stereotype.Component;

@Component
public class RestaurantMapper {

    public RestaurantResponse toRestaurantResponse(Restaurant restaurant){
        RestaurantResponse response = new RestaurantResponse();
        response.setId(restaurant.getId());
        response.setName(restaurant.getName());
        response.setPhoneNumber(restaurant.getPhoneNumber());
        response.setNumberOfTable(restaurant.getNumberOfTable());
        return response;
    }

}
