package com.kolmikra.controller.impl;

import com.kolmikra.controller.AbstractController;
import com.kolmikra.entity.CommonClient;
import com.kolmikra.entity.IndClient;
import com.kolmikra.service.impl.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
@CrossOrigin
public class ClientController extends AbstractController<CommonClient, ClientService> {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        super(clientService);
        this.clientService = clientService;
    }

}
