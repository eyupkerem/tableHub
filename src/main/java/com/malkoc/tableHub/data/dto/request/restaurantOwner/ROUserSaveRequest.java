package com.malkoc.tableHub.data.dto.request.restaurantOwner;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ROUserSaveRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
