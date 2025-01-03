package com.malkoc.tableHub.service.admin;

import com.malkoc.tableHub.data.dto.request.admin.AdminFoodSaveRequest;
import com.malkoc.tableHub.data.dto.response.admin.AdminFoodResponse;
import com.malkoc.tableHub.data.entity.Food;
import com.malkoc.tableHub.data.mapper.FoodMapper;
import com.malkoc.tableHub.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminFoodService {

    private final FoodRepository foodRepository;
    private final FoodMapper foodMapper;

    public AdminFoodResponse save(AdminFoodSaveRequest adminFoodSaveRequest) {
        Food food = foodMapper.toFood(adminFoodSaveRequest);
        foodRepository.save(food);
        return foodMapper.toAdminFoodResponse(food);
    }

}
