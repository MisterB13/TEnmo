package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.Account;
import com.techelevator.util.BasicLogger;
import org.springframework.http.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

public class AccountService {

<<<<<<< HEAD
    private final String API_BASE_URL = "http://localhost:8080/account/";
=======
<<<<<<< HEAD
    private final String API_BASE_URL = "http://localhost:8080/account/";
=======
    private final String ACCOUNT_API_URL = "http://localhost:8080/account/";
>>>>>>> 59935033e8cf01467ef08909aa24556e6fce870b
>>>>>>> fdc0452dc5e2f1936c7107dbec74f55ea9041d8b
    private final RestTemplate restTemplate = new RestTemplate();

    public AccountService() { }

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> fdc0452dc5e2f1936c7107dbec74f55ea9041d8b
    public Account getUserAccount(int userId) {

        Account account = null;

<<<<<<< HEAD
=======
=======
    public Account getUserAccount(int id) {

        Account account = null;
>>>>>>> 59935033e8cf01467ef08909aa24556e6fce870b
>>>>>>> fdc0452dc5e2f1936c7107dbec74f55ea9041d8b
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Void> entity = new HttpEntity<>(headers);

<<<<<<< HEAD
            ResponseEntity<Account> response = restTemplate.exchange(API_BASE_URL + userId, HttpMethod.GET, entity, Account.class);
=======
<<<<<<< HEAD
            ResponseEntity<Account> response = restTemplate.exchange(API_BASE_URL + userId, HttpMethod.GET, entity, Account.class);
=======
            ResponseEntity<Account> response = restTemplate.exchange(ACCOUNT_API_URL + id, HttpMethod.GET, entity, Account.class);
>>>>>>> 59935033e8cf01467ef08909aa24556e6fce870b
>>>>>>> fdc0452dc5e2f1936c7107dbec74f55ea9041d8b

            account = response.getBody();

        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return account;
    }
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> fdc0452dc5e2f1936c7107dbec74f55ea9041d8b

    public Account updateAccountBalance(Account account) {

        Account updatedAccount = null;
        try {

            if(account != null) {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                HttpEntity<Account> entity = new HttpEntity<>(account, headers);

                ResponseEntity<Account> response = restTemplate.exchange(API_BASE_URL, HttpMethod.PUT, entity, Account.class);

                updatedAccount = response.getBody();
            }

        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return updatedAccount;
    }
<<<<<<< HEAD
=======
=======
>>>>>>> 59935033e8cf01467ef08909aa24556e6fce870b
>>>>>>> fdc0452dc5e2f1936c7107dbec74f55ea9041d8b
}
