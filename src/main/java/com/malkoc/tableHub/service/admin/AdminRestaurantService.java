package com.malkoc.tableHub.service.admin;

import com.malkoc.tableHub.data.entity.Restaurant;
import com.malkoc.tableHub.data.mapper.RestaurantMapper;
import com.malkoc.tableHub.data.dto.request.RestaurantSaveRequest;
import com.malkoc.tableHub.data.dto.response.RestaurantResponse;
import com.malkoc.tableHub.repository.RestaurantRepository;
import com.malkoc.tableHub.util.RestaurantValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminRestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;
    private final RestaurantValidator restaurantValidator;


    public RestaurantResponse save(RestaurantSaveRequest request) {
        restaurantValidator.existByName(request.getName());
        Restaurant restaurant = restaurantMapper.toRestaurant(request);
        restaurantRepository.save(restaurant);
        return restaurantMapper.toRestaurantResponse(restaurant);
    }
}
