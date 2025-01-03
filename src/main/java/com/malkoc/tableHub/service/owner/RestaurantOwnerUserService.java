package com.malkoc.tableHub.service.owner;

import com.malkoc.tableHub.data.dto.request.restaurantOwner.ROUserSaveRequest;
import com.malkoc.tableHub.data.dto.response.UserResponse;
import com.malkoc.tableHub.data.entity.User;
import com.malkoc.tableHub.data.mapper.UserMapper;
import com.malkoc.tableHub.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestaurantOwnerUserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    //TODO (KEREM MALKOC) SECURITYDEN SONRA RESTAURANT ID GIRIS YAPMIŞ KULLANICIDAN ALINICAK
    public UserResponse save(ROUserSaveRequest request) {
        User user = userMapper.toUser(request);
        userRepository.save(user);
        return userMapper.toUserResponse(user);
    }
}
