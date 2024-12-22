package com.malkoc.tableHub.util;

import com.malkoc.tableHub.data.constants.ErrorConstants;
import com.malkoc.tableHub.exception.ClientException;
import com.malkoc.tableHub.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RestaurantValidator {
    private final RestaurantRepository restaurantRepository;

    public void existByName(String name){
        if (restaurantRepository.findByName(name).isPresent()){
            throw new ClientException(ErrorConstants.RESTAURANT_NAME_ALREADY_EXIST);
        }
    }
}
