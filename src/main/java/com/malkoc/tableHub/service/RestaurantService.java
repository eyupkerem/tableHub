package com.malkoc.tableHub.service;

import com.malkoc.tableHub.data.constants.ErrorConstants;
import com.malkoc.tableHub.data.entity.Restaurant;
import com.malkoc.tableHub.data.mapper.RestaurantMapper;
import com.malkoc.tableHub.data.request.RestaurantSaveRequest;
import com.malkoc.tableHub.data.response.RestaurantResponse;
import com.malkoc.tableHub.exception.ClientException;
import com.malkoc.tableHub.repository.RestaurantRepository;
import com.malkoc.tableHub.util.RestaurantValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;
    private final RestaurantValidator restaurantValidator;

    @Transactional(readOnly = true)
    public Page<RestaurantResponse> getAllRestaurants(int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        return restaurantRepository.findAll(pageable)
                .map(restaurantMapper::toRestaurantResponse);
    }

    @Transactional(readOnly = true)
    public RestaurantResponse getRestaurant(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(
                ()-> new ClientException(ErrorConstants.RESTAURANT_NOT_FOUND)
        );
        return restaurantMapper.toRestaurantResponse(restaurant);
    }


    public RestaurantResponse save(RestaurantSaveRequest request) {
        restaurantValidator.existByName(request.getName());
        Restaurant restaurant = restaurantMapper.toRestaurant(request);
        restaurantRepository.save(restaurant);
        return restaurantMapper.toRestaurantResponse(restaurant);
    }
}
