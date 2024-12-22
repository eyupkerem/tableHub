package com.malkoc.tableHub.service.owner;

import com.malkoc.tableHub.data.constants.ErrorConstants;
import com.malkoc.tableHub.data.dto.request.AddressUpdateRequest;
import com.malkoc.tableHub.data.dto.request.AddressSaveRequest;
import com.malkoc.tableHub.data.dto.response.AddressResponse;
import com.malkoc.tableHub.data.entity.Address;
import com.malkoc.tableHub.data.mapper.AddressMapper;
import com.malkoc.tableHub.exception.ClientException;
import com.malkoc.tableHub.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestaurantOwnerAddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    public AddressResponse saveAddress(AddressSaveRequest addressRequest) {
        Address address = addressMapper.toAddress(addressRequest);
        addressRepository.save(address);
        return addressMapper.toAddressResponse(address);
    }

    public AddressResponse changeAddress(AddressUpdateRequest request) {
        Address address = addressRepository.findById(request.getAddressId()).orElseThrow(
                () -> new ClientException(ErrorConstants.ADDRESS_NOT_FOUND)
        );
        Address changedAddress = addressRepository.save(addressMapper.toChangedAddress(request,address));
        return addressMapper.toAddressResponse(changedAddress);
    }
}
