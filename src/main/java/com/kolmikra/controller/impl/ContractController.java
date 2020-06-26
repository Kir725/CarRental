package com.kolmikra.controller.impl;

import com.kolmikra.controller.AbstractController;
import com.kolmikra.entity.CommonClient;
import com.kolmikra.entity.Contract;
import com.kolmikra.service.impl.ClientService;
import com.kolmikra.service.impl.ContractService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController
@RequestMapping("/contract")
@CrossOrigin
public class ContractController extends AbstractController<Contract, ContractService> {

}
