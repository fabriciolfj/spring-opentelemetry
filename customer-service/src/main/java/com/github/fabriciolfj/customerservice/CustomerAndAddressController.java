package com.github.fabriciolfj.customerservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerAndAddressController {

    @GetMapping("/customer/{id}")
    public Customer find(@PathVariable("id") final Long id) {
        return Customer.builder()
                .name("teste " + id)
                .build();
    }

    @GetMapping("/address/{id}")
    public Address findAddress(@PathVariable("id") final Long id) {
        return Address.builder()
                .city("Serrana")
                .number("112 " + id)
                .street("Rua test")
                .build();
    }
}
