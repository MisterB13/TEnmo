package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.entities.Transfer;
import com.techelevator.tenmo.services.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/transfer")
public class TransferController {

    @Autowired
    TransferService transferService;

    public TransferController() { }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Transfer> getAll(@RequestParam(defaultValue = "0") int accountId) {
        System.out.println(accountId);
        return transferService.getTransfersByAccount(accountId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "", method = RequestMethod.POST)
    public Transfer create(@RequestBody Transfer transfer) {
        return transferService.createTransfer(transfer);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Transfer get(@PathVariable("id") int transferId) {
        return transferService.getTransferById(transferId);
    }


}
