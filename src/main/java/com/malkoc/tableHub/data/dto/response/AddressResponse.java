package com.malkoc.tableHub.data.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressResponse {
    private String number;
    private String street;
    private String avenue;
    private String city;
    private String country;
    private String description;
}
