package com.malkoc.tableHub.data.dto.response;

import com.malkoc.tableHub.data.entity.Restaurant;
import lombok.Data;

@Data
public class FoodResponse {
    private String name;
    private Long price;
    private Restaurant restaurant;
    private String description;
}
