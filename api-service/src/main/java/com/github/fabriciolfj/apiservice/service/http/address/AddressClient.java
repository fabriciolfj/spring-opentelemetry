package com.github.fabriciolfj.apiservice.service.http.address;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class AddressClient {

    private final RestTemplate restTemplate;

    @Value("${customerclient.url}")
    public String url;

    public Address findAddress(final Long id) {
       try {
           return restTemplate.getForObject(url + "/address/" + id , Address.class);
       } catch (Exception e) {
           throw new RuntimeException(e.getMessage());
       }
    }
}
