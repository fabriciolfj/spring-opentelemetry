package com.github.fabriciolfj.apiservice.service.http.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class CustomerClient {

    private final RestTemplate restTemplate;

    @Value("${customerclient.url}")
    public String url;

    public Customer findCustomer(final Long id) {
       try {
           return restTemplate.getForObject(url + "/customer/" + id, Customer.class);
       } catch (Exception e) {
           throw new RuntimeException(e.getMessage());
       }
    }
}
