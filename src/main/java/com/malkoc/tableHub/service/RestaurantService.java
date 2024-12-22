package com.malkoc.tableHub.service;

import com.malkoc.tableHub.data.constants.ErrorConstants;
import com.malkoc.tableHub.data.dto.response.RestaurantResponse;
import com.malkoc.tableHub.data.entity.Restaurant;
import com.malkoc.tableHub.data.mapper.RestaurantMapper;
import com.malkoc.tableHub.exception.ClientException;
import com.malkoc.tableHub.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;

    @Transactional(readOnly = true)
    public Page<RestaurantResponse> getAllRestaurants(int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        return restaurantRepository.findAll(pageable)
                .map(restaurantMapper::toRestaurantResponse);
    }

    public RestaurantResponse getRestaurant(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(
                () -> new ClientException(ErrorConstants.RESTAURANT_NOT_FOUND, HttpStatus.NOT_FOUND)
        );
        return restaurantMapper.toRestaurantResponse(restaurant);
    }
}
