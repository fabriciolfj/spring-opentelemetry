package com.github.fabriciolfj.apiservice.service;

import com.github.fabriciolfj.apiservice.dto.AddressResponse;
import com.github.fabriciolfj.apiservice.dto.CustomerResponse;
import com.github.fabriciolfj.apiservice.service.http.address.AddressClient;
import com.github.fabriciolfj.apiservice.service.http.customer.CustomerClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final AddressClient addressClient;
    private final CustomerClient customerClient;

    public CustomerResponse findCustomer(final Long id) {
        var customer = customerClient.findCustomer(id);

        return CustomerResponse.builder()
                .name(customer.getName())
                .build();
    }

    public AddressResponse getAddress(Long id) {
        final var address = addressClient.findAddress(id);

        return AddressResponse.builder()
                .city(address.getCity())
                .number(address.getNumber())
                .street(address.getStreet())
                .build();
    }

}
