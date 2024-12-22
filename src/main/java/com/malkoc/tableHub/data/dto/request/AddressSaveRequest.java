package com.malkoc.tableHub.data.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressSaveRequest {
    private Long restaurantId;
    private String number;
    private String street;
    private String avenue;
    private String city;
    private String country;
    private String description;

}
