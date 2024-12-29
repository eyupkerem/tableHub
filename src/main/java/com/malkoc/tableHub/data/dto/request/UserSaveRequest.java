package com.malkoc.tableHub.data.dto.request;

import lombok.Data;

@Data
public class UserSaveRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Long RestaurantId;
}
