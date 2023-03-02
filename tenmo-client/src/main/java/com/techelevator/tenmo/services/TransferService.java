package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.Transfer;
import com.techelevator.util.BasicLogger;
import org.springframework.http.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

public class TransferService {

    private final String API_BASE_URL = "http://localhost:8080/transfer/";
    private final RestTemplate restTemplate = new RestTemplate();
    private final String ACCOUNT_ID = "accountId";

    public TransferService() { }

    public Transfer createTransfer(Transfer transfer) {
         Transfer createTransfer = null;
          try {
//              HttpHeaders headers = new HttpHeaders();
//              headers.setContentType(MediaType.APPLICATION_JSON);

//              HttpEntity<Transfer> entity = new HttpEntity<>(transfer, headers);

              ResponseEntity<Transfer> response = restTemplate.exchange(API_BASE_URL, HttpMethod.POST, createTransferEntity(transfer), Transfer.class);

              createTransfer = response.getBody();

          } catch (RestClientResponseException | ResourceAccessException e) {
              BasicLogger.log(e.getMessage());
          }

          return createTransfer;
    }


    public Transfer getTransfer(int transferId) {
        Transfer transfer = null;

        try {
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.APPLICATION_JSON);
//            HttpEntity<Void> entity = new HttpEntity<>(headers);

            ResponseEntity<Transfer> response = restTemplate.exchange(API_BASE_URL + transferId, HttpMethod.GET, createAuthEntity(), Transfer.class);

            transfer = response.getBody();

        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return transfer;
    }

    public List<Transfer> getTransferHistory(int accountId) {
        List<Transfer> transfers = null;

        try {
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.APPLICATION_JSON);
//            HttpEntity<Void> entity = new HttpEntity<>(headers);

            URI uri = UriComponentsBuilder.fromUri(URI.create(API_BASE_URL)).queryParam(ACCOUNT_ID, accountId).build().toUri();

            ResponseEntity<Transfer[]> response = restTemplate.exchange(uri, HttpMethod.GET, createAuthEntity(), Transfer[].class);

            transfers = Arrays.asList(response.getBody());

        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return transfers;
    }

    public HttpEntity<Transfer> createTransferEntity(Transfer transfer) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(transfer, headers);
    }

    public HttpEntity<Void> createAuthEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(headers);
    }

}
