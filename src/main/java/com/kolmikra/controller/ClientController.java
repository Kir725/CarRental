package com.kolmikra.controller;

import com.kolmikra.entity.CommonClient;
import com.kolmikra.entity.IndClient;
import com.kolmikra.service.impl.ClientService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController extends AbstractController<CommonClient, ClientService>{

}
