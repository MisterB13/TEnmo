package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transaction;
import com.techelevator.util.BasicLogger;
import org.springframework.http.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

public class AccountService {
    private final String API_BASE_URL = "http://localhost:8080/account/";
    private final RestTemplate restTemplate = new RestTemplate();
    public Object getUsernameByAccountId;
    private String authToken;

    public AccountService() { }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
    public Account getUserAccount(int userId) {

        Account account = null;
        try {
            ResponseEntity<Account> response = restTemplate.exchange(API_BASE_URL + userId, HttpMethod.GET, HttpEntityService.createAuthEntity(), Account.class);
            account = response.getBody();

        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return account;
    }

    public Account updateAccountBalance(Account account) {

        Account updatedAccount = null;
        try {

            if(account != null) {
                ResponseEntity<Account> response = restTemplate.exchange(API_BASE_URL, HttpMethod.PUT, HttpEntityService.createGenericEntity(account), Account.class);
                updatedAccount = response.getBody();
            }

        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return updatedAccount;
    }

    public boolean createTransaction(int accountFromId, int accountToId , BigDecimal amount) {

        Transaction transaction = new Transaction(accountFromId,accountToId,amount);
        boolean success = false;
        try {
            if(transaction != null) {
                ResponseEntity<Void> response = restTemplate.exchange(API_BASE_URL + "transaction", HttpMethod.PUT, HttpEntityService.createGenericEntity(transaction), Void.class);
                success = true;

            }
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return success;
    }

    public Account getAccountByUserId(int userId) {
        Account account = null;
        try {
            ResponseEntity<Account> response =
                    restTemplate.exchange(API_BASE_URL + "accounts/user/" + userId,
                            HttpMethod.GET, makeAuthEntity(), Account.class);
            account = response.getBody();
        } catch (RestClientResponseException | ResourceAccessException e) {
            System.out.println("Failed to retrieve account");
        }
        return account;
    }


    public HttpEntity<Void> makeAuthEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(authToken);
        return new HttpEntity<>(headers);
    }

    public HttpEntity<Account> makeAccountEntity(Account account) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(authToken);
        return new HttpEntity<>(account, headers);
    }

}
