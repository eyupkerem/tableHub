package com.malkoc.tableHub.data.response;

import com.malkoc.tableHub.data.entity.Address;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestaurantResponse {
    private Long id;
    private String name;
    private String phoneNumber;
    private int numberOfTable;
}
