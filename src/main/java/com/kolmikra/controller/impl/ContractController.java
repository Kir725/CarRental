package com.kolmikra.controller.impl;

import com.kolmikra.controller.AbstractController;
import com.kolmikra.entity.CommonClient;
import com.kolmikra.entity.Contract;
import com.kolmikra.entity.Vehicle;
import com.kolmikra.exception.NoSuchItemException;
import com.kolmikra.service.impl.ClientService;
import com.kolmikra.service.impl.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/contract")
@CrossOrigin
public class ContractController extends AbstractController<Contract, ContractService> {

    private final ContractService contractService;

    @Autowired
    public ContractController(ContractService contractService) {
        super(contractService);
        this.contractService = contractService;
    }

    @GetMapping("/getContractsByClient/{clientId}")
    public ResponseEntity<List<Contract>> getContractsByClient(@PathVariable int clientId) {
        try {
            List<Contract> result = contractService.getContractsByClient(clientId);
            return ResponseEntity.ok(result);
        } catch (NoSuchItemException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
