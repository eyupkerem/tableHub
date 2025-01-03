package com.malkoc.tableHub.controller.owner;

import com.malkoc.tableHub.data.constants.Constants;
import com.malkoc.tableHub.data.dto.request.AddressUpdateRequest;
import com.malkoc.tableHub.data.dto.request.AddressSaveRequest;
import com.malkoc.tableHub.data.dto.response.AddressResponse;
import com.malkoc.tableHub.service.owner.RestaurantOwnerAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constants.API_PREFIX + Constants.RESTAURANT_OWNER +  "/restaurant")
@RequiredArgsConstructor
public class ROAddressController {

    private final RestaurantOwnerAddressService restaurantOwnerAddressService;

    @PostMapping("/save-address")
    public ResponseEntity<AddressResponse> saveAddress(@RequestBody AddressSaveRequest addressRequest){
        return ResponseEntity.ok(restaurantOwnerAddressService.saveAddress(addressRequest));
    }

    @PutMapping("change-address")
    public ResponseEntity<AddressResponse> changeAddress(@RequestBody AddressUpdateRequest request){
        return ResponseEntity.ok(restaurantOwnerAddressService.changeAddress(request));
    }

}
