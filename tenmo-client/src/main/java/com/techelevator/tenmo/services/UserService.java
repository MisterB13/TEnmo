package com.techelevator.tenmo.services;


import com.techelevator.tenmo.model.User;
import com.techelevator.util.BasicLogger;
import org.springframework.http.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserService {

    private final String ACCOUNT_API_URL = "http://localhost:8080/user/";
    private final RestTemplate restTemplate = new RestTemplate();

    public UserService() { }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Void> entity = new HttpEntity<>(headers);

            ResponseEntity<User[]> response = restTemplate.exchange(ACCOUNT_API_URL, HttpMethod.GET, entity, User[].class);

            users = Arrays.asList(response.getBody());

        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return users;
    }
}
