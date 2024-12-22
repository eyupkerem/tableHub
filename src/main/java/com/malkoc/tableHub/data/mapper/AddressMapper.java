package com.malkoc.tableHub.data.mapper;

import com.malkoc.tableHub.data.dto.request.AddressSaveRequest;
import com.malkoc.tableHub.data.dto.request.AddressUpdateRequest;
import com.malkoc.tableHub.data.dto.response.AddressResponse;
import com.malkoc.tableHub.data.entity.Address;
import com.malkoc.tableHub.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddressMapper {

    private final RestaurantRepository restaurantRepository;

    public Address toAddress(AddressSaveRequest addressSaveRequest){
        Address address = new Address();
        address.setNumber(addressSaveRequest.getNumber());
        address.setStreet(addressSaveRequest.getStreet());
        address.setAvenue(addressSaveRequest.getAvenue());
        address.setCity(addressSaveRequest.getCity());
        address.setCountry(addressSaveRequest.getCountry());
        address.setDescription(addressSaveRequest.getDescription());
//        address.setRestaurant(restaurantRepository.findById(addressSaveRequest.getRestaurantId())
//                .orElseThrow(
//                        () -> new ClientException(ErrorConstants.RESTAURANT_NOT_FOUND)
//                ));
        return address;
    }

    public AddressResponse toAddressResponse(Address address){
        AddressResponse addressResponse = new AddressResponse();
        addressResponse.setNumber(address.getNumber());
        addressResponse.setStreet(address.getStreet());
        addressResponse.setAvenue(address.getAvenue());
        addressResponse.setCity(address.getCity());
        addressResponse.setCountry(address.getCountry());
        addressResponse.setDescription(address.getDescription());

        return addressResponse;
    }

    public Address toChangedAddress(AddressUpdateRequest request, Address address) {
        address.setNumber(request.getNumber());
        address.setStreet(request.getStreet());
        address.setAvenue(request.getAvenue());
        address.setCity(request.getCity());
        address.setCountry(request.getCountry());
        address.setDescription(request.getDescription());
        return address;
    }
}
