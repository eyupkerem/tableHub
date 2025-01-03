package com.malkoc.tableHub.data.mapper;

import com.malkoc.tableHub.data.constants.ErrorConstants;
import com.malkoc.tableHub.data.dto.request.UserSaveRequest;
import com.malkoc.tableHub.data.dto.request.restaurantOwner.ROUserSaveRequest;
import com.malkoc.tableHub.data.dto.response.UserResponse;
import com.malkoc.tableHub.data.entity.Restaurant;
import com.malkoc.tableHub.data.entity.User;
import com.malkoc.tableHub.exception.ClientException;
import com.malkoc.tableHub.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final RestaurantRepository restaurantRepository;

    public User toUser(UserSaveRequest userSaveRequest) {
        User user = new User();
        user.setFirstName(userSaveRequest.getFirstName());
        user.setLastName(userSaveRequest.getLastName());
        user.setEmail(userSaveRequest.getEmail());
        user.setPassword(userSaveRequest.getPassword());
        if (userSaveRequest.getRestaurantId() != null) {
            Restaurant restaurant = restaurantRepository.findById(userSaveRequest.getRestaurantId())
                    .orElseThrow(() -> new ClientException(ErrorConstants.RESTAURANT_NOT_FOUND));
            user.setRestaurant(restaurant);
        } else {
            user.setRestaurant(null);
        }
        return user;
    }

    public UserResponse toUserResponse(User user) {

        UserResponse userResponse = new UserResponse();
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setEmail(user.getEmail());
        if (user.getRestaurant() != null) {
            userResponse.setRestaurantName(user.getRestaurant().getName());
        } else {
            userResponse.setRestaurantName(null);
        }
        return userResponse;
    }


    public User toUser(ROUserSaveRequest ROUserSaveRequest) {
        User user = new User();
        user.setFirstName(ROUserSaveRequest.getFirstName());
        user.setLastName(ROUserSaveRequest.getLastName());
        user.setEmail(ROUserSaveRequest.getEmail());
        user.setPassword(ROUserSaveRequest.getPassword());
        user.setRestaurant(null); // Restaurant bilgisi olmadığı için null olarak ayarlanıyor
        return user;
    }

}
