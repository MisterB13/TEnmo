package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.dto.TransferDto;
import com.techelevator.util.BasicLogger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class TransferService {

    private final String API_BASE_URL = "http://localhost:8080/transfer/";
    private final RestTemplate restTemplate = new RestTemplate();

    private String authToken;

    public TransferService() {
    }

    public Transfer createTransfer(Transfer transfer) {
         Transfer createTransfer = null;
          try {
              ResponseEntity<Transfer> response = restTemplate.exchange(API_BASE_URL, HttpMethod.POST, HttpEntityService.createGenericEntity(transfer), Transfer.class);
              createTransfer = response.getBody();

          } catch (RestClientResponseException | ResourceAccessException e) {
              BasicLogger.log(e.getMessage());
          }
          return createTransfer;
    }


    public Transfer getTransfer(int id) {
        Transfer transfer = null;
        try {
            ResponseEntity<Transfer> response = restTemplate.exchange(API_BASE_URL + id, HttpMethod.GET, HttpEntityService.createAuthEntity(), Transfer.class);
            transfer = response.getBody();

        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return transfer;
    }

    public List<Transfer> getTransferHistory(int accountId) {
        List<Transfer> transfers = null;
        try {
            URI uri = UriComponentsBuilder.fromUri(URI.create(API_BASE_URL)).queryParam("accountId", accountId).build().toUri();
          ResponseEntity<Transfer[]> response = restTemplate.exchange(uri, HttpMethod.GET, HttpEntityService.createAuthEntity(), Transfer[].class);
          transfers = Arrays.asList(Objects.requireNonNull(response.getBody()));

        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return transfers;
    }

    public List<TransferDto> getTransferDtoHistory(int accountId) {
        List<TransferDto> transfers = null;
        try {
            URI uri = UriComponentsBuilder.fromUri(URI.create(API_BASE_URL + "dto/")).queryParam("accountId", accountId).build().toUri();

            ResponseEntity<TransferDto[]> response = restTemplate.exchange(uri, HttpMethod.GET, HttpEntityService.createAuthEntity(), TransferDto[].class);
            transfers = Arrays.asList(Objects.requireNonNull(response.getBody())) ;

        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return transfers;
    }

    public Transfer getCurrentUserTransferById(int transferId) {
        Transfer transfer = null;
        try {
            ResponseEntity<Transfer> response =
                    restTemplate.exchange(API_BASE_URL + "transfers/my-transfers/" + transferId,
                            HttpMethod.GET, makeAuthEntity(), Transfer.class);

            transfer = response.getBody();
        } catch (RestClientResponseException | ResourceAccessException e) {
            System.out.println("Transfer pull failed.");
        }
        return transfer;
    }

    public Transfer getTransferType(String transferType) {
        Transfer transfer = null;
        try {
            ResponseEntity<Transfer> response = restTemplate.exchange(API_BASE_URL, HttpMethod.GET, HttpEntityService.createAuthEntity(), Transfer.class);
            transfer = response.getBody();

        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return transfer;
    }

    public Transfer getTransferStatus(String transferStatus) {
        Transfer transfer = null;
        try {
            ResponseEntity<Transfer> response = restTemplate.exchange(API_BASE_URL, HttpMethod.GET, HttpEntityService.createAuthEntity(), Transfer.class);
            transfer = response.getBody();

        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return transfer;
    }
    public HttpEntity<Void> makeAuthEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(authToken);
        return new HttpEntity<>(headers);
    }
}
