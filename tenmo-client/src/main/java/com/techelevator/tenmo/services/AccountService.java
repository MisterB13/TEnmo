package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.Account;
import com.techelevator.util.BasicLogger;
import org.springframework.http.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

public class AccountService {

    private final String ACCOUNT_API_URL = "http://localhost:8080/account/";
    private final RestTemplate restTemplate = new RestTemplate();

    public AccountService() { }

    public Account getUserAccount(int id) {

        Account account = null;
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Void> entity = new HttpEntity<>(headers);

            ResponseEntity<Account> response = restTemplate.exchange(ACCOUNT_API_URL + id, HttpMethod.GET, entity, Account.class);

            account = response.getBody();

        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return account;
    }
}
