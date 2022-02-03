package com.github.fabriciolfj.apiservice.controller;

import com.github.fabriciolfj.apiservice.dto.CustomerResponse;
import com.github.fabriciolfj.apiservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public CustomerResponse find(@PathVariable("id") final Long id) {
        var customer = service.findCustomer(id);
        var address = service.getAddress(id);

        customer.setAddress(address);
        return customer;
    }
}
