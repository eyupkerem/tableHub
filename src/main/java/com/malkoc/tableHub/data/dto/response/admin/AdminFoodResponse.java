package com.malkoc.tableHub.data.dto.response.admin;

import lombok.Data;

@Data
public class AdminFoodResponse {
    private String name;
    private Long price;
    private String restaurantName;
    private String description;
}
