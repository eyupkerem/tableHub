package com.malkoc.tableHub.data.mapper;

import com.malkoc.tableHub.data.constants.ErrorConstants;
import com.malkoc.tableHub.data.dto.request.admin.AdminFoodSaveRequest;
import com.malkoc.tableHub.data.dto.response.admin.AdminFoodResponse;
import com.malkoc.tableHub.data.entity.Food;
import com.malkoc.tableHub.data.entity.Restaurant;
import com.malkoc.tableHub.exception.ClientException;
import com.malkoc.tableHub.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FoodMapper {

     private final RestaurantRepository restaurantRepository;

    public Food toFood(AdminFoodSaveRequest adminFoodSaveRequest) {
        Food food = new Food();
        food.setName(adminFoodSaveRequest.getName());
        food.setPrice(adminFoodSaveRequest.getPrice());
        food.setDescription(adminFoodSaveRequest.getDescription());
        food.setAvailable(true);
            if (adminFoodSaveRequest.getRestaurantId() != null) {
                Restaurant restaurant = restaurantRepository.findById(adminFoodSaveRequest.getRestaurantId())
                        .orElseThrow(() -> new ClientException(ErrorConstants.RESTAURANT_NOT_FOUND));
                food.setRestaurant(restaurant);
            } else {
                food.setRestaurant(null);
            }
            return food;
    }

    public AdminFoodResponse toAdminFoodResponse(Food food) {
        AdminFoodResponse response = new AdminFoodResponse();
        response.setName(food.getName());
        response.setPrice(food.getPrice());
        response.setDescription(food.getDescription());
        response.setRestaurantName(
                food.getRestaurant() != null ? food.getRestaurant().getName() : "No Restaurant"
        );
        return response;
    }
}
