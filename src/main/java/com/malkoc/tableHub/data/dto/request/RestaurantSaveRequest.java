package com.malkoc.tableHub.data.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantSaveRequest {
    private String name;
    private String phoneNumber;
    private int numberOfTable;
}
