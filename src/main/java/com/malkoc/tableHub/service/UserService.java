package com.malkoc.tableHub.service;

import com.malkoc.tableHub.data.dto.request.UserSaveRequest;
import com.malkoc.tableHub.data.dto.response.UserResponse;
import com.malkoc.tableHub.data.entity.User;
import com.malkoc.tableHub.data.mapper.UserMapper;
import com.malkoc.tableHub.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserResponse save(UserSaveRequest userSaveRequest) {
        User user = userMapper.toUser(userSaveRequest);
        userRepository.save(user);
        return userMapper.toUserResponse(user);
    }
}
