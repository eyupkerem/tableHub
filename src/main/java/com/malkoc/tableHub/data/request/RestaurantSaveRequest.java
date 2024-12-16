package com.malkoc.tableHub.data.request;

import com.malkoc.tableHub.data.entity.Address;
import com.malkoc.tableHub.data.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantSaveRequest {

    private String name;
    private String phoneNumber;
    private int numberOfTable;
    private Address address;
    private List<User> employees;

}
