package com.malkoc.tableHub.data.dto.request.admin;

import lombok.Data;

@Data
public class AdminFoodSaveRequest {
    private String name;
    private Long price;
    private Long restaurantId;
    private String description;
}
