package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.entities.Transfer;
import com.techelevator.tenmo.model.TransferDto;
import com.techelevator.tenmo.services.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/transfer")
@PreAuthorize("isAuthenticated()")
public class TransferController {

    @Autowired
    TransferService transferService;

    public TransferController() { }

    @GetMapping(path = "/dto")
    public List<TransferDto> getAllDtos(@Valid @RequestParam(defaultValue = "0") int accountId) {
        return transferService.getTransferDtosByAccount(accountId);
    }
    @GetMapping
    public List<Transfer> getAll(@Valid @RequestParam(defaultValue = "0") int accountId) {
        return transferService.getTransfersByAccount(accountId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Transfer create(@Valid @RequestBody Transfer transfer) {
        return transferService.createTransfer(transfer);
    }

    @GetMapping(path = "/{id}")
    public Transfer get(@Valid @PathVariable("id") int transferId) {
        return transferService.getTransferById(transferId);
    }


}
